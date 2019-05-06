package enadchat.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enadchat.beans.Utilisateur;
import enadchat.dao.DAOFactory;
import enadchat.dao.UtilisateurDao;
import enadchat.forms.InscriptionUtilisateurForm;

public class InscriptionUtilisateur extends HttpServlet {

	public static final String VUE_ICU = "/WEB-INF/inscriptionUtilisateur.jsp";

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String ATT_UTILISATEUR = "utilisateur";

	public static final String ATT_SESSION_UTILISATEUR = "sessionUtilisateur";

	public static final String ATT_FORM = "form";

	public static final String ACCUEIL_UTILISATEUR = "/enadchat/accueilchat";

	private UtilisateurDao utilisateurDao;

	public void init() throws ServletException {

		this.utilisateurDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getUtilisateurDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 * 
		 * 
		 */

		this.getServletContext().getRequestDispatcher(VUE_ICU).forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		InscriptionUtilisateurForm form = new InscriptionUtilisateurForm(utilisateurDao);

		Utilisateur utilisateur = form.inscrireUtilisateur(request);

		request.setAttribute(ATT_FORM, form);

		request.setAttribute(ATT_UTILISATEUR, utilisateur);

		if (form.getErreurs().isEmpty()) {

			HttpSession session = request.getSession();

			session.setAttribute(ATT_SESSION_UTILISATEUR, utilisateur);

			response.sendRedirect(ACCUEIL_UTILISATEUR);

		} else {

			this.getServletContext().getRequestDispatcher(VUE_ICU).forward(request, response);

		}

	}

}
