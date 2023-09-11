package com.sophie.interviewproblems;

import java.util.Scanner;

public class MultiplicationAlgorithm {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the integer multiplication program! Please insert the numbers you wish to multiply.");
		System.out.println("First input: ");
		int first = scan.nextInt();
		System.out.println("Second input: ");
		int second = scan.nextInt();
		System.out.println("Product: " + multiply(first, second));
	}
	
	public static int multiply(int first, int second) {
		int product = 0;
		boolean isNegative = false;
		if (second < 1) {
			isNegative = true;
			second = Math.absExact(second);
		}
		for(int i = 0; i < second; i++) {
			product += first;
		}
		if(isNegative) {
			product = -product;
		}
		return product;
	}

}
