package com.sdz.synchro;

import com.sdz.atomic.Increment;
import com.sdz.atomic.Test;

public class TestProcessusThread {

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
