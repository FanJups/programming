/**
 * 
 */
package com.sdz.vue;

import com.sdz.model.Model;
import com.sdz.observer.Observable;

/**
 * @author Admin
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Observable model = new Model();
		Fenetre fen = new Fenetre(model);
		fen.setVisible(true);

	}

}
