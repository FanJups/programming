package enadchat.filters;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enadchat.dao.DAOFactory;
import enadchat.dao.MessageDao;
import enadchat.dao.UtilisateurDao;

/**
 * Servlet Filter implementation class RestrictionFilter
 */
@WebFilter("/RestrictionFilter")
public class RestrictionFilter implements Filter {

	public static final String UTILISATEUR = "/enadchat/inscription_connexion_utilisateur";

	public static final String ACCUEIL_UTILISATEUR = "/enadchat/accueilchat";

	public static final String ATT_SESSION_UTILISATEUR = "sessionUtilisateur";

	private MessageDao messageDao;

	private UtilisateurDao utilisateurDao;

	public static final String CONF_DAO_FACTORY = "daofactory";

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		ArrayList<String> urls_utilisateur = new ArrayList<String>();

		int capteur_urls_utilisateur = 0;

		urls_utilisateur.add("/accueilchat");

		urls_utilisateur.add("/deconnexion");

		/* Cast des objets request et response */

		HttpServletRequest request = (HttpServletRequest) req;

		HttpServletResponse response = (HttpServletResponse) resp;

		HttpSession session = request.getSession();

		String chemin = request.getRequestURI().substring(request.getContextPath().length());

		if (chemin.startsWith("/inc") || chemin.startsWith("/chat")) {

			// pass the request along the filter chain
			chain.doFilter(request, response);
		}

		if (chemin.startsWith("/connexion_utilisateur") || chemin.startsWith("/inscription_utilisateur")
				|| chemin.startsWith("/inscription_connexion_utilisateur")) {

			if (session.getAttribute(ATT_SESSION_UTILISATEUR) != null) {

				response.sendRedirect(ACCUEIL_UTILISATEUR);

			} else {

				chain.doFilter(request, response);
			}
		}

		String uri = request.getRequestURI();

		if (capteur_urls_utilisateur == 0) {

			for (int i = 0; i < urls_utilisateur.size(); i++) {

				if (uri.contains(urls_utilisateur.get(i))) {

					capteur_urls_utilisateur++;

					break;

				}

			}

			if (capteur_urls_utilisateur == 1) {

				if (session.getAttribute(ATT_SESSION_UTILISATEUR) != null) {

					chain.doFilter(request, response);

				} else {

					response.sendRedirect(UTILISATEUR);

				}

			}

		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {

		// TODO Auto-generated method stub

		this.messageDao = ((DAOFactory) config.getServletContext().getAttribute(CONF_DAO_FACTORY)).getMessageDao();

		this.utilisateurDao = ((DAOFactory) config.getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getUtilisateurDao();
	}

}
