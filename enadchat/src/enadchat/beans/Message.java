package enadchat.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Message implements Serializable {

	private Long id_message;

	private String texte_message;

	private String identifiant_emetteur;

	private String identifiant_destinataire;

	private Timestamp date_heure_creation_message;

	/**
	 * @return the id_message
	 */
	public Long getId_message() {
		return id_message;
	}

	/**
	 * @param id_message
	 *            the id_message to set
	 */
	public void setId_message(Long id_message) {
		this.id_message = id_message;
	}

	/**
	 * @return the texte_message
	 */
	public String getTexte_message() {
		return texte_message;
	}

	/**
	 * @param texte_message
	 *            the texte_message to set
	 */
	public void setTexte_message(String texte_message) {
		this.texte_message = texte_message;
	}

	/**
	 * @return the identifiant_emetteur
	 */
	public String getIdentifiant_emetteur() {
		return identifiant_emetteur;
	}

	/**
	 * @param identifiant_emetteur
	 *            the identifiant_emetteur to set
	 */
	public void setIdentifiant_emetteur(String identifiant_emetteur) {
		this.identifiant_emetteur = identifiant_emetteur;
	}

	/**
	 * @return the identifiant_destinataire
	 */
	public String getIdentifiant_destinataire() {
		return identifiant_destinataire;
	}

	/**
	 * @param identifiant_destinataire
	 *            the identifiant_destinataire to set
	 */
	public void setIdentifiant_destinataire(String identifiant_destinataire) {
		this.identifiant_destinataire = identifiant_destinataire;
	}

	/**
	 * @return the date_heure_creation_message
	 */
	public Timestamp getDate_heure_creation_message() {
		return date_heure_creation_message;
	}

	/**
	 * @param date_heure_creation_message
	 *            the date_heure_creation_message to set
	 */
	public void setDate_heure_creation_message(Timestamp date_heure_creation_message) {
		this.date_heure_creation_message = date_heure_creation_message;
	}

}
