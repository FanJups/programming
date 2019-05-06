package CountDownLock;

import java.util.concurrent.CountDownLatch;

public class Test2 {

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

		t1.start();
		t2.start();

		Thread t3 = new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					lock.countDown();
					System.out.println(lock.getCount() + "...");
					if (lock.getCount() == 0) {
						System.out.println("Top départ pour les threads bloqués");
						break;
					}
				}
			}
		});

		t3.start();

	}

}
