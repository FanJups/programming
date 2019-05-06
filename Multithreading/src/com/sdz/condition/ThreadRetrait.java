package com.sdz.condition;

import java.util.Random;

public class ThreadRetrait extends Thread {

	private CompteEnBanque ceb;
	private Random rand = new Random();
	private static int nbThread = 1;

	public ThreadRetrait(CompteEnBanque c) {
		ceb = c;
		this.setName("Retrait" + nbThread++);
	}

	public void run() {
		while (true) {
			int nb = rand.nextInt(300);
			long montant = Integer.valueOf(nb).longValue();
			ceb.retrait(montant);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

}
