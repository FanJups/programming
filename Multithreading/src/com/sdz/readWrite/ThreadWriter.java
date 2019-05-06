package com.sdz.readWrite;

public class ThreadWriter extends Thread {
	private Dictionnaire dico;

	public ThreadWriter(String nom, Dictionnaire pDico) {
		setName(nom);
		dico = pDico;
	}

	public void run() {
		while (true) {
			dico.ajouter();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
