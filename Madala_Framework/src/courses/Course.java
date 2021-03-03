/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courses;

import enums.Pre_Req;
import enums.Proff_Recommend;
import java.util.HashMap;

/**
 *
 * @author Sreenidhi Madala
 */
public class Course implements Comparable<Course> {

    private String title;
    private Pre_Req pre_req;
    private Proff_Recommend recomm;
    private double fees;
    private HashMap<String, Student> std_ID;

    /**
     *
     * @param title
     * @param pre_req
     * @param recomm
     * @param fees
     */
    public Course(String title, Pre_Req pre_req, Proff_Recommend recomm, double fees) {
        this.title = title;
        this.pre_req = pre_req;
        this.recomm = recomm;
        this.fees = fees;
        this.std_ID = new HashMap<>();
    }

    /**
     * Get the title of the course
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * gets the pre req
     *
     * @return pre req
     */
    public Pre_Req getPre_req() {
        return pre_req;
    }

    /**
     * gets the professor recomm
     *
     * @return recomm
     */
    public Proff_Recommend getRecomm() {
        return recomm;
    }

    /**
     * gets the fees
     *
     * @return fees
     */
    public double getFees() {
        return fees;
    }

    /**
     * gets the unique id of the student
     *
     * @return std_ID
     */
    public HashMap<String, Student> getStd_ID() {
        return std_ID;
    }

    /**
     * Add student id to the student object
     *
     * @param nickName
     * @param student
     */
    public void addstd_ID(String nickName, Student student) {
        std_ID.put(nickName, student);
    }

    /**
     * compares the course
     *
     * @param course
     * @return
     */
    public int compareTo(Course course) {
        return this.pre_req.compareTo(course.getPre_req());
    }

    /**
     * gets the info of the course
     *
     * @return String
     */
    @Override
    public String toString() {
        String str1 = "";
        for (String abc : std_ID.keySet()) {
            String act = std_ID.get(abc).toString()
                    .substring(0, std_ID.get(abc).toString()
                            .indexOf("\t"));
            str1 += abc + "\t\t\t" + act + "\n";
        }
        String str2 = "";
        switch (pre_req) {
            case OOPS:
                str2 += "Oops";
                break;
            case DATABASE:
                str2 += "Database";
                break;
            case FRAMEWORKS:
                str2 += "Frameworks";
                break;
            case MOBILE_COMPUTING:
                str2 += "MOBILE_COMPUTING";
                break;
            case GDP_1:
                str2 += "GDP-1";
                break;
            case GDP_2:
                str2 += "GDP-2";
                break;
        }
        return title + "\nPre_Req: " + str2 + "\t\tProff_Recommend: "
                + recomm.getDescription() + "\nfees: $"
                + String.format("%.2f", fees) + "\nStudents:\n"
                + "------------------------------------------------------\n"
                + "Student_ID	  Student Name\n"
                + "------------------------------------------------------\n"
                + str1;
    }
}
