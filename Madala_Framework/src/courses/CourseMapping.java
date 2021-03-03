/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Sreenidhi Madala
 */
public class CourseMapping {

    private HashMap<Course, LinkedList<Person>> courseMap;

    /**
     * constructor for CourseMapping
     */
    public CourseMapping() {
        this.courseMap = new HashMap<>();
    }

    /**
     * gets the course map
     *
     * @return courseMap
     */
    public HashMap<Course, LinkedList<Person>> getCourseMap() {
        return courseMap;
    }

    /**
     * adds the staff to course map
     *
     * @param course
     * @param person
     */
    public void addStaff(Course course, Person person) {

        if (null != courseMap && null != person) {
            LinkedList<Person> personList = courseMap.get(course);
            if (null != personList) {
                personList.add(person);
                courseMap.put(course, personList);
            } else {
                LinkedList<Person> personLis = new LinkedList<Person>();
                personLis.add(person);
                courseMap.put(course, personLis);
            }
        }
    }

    /**
     * gets the list of all courses each professor teaches
     *
     * @param StudentFullName
     * @return course
     */
    public List<Course> getListOfAllCoursesProffTeach(String StudentFullName) {
        List<Course> course = new ArrayList<>();
        Set<Course> cour = courseMap.keySet();
        for (Course course1 : cour) {
            LinkedList<Person> personLi = courseMap.get(course1);
            for (Person person : personLi) {
                String fname = person.getFirstName() + " " + person.getLastName();
                if (StudentFullName.equalsIgnoreCase(fname)) {
                    course.add(course1);
                }
            }
        }
        return course;
    }

    /**
     * gets all staff for each course
     *
     * @param courseName
     * @return staff
     */
    public List<Staff> getAllStaff(String courseName) {
        List<Staff> staff = new ArrayList<>();
        Set<Course> cour = courseMap.keySet();
        for (Course course1 : cour) {
            if (course1.getTitle().equals(courseName)) {
                LinkedList<Person> personList = courseMap.get(course1);
                for (Object person : personList) {
                    if (person instanceof Staff) {
                        Staff staf = (Staff) person;
                        staff.add(staf);
                    }
                }
                break;
            }
        }

        return staff;
    }

    /**
     * gets the list of all student id's
     *
     * @param student
     * @return stu
     */
    public List<String> getListOfAllStudentIDs(String student) {
        List<String> stu = new ArrayList<>();
        String[] name = student.split(" ");
        Set<Course> cour = courseMap.keySet();
        for (Course course1 : cour) {
            for (String chara : course1.getStd_ID().keySet()) {
                if ((course1.getStd_ID().get(chara).getFirstName()
                        .equals(name[0])) && (course1.getStd_ID()
                        .get(chara).getLastName().equals(name[1]))) {
                    stu.add(chara);
                }
            }
        }
        return stu;
    }

    /**
     * gets all students
     *
     * @return student
     */
    public List<Student> getAllStudents() {
        List<Student> student = new ArrayList<>();
        Set<Course> cour = courseMap.keySet();
        for (Course course1 : cour) {
            for (Student stud : course1.getStd_ID().values()) {
                if (!student.contains(stud)) {
                    student.add(stud);
                }
            }
        }
        return student;
    }

    /**
     * prints the info of course map
     *
     * @return string
     */
    @Override
    public String toString() {
        String course = "";
        Set<Course> cour = courseMap.keySet();
        for (Course course1 : cour) {
            List staf = getAllStaff(course1.getTitle());
            String staff = "";
            for (Object staff5 : staf) {
                staff += "\n" + staff5.toString();
            }
            course += "******************************************************\n"
                    + course1.toString()
                    + "------------------------------------------------------\n"
                    + "Course Staff\n"
                    + "------------------------------------------------------\n"
                    + "\tName\t\t\tRole\n"
                    + "------------------------------------------------------"
                    + staff + "\n\n";
        }
        return course;
    }
}
