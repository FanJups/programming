package com.cpp.oddcenteredarray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class CenteredArrays {

	public static int centered(int[] tab) {

		Integer[] tab2 = IntStream.of(tab).boxed().toArray(Integer[]::new);

		int l = tab2.length;
		int result = 1;
		if (l % 2 == 0)
			result = 0;
		else {
			if (l == 1)
				result = 1;
			else {

				// middle element is the minimum

				int min = Arrays.stream(tab2).min(Integer::compare).get();

				if (min == tab[l / 2]) {
					// middle element is unique

					Set<Integer> s = new HashSet<>(Arrays.asList(tab2));

					result = (s.size() == tab.length) ? 1 : 0;

				} else {

					result = 0;
				}

			}

		}

		return result;

	}

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5 };

		System.out.println(centered(a));

	}

}
