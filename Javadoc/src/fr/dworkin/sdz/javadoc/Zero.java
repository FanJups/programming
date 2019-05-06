package fr.dworkin.sdz.javadoc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * <b>Zero est la classe représentant un membre du Site du Zéro.</b>
 * <p>
 * Un membre du SDZ est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un identifiant unique attribué définitivement.</li>
 * <li>Un pseudo,susceptioble d'être changé.</li>
 * <li>Un "level".Il peut être "zéro",newser,validateur,modérateur,etc.</li>
 * </ul>
 * </p>
 * <p>
 * De plus,un Zéro a une liste d'amis Zéro.Le membre pourra ajouter ou enlever
 * des amis à cette liste.
 * </p>
 *
 * @see SDZLevel
 *
 * @author dworkin
 * @version 3.0
 */

public class Zero {

	/**
	 * L'ID du Zéro.Cet ID n'est pas modifiable.
	 * 
	 * @see Zero#Zero(int,String)
	 * @see Zero#getId()
	 */
	private int id;
	/**
	 * Le pseudo du Zéro.Ce pseudo est changeable.
	 *
	 * @see Zero#getPseudo()
	 * @see Zero#setPseudo(String)
	 */
	private String pseudo;

	/**
	 * Le "level" du Zéro. Ce "level" peut être modifié.
	 * <p>
	 * Pour de plus amples informations sur les "levels" possibles,regardez la
	 * documentation de la classe SDZLevel.
	 * </p>
	 * 
	 * @see SDZLevel
	 * 
	 * @see Zero#getLevel()
	 * @see Zero#setLevel(SDZLevel)
	 */
	private SDZLevel level;
	/**
	 * La liste des amis du Zéro.
	 * <p>
	 * Il est possible d'ajouter ou de retirer des amis dans cette liste.
	 * </p>
	 * 
	 * @see Zero#getListeAmis()
	 * @see Zero#ajouterAmi(Zero)
	 * @see Zero#retirerAmi(Zero)
	 */

	private List<Zero> listeAmis;

	/**
	 * Constructeur Zero.
	 * <p>
	 * A la construction d'un objet Zéro, le "level" est fixé à SDZLevel.ZERO,ce
	 * qui correspond au niveau d'un membre.De plus, la liste des amis est créée
	 * vide.
	 * </p>
	 * 
	 * @param id
	 *            L'identifiant unique du Zéro.
	 * @param pseudo
	 *            Le pseudo du Zéro.
	 *
	 * @see Zero#id
	 * @see Zero#pseudo
	 * @see Zero#level
	 * @see Zero#listeAmis
	 */

	public Zero(int id, String pseudo) {
		this.id = id;
		this.pseudo = pseudo;
		this.level = SDZLevel.ZERO;
		listeAmis = new ArrayList<Zero>();
	}

	/**
	 * Ajoute un Zéro à la liste des amis.
	 * 
	 * @param ami
	 *            Le nouvel ami du Zéro.
	 * @see Zero#listeAmis
	 */

	public void ajouterAmi(Zero ami) {
		listeAmis.add(ami);
	}

	/**
	 * Retire un Zéro à la liste des amis
	 * 
	 * @param ancienAmi
	 *            Un ancien ami du Zéro.
	 * @see Zero#listeAmis
	 */

	public void retirerAmi(Zero ancienAmi) {
		listeAmis.remove(ancienAmi);
	}

	/**
	 * Retourne l'ID du Zéro.
	 * 
	 * @return L'identifiant du membre
	 */

	public int getId() {
		return id;
	}

	/**
	 * Retourne le pseudo du Zéro.
	 * 
	 * @return Le pseudo du membre,sous forme d'une chaîne de caractères.
	 */

	public String getPseudo() {
		return pseudo;
	}

	/**
	 * Retourne le level du Zéro.
	 * 
	 * @return Une instance de SDZLevel,qui correspond au niveau du membre sur
	 *         SDZ.
	 * 
	 * @see SDZLevel
	 */

	public SDZLevel getLevel() {
		return level;
	}

	/**
	 * Met à jour le niveau du membre.
	 * 
	 * @param level
	 *            Le nouveau level du membre.
	 * 
	 * @see SDZLevel
	 */

	protected void setLevel(SDZLevel level) {
		this.level = level;
	}

	/**
	 * Met à jour le pseudo du membre.
	 * 
	 * @param pseudo
	 *            Le nouveau pseudo du membre.
	 * 
	 * @since 3.0
	 */

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * Retourne la liste des amis du Zéro.
	 * 
	 * @return La liste des amis du Zéro.
	 * 
	 * @see Zero
	 */

	protected List<Zero> getListeAmis() {
		return listeAmis;
	}

	/**
	 * Retourne la liste des amis du Zéro.
	 * 
	 * @return La liste des amis du Zéro,sous la forme d'un vecteur.
	 * 
	 * @deprecated Depuis Java 1.4,remplacé par getListeAmis()
	 * 
	 * @see Zero
	 * @see Zero#getListeAmis()
	 */

	protected Vector<Zero> getVectorAmis() {
		Vector<Zero> vector = new Vector<Zero>();
		for (Zero z : listeAmis) {
			vector.add(z);
		}
		return vector;
	}

	/**
	 * Retourne l'adresse du profil du Zéro.
	 * 
	 * @return L'URL du profil du Zéro,générée à partir de l'id du Zéro
	 * 
	 * @throws MalformedURLException
	 *             Si jamais l'url est mal formée.
	 * 
	 * @see Zero#id
	 */

	public URL getURLProfil() throws MalformedURLException {
		URL url = new URL("http://www.siteduzero.com/membres-294-" + id + ".html");
		return url;
	}

}
