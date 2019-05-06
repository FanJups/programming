package general;
/**
 * 
 */

/**
 * @author Admin
 *
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Accepter_connexion implements Runnable {

	private ServerSocket socketserver = null;

	private Socket socket = null;

	public Thread t1;

	public Accepter_connexion(ServerSocket ss) {

		this.socketserver = ss;
	}

	public void run() {

		try {

			while (true) {

				socket = socketserver.accept();

				System.out.println("Un zéro veut se connecter ");

				t1 = new Thread(new Authentification(socket));

				t1.start();

			}
		} catch (IOException e) {

			System.err.println("Erreur serveur");
		}
	}

}
