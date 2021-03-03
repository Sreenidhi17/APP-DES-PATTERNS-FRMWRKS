/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courses;

/**
 *
 * @author Sreenidhi Madala
 */
public class Student extends Person {

    private int sem;
    private double gpa;

    /**
     * constructor for student class
     *
     * @param sem
     * @param gpa
     * @param firstName
     * @param lastName
     */
    public Student(int sem, double gpa, String firstName, String lastName) {
        super(firstName, lastName);
        this.sem = sem;
        this.gpa = gpa;
    }

    /**
     * gets the semester of the student
     *
     * @return sem
     */
    public int getSem() {
        return sem;
    }

    /**
     * gets the gpa of student
     *
     * @return gpa
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * compare to method
     *
     * @param other
     * @return
     */
    @Override
    public int compareTo(Person other) {
        double ren = ((Student) other).gpa;
        return (int) (ren - this.gpa);

    }

    /**
     * prints the info of student
     *
     * @return string
     */
    @Override
    public String toString() {
        return super.toString() + "		sem: " + sem;
    }

}
