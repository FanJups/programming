/**
 * 
 */
package com.sdz.controler;

import com.sdz.model.Model;
import com.sdz.observer.Observable;

/**
 * @author Admin
 *
 */
public class Controler {
	
	private Model model;
	
	public Controler(Observable mod){
		this.model=(Model)mod;
	}
	
	public void control(char c){
		
		if(c=='E'){
			char tab[]={'�', '�', '�', '�', c};
			this.model.assign(tab);
		}
		
		else if(c=='A'){
			char tab[]={'�', '�', '�', c};
			this.model.assign(tab);
		}
		
		else if(c=='I'){
			char tab[]={'�', '�', c};
			this.model.assign(tab);
		}
		
		else if(c=='O'){
			char tab[]={'�', '�', c};
			this.model.assign(tab);
		}
		
		else if(c=='U'){
			char tab[]={'�', '�', c};
			this.model.assign(tab);
		}
		
		else if(c=='C'){
			char tab[]={'�', c};
			this.model.assign(tab);
		}
		
		else
			this.model.assign(c);
		
		
	}

}
