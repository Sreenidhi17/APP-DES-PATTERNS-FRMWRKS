/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courses;

import enums.Roles;

/**
 *
 * @author Sreenidhi Madala
 */
public class Staff extends Person {

    private Roles role;

    /**
     * constructor for staff
     *
     * @param role
     * @param firstName
     * @param lastName
     */
    public Staff(Roles role, String firstName, String lastName) {
        super(firstName, lastName);
        this.role = role;
    }

    /**
     * gets the role of staff
     *
     * @return role
     */
    public Roles getRole() {
        return role;
    }

    /**
     * compares the roles
     *
     * @param another
     * @return
     */
    @Override
    public int compareTo(Person another) {
        return this.getRole().compareTo(this.getRole());
    }

    /**
     * prints the info if staff
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "			" + role;
    }

}
