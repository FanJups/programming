/**
 * 
 */

/**
 * @author Admin
 *
 */
public class Guest {

	/**
	 * 
	 */

	private String name;
	private int age;

	public Guest(String name, int age) {
		// TODO Auto-generated constructor stub

		this.name = name;
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "Guest " + this.name + ", " + this.age;
	}

}
