package com.sdz.callable1;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Nous créons un objet Callable basique

		Callable<Integer> c1 = new Callable<Integer>() {

			public Integer call() throws Exception {

				Random rand = new Random();
				int result = rand.nextInt(2_000);
				System.out.println("Dans l'objet Callable : " + result);
				try {
					Thread.sleep(3_000);
				} catch (Exception e) {
					e.printStackTrace();
				}

				return result;
			}

		};

		// Nous l'associons à un objet FutureTask du même type générique

		FutureTask<Integer> ft1 = new FutureTask<>(c1);

		System.out.println(" - Lancement de notre premier test.");
		// Pour que cette tâche soit lancée dans un thread
		// nous devons tout de même utiliser la classe Thread
		// qui autorise un objet de type FutureTask dans son constructeur
		Thread t = new Thread(ft1);

		// Nous lançons maintenant le thread
		t.start();
		System.out.println("Traitement...");
		try {
			// Ici, notre objet Future attend la fin de la tâche pour
			// retourner le résultat,en attendant
			// le thread courant est bloqué

			System.out.println("Résultat : " + ft1.get());
		} catch (Exception e) {
			e.printStackTrace();
		}

		showStatus(ft1);

		System.out.println("\n - Lancement de notre second test.");
		ft1 = new FutureTask<>(c1);
		t = new Thread(ft1);
		t.start();
		System.out.println("Traitement...");

		// Ici,nous mettons un délai,il y aura donc une exception de levée
		// car le délai est inférieur à la pause dans l'objet Callable

		try {
			System.out.println("Résultat : " + ft1.get(500, TimeUnit.MILLISECONDS));

		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.err.println("La tâche a mis trop de temps à répondre.");
		}

		/*
		 * Cette instruction n'affichera rien car le statut de la tâche n'est ni
		 * OK ni annulée...
		 */

		showStatus(ft1);

	}

	private static void showStatus(FutureTask<Integer> ft1) {
		if (ft1.isDone())
			System.out.println("La tâche s'est déroulée correctement");
		if (ft1.isCancelled())
			System.out.println("La tâche est annulée");
	}

}
