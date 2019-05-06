package CountDownLock;

import java.util.concurrent.CountDownLatch;

public class Test {

	static CountDownLatch lock = new CountDownLatch(10);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Premier thread en attente !..");
				try {
					lock.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("Premier thread libéré après le compte à rebours");
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Deuxième thread en attente !..");
				try {
					lock.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("Deuxième thread libéré après le compte à rebours");
			}
		});

		Fenetre fen = new Fenetre(lock);
		t1.start();
		t2.start();

	}

}
