package com.sdz.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Increment {

	private int entier = 0;
	// Nous créons notre objet qui va nous fournir un verrou
	private Lock verrou = new ReentrantLock();

	public void incremente() {
		// Nous verrouillons le code qui suit cette instruction
		verrou.lock();

		/*
		 * Nous utilisons un bloc try surtout pour avoir un bloc finally
		 */

		try {
			// tout ce code est maintenant considéré comme atomique !
			entier++;
		} finally {
			/*
			 * ainsi même s'il y a une interruption sur notre thread le verrou
			 * sera relâché,dans le cas contraire tous les autres threads ne
			 * pourraient plus travailler !
			 */
			verrou.unlock();
		}
	}

	public synchronized Integer get() {
		return entier;
	}
}
