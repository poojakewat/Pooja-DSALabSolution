package com.greatlearning.driver;
import java.util.Scanner;
import java.util.Stack;

public class ParanthesisProblem {

	public ParanthesisProblem() {	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);;
		try {
			System.out.println("Please enter the expression");
			String expression =sc.next();
			//String expression = "{[]}())";
			boolean result = checkBalance(expression);
			if(result)
				System.out.println("The entered String "+expression+" has Balanced Brackets");
			else
				System.out.println("The entered Strings "+expression+" do not contain Balanced Brackets");
		}finally {
			sc.close();
		}
	}

	private static boolean checkBalance(String expression) {
		if(expression.length()%2==1)
			return false;
		Stack<Character> stack = new Stack<>();
		for(int i =0;i<expression.length();i++) {
			char character = expression.charAt(i);

			if(character == '{'|| character == '('|| character == '[')
				stack.push(character);
			else {
				char c = stack.pop();
				switch(character) {
				case '}':
					if(c!='{')
						return false;
					break;
				case ')':
					if(c!='(')
						return false;
					break;
				case ']':
					if(c!='[')
						return false;
					break;
				}
			}

		}
		return stack.isEmpty();
	}
}
