package enadchat.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enadchat.beans.Utilisateur;
import enadchat.dao.DAOFactory;
import enadchat.dao.UtilisateurDao;
import enadchat.forms.AccueilChatForm;

public class AccueilChat extends HttpServlet {

	public static final String VUE_CHAT = "/WEB-INF/accueilchat.jsp";

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String ATT_SESSION_UTILISATEUR = "sessionUtilisateur";

	public static final String ATT_UTILISATEUR = "utilisateur";

	private UtilisateurDao utilisateurDao;

	public void init() throws ServletException {

		this.utilisateurDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getUtilisateurDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AccueilChatForm form = new AccueilChatForm(utilisateurDao);

		ArrayList<Utilisateur> utilisateursConnectes = form.listePersonnesConnectees(request);

		request.setAttribute("utilisateurs", utilisateursConnectes);

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 * 
		 * 
		 */

		this.getServletContext().getRequestDispatcher(VUE_CHAT).forward(request, response);

	}

}
