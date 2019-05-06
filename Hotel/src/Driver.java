
/**
 * 
 */

/**
 * @author Admin
 *
 */

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hotel h1 = new Hotel("4HWC", 1, 1000);
		Hotel h2 = new Hotel("Hilton", 3, 200);

		Guest g1 = new Guest("Fanon", 22);
		Guest g2 = new Guest("Allissone", 22);

		h1.add(g2);
		h1.add(g1);
		h1.printGuests();

		System.out.println(h1.toString());
		System.out.println(h2.toString());

	}

}
