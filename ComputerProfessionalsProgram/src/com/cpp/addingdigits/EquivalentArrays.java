package com.cpp.addingdigits;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EquivalentArrays {

	static int equivalentArrays(int[] a1, int[] a2) {

		Integer[] tab1 = IntStream.of(a1).boxed().toArray(Integer[]::new);
		Integer[] tab2 = IntStream.of(a2).boxed().toArray(Integer[]::new);

		Set<Integer> s1 = new HashSet<>(Arrays.asList(tab1));
		Set<Integer> s2 = new HashSet<>(Arrays.asList(tab2));

		return s1.containsAll(s2) && s2.containsAll(s1) ? 1 : 0;

	}

	static int hasSingleMaximum(int[] a) {

		if (a == null)
			return 0;
		if (a.length == 0)
			return 0;

		Integer[] tab = IntStream.of(a).boxed().toArray(Integer[]::new);

		List<Integer> l = Arrays.asList(tab);

		int max = l.parallelStream().max(Integer::compare).get();

		return Collections.frequency(l, max) == 1 ? 1 : 0;

	}

	static int isTwinPaired(int[] a) {
		if (a == null)
			return 0;

		IntPredicate even = value -> value % 2 == 0;
		IntPredicate odd = value -> value % 2 != 0;

		int[] aEven = IntStream.of(a).filter(even).toArray();

		int[] aOdd = IntStream.of(a).filter(odd).toArray();

		for (int i = 0; i < aEven.length - 1; i++) {
			if (aEven[i] > aEven[i + 1])
				return 0;
		}

		for (int i = 0; i < aOdd.length - 1; i++) {
			if (aOdd[i] > aOdd[i + 1])
				return 0;
		}

		return 1;

	}

	public static void main(String[] args) {

		int[] a = {};

		System.out.println(isTwinPaired(a));

	}

}
