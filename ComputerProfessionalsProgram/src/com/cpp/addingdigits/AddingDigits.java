package com.cpp.addingdigits;

import java.util.Arrays;

public class AddingDigits {

	public static int add(int number) {

		String[] stringDigits = Integer.toString(number).split("");

		int sum = Arrays.asList(stringDigits).parallelStream().mapToInt(Integer::parseInt).sum();

		return sum <= 9 ? sum : add(sum);
	}

	public static void main(String[] args) {

		int x = 869874569;

		System.out.println(add(x));

	}

}
