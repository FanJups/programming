/**
 * 
 */
package com.sdz.vue;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sdz.model.Horloge;
import com.sdz.observer.Observateur;

/**
 * @author Admin
 *
 */
public class Fenetre extends JFrame {

	private JLabel label = new JLabel();
	private Horloge horloge;

	public Fenetre() {
		// On initialise la JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(200, 80);

		// On initialise l'horloge
		this.horloge = new Horloge();
		// On place un écouteur sur l'horloge
		this.horloge.addObservateur(new Observateur() {

			public void update(String hour) {
				label.setText(hour);
			}
		});

		// On initialise le JLabel

		Font police = new Font("DS-digital", Font.TYPE1_FONT, 30);
		this.label.setFont(police);
		this.label.setHorizontalAlignment(JLabel.CENTER);

		// On ajoute le JLabel à la JFrame

		this.getContentPane().add(this.label, BorderLayout.CENTER);
		this.setVisible(true);
		this.horloge.run();
	}

	/**
	 * @param args
	 */
	// Méthode main lançant le programme
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fenetre fen = new Fenetre();

	}

}
