package com.sdz.conversation;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Interview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Lock lock = new ReentrantLock();
		Condition question = lock.newCondition();
		Condition response = lock.newCondition();
		Journaliste j = new Journaliste("ADAMA", lock, question, response);
		Personne p = new Personne("DG", lock, question, response);

		j.start();
		p.start();

	}

}
