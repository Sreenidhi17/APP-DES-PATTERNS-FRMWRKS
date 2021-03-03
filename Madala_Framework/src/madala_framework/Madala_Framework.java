/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madala_framework;

import java.util.LinkedList;

/**
 *
 * @author Madala Sreenidhi
 */
public class Madala_Framework {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
// Add elements to the linked list.
        list.add("F");
        list.add("B");
        list.add("D");
        list.add("E");
        list.add("C");
        list.addLast("Z");
        list.addFirst("A");
        list.add(1, "A2");
        System.out.println("Original contents of list: " + list);
// Remove elements from the linked list.
        list.remove("F");
        list.remove(2);
        System.out.println("Contents of list after deletion: " + list);
        list.removeFirst();
        list.removeLast();
        System.out.println("list after deleting first and last: " + list);
// Get and set a value.
        String value = list.get(2);
        list.set(2, value + " Changed");
        System.out.println("list after change: " + list);
    }

}
