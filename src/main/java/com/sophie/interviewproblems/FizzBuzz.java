package com.sophie.interviewproblems;

public class FizzBuzz {

	public static void main(String[] args) {
		System.out.println("The objective of this program is to count the numbers from 1 to 100.");
		System.out.println("However, numbers divisible by three should be replaced by 'Fizz'.");
		System.out.println("Numbers divisible by five should be replaced by 'Buzz'.");
		System.out.println("Numbers divisible by three *and* five should be replaced by 'FizzBuzz'.");
		System.out.println("Proceeding...");
		/*
		 * Rationale for solution:
		 * Need to iterate from 1 to 100, so a for loop is a simple solution.
		 * While it's possible to start by defining a String with the value of the integer, and replacing that value, this is inefficient.
		 * Instead, check for the 'Fizz' and 'Buzz' properties, store them as booleans, and find FizzBuzz values with AND statements.
		 */
		for(int i = 1; i< 101; i++) {
			boolean isFizz = false;
			boolean isBuzz = false;
			boolean isFizzBuzz = false;
			if((i % 3) == 0) {
				isFizz = true;
				}
			if((i % 5) == 0) {
				isBuzz = true;
			}
			if(isFizz && isBuzz) {
				isFizzBuzz = true;
			}
			if(isFizzBuzz) {
				System.out.println(" FizzBuzz ");
			}
			else if(isFizz) {
				System.out.println(" Fizz ");
			} 
			else if(isBuzz) {
				System.out.println(" Buzz ");
			} else {
				System.out.println(" " + String.valueOf(i) + " ");
			}
		}

	}

}
