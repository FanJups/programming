import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Lookup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("----------------------------------------------------");
			System.out.println("Saisissez une adresse IPV4 ou un nom de domaine : ");
			System.out.println("----------------------------------------------------");
			String hote = sc.nextLine();
			if (hote.equalsIgnoreCase("fin")) {
				break;
			}
			System.out.println("Voici le résultat trouvé : ");
			System.out.println(lookup(hote));
		}

		System.out.println("Fin du programme");

	}

	public static String lookup(String host) {
		String result = "";
		try {
			// Il s'agit d'un nom de domaine et non d'une adresse IPV4
			if (host.matches("[a-zA-Z\\.]+")) {
				result = InetAddress.getByName(host).getHostAddress();
			}
			// IP V4
			else {
				result = InetAddress.getByName(host).getHostName();
			}
		} catch (UnknownHostException e) {
			return "Erreur : impossible de trouver une correspondance pour l'entrée " + host;
		}

		return result;
	}

}
