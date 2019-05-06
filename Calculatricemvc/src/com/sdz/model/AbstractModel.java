package com.sdz.model;

import java.util.ArrayList;
import com.sdz.observer.Observable;
import com.sdz.observer.Observer;

public abstract class AbstractModel implements Observable {
	
	protected double result=0;
	protected String operateur="",operande="";
	private ArrayList<Observer> listObserver = new ArrayList<Observer> ();
	
	// Efface
	public abstract void reset();
	
	//Effectue le calcul
	public abstract void calcul();
	
	//Affichage forcé du résultat
	public abstract void getResultat();
	
	//Définit l'opérateur de l'opération
	public abstract void setOperateur(String operateur);
	
	//Définit le nombre à utiliser pour l'opération
	public abstract void setNombre (String nbre);
	
	//Implémentation du pattern observer
	public void addObserver(Observer obs){
		this.listObserver.add(obs);
	}
	
	public void notifyObserver(String str) {
		if(str.matches("^0[0-9]+"))
			str=str.substring(1,str.length());
		
		for(Observer obs:listObserver)
			obs.update(str);
	}
	
	public void removeObserver() {
		listObserver= new ArrayList<Observer>();
	}

}
