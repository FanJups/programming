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
import com.sdzee.tp.dao.DAOFactory;
import com.sdzee.tp.forms.CreationClientForm;

public class CreationClient extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String CHEMIN = "chemin";
	public static final String ATT_CLIENT = "client";
	public static final String ATT_FORM = "form";
	public static final String SESSION_CLIENTS = "clients";

	public static final String VUE_SUCCES = "/WEB-INF/afficherClient.jsp";
	public static final String VUE_FORM = "/WEB-INF/creerClient.jsp";

	private ClientDao clientDao;

	public void init() throws ServletException {
		/* Récupération d'une instance de notre DAO Utilisateur */

		this.clientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getClientDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * A la réception d'une requête GET, simple affichage du formulaire
		 */

		this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * Lecture du paramètre 'chemin' passé à la servlet via la déclaration
		 * dans le web.xml
		 */

		String chemin = this.getServletConfig().getInitParameter(CHEMIN);

		/* Préparation de l'objet formulaire */
		CreationClientForm form = new CreationClientForm(clientDao);

		/* Traitement de la requête et récupération du bean en résultant */
		Client client = form.creerClient(request, chemin);

		/* Ajout du bean et de l'objet métier à l'objet requête */
		request.setAttribute(ATT_CLIENT, client);
		request.setAttribute(ATT_FORM, form);

		/* Si aucune erreur */

		if (form.getErreurs().isEmpty()) {
			/* Alors récupération de la map des clients dans la session */
			HttpSession session = request.getSession();
			Map<Long, Client> clients = (HashMap<Long, Client>) session.getAttribute(SESSION_CLIENTS);

			/*
			 * Si aucune map n'existe, alors initialisation d'une nouvelle map
			 */

			if (clients == null) {
				clients = new HashMap<Long, Client>();
			}

			/* Puis ajout du client courant dans la Map */

			clients.put(client.getId(), client);

			/* Et enfin (ré)enregistrement de la map en session */
			session.setAttribute(SESSION_CLIENTS, clients);

			/* Affichage de la fiche récapitulative */

			this.getServletContext().getRequestDispatcher(VUE_SUCCES).forward(request, response);
		} else {
			/* Sinon, ré-affichage du formulaire de création avec les erreurs */
			this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
		}
	}

}
