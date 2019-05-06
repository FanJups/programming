package com.sdz.exception;

import java.lang.Thread.UncaughtExceptionHandler;

public class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {

	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("Une exception de type : " + e.getClass().getName());
		System.out.println("Est survenue dans " + t.getName());
	}

}
