/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courses;

import enums.Pre_Req;
import enums.Proff_Recommend;
import enums.Roles;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sreenidhi Madala
 */
public class CourseDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
    //Create CourseMapping object as mapper and initialize it.
    CourseMapping courseMapping = new CourseMapping();
//        scan the courses.txt for input
        Scanner scanner = new Scanner(new File("courses.txt"));
		//Starts loop
                scanner.nextLine();
//                scans all the values from the input file
                while (scanner.hasNext()) {                    
               String title = scanner.nextLine();
               String req = scanner.nextLine();
                    String req_;
//          gets the value and replaces the string as expected       
            if (req.contains(" ")) {
                req_ = req.replace(" ", "_");
            } else {
                req_ = req;
            }
               Pre_Req pre_Req = Pre_Req.valueOf(req.toUpperCase());
               String fees = scanner.next().substring(1);
               double fees_ = Double.parseDouble(fees);
               String str = scanner.nextLine();
               String rec = scanner.nextLine();
               Proff_Recommend proff_Recommend = Proff_Recommend.valueOf(rec.toUpperCase());
//               creating a new course object and adding all the values 
            Course course = new Course(title, pre_Req, proff_Recommend, fees_);
                String description = scanner.nextLine();
            do {
                String stud;
                if (!description.equals("Students")) {
                    stud = description;
                } else {
                    stud = scanner.nextLine();
                }
                String[] act = stud.split(" - ");
                String[] name = act[1].split(" ");
                int sem = scanner.nextInt();
                scanner.nextLine();
                String gpa = scanner.next().substring(1);
                scanner.nextLine();
                double agpa = Double.parseDouble(gpa) *
                        1000000;
//              creating a new student list and add the values to the list
                Student stud_list = new Student( sem, agpa,name[0],name[1]);
                course.addstd_ID(act[0], stud_list);
                if (scanner.hasNext()) {
                    description = scanner.nextLine();
                } else {
                    break;
                }
            } while (!description.equals("Staff"));

              do {
                String staff;
                if (!description.equals("Staff")) {
                    staff = description;
                } else {
                    staff = scanner.nextLine();
                }
                String[] staff_Name = staff.split(" ");
                String s_Roles = scanner.nextLine();
                String stri;
                if (s_Roles.contains(" ")) {
                    stri = s_Roles.replace(" ", "_");
                } else {
                    stri = s_Roles;
                }
                Roles role = Roles.valueOf(stri.toUpperCase());
                Person staf = new Staff(role,staff_Name[0],
                        staff_Name[1]);
                courseMapping.addStaff(course, staf);
                if (scanner.hasNext()) {
                    description = scanner.nextLine();
                } else {
                    break;
                }
            } while (!description.equals("Course"));
        }                   
//  Method call for getting all Students for a given course
System.out.println("*********************************************"
                + "*********\n"
                + "Details of all courses in mapper");
        System.out.print(courseMapping.toString().substring(0, courseMapping.toString()
                .length()-1));
        System.out.println("**************************************************"
                + "****\n"
                + "\n"
                + "******************************************************\n"
                + "All staff mapped with in GDP-2 course\n"
                + "******************************************************");
        for (Staff technician : courseMapping.getAllStaff("GDP-2")) {
            System.out.println(technician);
        }
   //  Method call for getting Student ID of a student in different courses
        System.out.println("\n*********************************************"
                + "*********\n"
                + "Id's of Student Sreenidhi Madala in different courses\n"
                + "******************************************************");
        for (String course : courseMapping.getListOfAllStudentIDs("Sreenidhi Madala")) {
            System.out.println(course);
        }
        System.out.println("\n********************************************"
                + "**********\n"
                + "List of courses Bandi Ajay Teaches\n"
                + "******************************************************");
//      Method call for getting courses taught by a professor  
        for (Course course : courseMapping.getListOfAllCoursesProffTeach("Bandi Ajay")
                ) {
            System.out.println(course.getTitle());
        }
//      Method to print all students in the db  
        System.out.println("\n***********************************************"
                + "*******\n"
                + "List of all Students from all courses in the map\n"
                + "******************************************************");
        List<Student> actor = courseMapping.getAllStudents();
        Collections.sort(actor);
        for (Course course1 : courseMapping.getCourseMap().keySet()) {
            for (Student actor1 : actor) {
                for (Student actor2 : course1.getStd_ID().values()) { 
                    if (actor2.getFirstName().equals(actor1.getFirstName()) 
                            && actor2.getLastName().equals(actor1.getLastName())) {
                        System.out.println(actor1);
                    }
                }
            }
        }
        System.out.println("\n*********************************************"
                + "*********\n"
                + "List of all courses sorted based on cost per course in"
                + " descending order\n"
                + "******************************************************");
        List<Double> list = new ArrayList<>();
        for (Course crs : courseMapping.getCourseMap().keySet()) {
            list.add(crs.getFees());
        }
        Collections.sort(list, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return Double.compare(o2, o1);
            }
        });
        for (Double description : list) {
            for (Course curs : courseMapping.getCourseMap().keySet()) {
                if (curs.getFees() == description) {
                    System.out.println(curs.getTitle() + "\t\t$" +
                            String.format("%.2f", description));
                }
            }
        }
    }
    
}