package com.sdz.synchro;

import com.sdz.atomic.TestProcessusThread;

public class Test implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {

			TestProcessusThread.entier.incremente();
			System.out.println(Thread.currentThread().getName() + "-" + TestProcessusThread.entier.get());

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

			}
		}
	}

}
