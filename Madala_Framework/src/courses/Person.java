/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courses;

import java.util.Objects;

/**
 *
 * @author Sreenidhi Madala
 */
public abstract class Person implements Comparable<Person> {

    private String firstName;
    private String lastName;

    /**
     * constructor of person class
     *
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * gets the first name
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * gets the last name
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * hash code
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.firstName);
        hash = 73 * hash + Objects.hashCode(this.lastName);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }

    /**
     * compares the name
     *
     * @param other
     * @return int
     */
    @Override
    public int compareTo(Person other) {

        if (this.lastName.compareTo(other.lastName) == 0) {
            return this.firstName.compareTo(other.firstName);
        } else {
            return this.lastName.compareTo(other.lastName);
        }

    }

    /**
     * prints the info of person
     *
     * @return
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
