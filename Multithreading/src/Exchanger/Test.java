package Exchanger;

import java.util.concurrent.Exchanger;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Exchanger ex = new Exchanger();
		Thread t1 = new Thread(new FileFinder(ex));
		Thread t2 = new Thread(new FileMover(ex));

		t1.start();
		t2.start();

	}

}
