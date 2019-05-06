package Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Restaurant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Restaurant à 5 places
		Semaphore sem = new Semaphore(5);

		ExecutorService execute = Executors.newCachedThreadPool();

		int i = 0;
		while (true) {
			Client cli = new Client("Client N° " + (++i), sem);
			execute.execute(cli);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
