package com.cpp.lengthcharacters;

public class LengthCharacters {

	public static char[] lengthCharacters(char[] a, int start, int len) {

		int aLength = a.length;

		if (aLength == 0)
			return null;

		else {
			if (start >= 0 && start <= aLength - 1) {
				if (len >= 0) {
					int end = len + start - 1;

					if (end >= 0 && end <= aLength - 1) {

						char[] result = new char[len];

						for (int j = 0, i = start; i <= end && j < len; i++, j++)

							result[j] = a[i];

						return result;

					} else
						return null;

				} else
					return null;

			} else {

				return null;
			}

		}

	}

	public static void main(String[] args) {

		char[] a = { 'a', 'b', 'c' };
		int start = 0;
		int len = 4;

		try {
			System.out.println(lengthCharacters(a, start, len));

		} catch (NullPointerException e) {

			System.out.println("null");

		}

	}

}
