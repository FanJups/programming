package CyclicBarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Barrier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CBExemple cbe1, cbe2, cbe3, cbe4;

		cbe1 = new CBExemple(0, 100, "Thread-0-100");
		cbe2 = new CBExemple(1_000, 5_000, "Thread-1000-5000");
		cbe3 = new CBExemple(5_000, 15_000, "Thread-5000-15000");
		cbe4 = new CBExemple(10_000, 50_000, "Thread-10000-50000");

		// Nous allons utiliser une liste pour lancer tous nos threads
		ArrayList<Callable<Integer>> tasks = new ArrayList<>();
		tasks.add(cbe1);
		tasks.add(cbe2);
		tasks.add(cbe3);
		tasks.add(cbe4);

		ExecutorService execute = Executors.newFixedThreadPool(4);

		// Cet objet accepte un deuxième argument qui est un Runnable
		// permettant de faire une action lorsque la barrière cède
		CyclicBarrier barrier = new CyclicBarrier(4, new AfterBarrier(tasks));

		// Nous mettons maintenant notre barrière dans nos objets
		// Callable<Integer>

		cbe1.setBarrier(barrier);
		cbe2.setBarrier(barrier);
		cbe3.setBarrier(barrier);
		cbe4.setBarrier(barrier);

		try {
			// Cette méthode est nouvelle pour vous
			// Vous pouvez ainsi lancer une liste de threads
			// Et récupérer une liste d'objet Future<T> : un par objet
			// Callable<T>

			List<Future<Integer>> listFuture = execute.invokeAll(tasks);

			int resultat = 0;

			// On parcourt les résulstats

			for (Future<Integer> ft : listFuture)
				resultat += ft.get();
			System.out.println("Total = " + resultat);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		execute.shutdown();

	}

}
