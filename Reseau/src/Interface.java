
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// Nous spécifions que la réponse devra se faire par ce chemin
			InetAddress lo = InetAddress.getByName("192.168.2.44");

			/*
			 * Le fait de mettre 0 dans le numéro de port de réponse informe que
			 * n'importe quel numéro est accepté
			 */

			Socket soc = new Socket("www.openclassrooms.com", 80, lo, 0);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
