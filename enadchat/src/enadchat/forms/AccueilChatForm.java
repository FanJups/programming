package enadchat.forms;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import enadchat.beans.Utilisateur;
import enadchat.dao.UtilisateurDao;

public final class AccueilChatForm {

	private UtilisateurDao utilisateurDao;

	public AccueilChatForm(UtilisateurDao utilisateurDao) {

		this.utilisateurDao = utilisateurDao;
	}

	public ArrayList<Utilisateur> listePersonnesConnectees(HttpServletRequest request) {

		return utilisateurDao.trouver_utilisateurs_connectes();

	}

}
