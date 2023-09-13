package com.sophie.interviewproblems;

import java.util.Scanner;
import java.util.TreeMap;

public class StringCompositionChecker {

	public static void main(String[] args) {
		System.out.println("Welcome to the String Composition Checker program.");
		System.out.println("Please enter the string to check below.");
		Scanner scan = new Scanner(System.in);
		String inString = scan.nextLine();
		TreeMap<String, Integer> inMap = new TreeMap<String, Integer>();
		for(int i = 0; i < inString.length(); i++) {
			String treeIn = String.valueOf(inString.charAt(i));
			if(inMap.containsKey(treeIn)) {
				int inCount = inMap.get(treeIn); 
				inMap.replace(treeIn, inCount, inCount + 1);
			} else {
				inMap.put(treeIn, 1);
			}
		}
		inMap.remove(" ");
		inMap.remove(",");
		inMap.remove("[");
		inMap.remove("]");
		inMap.remove(".");
		System.out.println("String composition calculated, results are as follows - " + inMap.toString());

		/*Sample result - 
		Input: The quick brown fox jumps over the lazy dog.
		Output: {T=1, a=1, b=1, c=1, d=1, e=3, f=1, g=1, h=2, i=1, j=1, k=1, l=1, m=1, n=1, o=4, p=1, q=1, r=2, s=1, t=1, u=2, v=1, w=1, x=1, y=1, z=1}
		
		Input 2: [T, a, b, c, d, e, e, e, f, g, h, h, h, i, j, k, l, m, n, o, o, o, o, p, q, q, r, r, s, t, u, u, u, v, w, w, x, x, y, z, z]
		Output: {T=1, a=1, b=1, c=1, d=1, e=3, f=1, g=1, h=3, i=1, j=1, k=1, l=1, m=1, n=1, o=4, p=1, q=2, r=2, s=1, t=1, u=3, v=1, w=2, x=2, y=1, z=2}
		*/
		
	}

}
