package com.cpp.diffsumoddeven;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class DiffSumOddEven {

	public static int diffSum(int[] tab) {
		IntPredicate even = value -> value % 2 == 0;
		IntPredicate odd = value -> value % 2 != 0;
		int sumEven = IntStream.of(tab).filter(even).sum();
		int sumOdd = IntStream.of(tab).filter(odd).sum();
		return sumOdd - sumEven;
	}

	public static void main(String[] args) {
		int[] a = {};

		System.out.println(diffSum(a));

	}

}
