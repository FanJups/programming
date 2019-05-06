package enadchat.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InscriptionConnexionUtilisateur extends HttpServlet {

	public static final String VUE_ICU = "/WEB-INF/inscriptionConnexionUtilisateur.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 * 
		 * 
		 */

		this.getServletContext().getRequestDispatcher(VUE_ICU).forward(request, response);

	}

}
