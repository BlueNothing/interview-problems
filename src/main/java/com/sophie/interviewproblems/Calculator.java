package com.sophie.interviewproblems;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		System.out.println("Welcome to the calculator program.");
		System.out.println("Please note that the current iteration of the program resolves Addition, Subtraction, Integer Multiplication, and Modulus. Division, Exponentiation, and other functionality are pending.");
		System.out.println("Please also note that at this time, nested parens and expressions ending with a paren may not be properly supported.");
		System.out.println("Please enter the computation you want to solve on the next line.");
		Scanner scan = new Scanner(System.in);
		ArrayList<String> eqnParts = new ArrayList<String>();
		String eqn = scan.nextLine();
		if(eqn.contains("(")){
			eqnParts.add(eqn.substring(eqn.indexOf("("), eqn.indexOf(")")));
			eqn = eqn.substring(0, eqn.indexOf("(")).concat(eqn.substring(eqn.indexOf(")") + 1));
		}
		
		

	}

}
