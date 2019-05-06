package com.sdz.executor;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Notre executor mono-thread
		ExecutorService execute = Executors.newSingleThreadExecutor();

		// Nous créons maintenant nos objets
		Path chemin = Paths.get("C:\\wamp");
		Path chemin2 = Paths.get("C:\\glassfish4");
		Path chemin3 = Paths.get("C:\\tomcat8");

		// La méthode submit permet de récupérer un objet Future qui contiendra
		// le résultat obtenu

		Future<Long> ft1 = execute.submit(new FolderScanner(chemin));
		Future<Long> ft2 = execute.submit(new FolderScanner(chemin2));
		Future<Long> ft3 = execute.submit(new FolderScanner(chemin3));

		Long total;

		try {
			// Nous ajoutons tous les résultats
			total = ft1.get() + ft2.get() + ft3.get();
			System.out.println("nombre total de fichiers trouvés : " + total);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		// Dès que nos tâches sont terminées,nous fermons le pool
		// Sans cette ligne,ce programme restera en cours d'exécution
		execute.shutdown();

	}

}
