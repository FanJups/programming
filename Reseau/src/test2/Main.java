package test2;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Scanner sc = new Scanner(System.in);
			Ftp ftp = new Ftp("fanon");
			System.out.println("Connexion au FTP");

			ftp.connect();
			ftp.debugMode(true);

			System.out.println("----------------------------------------------------");
			System.out.println("Vous êtes maintenant connecté au FTP");
			System.out.println("Vous avez le droit aux commandes PWD,CWD,LIST et QUIT");
			System.out.println("----------------------------------------------------\n\n");
			String reponse = "";
			boolean encore = true;
			while (encore) {
				reponse = sc.nextLine().toUpperCase();

				switch (reponse) {
				case "PWD":
					System.out.println(ftp.pwd());
					break;
				case "CWD":
					System.out.println(">> Saisissez le nom du répertoire où vous allez : ");
					String dir = sc.nextLine();
					System.out.println(ftp.cwd(dir));
					break;
				case "LIST":
					String list = ftp.list();
					System.out.println(list);
					break;
				case "QUIT":
					ftp.quit();
					encore = false;
					break;
				default:
					System.err.println("Commande inconnue !");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("Ciao ! ");

	}

}
