package Exchanger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Exchanger;

public class FileMover implements Runnable {

	private List<String> listDocument = new ArrayList<>();
	Exchanger exchanger;

	public FileMover(Exchanger ex) {
		exchanger = ex;

	}

	public void run() {
		while (true) {
			System.out.println("------------------------------------");
			System.out.println("Contenu de la liste côté déplaceur : ");
			System.out.println(listDocument);
			System.out.println("------------------------------------");
			Iterator<String> it = listDocument.iterator();

			while (it.hasNext()) {
				String nom = it.next();

				// On traite avec notre objet
				it.remove();
				System.out.println("[-] Suppression de " + nom + " dans la collection");

				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// Lorsque la liste est vide,on demande à récupérer une liste pleine

			try {
				System.err.println("\t -> Liste vide du côté du déplaceur de fichier !");
				listDocument = (List<String>) exchanger.exchange(listDocument);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
