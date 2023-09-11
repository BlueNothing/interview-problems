package com.sophie.interviewproblems;

import java.util.Scanner;

public class TextToBinaryConverter {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the message you'd like to convert to binary.");
		String userInput = scan.nextLine(); //User inputs a string to convert.
		String out = "";
		for(int i = 0; i < userInput.length(); i++) {
			int in = (int) userInput.charAt(i); //Converts character to ASCII encoding for character.
			System.out.println(in);
			String outComp = binarize(in); //Each 'output component' should be an 8-bit binary string.
			out = out.concat(outComp);
			System.out.println("Binary: " + Integer.toBinaryString(in)); //If this matches the "Conversion result" line after leading zeroes, everything is working properly.
		}
		System.out.println(out);
	}

public static String binarize(int in) {
	System.out.println("Binarizing " + in);
	StringBuilder binaryIn = new StringBuilder("0000000"); //Since all ASCII codes are 7 bits, but formatting requires 8, the leading bit is always zero, and we'll add it on at the end.
	for(int i = 6; i >= 0; i--) { 
			if (in >= Math.pow(2, i)) {
				binaryIn.setCharAt((6 - i), '1'); 
				in -= Math.pow(2, i);
		} else {
			binaryIn.setCharAt((6 -i), '0');
		}
	}
	binaryIn = binaryIn.insert(0, '0');
	System.out.println("Conversion result: " + binaryIn.toString());
	
	return binaryIn.toString();
}

}