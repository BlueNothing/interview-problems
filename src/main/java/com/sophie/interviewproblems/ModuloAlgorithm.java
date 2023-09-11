package com.sophie.interviewproblems;

import java.util.Scanner;

public class ModuloAlgorithm {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the modulus program! Please insert the number you want to take the modulus of.");
		System.out.println("Input: ");
		int first = scan.nextInt();
		System.out.println("Modulo input: ");
		int second = scan.nextInt();
		System.out.println("Modulus: " + mod(first, second));
	}
	
	public static int mod(int first, int second) {
		int mod = 0;
		boolean isNegative = false;
		if (first < 0 ^ second < 0) {
			first = Math.abs(first);
			second = Math.abs(second);
			isNegative = true;
		}
		if(second == 0) {
			throw new ArithmeticException("Division by zero error. " + first + " mod " + second + " requires division by zero to execute.");
		}
			while(first >= second) {
				first -= second;
			}
			mod = first;
			if (isNegative) {
				mod = -mod;
			}
			return mod;
		}

}
