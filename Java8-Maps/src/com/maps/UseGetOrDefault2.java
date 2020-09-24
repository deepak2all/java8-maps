package com.maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class UseGetOrDefault2 {
	
	private static final String DELIVER_TO = "DeliverTo";
	private static final String RUNDATE = "RunDate";
	private static final String SCHEDULER_MDP = "SchedulerMDP";
	
	private static final List<String> schedulerItems = Arrays.asList(DELIVER_TO, RUNDATE, SCHEDULER_MDP);
	
	/*
	 * Basically the useGetOrDefault method returns a default value whenever the value
	 * was not found using the key specified on the hashmap
	 * This is a convenient way to handle the scenario where we want a returned other than null,
	 * which is being returned by get method whenever the key wasn't found in the HashMap obj
	 */
	private static Map<String, BiConsumer<Schedule, String>> rangeMap = new HashMap<>();
	private static Map<Schedule, String> rangeMapTmp = new HashMap<>();
	private static Map<String, String> outOfRangeMap = new HashMap<>();
	
	static {
		rangeMap.put(DELIVER_TO, Schedule::setDeliverTo);
		rangeMap.put(RUNDATE, Schedule::setScheduledRunDateTime);
		rangeMap.put(SCHEDULER_MDP, Schedule::setMdp);
 	}
	
 	
	public static class Schedule {
 		private String scheduledRunDateTime;
 		private String deliverTo;
 		private String mdp;

 		public String getScheduledRunDateTime() {
 			return scheduledRunDateTime;
 		}

 		public void setScheduledRunDateTime(String scheduledRunDateTime) {
 			this.scheduledRunDateTime = scheduledRunDateTime;
 		}

 		public String getDeliverTo() {
 			return deliverTo;
 		}

 		public void setDeliverTo(String deliverTo) {
 			this.deliverTo = deliverTo;
 		}

 		public String getMdp() {
 			return mdp;
 		}

 		public void setMdp(String mdp) {
 			this.mdp = mdp;
 		}

 	}
 	public static void main(String[] args){
 		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("DeliverTo", "MDP");
		paramMap.put("AsAtDate", "2020-05-14");
		paramMap.put("MDP", "ACTIONM");
		paramMap.put("FromDate", "2020-05-09");
		paramMap.put("ToDate", "2020-05-14");
		paramMap.put("RunDate", "2020-05-14");
		

		for(Map.Entry<String, String> map : paramMap.entrySet()){
			if(schedulerItems.contains(map.getKey())){
				rangeMap.getOrDefault(map.getKey(), (schedule, s) -> {})
				.accept(new Schedule(), map.getValue());
			} else {
				outOfRangeMap.put(map.getKey(), map.getValue());
			}
		}
		
		BiConsumer<String,String> outOfRangeMapKey = (key,value) -> 
		System.out.println("Key1:"+ key+" Value1:"+ value);
		outOfRangeMap.forEach(outOfRangeMapKey);
		
		BiConsumer<String,BiConsumer<Schedule,String>> rangeMapKey = (key, value) -> 
		System.out.println("Key2:"+ key/*+" Value2:"+ value*/);
		rangeMap.forEach(rangeMapKey);
		
		BiConsumer<Schedule,String> rangeMapTmpKey = (key, value) -> 
		System.out.println(/*"Key2:"+ key+*/" Value2:"+ value);
		rangeMapTmp.forEach(rangeMapTmpKey);
		
		BiConsumer<String, String> bc = (a, b) -> {System.out.println(a + " | " + b);};
		bc.accept("1", "2");
		
 	}
}
