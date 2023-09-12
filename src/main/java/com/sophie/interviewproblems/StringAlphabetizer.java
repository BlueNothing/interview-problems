package com.sophie.interviewproblems;

import java.util.ArrayList;
import java.util.Scanner;

public class StringAlphabetizer {
	
	public static void main(String[] args) {
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
		}
			for(int i = 0; i < words.size() - 2; i++) {
				if(words.get(i).compareTo(words.get(i + 1)) < 1) {
					String store = words.get(i);
					words.set(i, words.get(i + 1));
					words.set(i + 1, store);
				}
			}
		}
		else if(modeSetting.equalsIgnoreCase("string")) {
			
		} else {
			while(!(modeSetting.equalsIgnoreCase("words")) && !(modeSetting.equalsIgnoreCase("string"))) {
				System.out.println("Mode selection not recognized.");
				System.out.println("Do you want the 'words' alphabetized, or the 'string'? Please type 'words' or 'string' to select mode.");
				modeSetting = scan.nextLine();
			}
		}
	}

}
