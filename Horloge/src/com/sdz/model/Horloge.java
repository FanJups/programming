/**
 * 
 */
package com.sdz.model;

import java.util.ArrayList;
import java.util.Calendar;

import com.sdz.observer.Observable;
import com.sdz.observer.Observateur;

/**
 * @author Admin
 *
 */
public class Horloge implements Observable {

	// On récupère l'instance d'un calendrier
	// Elle va nous permettre de récupérer l'heure actuelle
	private Calendar cal;
	private String hour = "";
	// Notre collection d'observateurs
	private ArrayList<Observateur> listObservateur = new ArrayList<Observateur>();

	public void run() {
		while (true) {
			this.cal = Calendar.getInstance();

			this.hour = this.cal.get(Calendar.HOUR_OF_DAY) + " : "
					+ (this.cal.get(Calendar.MINUTE) < 10 ? "0" + this.cal.get(Calendar.MINUTE)
							: this.cal.get(Calendar.MINUTE))
					+ " : " + ((this.cal.get(Calendar.SECOND) < 10) ? "0" + this.cal.get(Calendar.SECOND)
							: this.cal.get(Calendar.SECOND));

			// On avertit les observateurs que l'heure a été mise à jour
			this.updateObservateur();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Ajoute un observateur à la liste
	public void addObservateur(Observateur obs) {
		this.listObservateur.add(obs);
	}

	public void delObservateur() {
		this.listObservateur = new ArrayList<Observateur>();
	}

	// Avertit les observateurs que l'objet observable a changé
	// et invoque la méthode update() de chaque observateur

	public void updateObservateur() {
		for (Observateur obs : this.listObservateur)
			obs.update(this.hour);
	}

}
