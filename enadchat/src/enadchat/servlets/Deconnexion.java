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

public class Deconnexion extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String ICU = "/enadchat/inscription_connexion_utilisateur";

	public static final String ATT_SESSION_UTILISATEUR = "sessionUtilisateur";

	private UtilisateurDao utilisateurDao;

	public void init() throws ServletException {

		this.utilisateurDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getUtilisateurDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		utilisateurDao.supprimerUtilisateursConnectes((Utilisateur) session.getAttribute(ATT_SESSION_UTILISATEUR));

		session.invalidate();

		response.sendRedirect(ICU);

	}

}
