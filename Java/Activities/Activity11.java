package NehaActivity1;

import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args) {
        HashMap<Integer, String> hash_map = new HashMap<>();


        hash_map.put(1, "Red");
        hash_map.put(2, "Green");
        hash_map.put(3, "Blue");
        hash_map.put(4, "Yellow");
        hash_map.put(5, "Purple");

 
        System.out.println("Map have: " + hash_map);


        hash_map.remove(4);


        boolean hasGreen = hash_map.containsValue("Green");
        System.out.println("Contains 'Green'? " + hasGreen);

        // Print size
        System.out.println("Size: " + hash_map.size());
    }
}
