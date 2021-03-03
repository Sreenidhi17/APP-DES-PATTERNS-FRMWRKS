/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madala_framework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Madala_Sreenidhi
 */
public class DemoHashMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Create a hash map.
        HashMap<String, Double> hashMap = new HashMap<String, Double>();
// Put elements to the map
        hashMap.put("san Deigo", new Double(3434.34));
        hashMap.put("will Smith", new Double(123.22));
        hashMap.put("stude Baker", new Double(1378.00));
        hashMap.put("Tod nod", new Double(99.22));
        hashMap.put("Ralph lauren", new Double(-19.08));
// Get a set of the entries.
        Set<Map.Entry<String, Double>> set = hashMap.entrySet();
// Display the set.
        for (Map.Entry<String, Double> mep : set) {
            System.out.print(mep.getKey() + ": ");
            System.out.println(mep.getValue());
        }
        System.out.println();
// Deposit 1000 into John Doe's account.
        double balance = hashMap.get("san Deigo");
        hashMap.put("san Deigo", balance + 1000);
        System.out.println("san Deigo's new balance: "
                + hashMap.get("san Deigo"));
    }

}
