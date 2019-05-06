/**
 * 
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.History;

/**
 * @author Admin
 *
 */

@WebServlet("/controller/FactorialCalculator")
public class FactorialCalculatorServlet extends HttpServlet {

	ArrayList<History> lert = new ArrayList<History>();

	private String CHAMP_NOMBRE = "n";

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Date dat = new Date();

		History hist = new History(dat, 2, 2);

		HttpSession session = request.getSession();

		String nombre = getValeurChamp(request, CHAMP_NOMBRE);

		Integer n = Integer.parseInt(nombre);

		int result = factorial(n);

		Date date = new Date();

		hist.setDate(date);

		hist.setValue_of_n(n);

		hist.setResultfactorial(result);

		session.setAttribute("historique", lert);

		lert.add(hist);

		RequestDispatcher disp = request.getRequestDispatcher("/index.jsp");

		disp.forward(request, response);

	}

	private String getValeurChamp(ServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else
			return valeur;
	}

	private int factorial(Integer i) {

		int a = 1;

		if (i == 0 || i == 1) {
			return 1;
		}

		else {
			for (int j = 1; j <= i; j++) {
				a = a * j;
			}

			return a;
		}

	}

}
