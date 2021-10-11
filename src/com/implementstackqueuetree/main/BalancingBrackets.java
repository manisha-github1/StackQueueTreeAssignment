package com.implementstackqueuetree.main;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {

	private static boolean isBalanced(String bracketExpression) {
		Stack stack = new Stack();

		int size = bracketExpression.length();

		// iterate i : 0 -> end of string
		for (int i = 0; i < bracketExpression.length(); i++) {

			// c = String character at i - use charAt( i )
			Character c = bracketExpression.charAt(i);
			// check if the c if one of the opening brackets
			if (c == '{' || c == '[' || c == '(') {
				// push to place opening bracket into the stack
				stack.push(c);
			}
			// else
			else {
				// if stack is empty then return false. Since input string is not balanced
				if (stack.isEmpty()) {
					return false;
				}
				// if input is valid bracket then pop the stack element.
				Character d = (Character) stack.pop();
				
				// Compare input string character "c" and stacked output popped character "d", if it match then proceed, if not then return false.
				if (c == '}' && d != '{' || c == ']' && d != '[' || c == ')' && d != '(') {
					return false;
				}
			}
		}
		// check if stack is empty. If yes then balanced, else not balanced
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String sampleInput;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sample input Bracket String.");
		System.out.println("");
		sampleInput = sc.next();
		// String bracketExpression = "([[{}]])";

		if (isBalanced(sampleInput)) {
			System.out.println(" ");
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println(" ");
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
	}
}
