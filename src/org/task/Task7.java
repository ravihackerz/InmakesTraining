package org.task;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Task7 {
		public static void main(String[] args) {
		Map<Integer, String> m = new LinkedHashMap<>();
		m.put(10, "java");
		m.put(20, "Sql");
		m.put(30, "oops");
		m.put(40, "selenium");
		
		Set<java.util.Map.Entry<Integer, String>> s =  m.entrySet();
		for(java.util.Map.Entry<Integer,String> e : s) {
			Integer key = e.getKey();
			System.out.println(key);
			String value = e.getValue();
			System.out.println(value);
			
		}
		
		
		
		
		}
		
		}

