package NehaActivity1;

import java.util.HashSet;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        
  
        hs.add("M");
        hs.add("B");
        hs.add("C");
        hs.add("A");
        hs.add("M");  
        hs.add("X");
  
        System.out.println("HashSet: " + hs);
        System.out.println("Size: " + hs.size());
        

        hs.remove("A");
        
  
        boolean containsM = hs.contains("M");
        System.out.println("'M' present? " + containsM);
        

        System.out.println("Updated HashSet: " + hs);
        System.out.println("New Size: " + hs.size());
    }
}
