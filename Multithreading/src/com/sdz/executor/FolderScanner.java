package com.sdz.executor;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FolderScanner implements Callable<Long> {

	private Path path = null;
	private long result = 0;

	public FolderScanner() {
	}

	public FolderScanner(Path pf) {
		path = pf;
	}

	/**
	 * Méthode qui se charge de scanner les dossiers de façon récursive
	 */

	public Long call() {
		System.out.println("Exécution dans " + Thread.currentThread().getName());
		System.out.println("Scan du dossier : " + path + " à la recherche des fichiers ");

		// On liste maintenant le contenu du répertoire pour traiter les
		// sous-dossiers
		try (DirectoryStream<Path> listing = Files.newDirectoryStream(path)) {
			for (Path nom : listing) {
				// S'il s'agit d'un dossier,on le scanne grâce à notre objet
				if (Files.isDirectory(nom.toAbsolutePath())) {
					// si nous sommes dans un répertoire,nous lançons un nouveau
					// thread d'exécution
					// sur ce répertoire pour compter le nombre de fichiers
					FolderScanner f = new FolderScanner(nom.toAbsolutePath());

					// On retrouve notre objet FutureTask qui va nous permettre
					// de récupérer
					// le résultat du comptage de fichiers
					FutureTask<Long> ft = new FutureTask<>(f);
					Thread t = new Thread(ft);
					t.start();
					try {
						result += ft.get();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Maintenant,on filtre le contenu de ce même dossier sur le filtre
		// défini
		try (DirectoryStream<Path> listing = Files.newDirectoryStream(path)) {
			for (Path nom : listing) {
				// Pour chaque fichier correspondant,on incrémente notre
				// compteur
				result++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}
