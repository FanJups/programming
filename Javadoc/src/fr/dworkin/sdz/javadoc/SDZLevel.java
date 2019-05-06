package fr.dworkin.sdz.javadoc;

/**
 * <b>SDZLevel est un type énuméré "type-safe".</b>
 * <p>
 * Il existe cinq types de membres sur le Site du Zéro :
 * <ul>
 * <li>Membre</li>
 * <li>Newser</li>
 * <li>Validateur</li>
 * <li>Modérateur</li>
 * <li>Administrateur</li>
 * </ul>
 * </p>
 * <p>
 * <b>Note : </b> Cette énumération a été modifiée il y a un mois pour rajouter
 * le niveau "Newser"
 * </p>
 * 
 * @author dworkin,zozor
 * @version 3.1
 */

public enum SDZLevel {

	/**
	 * L'énumérateur des niveaux
	 * 
	 * <b>Note : </b> le niveau newser a été rajouté en 2007
	 * 
	 * @since 2007
	 */

	ZERO("Zéro", 0), NEWSER("Newser", 1), VALIDATEUR("Validateur", 2), MODERATEUR("Modérateur", 3), ADMIN("Administrateur", 4);

	/**
	 * Le nom du "level"
	 */

	private String nom;

	/**
	 * La valeur du "level"
	 */

	private int valeur;

	/**
	 * Constructeur SDZLevel.
	 * 
	 * @param nom
	 *            Le nom du "level".
	 * @param valeur
	 *            La valeur du "level".
	 */

	private SDZLevel(String nom, int valeur) {
		this.nom = nom;
		this.valeur = valeur;
	}

	/**
	 * Retourne le nom du "level".
	 * 
	 * @return Le nom du niveau correspondant,sous forme d'une chaîne de
	 *         caractères.
	 */

	public String getNom() {
		return this.nom;
	}

	/**
	 * Retourne la valeur du "level".
	 * 
	 * @return La valeur du niveau,sous forme d'un entier.
	 */

	public int getValeur() {
		return this.valeur;
	}

}
