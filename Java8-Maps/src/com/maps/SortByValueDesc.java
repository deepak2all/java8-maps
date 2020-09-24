package com.maps;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.BiConsumer;

public class SortByValueDesc {

	public static void main (String[] args) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("DeliverTo", "MDP");
		paramMap.put("AsAtDate", "2020-05-14");
		paramMap.put("MDP", "ACTIONM");
		paramMap.put("FromDate", "2020-05-09");
		paramMap.put("ToDate", "2020-05-14");
		paramMap.put("RunDate", "2020-05-14");
		
		Map<String, String> sorted = paramMap
				.entrySet()
				.stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(),
				(e1, e2) -> e2, LinkedHashMap::new));

		System.out.println("ORIGINAL MAP");
		for(Map.Entry<String, String> entry : paramMap.entrySet()){
			System.out.println("KEY ::" + entry.getKey() + " " + "VALUE ::" + entry.getValue());
		}
		System.out.println("=======================================");
		
		System.out.println("MAP SORTED BY VALUE, IN DESCENDING ORDER");
		for(Map.Entry<String, String> entry : sorted.entrySet()){
			System.out.println("KEY ::" + entry.getKey() + " " + "VALUE ::" + entry.getValue());
		}
		System.out.println("=======================================");
		
		System.out.println("MAP PRINTED USING BICONSUMER");
		BiConsumer<String,String> biConsumer = (key,value) -> 
		System.out.println("Key:"+ key+" Value:"+ value);
		sorted.forEach(biConsumer);
	}
}
