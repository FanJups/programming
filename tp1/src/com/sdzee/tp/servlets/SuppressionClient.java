package com.sdzee.tp.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.tp.beans.Client;
import com.sdzee.tp.dao.ClientDao;
import com.sdzee.tp.dao.DAOException;
import com.sdzee.tp.dao.DAOFactory;

public class SuppressionClient extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String PARAM_ID_CLIENT = "idClient";
	public static final String SESSION_CLIENTS = "clients";

	public static final String VUE = "/listeClients";

	private ClientDao clientDao;

	public void init() throws ServletException {
		/* Récupération d'une instance de notre DAO Utilisateur */
		this.clientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getClientDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Récupération du paramètre */
		String idClient = getValeurParametre(request, PARAM_ID_CLIENT);

		Long id = Long.parseLong(idClient);

		/* Récupération de la Map des clients enregistrés en session */

		HttpSession session = request.getSession();
		Map<Long, Client> clients = (HashMap<Long, Client>) session.getAttribute(SESSION_CLIENTS);

		/* Si l'id du client et la Map des clients ne sont pas vides */

		if (id != null && clients != null) {

			try {
				/* Alors suppression du client de la BDD */
				clientDao.supprimer(clients.get(id));

				/* Puis suppression du client de la Map */
				clients.remove(id);
			} catch (DAOException e) {
				e.printStackTrace();
			}

			/* Et remplacement de l'ancienne Map en session par la nouvelle */

			session.setAttribute(SESSION_CLIENTS, clients);

		}

		/* Redirection vers la fiche récapitulative */
		response.sendRedirect(request.getContextPath() + VUE);
	}

	/*
	 * Méthode utilitaire qui retourne null si un paramètre est vide, et son
	 * contenu sinon.
	 */

	private static String getValeurParametre(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur;
		}
	}

}
