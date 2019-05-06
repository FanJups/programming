package enadchat.dao;

import java.util.ArrayList;

import enadchat.beans.Utilisateur;

public interface UtilisateurDao {

	Utilisateur trouver(String identifiant_utilisateur) throws DAOException;

	Utilisateur trouverIdentifMdp(String identifiant_utilisateur, String mdp_utilisateur) throws DAOException;

	void creer(Utilisateur utilisateur) throws DAOException;

	void utilisateursConnectes(Utilisateur utilisateur) throws DAOException;

	void supprimerUtilisateursConnectes(Utilisateur utilisateur) throws DAOException;

	ArrayList<Utilisateur> trouver_utilisateurs_connectes() throws DAOException;

}
