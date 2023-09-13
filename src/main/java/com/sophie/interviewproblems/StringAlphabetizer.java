package com.sophie.interviewproblems;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class StringAlphabetizer {
	
	public static void main(String[] args) {
		/*
		 * Note: Current iteration of this program is case-sensitive, this can be altered easily.
		 */
		System.out.println("Welcome to the String Alphabetizer program.");
		System.out.println("Please enter the string to alphabetize below.");
		Scanner scan = new Scanner(System.in);
		String inString = scan.nextLine();
		System.out.println("Do you want the 'words' alphabetized, or the 'string'? Please type 'words' or 'string' to select mode.");
		String modeSetting = scan.nextLine();
		if(modeSetting.equalsIgnoreCase("words")) {
			System.out.println("Alphabetizing the words in the String.");
			ArrayList<String> sortedString = new ArrayList<String>();
			ArrayList<String> words = new ArrayList<String>();
			while(inString.contains(" ")) {
			int endex = inString.indexOf(" ");
			words.add(inString.substring(0, endex));
			inString = inString.substring(endex + 1);
			System.out.println(inString);
		}
			words.add(inString);
			sortedString.add(words.get(0));
			/*
			 * Explaining the Algorithm - 
			 * If the sortedString is empty, add the first element from the input to the sortedString.
			 * For all other elements, the element will be before, after, or equal to the front element of the sorted string.
			 * If it's before, it's the new front. If it's equal, add it right before or after the one it's comparing to. 
			 * If it's after, repeat this process until it's before something or the list is done (in which case, it's the last item in the list at the time).
			 * 
			 * How to ensure full sorting from this logic?
			 * Let's think about this for a moment.
			 * Base case - The list is empty. The empty list is sorted by default.
			 * Now, I add an element. The list of one element is sorted by default.
			 * Each new element is being added to a sorted list, so as long as any new element is added in order, the list will be sorted when all of the inputs are in it.
			 * 
			 * So how to ensure that any new element is added in the right place?
			 * Iterate through the list until you find a place where the previous entry is smaller and the next entry is larger.
			 * Since we know at each step that the list is sorted, we know the previous entry is smaller by default (or at worst, equal) if the next entry is larger. 
			 */
			
			for(int i = 1; i < words.size() - 1; i++) { //Since the first element from words is already in the sorted string, we skip it here.
				boolean added = false;
				for(int j = 0; j < sortedString.size(); j++) { //Check words[i] against each element in the output list.
					if(!added && words.get(i).compareTo(sortedString.get(j)) <= 0) { //If sortedString[j] does not precede or equal words[i]...
						 sortedString.add(j, words.get(i));
						 added = true;
						 System.out.println(words.toString());
						 System.out.println(sortedString.toString());
						 continue;
					}
					if(!added && j == sortedString.size() - 1) { //If the new entry doesn't precede or coincide with anything in the list, add it at the end.
						sortedString.add(words.get(i));
					}
				}
			}
			System.out.println("Sort completed! Results: " + sortedString.toString());
		}
		
		else if(modeSetting.equalsIgnoreCase("string")) {
			System.out.println("Alphabetizing the characters in the String.");
			ArrayList<Character> letters = new ArrayList<Character>();
			for(int i = 0; i < inString.length(); i++) {
				letters.add(inString.charAt(i));
			}
			ArrayList<Character> sortedChars= new ArrayList<Character>();
			sortedChars.add(letters.get(0));

			/*
			 * Explaining the Algorithm - 
			 * The same kind of algorithm used for word-based sorting should essentially work here. 
			 */
			
			for(int i = 1; i < letters.size() - 1; i++) { //Since the first element from words is already in the sorted string, we skip it here.
				boolean added = false;
				for(int j = 0; j < sortedChars.size(); j++) { //Check each new character against each element in the output list.
					if(letters.get(i) == ' ') { //Spaces aren't really interesting, so I'll default to omitting them.
						continue;
					}
					if(!added && letters.get(i).compareTo(sortedChars.get(j)) <= 0) { //If sortedString[j] does not precede or equal words[i]...
						sortedChars.add(j, letters.get(i));
						 added = true;
						 System.out.println(letters.toString());
						 System.out.println(sortedChars.toString());
						 continue;
					}
					if(!added && j == sortedChars.size() - 1) { //If the new entry doesn't precede or coincide with anything in the list, add it at the end.
						sortedChars.add(letters.get(i));
					}	
					}
				}
			System.out.println("Sort concluded, entering validation step!");
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
			String inMapString = inMap.toString();
			System.out.println("String composition calculated for input, results are as follows - " + inMapString);
			
			TreeMap<String, Integer> outMap = new TreeMap<String, Integer>();
			for(int i = 0; i < sortedChars.size(); i++) {
				String treeOut = String.valueOf(sortedChars.get(i));
				if(outMap.containsKey(treeOut)) {
					int outCount = outMap.get(treeOut); 
					outMap.replace(treeOut, outCount, outCount + 1);
				} else {
					outMap.put(treeOut, 1);
				}
			}
			outMap.remove(" ");
			outMap.remove(",");
			outMap.remove("[");
			outMap.remove("]");
			outMap.remove(".");
			String outMapString = outMap.toString();
			System.out.println("String composition calculated for output, results are as follows - " + outMapString);
			
			if(inMap.equals(outMap)) {
				System.out.println("Validated! The input and output contain the same set of key-value pairs.");
			} else {
				System.out.println("Validation failed! There is a mismatch between the key-value pairs from the input and output.");
				//I seem to get an extra h, q, w, x, z in my test.
			}
			
		} else {
			while(!(modeSetting.equalsIgnoreCase("words")) && !(modeSetting.equalsIgnoreCase("string"))) {
				System.out.println("Mode selection not recognized.");
				System.out.println("Do you want the 'words' alphabetized, or the 'string'? Please type 'words' or 'string' to select mode.");
				modeSetting = scan.nextLine();
			}
		}
	}

}
