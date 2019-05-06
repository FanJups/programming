package changeBillsCoins;

public class Solution {

	// Liens utiles

	// https://www.google.fr/search?ei=NdIEXLeQDIqqa57NkbAO&q=optimal+way+to+give+back+a+certain+amount+java+change+10+euros+5+euros+2+euros&oq=optimal+way+to+give+back+a+certain+amount+java+change+10+euros+5+euros+2+euros&gs_l=psy-ab.3...701869.720610..720845...0.0..0.174.3204.34j6......0....1..gws-wiz.......0i71j35i39j33i160j33i21.pKBI9jdFFwE

	// https://codereview.stackexchange.com/questions/202430/optimal-change-with-only-with-two-euros-coins-and-five-and-ten-euros-bills

	// https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/

	// https://stackoverflow.com/questions/46596510/java-least-number-of-bills-and-coins-for-change

	// https://codereview.stackexchange.com/questions/47397/find-minimum-number-of-coins

	// https://www.daniweb.com/programming/software-development/threads/384132/give-change-money-least-bills-and-coins-needed

	static Change optimalChange(long s) {
		long change = s;
		Change c = new Change();
		if (change >= 10) {
			if (change % 2 != 0 && change % 5 != 0) {
				return dealWithChangeLike31Euros(change);
			} else {
				c.bill10 = (long) change / 10;
				change = change % c.bill10;
			}
		}

		if (change < 10 && change >= 5) {
			if (change % 2 == 0) {
				c.bill5 = 0;
				c.coin2 = change / 2;
			} else {
				change = change - 5;
				c.bill5 = 1;
			}
		}

		else if (change % 2 == 0) {
			c.bill5 = 0;
			c.coin2 = change / 2;
		} else {
			return null;
		}
		return c;
	}

	static Change dealWithChangeLike31Euros(long s) {
		Change c = new Change();
		// c.bill10 = ((long) s / 10) - 1;

		c.bill10 = ((long) s / 10);

		long change = (long) s % (c.bill10 * 10);
		if (change > 5) {
			change = change - 5;
			c.bill5 = 1;
		}
		if (change % 2 == 0) {
			c.coin2 = change / 2;
		} else {
			return null;
		}
		return c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Change x = Solution.optimalChange(10L);

		System.out
				.println(" 10 euros : " + x.bill10 + " / " + " 5 euros : " + x.bill5 + " / " + " 2 euros : " + x.coin2);

	}

}
