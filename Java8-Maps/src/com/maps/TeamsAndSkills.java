package com.maps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TeamsAndSkills implements Solution {
    @Override
    public int differentTeams(String skills) {
    	String teamskills = "pcmbz";
        return countCharacters(skills).values().stream().sorted(Comparator.reverseOrder()) // we need to return min
                .skip(teamskills.length() - 1) // we want to get the maximum value
                .findFirst() // if there is some then return
                .orElse(0); // if no values in the stream return default
    }
 
    private static Map<Integer,Integer> countCharacters(String skills){
        return skills.chars().boxed()
                .collect(HashMap::new, (a,s) -> a.compute( s,(k,v) ->  v == null ? 1: v+1), HashMap::putAll );
    }
    
    public static void main (String[] args){
    	TeamsAndSkills comp = new TeamsAndSkills();
    	//System.out.println(comp.differentTeams("pcmbzplfdfcmbz"));
    	System.out.println(comp.differentTeams("pcmbzsdspcmbzdsdspdcmbzzpcmbz"));
    }
}

/*
Programmer – code p
Customer – code c
Manager – code m
Tester – code b
Coach – code z
*/

interface Solution {

	String TEAM = "pcmbz";
	 
    /**
     * Calculate how many times sequence {@link #TEAM} occurred in the given string taking into account that we do not consider
     * the order of occurrence of single characters in the given string.
     * e.g pcmbzpcmbz  returns 2 since we have two matching strings pcmbz and pcmbz
     * e.g pcmbzpcmbzzbmcp returns 3 since we have three matching strings pcmbz and pcmbz and zbmcp
     * e.g pcmbzpcmbp returns 1 since we can form only one pcmbz sequence
     * @param skills
     * @return total number of occurrences
     */
    int differentTeams(String skills);
    
    // http://blog.cranberrysoft.com/2018/07/22/i-am-just-tyro-at-hackerrank/
}