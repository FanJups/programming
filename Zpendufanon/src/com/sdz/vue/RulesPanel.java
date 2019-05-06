/**
 * 
 */
package com.sdz.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * @author Admin
 *
 */
public class RulesPanel extends ZContainer {
	
	public RulesPanel(Dimension dim){
		super(dim);
		initPanel();
	}
	
	public void initPanel(){
		JLabel titre = new JLabel();
		titre.setFont(comics30);
		titre.setText("Le jeu du pendu 4HWC");
		titre.setHorizontalAlignment(JLabel.CENTER);
		
		this.panel.add(titre, BorderLayout.CENTER);
		
		this.panel.add(new JLabel(new ImageIcon("pendu.jpg")), BorderLayout.CENTER);
		
		JTextArea accueil = new JTextArea();
		accueil.setBackground(Color.white);
		accueil.setText(	"\n\n\nVous avez sept coups pour trouver le mot caché. Si vous réussissez, on recommence !\n" +
							"Plus vous trouvez de mots, plus votre score augmente. Alors, à vous de jouer !\n" +
							"\n\nCOMPTE DES POINTS :\n\n\tMot trouvé sans erreur\t\t100 pts\n\tMot trouvé avec une erreur\t50 pts\n" +
							"\tMot trouvé avec deux erreurs\t35 pts\n\tMot trouvé avec trois erreurs\t25 pts\n\tMot trouvé avec quatre erreurs\t15 pts\n" +
							"\tMot trouvé avec cinq erreurs\t10 pts\n\tMot trouvé avec six erreurs\t5 pts\n\n\n" +
							"On vous souhaite bien du plaisir !\nSi vous pensez pouvoir trouver un mot en un seul essai, c'est que vous croyez que le dictionnaire est petit.\n" +
							"Or, pour votre information, il contient plus de 336 000 mots ! Bonne chance ! ;) \n\n 4HWC IT TESTS");
		accueil.setFont(arial);
		accueil.setEditable(false);
		this.panel.add(accueil, BorderLayout.SOUTH);
	}
	

}
