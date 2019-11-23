package com.cpp.reverseintenger;

public class ReverseInteger {

	public static int f(int n) {

		String x = n < 0 ? Integer.toString(-n) : Integer.toString(n);

		String res = "";

		for (int i = x.length() - 1; i >= 0; i--)

			res = res + x.charAt(i);

		return n < 0 ? Integer.parseInt("-" + res) : Integer.parseInt(res);
	}

	public static void main(String[] args) {

		System.out.println(f(-12345));
	}

}
