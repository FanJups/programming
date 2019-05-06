package com.sdz.synchro;

public class Increment {

	private int entier = 0;

	public synchronized void incremente() {
		entier++;
	}

	public synchronized Integer get() {
		return entier;
	}

	/*
	 * public synchronized void incremente() {
	 * 
	 * synchronized(this){ entier++; } }
	 * 
	 * public synchronized Integer get() { synchronized(this){ return entier; }
	 * }
	 */

}
