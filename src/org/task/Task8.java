package org.task;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Task8 {
public static void main(String[] args) {
	Map<Integer, Integer> m = new TreeMap<>();
	m.put(10, 10);
	m.put(20, 20);
	m.put(30, 30);
	m.put(40, 40);
	m.put(50, 50);
	m.put(60, 60);
	m.put(10, 10);
	m.put(50, 50);
	m.put(40, 40);
	Collection<Integer> c = m.keySet();
	System.out.println("key : " + c);
}
}
