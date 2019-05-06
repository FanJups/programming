package com.sdz.exception;

import java.util.Random;

public class ThreadException extends Thread {

	public ThreadException(String name) {
		setName(name);
		setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
	}

	public void run() {
		Random rand = new Random();
		while (true) {
			System.out.println("-" + getName());
			int cas = rand.nextInt(5);

			switch (cas) {
			case 0:
				int i = 10 / 0;
				break;
			case 1:
				Object str = "toto";
				double d = (double) str;
				break;
			default:
				System.out.println("aucune erreur...");
				break;
			}
		}
	}

}
