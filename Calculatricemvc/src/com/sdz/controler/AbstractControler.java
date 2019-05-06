package com.sdz.controler;
import java.util.ArrayList;
import com.sdz.model.AbstractModel;

public abstract class AbstractControler {
	
	protected AbstractModel calc;
	protected String operateur ="",nbre="";
	protected ArrayList<String> listOperateur = new ArrayList<String>();
	
	public AbstractControler (AbstractModel cal){
		this.calc=cal;
		//On définit la liste des opérateurs
		//Afin de s'assurer qu'ils sont corrects
		this.listOperateur.add("+");
		this.listOperateur.add("-");
		this.listOperateur.add("*");
		this.listOperateur.add("/");
		this.listOperateur.add("=");
	}
	
	//Définit l'opérateur
	public void setOperateur (String ope) {
		this.operateur=ope;
		control();
	}
	
	//Définit le nombre
		public void setNombre (String nombre) {
			this.nbre=nombre;
			control();
		}
		
	//Efface
		public void reset(){
			this.calc.reset();
		}
		
	// Méthode de contrôle
		abstract void control();

}
