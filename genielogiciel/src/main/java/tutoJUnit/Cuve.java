package tutoJUnit;

public class Cuve {
	
	double quantite;
	double quantiteMax;
	public Cuve(double quantite, double quantiteMax) {
	this.quantite= quantite;
	this.quantiteMax= quantiteMax;
	}
	public void remplir(double quantite){
	this.quantite+=quantite;
	}
	public void vider(double quantite){
	this.quantite-=quantite;
	}
	public String toString(){
	return quantite+" "+quantiteMax;
	}

}
