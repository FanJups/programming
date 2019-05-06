package com.sdz.controler;
import com.sdz.model.AbstractModel;

public class CalculetteControler extends AbstractControler {
	
	public CalculetteControler(AbstractModel cal){
		super(cal);
	}
	
	public void control(){
		//On notifie le modèle d'une action si le contrôle est bon
		//--------------------------------------------------------
		
		//Si l'opérateur est dans la liste
		if(this.listOperateur.contains(this.operateur)){
			//Si l'opérateur est =
			if(this.operateur.equals("="))
				this.calc.getResultat();//On ordonne au modèle d'afficher le résultat
			//Sinon, on passe l'opérateur au modèle
			else
				this.calc.setOperateur(this.operateur);
		}
		
		//Si le nombre est conforme
		
		if(this.nbre.matches("^[0-9.]+$"))
			this.calc.setNombre(this.nbre);
		
		this.operateur="";
		this.nbre="";
	}

}
