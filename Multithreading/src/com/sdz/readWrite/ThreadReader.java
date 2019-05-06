package com.sdz.readWrite;

public class ThreadReader extends Thread {

	private Dictionnaire dico;

	public ThreadReader(String nom, Dictionnaire pDico) {
		setName(nom);
		dico = pDico;
	}

	public void run() {
		while (true) {
			dico.lire();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
