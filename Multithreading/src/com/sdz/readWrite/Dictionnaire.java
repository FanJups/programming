package com.sdz.readWrite;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Dictionnaire {

	private Map<Integer, String> dico = new TreeMap<>();
	private String[] listMot = { "abc", "bcd", "cde", "def", "efg" };
	private Random rand = new Random();
	private static AtomicInteger indiceCollection = new AtomicInteger(0);

	ReadWriteLock rwl = new ReentrantReadWriteLock();
	// Le verrou en écriture
	Lock writeLock = rwl.writeLock();
	// Le verrou en lecture
	Lock readLock = rwl.readLock();

	public void ajouter() {
		// On pose le verrou en écriture,ce qui va bloquer tous les autres
		// threads en écriture mais aussi en lecture
		writeLock.lock();
		try {
			// On fait notre traitement
			String mot = listMot[rand.nextInt(5)];
			int indice = indiceCollection.getAndIncrement();
			String motAjouter = mot + indice;
			dico.put(indice, motAjouter);
			System.err.println(Thread.currentThread().getName() + " : indice = " + indice + " ; mot = " + motAjouter);
		} finally {
			// On n'oublie surtout pas de libérer le verrou !
			writeLock.unlock();
		}
	}

	public void lire() {
		// On pose le verrou en lecture,ce qui n'a pas d'effet pour les threads
		// qui ne font que lire mais qui va permettre
		// aux threads en écriture de bloquer l'accès lorsque ceux-ci invoque un
		// verrou
		readLock.lock();

		try {
			// On fait notre traitement
			if (dico.keySet().size() > 0) {
				int length = dico.keySet().size();

				int indiceMot = rand.nextInt(length);

				System.out.println(Thread.currentThread().getName() + " : indice = " + indiceMot + " ; mot = "
						+ dico.get(indiceMot));

			}
		} finally {
			// On n'oublie pas de libérer le verrou !
			readLock.unlock();
		}
	}

}
