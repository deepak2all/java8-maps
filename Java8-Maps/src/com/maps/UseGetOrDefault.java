package com.maps;

import java.util.HashMap;


public class UseGetOrDefault {

	public static void main (String[] args) {
		
		// Create a HashMap and add some values
		HashMap<String, Integer> map = new HashMap<>(); 
	    map.put("a", 100); 
	    map.put("b", 200); 
	    map.put("c", 300); 
	    map.put("d", 400); 
	    
	    // print map details 
        System.out.println("HashMap: " + map.toString()); 
  
        // provide key whose value has to be obtained 
        // and default value for the key. Store the 
        // return value in k 
        int k = map.getOrDefault("b", 500); 
        // print the value of k returned by 
        // getOrDefault(Object key, V defaultValue) method 
        System.out.println("Returned Value for k: " + k); 
        // As "b" is present and has a value, it gets returned for k
        
        // provide key whose value has to be obtained 
        // and default value for the key. Store the 
        // return value in l
        int l = map.getOrDefault("y", 500); 
  
        // print the value of k returned by 
        // getOrDefault(Object key, V defaultValue) method 
        System.out.println("Returned Value for l: " + l); 
        // As "y" is NOT present, it returns default value for l
        
	}
}
