
public class Test implements Runnable {

	public void run() {
		for (int i = 0; i < 10; i++) {

			// Cette méthode permet d'incrémenter la valeur
			// Et de retourner la valeur modifiée de façon atomique
			TestProcessusThread.entier.incrementAndGet();
			System.out.println(Thread.currentThread().getName() + "-" + TestProcessusThread.entier);

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

			}
		}
	}

}
