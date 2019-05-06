package charsequence;

import java.util.Stack;

public class charSequence {

	/*
	 * 
	 * https://stackoverflow.com/questions/16874176/parenthesis-brackets-
	 * matching-using-stack-algorithm
	 * 
	 * https://www.google.fr/search?q=string+brackets+java&oq=string+brackets&
	 * aqs=chrome.1.69i57j0l5.11189j1j7&sourceid=chrome&ie=UTF-8
	 * 
	 * 
	 */

	public boolean CheckParentesis(String str) {
		if (str.isEmpty())
			return true;

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);
			if (current == '{' || current == '(' || current == '[') {
				stack.push(current);
			}

			if (current == '}' || current == ')' || current == ']') {
				if (stack.isEmpty())
					return false;

				char last = stack.peek();
				if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
					stack.pop();
				else
					return false;
			}

		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		charSequence test = new charSequence();

		System.out.println(test.CheckParentesis(""));

	}

}
