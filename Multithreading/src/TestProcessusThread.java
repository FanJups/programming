import java.util.concurrent.atomic.AtomicInteger;

public class TestProcessusThread {

	// On déclare donc notre objet
	public static AtomicInteger entier = new AtomicInteger();

	public static void main(String[] args) {

		Thread t1 = new Thread(new Test());
		Thread t2 = new Thread(new Test());
		Thread t3 = new Thread(new Test());
		Thread t4 = new Thread(new Test());

		// On lance nos threads
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
