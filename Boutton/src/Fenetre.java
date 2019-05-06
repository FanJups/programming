import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
public class Fenetre extends JFrame {
	
	
	public Fenetre(){
		
		this.setTitle("GridBagLayout");
		this.setSize(300,160);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		// On crée nos différents conteneurs de couleur différente
		
		JPanel cell1 = new JPanel(); 
		cell1.setBackground(Color.YELLOW);
		cell1.setPreferredSize(new Dimension(60,40));
		
		JPanel cell2 = new JPanel(); 
		cell2.setBackground(Color.red);
		cell2.setPreferredSize(new Dimension(60,40));
		
		JPanel cell3 = new JPanel(); 
		cell3.setBackground(Color.green);
		cell3.setPreferredSize(new Dimension(60,40));
		
		JPanel cell4 = new JPanel(); 
		cell4.setBackground(Color.black);
		cell4.setPreferredSize(new Dimension(60,40));
		
		JPanel cell5 = new JPanel(); 
		cell5.setBackground(Color.cyan);
		cell5.setPreferredSize(new Dimension(60,40));
		
		JPanel cell6 = new JPanel(); 
		cell6.setBackground(Color.BLUE);
		cell6.setPreferredSize(new Dimension(60,40));
		
		JPanel cell7 = new JPanel(); 
		cell7.setBackground(Color.orange);
		cell7.setPreferredSize(new Dimension(60,40));
		
		JPanel cell8 = new JPanel(); 
		cell8.setBackground(Color.DARK_GRAY);
		cell8.setPreferredSize(new Dimension(60,40));
		
		
		// Le conteneur principal
		JPanel content = new JPanel();
		content.setBackground(Color.WHITE);
		
		// On définit le layout manager
		content.setLayout(new GridBagLayout());
		
		// L'objet servant à positionner les composants
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		// On positionne la case de départ du composant
		
		gbc.gridx=0;
		gbc.gridy=0;
		
		// La taille en hauteur et en largeur
		
		gbc.gridheight=1;
		gbc.gridwidth=1;
		content.add(cell1, gbc);
		//-------------------------------------
		gbc.gridx=1;
		content.add(cell2, gbc);
		//-------------------------------------
		gbc.gridx=2;
		content.add(cell3, gbc);
		//-------------------------------------
		// Cette instruction informe le layout que c'est une fin de ligne
		
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		gbc.gridx=3;
		content.add(cell4, gbc);
		//---------------------------------------
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=2;
		
		// celle-ci indique que la cellule se réplique de façon verticale
		
		gbc.fill=GridBagConstraints.VERTICAL;
		content.add(cell5, gbc);
		
		//--------------------------------------
		
		gbc.gridx=1;
		gbc.gridheight=1;
		
		// celle-ci indique que la cellule se réplique de façon horizontale
		
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		content.add(cell6,gbc);
		
		//-----------------------------------------------
		
		gbc.gridx=1;
		gbc.gridy=2;
		gbc.gridwidth=2;
		content.add(cell7,gbc);
		
		//---------------------------------------------
		
		gbc.gridx=3;
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		content.add(cell8,gbc);
		
		//---------------------------------
		//On ajoute le conteneur
		
		this.setContentPane(content);
		this.setVisible(true);
		
		
		
	}

}
