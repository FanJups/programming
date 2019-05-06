package reshapeStrings;

import java.util.Scanner;

/**
 *
 * @author AntoFra
 */
public class Reshape_string {
	/*
	 * Statement The reshape(n, str) method should return the string str without
	 * spaces and layed out in lines of at most n characters. Examples: reshape(3,
	 * "abc de fghij") => returns "abc\ndef\nghi\nj" reshape(6, "1 23 456") =>
	 * returns "123456"
	 */

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str;
		int num;

		// insert a string and a number
		System.out.print("Insert a string: ");
		str = input.nextLine();
		System.out.print("Insert the number of character: ");
		num = input.nextInt();

		// print the result of the reshape method
		System.out.println("Result of reshape method: " + '\n' + reshape(num, str));
	}

	public static String reshape(int n, String str) {
		// replace each space with empty string
		str = str.replace(" ", "");

		// insert a '\n' character each n characters
		String res = "";
		for (int i = 0; i < str.length(); i++) {
			if (i % n == 0 && i != 0)
				res = res + '\n' + str.charAt(i);
			else
				res += str.charAt(i);
		}

		return res;
	}
}
