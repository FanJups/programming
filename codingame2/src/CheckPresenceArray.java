import java.util.Arrays;

public class CheckPresenceArray {

	static boolean exists(int[] ints, int k) {

		/*
		 * boolean compteur = false;
		 * 
		 * for (int i = 0; i < ints.length; i++) { if (k == ints[i]) { compteur = true;
		 * 
		 * break; } }
		 * 
		 * return compteur;
		 */

		if (Arrays.binarySearch(ints, k) >= 0) {
			return true;
		} else {
			return false;
		}

	}

	static int maxInts(int[] ints) {

		int max = 0;

		if (ints.length > 0) {
			max = ints[0];

			for (int i = 0; i < ints.length; i++) {
				if (ints[i] > max) {
					max = ints[i];
				}
			}
		} else {
			// Nothing to do
		}

		return max;

	}

	public static boolean ifMagic(String mot) {
		boolean test = false;

		char[] voyelles = { 'a', 'e', 'i', 'o', 'u', 'y' };

		char[] data = new char[26];
		String[] alphabet = new String[26]; // a- z
		for (int i = 0; i < 26; i++) {
			data[i] = (char) (65 + (i / 26) * 6 + i);

			alphabet[i] = data[i] + "";

			alphabet[i] = alphabet[i].toLowerCase();

		}

		if (mot.trim().length() >= 5 && mot.trim().length() <= 7) {

			char mot0 = mot.charAt(0);

			char mot1 = mot.charAt(1);

			char derniereLettre = mot.charAt(mot.trim().length() - 1);

			if (Arrays.binarySearch(alphabet, mot0 + "") >= 0) {

				if (Arrays.binarySearch(alphabet, mot1 + "") >= 0) {

					// Les 2 premières lettres sont des lettres alphabétiques

					if (Character.toLowerCase(mot0) < Character.toLowerCase(mot1)) {
						// les deux lettres se suivent

						if (Arrays.binarySearch(voyelles, derniereLettre) >= 0) {
							test = true;
						}

					}

				}

			}

		}

		return test;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ints = { -9, 14, 37, 102 };
		System.out.println(CheckPresenceArray.exists(ints, 102)); // true
		System.out.println(CheckPresenceArray.exists(ints, 36)); // false

		/**
		 * Descent codin game
		 * 
		 ***/

		int[] tab = { 12, 1, 21, 8 };
		int min = Arrays.stream(tab).min().getAsInt();
		int max = Arrays.stream(tab).max().getAsInt();
		System.out.println("Min = " + min);
		System.out.println("Max = " + max);

		// Max

		System.out.println("Max basique = " + CheckPresenceArray.maxInts(tab));

		// Décalage logique

		int intX = 3;

		int decDIntX = intX >> 2;

		int decGIntX = intX << 2;

		// déc à gauche = multiplication par 2 en binaire

		// déc à droite = div entière par 2 en binaire

		System.out.println(" Déc G : " + decGIntX);

		System.out.println(" Déc D : " + decDIntX);

		// MAGIC WORD

		String mot = "abaazy ";

		System.out.println("?g = " + CheckPresenceArray.ifMagic(mot));

	}

}
