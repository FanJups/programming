import java.net.InetAddress;
import java.net.UnknownHostException;

public class Inet2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// Nous appelons une méthode statique de cet objet pour en récupérer
			// une instance

			InetAddress address = InetAddress.getByName("openclassroom.com");
			System.out.println("L'adresse IP de " + address.getHostName() + " est : " + address.getHostAddress());

			// Certains sites peuvent avoir plusieurs adresses IP
			// C'est le cas de Google

			InetAddress[] addresses = InetAddress.getAllByName("google.fr");
			System.out.println("\n Toutes les adresses IP de google.fr : ");
			for (InetAddress ad : addresses)
				System.out.println("-" + ad.getHostAddress());

			addresses = InetAddress.getAllByName("google.com");
			System.out.println("\n Toutes les adresses IP de google.com : ");
			for (InetAddress ad : addresses)
				System.out.println("-" + ad.getHostAddress());

		} catch (UnknownHostException e) {

		}

	}

}
