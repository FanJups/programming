package CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public class CBExemple implements Callable<Integer> {

	int start, end, resultat;
	CyclicBarrier barrier;
	String name;

	public CBExemple(int pStart, int pEnd, String pName) {
		start = pStart;
		end = pEnd;
		name = pName;
	}

	public Integer call() {
		System.out.println("Le thread " + name + " se met en action");

		// Nous allons faire en sorte que tous les threads
		// s'attendent lorsque ceux-ci atteignent la moitié de leur travail
		// attitré

		int moitie = (end - start) / 2;
		resultat = 0;

		while (start < end) {
			resultat += start;
			start++;

			try {
				Thread.sleep(1);

			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			if (start == moitie) {
				try {

					System.err.println("Le thread " + name + " a atteint la moitié de sa tâche");
					System.err.println(
							"\t -> " + (barrier.getNumberWaiting() + 1) + " threads actuellement à la barrière !");

					// Cette invocation indique que le thread est arrivé à la
					// barrière
					// Il attend maintenant que la limite soit atteinte
					// pour pouvoir franchir la barrière
					barrier.await();

					System.out.println("Barrière dépassée : Le thread " + name + " se remet à l'oeuvre !");
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}

			}
		}

		return resultat;
	}

	public int getResultat() {
		return resultat;
	}

	public String getName() {
		return name;
	}

	// nous affectons maintenant la barrière après coup
	public void setBarrier(CyclicBarrier pBarrier) {
		barrier = pBarrier;
	}

}
