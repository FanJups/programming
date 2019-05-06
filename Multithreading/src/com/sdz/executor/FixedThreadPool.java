package com.sdz.executor;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Notre executor fixé à 2 threads maximum
		ExecutorService execute = Executors.newFixedThreadPool(2);

		// Nous créons une liste stockant les objets Future<Long>
		ArrayList<Future<Long>> listFuture = new ArrayList<>();

		// Nous créons maintenant nos objets
		Path chemin = Paths.get("C:\\wamp");
		Path chemin2 = Paths.get("C:\\glassfish4");
		Path chemin3 = Paths.get("C:\\tomcat8");

		// On change un peu le code en utilisant une boucle
		Path[] chemins = new Path[] { chemin, chemin2, chemin3 };

		Long total = 0L;

		for (Path path : chemins) {
			// Nous lançons le traitement
			Future<Long> ft = execute.submit(new FolderScanner(path));

			// Nous stockons l'objet Future<Long>
			// si nous avions utilisé la méthode get() directement
			// Les tâches se seraient lancées de façon séquentielle
			// car la méthode get() attend la fin du traitement
			listFuture.add(ft);
		}

		// Afin d'avoir un traitement en parallèle
		// Nous parcourons mainetant la liste de nos objets Future<T>

		Iterator<Future<Long>> it = listFuture.iterator();

		while (it.hasNext()) {
			try {
				total += it.next().get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		System.out.println("nombre total de fichiers trouvés : " + total);

		// Dès que nos tâches sont terminées,nous fermons le pool
		// Sans cette ligne,ce programme restera en cours d'exécution
		execute.shutdown();

	}

}
