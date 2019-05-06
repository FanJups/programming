package enadchat.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Utilisateur implements Serializable {

	private Long id_utilisateur;

	private String identifiant_utilisateur;

	private String noms_prenoms_utilisateur;

	private String mdp_utilisateur;

	private Timestamp date_heure_inscription_utilisateur;

	/**
	 * @return the id_utilisateur
	 */
	public Long getId_utilisateur() {
		return id_utilisateur;
	}

	/**
	 * @param id_utilisateur
	 *            the id_utilisateur to set
	 */
	public void setId_utilisateur(Long id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	/**
	 * @return the identifiant_utilisateur
	 */
	public String getIdentifiant_utilisateur() {
		return identifiant_utilisateur;
	}

	/**
	 * @param identifiant_utilisateur
	 *            the identifiant_utilisateur to set
	 */
	public void setIdentifiant_utilisateur(String identifiant_utilisateur) {
		this.identifiant_utilisateur = identifiant_utilisateur;
	}

	/**
	 * @return the noms_prenoms_utilisateur
	 */
	public String getNoms_prenoms_utilisateur() {
		return noms_prenoms_utilisateur;
	}

	/**
	 * @param noms_prenoms_utilisateur
	 *            the noms_prenoms_utilisateur to set
	 */
	public void setNoms_prenoms_utilisateur(String noms_prenoms_utilisateur) {
		this.noms_prenoms_utilisateur = noms_prenoms_utilisateur;
	}

	/**
	 * @return the mdp_utilisateur
	 */
	public String getMdp_utilisateur() {
		return mdp_utilisateur;
	}

	/**
	 * @param mdp_utilisateur
	 *            the mdp_utilisateur to set
	 */
	public void setMdp_utilisateur(String mdp_utilisateur) {
		this.mdp_utilisateur = mdp_utilisateur;
	}

	/**
	 * @return the date_heure_inscription_utilisateur
	 */
	public Timestamp getDate_heure_inscription_utilisateur() {
		return date_heure_inscription_utilisateur;
	}

	/**
	 * @param date_heure_inscription_utilisateur
	 *            the date_heure_inscription_utilisateur to set
	 */
	public void setDate_heure_inscription_utilisateur(Timestamp date_heure_inscription_utilisateur) {
		this.date_heure_inscription_utilisateur = date_heure_inscription_utilisateur;
	}

}
