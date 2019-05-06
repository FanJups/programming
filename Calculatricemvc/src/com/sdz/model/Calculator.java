package com.sdz.model;

import com.sdz.observer.Observable;

public class Calculator extends AbstractModel {
	
	//Définit l'opérateur
	public void setOperateur (String ope){
		//On lance le calcul
		calcul();
		
		//On stocke l'opérateur
		this.operateur=ope;
		
		//Si l'opérateur n'est pas =
		if(!ope.equals("=")){
			//On réinitialise l'opérande
			this.operande="";
		}
	}
	
	// Définit le nombre
	public void setNombre (String result){
		//On concatène le nombre
		this.operande+=result;
		//On met à jour
		notifyObserver(this.operande);
	}
	
	//Force le calcul
	public void getResultat(){
		calcul();
	}
	
	//Réinitialise tout
	public void reset(){
		this.result=0;
		this.operande="0";
		this.operateur="";
		//Mis à jour !
		notifyObserver(String.valueOf(this.result));
	}
	
	//Calcul
	
	public void calcul(){
		// S'il n' y a pas d'opérateur, le résultat est le nombre saisi
		
		if(this.operateur.equals("")){
			this.result= Double.parseDouble(this.operande);
		}
		else{
			//Si l'opérande n'est pas vide, on calcule avec l'opérateur de calcul
			if(!this.operande.equals("")){
				if(this.operateur.equals("+"))
					this.result+= Double.parseDouble(this.operande);
				if(this.operateur.equals("-"))
					this.result-= Double.parseDouble(this.operande);
				if(this.operateur.equals("*"))
					this.result*= Double.parseDouble(this.operande);
				if(this.operateur.equals("/")){
					try {
						this.result /=Double.parseDouble(this.operande);
					}catch (ArithmeticException e){
						this.result=0;
					}
				}
					
			}
		}
		this.operande="";
		// On lance aussi la mise à  jour !
		
		notifyObserver(String.valueOf(this.result));
	}

}
