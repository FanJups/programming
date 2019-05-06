package com.sdz.atomic;

public class TestProcessusThread {

	// On déclare donc notre objet
	public static Increment entier = new Increment();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
