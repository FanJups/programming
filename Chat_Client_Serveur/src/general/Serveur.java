package general;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * 
 */

/**
 * @author Admin
 *
 */
public class Serveur {

	public static ServerSocket ss = null;

	public static Thread t;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			ss = new ServerSocket(2009);

			System.out.println("Le serveur est à l'écoute du port " + ss.getLocalPort());

			t = new Thread(new Accepter_connexion(ss));

			t.start();
		} catch (IOException e) {

			System.err.println("Le port " + ss.getLocalPort() + " est déjà utilisé !");
		}

	}

}
