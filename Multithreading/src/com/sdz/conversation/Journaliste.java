package com.sdz.conversation;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Journaliste extends Thread {

	private String nom;
	private Lock verrou;
	private Condition question, response;
	private Scanner sc = new Scanner(System.in);

	public Journaliste(String pNom, Lock pVerrou, Condition pQuestion, Condition pResponse) {
		nom = pNom;
		verrou = pVerrou;
		question = pQuestion;
		response = pResponse;
	}

	public void question() {
		verrou.lock();
		try {
			System.out.println(nom + ", posez votre question : ");
			sc.nextLine();
			// On libère le thread de réponse
			response.signalAll();
			// On bloque ce thread
			question.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// On n'oublie pas de libérer le verrou
			verrou.unlock();
		}
	}

	public void run() {
		while (true) {
			question();
		}
	}

}
