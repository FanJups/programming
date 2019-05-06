package duel;

public class Duel {

	// n>=2

	int erty = 12;

	public int numberOfDuels(int n) {
		/*
		 * int S = 0; while (n >= 2) {
		 * 
		 * n--;
		 * 
		 * S = S + n;
		 * 
		 * }
		 */

		int quick = n * (n - 1);

		int res = quick / 2;

		return res;
	}

	public int factoriel(int n) {

		int i, fact = 1;

		for (i = 1; i <= n; i++) {
			fact = fact * i;
		}

		return fact;
	}

	public int numberOfDuels2(int n) {
		int res = factoriel(n) / (2 * factoriel(n - 2));

		return res;
	}

	public static void callA(int x) {
		x += 2;
	}

	public static void callB(int x[]) {
		x[0] += 2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Duel d = new Duel();

		System.out.println(d.numberOfDuels2(10000));

		// System.out.println(erty);

		/*
		 * 
		 * int a = 10; int b[] = { 10 }; callA(a); callB(b);
		 * System.out.println("Output: " + a + " " + b[0]);
		 * 
		 */

	}

}
