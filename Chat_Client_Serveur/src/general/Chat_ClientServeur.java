package general;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 
 */

/**
 * @author Admin
 *
 */

public class Chat_ClientServeur implements Runnable {

	private Socket socket = null;

	private BufferedReader in = null;

	private PrintWriter out = null;

	private String login = "zero";

	private Thread t3, t4;

	public Chat_ClientServeur(Socket s, String log) {

		this.socket = s;

		this.login = log;

	}

	public void run() {

		try {

			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			out = new PrintWriter(socket.getOutputStream());

			Thread t3 = new Thread(new Reception(in, login));

			t3.start();

			Thread t4 = new Thread(new Emission(out));

			t4.start();

		} catch (IOException e) {

			System.err.println(login + "s'est déconnecté ");
		}
	}

}
