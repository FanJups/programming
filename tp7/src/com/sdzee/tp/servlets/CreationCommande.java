package com.sdzee.tp.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.tp.dao.ClientDao;
import com.sdzee.tp.dao.CommandeDao;
import com.sdzee.tp.entities.Client;
import com.sdzee.tp.entities.Commande;
import com.sdzee.tp.forms.CreationCommandeForm;

@WebServlet(urlPatterns = {
		"/creationCommande" }, initParams = @WebInitParam(name = "chemin", value = "/fichiers/images/") )
@MultipartConfig(location = "/tmp", maxFileSize = 2 * 1024 * 1024, maxRequestSize = 10 * 1024
		* 1024, fileSizeThreshold = 1024 * 1024)

public class CreationCommande extends HttpServlet {

	public static final String CHEMIN = "chemin";
	public static final String ATT_COMMANDE = "commande";
	public static final String ATT_FORM = "form";
	public static final String SESSION_CLIENTS = "clients";
	public static final String APPLICATION_CLIENTS = "initClients";
	public static final String SESSION_COMMANDES = "commandes";
	public static final String APPLICATION_COMMANDES = "initCommandes";
	public static final String VUE_SUCCES = "/WEB-INF/afficherCommande.jsp";
	public static final String VUE_FORM = "/WEB-INF/creerCommande.jsp";

	@EJB
	private ClientDao clientDao;
	@EJB
	private CommandeDao commandeDao;

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
		CreationCommandeForm form = new CreationCommandeForm(clientDao, commandeDao);

		/* Traitement de la requête et récupération du bean en résultant */
		Commande commande = form.creerCommande(request, chemin);

		/* Ajout du bean et de l'objet métier à l'objet requête */
		request.setAttribute(ATT_COMMANDE, commande);
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

			/* Puis ajout du client de la commande courante dans la map */

			clients.put(commande.getClient().getId(), commande.getClient());

			/* Et enfin (ré)enregistrement de la map en session */

			session.setAttribute(SESSION_CLIENTS, clients);

			/* Ensuite récupération de la map des commandes dans la session */

			Map<Long, Commande> commandes = (HashMap<Long, Commande>) session.getAttribute(SESSION_COMMANDES);

			/*
			 * Si aucune map n'existe, alors initialisation d'une nouvelle map
			 */

			if (commandes == null) {
				commandes = new HashMap<Long, Commande>();
			}

			/* Puis ajout de la commande courante dans la Map */

			commandes.put(commande.getId(), commande);

			/* Et enfin (ré)enregistrement de la map en session */
			session.setAttribute(SESSION_COMMANDES, commandes);

			/* Affichage de la fiche récapitulative */

			this.getServletContext().getRequestDispatcher(VUE_SUCCES).forward(request, response);
		} else {
			/* Sinon, ré-affichage du formulaire de création avec les erreurs */
			this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
		}

	}

}
