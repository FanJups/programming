package com.sdzee.tp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/listeClients" })
public class ListeClients extends HttpServlet {

	public static final String ATT_CLIENT = "client";
	public static final String ATT_FORM = "form";

	public static final String VUE = "/WEB-INF/listerClients.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * A la réception d'une requête GET, affichage de la liste des clients
		 */

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
