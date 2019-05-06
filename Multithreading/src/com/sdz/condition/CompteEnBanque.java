package com.sdz.condition;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CompteEnBanque {

	private AtomicLong solde = new AtomicLong(1_000L);
	private final long decouvert = -130L;
	// Cette variable va nous servir à savoir le nombre de tentatives de retrait
	// successives
	private AtomicLong tentativeDeRetrait = new AtomicLong(0);
	// Notre verrou
	private Lock verrou = new ReentrantLock();
	// Notre objet condition
	private Condition condition = verrou.newCondition();

	/**
	 * C'est sur cette méthode que nous allons devoir travailler dans nos
	 * threads et vérifier le solde avant de retirer de l'argent
	 */

	public void retrait(long montant) {
		verrou.lock();
		String threadName = Thread.currentThread().getName();

		try {

			// On met en attente les threads tant que la condition n'est pas
			// remplie
			// Le thread étant mis en attente si cette condition est remplie
			// on aurait pu utiliser un simple "if" mais on ne sait jamais

			while ((solde.get() - montant) < decouvert) {
				// dans ce cas, le thread qui tente de retirer ce montant
				// mettra notre solde en deçà du découvert autorisé

				System.err.println(threadName + " tente de retirer " + montant);

				// on stocke le cumul des tentatives de retrait car
				// lorsque le verrou sera levé,tous les threads en attente
				// seront autorisés à faire leur retrait,il faut donc contrôler
				// le cumul
				// de toutes les tentatives de retrait

				tentativeDeRetrait.addAndGet(montant);

				// On pose un verrou via la condition
				// cette instruction rend le thread inéligible à travailler

				condition.await();
			}

			// Si nous sommes ici,c'est que le montant du retrait
			// est autorisé ou que la condition a libéré le verrou sur le thread
			solde.set((solde.get() - montant));
			solde();
		}

		// L'ajout d'un verrou via une condition peut lever ce genre d'exception
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			// On oublie pas de libérer le verrou général
			verrou.unlock();
		}
	}

	// Puisqu'on utilise un objet AtomicLong
	// Inutile de synchroniser,mais on utilisera tout de même un verrou.^^
	// C'est dans cette méthode que la condition sera libérée

	public void depot(long montant) {
		// On utilise le même verrou que celui qui a engendré la condition
		// sans cela,la condition créée à partir de ce verrou
		// lèvera une exception si nous tentons de la libérer

		verrou.lock();

		try {
			// Nous faisons notre traitement
			long result = solde.addAndGet(montant);
			solde();

			// Nous vérifions si le solde après les tentatives de retraits
			// sera toujours au dessus de l'autorisation de découvert

			long soldeApresRetrait = getSolde() - tentativeDeRetrait.get();

			// Si tel estle cas,libération du verrou

			if (soldeApresRetrait > decouvert) {

				// On réinitialise notre variable de contrôle à 0
				tentativeDeRetrait.set(0);

				// On libère le verrou posé par la condition
				// Cette instruction va libérer tous les threads mis en attente

				condition.signalAll();

				System.err.println("\n Montant après retrait (" + soldeApresRetrait + ") < découvert \n");

			}
		} finally {
			// On n'oublie pas de libérer le verrou général
			verrou.unlock();
		}
	}

	public void solde() {
		System.out.println("Solde actuel,dans " + Thread.currentThread().getName() + " : " + solde.longValue());
	}

	public long getSolde() {
		return solde.longValue();
	}

	public long getDecouvert() {
		return decouvert;
	}

}
