/**
 * 
 */
package com.sdz.model;

import java.io.*;
import java.util.*;

/**
 * @author Admin
 *
 */
public class Score implements Serializable {
	
	  private String nom;
	  private int point, pointMarque;
	  private int nbreMot;
	  
	  public Score(){
		    this.nom = new String("........");
		    this.point = 0;
		    this.nbreMot = 0;
	  }
	  
	  public Score(String nom, int point, int mot){
		  this.nom = nom;
		  this.point = point;
		  this.nbreMot = mot;
	  }

	  public int getPoint(){
		  return point;
	  }
	  
	  public void initPoint(int nbErreur){
		  switch (nbErreur){

		      case 0:
		          this.point += 100;
		          this.pointMarque = 100;
		          break;
		
		      case 1:
		    	  this.point += 50;
		    	  this.pointMarque = 50;
		          break;
		
		      case 2:
		    	  this.point += 35;
		    	  this.pointMarque = 35;
		          break;
		
		      case 3:
		    	  this.point += 25;
		    	  this.pointMarque = 25;
		          break;
		
		      case 4:
		    	  this.point += 15;
		    	  this.pointMarque = 15;
		          break;
		
		      case 5:
		    	  this.point += 10;
		    	  this.pointMarque = 10;
		          break;
		
		      case 6:
		    	  this.point += 5;
		    	  this.pointMarque = 5;
		          break;
		
		      default:
		    	  this.point += 0;

	      }

	  }
	  public String getNom(){
		  return nom;
	  }
	  
	  public void setNom(String nom){
		  this.nom = (nom != null) ? nom : "........";
	  }

	  public void setNombreMot(int nbre){
		  this.nbreMot = nbre;
	  }
	  
	  public int getNombreMot(){
		  return this.nbreMot;
	  }
	  
	  public String toString(){
		  return " "+nom+" : "+point+" pts ("+nbreMot+" mot"+((nbreMot > 1) ? "s" : "")+")";	  
	  }

	  public int getPointMarque(){
		  return pointMarque;
	  }
	  

}
