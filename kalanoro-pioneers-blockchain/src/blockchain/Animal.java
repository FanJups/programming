package blockchain;

public class Animal {

	/*
	 * To learn more about blockchain
	 * 
	 * 1-
	 * https://medium.com/programmers-blockchain/create-simple-blockchain-java-
	 * tutorial-from-scratch-6eeed3cb03fa
	 * 
	 * 2-
	 * https://medium.com/programmers-blockchain/creating-your-first-blockchain-
	 * with-java-part-2-transactions-2cdac335e0ce
	 * 
	 */

	private String espece;

	private String zoneGeographique;

	private String sexe;

	private String nom;

	public Animal(String nom, String espece, String zoneGeographique, String sexe) {

		this.nom = nom;

		this.espece = espece;

		this.zoneGeographique = zoneGeographique;

		this.sexe = sexe;

	}

}
