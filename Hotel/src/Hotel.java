import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Admin
 *
 */
public class Hotel {

	/**
	 * 
	 */

	private String name;
	private int rating;
	private int capacity;
	private ArrayList<Guest> hotel_Guests = new ArrayList<Guest>();

	public Hotel(String name, int rating, int capacity) {
		// TODO Auto-generated constructor stub

		this.name = name;
		this.rating = rating;
		this.capacity = capacity;

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
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity
	 *            the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the hotel_Guests
	 */
	public ArrayList<Guest> getHotel_Guests() {
		return hotel_Guests;
	}

	/**
	 * @param hotel_Guests
	 *            the hotel_Guests to set
	 */
	public void setHotel_Guests(ArrayList<Guest> hotel_Guests) {
		this.hotel_Guests = hotel_Guests;
	}

	public String toString() {
		return "Hotel " + this.name + ", " + this.rating + ", " + this.capacity;
	}

	public void add(Guest g) {

		if (this.hotel_Guests.contains(g)) {
			System.out.println(
					g.getName() + " est déjà présent(e) dans cet hôtel. Par conséquent,l'ajout est impossible !");
		} else {

			if (freeRooms() > 0) {
				this.hotel_Guests.add(g);
			} else {
				System.out.println("Toutes les chambres sont occupées !");
			}

		}

	}

	public void remove(Guest g) {

		if (this.hotel_Guests.contains(g)) {

			this.hotel_Guests.remove(g);

		} else {
			System.out.println(g.getName()
					+ " n'est pas présent(e) dans cet hôtel. Par conséquent,la suppression est impossible !");
		}

	}

	public int freeRooms() {

		return (this.capacity - this.hotel_Guests.size());
	}

	public ArrayList<Guest> youngGuests(int age) {

		ArrayList<Guest> age_Guests = new ArrayList<Guest>();

		for (int i = 0; i < this.hotel_Guests.size(); i++) {

			if (this.hotel_Guests.get(i).getAge() < age) {
				age_Guests.add(hotel_Guests.get(i));
			}
		}

		return age_Guests;
	}

	public ArrayList<Guest> guests_Min_Age(ArrayList<Guest> listguests) {

		/*
		 * Le but c'est de renvoyer une liste de personnes possédant l'âge
		 * minimum
		 */

		int min_age;

		ArrayList<Guest> hotel_minageGuests = new ArrayList<Guest>();

		min_age = listguests.get(0).getAge();

		hotel_minageGuests.add(listguests.get(0));

		for (int i = 0; i < listguests.size(); i++) {

			if (listguests.get(i).getAge() <= min_age) {

				if (listguests.get(i).getAge() < min_age) {

					hotel_minageGuests.removeAll(listguests);

					min_age = listguests.get(i).getAge();

					hotel_minageGuests.add(listguests.get(i));

				}

				if (listguests.get(i).getAge() == min_age) {

					if (hotel_minageGuests.contains(listguests.get(i))) {

					}

					else {

						hotel_minageGuests.add(listguests.get(i));

					}

				}

			}
		}

		return hotel_minageGuests;

	}

	public void printGuests() {

		ArrayList<Guest> guests = new ArrayList<Guest>();

		int indice = 0;

		int comp = 0;

		int printcount = 0;

		guests = this.hotel_Guests;

		int guestsizeinit = guests.size();

		while (printcount < guestsizeinit) {

			if (guests_Min_Age(guests).size() == 1) {

				System.out.println(guests_Min_Age(guests).get(0).toString());

				printcount++;

				for (int i = 0; i < guests.size(); i++) {

					if (guests.get(i).getAge() == guests_Min_Age(guests).get(0).getAge()) {

						indice = i;
					}

				}

				guests.remove(guests.get(indice));

			}

			if (guests_Min_Age(guests).size() > 1) {

				for (int i = 0; i < guests_Min_Age(guests).size(); i++) {

					if (guests_Min_Age(guests).size() == 1) {

						System.out.println(guests_Min_Age(guests).get(i).getName());

						printcount++;

						for (int j = 0; j < guests.size(); j++) {

							if (guests.get(j).getName() == guests_Min_Age(guests).get(i).getName()) {

								indice = j;
							}

						}

						guests.remove(guests.get(indice));

					} else {

						comp = guests_Min_Age(guests).get(i).getName()
								.compareTo(guests_Min_Age(guests).get(i + 1).getName());

						if (comp < 0) {
							System.out.println(guests_Min_Age(guests).get(i).getName());

							printcount++;

							for (int j = 0; j < guests.size(); j++) {

								if (guests.get(j).getName() == guests_Min_Age(guests).get(i).getName()) {

									indice = j;
								}

							}

							guests.remove(guests.get(indice));

						}

						if (comp > 0) {
							System.out.println(guests_Min_Age(guests).get(i + 1).getName());

							printcount++;

							for (int j = 0; j < guests.size(); j++) {

								if (guests.get(j).getName() == guests_Min_Age(guests).get(i + 1).getName()) {

									indice = j;
								}

							}

							guests.remove(guests.get(indice));
						}

					}

				}

			}

		}

	}

}
