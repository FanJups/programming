package com.sdz.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Increment {

	private AtomicInteger entier = new AtomicInteger(0);

	public void incremente() {
		entier.incrementAndGet();

	}

	public Integer get() {
		return entier.get();
	}

}
