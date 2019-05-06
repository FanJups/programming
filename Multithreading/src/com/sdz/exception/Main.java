package com.sdz.exception;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 6; i++) {
			Thread t = new ThreadException("Thread-" + i);
			t.start();
		}

	}

}
