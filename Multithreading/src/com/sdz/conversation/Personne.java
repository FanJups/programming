package com.sdz.conversation;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Personne extends Thread {

	private String nom;
	private Lock verrou;
	private Condition question, response;
	private Scanner sc = new Scanner(System.in);

	public Personne(String pNom, Lock pVerrou, Condition pQuestion, Condition pResponse) {
		nom = pNom;
		verrou = pVerrou;
		question = pQuestion;
		response = pResponse;
	}

	public void response() {
		verrou.lock();
		try {
			System.out.println(nom + ", votre réponse ? ");
			sc.nextLine();
			// On informe redemande une question
			question.signalAll();
			// On bloque la réponse
			response.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// Et on libére le verrou !
			verrou.unlock();
		}
	}

	public void run() {
		while (true) {
			response();
		}
	}

}
