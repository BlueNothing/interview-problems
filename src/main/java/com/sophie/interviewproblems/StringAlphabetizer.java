package com.sophie.interviewproblems;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class StringAlphabetizer {
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
	
	public static void alphabetize(String modeSetting, String inString) {
		ArrayList<String> sortedString = new ArrayList<String>();
		ArrayList<String> words = new ArrayList<String>();
		String inStringArchive = inString;
		while(inString.contains(" ") || inString.contains(".")) {
			int endex = inString.indexOf(" ");
			
			if(endex == -1) {
				endex = inString.indexOf(".");
			}
			
			if(!inString.substring(0, endex).equals("")) {
				if(modeSetting.equalsIgnoreCase("words")) {
				words.add(inString.substring(0, endex));
				}
			inString = inString.substring(endex + 1);
		}
			
		}
		
		if(modeSetting.equalsIgnoreCase("words")) {
			System.out.println("Alphabetizing the words in the String: " + inStringArchive);
			sortedString.add(words.get(0));	
		}
		
		if(modeSetting.equalsIgnoreCase("string")) {
			System.out.println("Alphabetizing the characters in the String.");
			for(int i = 0; i < inStringArchive.length(); i++) {
				String charString = String.valueOf(inStringArchive.charAt(i));
				if(!charString.equals(" ") && !charString.equals(".")) {
				words.add(String.valueOf(inStringArchive.charAt(i))); //Input goes here, character by character.
			}
			}

			System.out.println("Input letters for sort: " + words.toString());
			sortedString.add(words.get(0));
		}
		
		
			for(int i = 1; i < words.size(); i++) { //Since the first element from words is already in the sorted string, we skip it here.
				boolean added = false;
				for(int j = 0; j < sortedString.size(); j++) { //Check words[i] against each element in the output list.
					if(words.get(i) == " ") { //Spaces aren't really interesting, so I'll default to omitting them.
						added = false;
						continue;
					}
					if(!added && words.get(i).compareTo(sortedString.get(j)) <= 0 && j != sortedString.size() - 1) { //If sortedString[j] does not precede or equal words[i]...
						added = true;
						sortedString.add(j, words.get(i));
						 continue;
					}
					else if(!added && j == sortedString.size() - 1) { //If the new entry doesn't precede or coincide with anything in the list, add it at the end.
						added = true;
						sortedString.add(words.get(i));
						continue;
					}
				}
			}
			System.out.println("Sort completed! Results: " + sortedString.toString());
			String validation = validate(modeSetting, inStringArchive, words, sortedString);
			System.out.println(validation);
					}
		
		public static String validate(String modeSetting, String inString,ArrayList<String> words, ArrayList<String> sortedString) {
			System.out.println("Entering validation step!");
			System.out.println("Input string: " + inString);
			System.out.println("Output string: " + sortedString.toString());
			
			TreeMap<String, Integer> inMap = new TreeMap<String, Integer>();
			for(int i = 0; i < words.size(); i++) {
				String treeIn = String.valueOf(words.get(i));
				if(inMap.containsKey(treeIn)) {
					int inCount = inMap.get(treeIn); 
					inMap.replace(treeIn, inCount, inCount + 1);
				} else {
					inMap.put(treeIn, 1);
				}
			}
			
			TreeMap<String, Integer> outMap = new TreeMap<String, Integer>();
			for(int i = 0; i < sortedString.size(); i++) {
				String treeOut = String.valueOf(sortedString.get(i));
				if(outMap.containsKey(treeOut)) {
					int outCount = outMap.get(treeOut); 
					outMap.replace(treeOut, outCount, outCount + 1);
				} else {
					outMap.put(treeOut, 1);
				}
			}
			
			inMap.remove(" ");
			inMap.remove(",");
			inMap.remove("[");
			inMap.remove("]");
			inMap.remove(".");
			
			outMap.remove(" ");
			outMap.remove(",");
			outMap.remove("[");
			outMap.remove("]");
			outMap.remove(".");
			
			String inMapString = inMap.toString();
			System.out.println("String composition calculated for input, results are as follows - " + inMapString);
			String outMapString = outMap.toString();
			System.out.println("String composition calculated for output, results are as follows - " + outMapString);
			
			boolean validated = inMap.equals(outMap) ? true: false;
			String solution = validated ? "Validated! The input and output contain the same set of key-value pairs." : "Validation failed! There is a mismatch between the key-value pairs from the input and output."; 
			
			if(modeSetting.equalsIgnoreCase("string")) {
			System.out.println(pangramChecker(inString, outMap));
			}
			
			return solution;
			
			/*Notes on former errors:
			 * I seem to get an extra h, q, u, w, x, z in the *output* in my test case.
			 * The quick brown fox jumps over the lazy dog.
			 * Expected results -
			 * T=1, a=1, b=1, c=1, d=1, e=3, f=1, g=1, h=2
			 * 
			 * Resolution: Ensure that 'added' is always set to true after an addition, and that the loop continues after each addition to prevent fall-through cases.
			 * 
			 * Coriander -> One of the 'r' characters disappeared in output sort.
			 * Resolution: Make sure that the loop taking inputs into sorting covers the whole input space instead of omitting one.
			 * x < list.size() is good, x == list.size() - 1 is fine, x < list.size() - 1 is not.
			 */ 
		}
	
	public static void main(String[] args) {
		/*
		 * Note: Current iteration of this program is case-insensitive, this can be altered easily.
		 */
		System.out.println("Welcome to the String Alphabetizer program.");
		System.out.println("Please enter the string to alphabetize below.");
		Scanner scan = new Scanner(System.in);
		String inString = scan.nextLine();
		inString = inString.toLowerCase();
		System.out.println("Do you want the 'words' alphabetized, or the 'string'? Please type 'words' or 'string' to select mode.");
		String modeSetting = scan.nextLine();
		while(!(modeSetting.equalsIgnoreCase("words")) && !(modeSetting.equalsIgnoreCase("string"))) {
			System.out.println("Mode selection not recognized.");
			System.out.println("Do you want the 'words' alphabetized, or the 'string'? Please type 'words' or 'string' to select mode.");
			modeSetting = scan.nextLine();
		}
		alphabetize(modeSetting, inString); //Working as expected for by-word alphabetization, but not for by-character alphabetization.
			}
	
	public static String pangramChecker(String inString, TreeMap<String, Integer> outMap) {
	boolean pangramState = true;
	ArrayList<String> alphabet = new ArrayList<String>();
	alphabet.add("a");
	alphabet.add("b");
	alphabet.add("c");
	alphabet.add("d");
	alphabet.add("e");
	alphabet.add("f");
	alphabet.add("g");
	alphabet.add("h");
	alphabet.add("i");
	alphabet.add("j");
	alphabet.add("k");
	alphabet.add("l");
	alphabet.add("m");
	alphabet.add("n");
	alphabet.add("o");
	alphabet.add("p");
	alphabet.add("q");
	alphabet.add("r");
	alphabet.add("s");
	alphabet.add("t");
	alphabet.add("u");
	alphabet.add("v");
	alphabet.add("w");
	alphabet.add("x");
	alphabet.add("y");
	alphabet.add("z");
	if(!outMap.keySet().containsAll(alphabet)) {
		pangramState = false;
	}
	
	return "You may be interested to know it is " + pangramState + " that \"" + inString + "\" is a pangram.";
	
}
}
