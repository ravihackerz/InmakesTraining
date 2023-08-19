package org.task;

public class Task3 {
public static void main(String[] args) {
	String s = "Inmakes Infotech",ns = " ";
	char ch;
	for (int i = 0; i<s.length(); i++ ) {
		ch = s.charAt(i);
		ns = ch+ns;
	}
	System.out.println(ns);
			
}
}