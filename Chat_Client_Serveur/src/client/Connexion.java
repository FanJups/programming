/**
 * 
 */
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Admin
 *
 */
public class Connexion implements Runnable {

	private Socket socket = null;

	public static Thread t2;

	public static String login = null, pass = null, message = null, message2 = null, message3 = null;

	private PrintWriter out = null;

	private BufferedReader in = null;

	private Scanner sc = null;

	private boolean connect = false;

	public Connexion(Socket s) {

		this.socket = s;

	}

	public void run() {

		try {
			out = new PrintWriter(socket.getOutputStream());

			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			sc = new Scanner(System.in);

			while (!connect) {

				System.out.println(in.readLine());

				login = sc.nextLine();

				out.println(login);

				out.flush();

				System.out.println(in.readLine());

				pass = sc.nextLine();

				out.println(pass);

				out.flush();

				if (in.readLine().equals("connecte")) {

					System.out.println("Je suis connecté");

					connect = true;
				} else {

					System.err.println("Vos informations sont incorrectes");
				}

			}

			t2 = new Thread(new Chat_ClientServeur(socket));

			t2.start();
		} catch (IOException e) {

			System.err.println("Le serveur ne répond plus ");
		}
	}
}
