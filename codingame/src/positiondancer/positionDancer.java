package positiondancer;

public class positionDancer {

	/*
	 * Sources :
	 * 
	 * https://www.google.fr/search?q=position+of+dancer+java&oq=position+of+
	 * dancer+java&aqs=chrome..69i57.10005j1j7&sourceid=chrome&ie=UTF-8
	 * 
	 * https://stackoverflow.com/questions/41292387/reccurence-algorithm-find-
	 * position-after-n-moves
	 * 
	 * https://math.stackexchange.com/questions/893293/finding-the-position-at-n
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public int getPosition(int n) {
		int tab[] = { 0, 1, -1, -4, -5, -3 };

		return tab[n % 6];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		positionDancer d = new positionDancer();

		System.out.println(d.getPosition(3));

	}

}
