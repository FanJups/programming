import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import java.util.ArrayList;

public class Fenetre extends JFrame {
	
	// LE MENU
	
	private JMenuBar menuBar= new JMenuBar();
	JMenu fichier = new JMenu("Fichier"),
			edition = new JMenu("Edition"),
					forme = new JMenu("Forme du pointeur"),
							couleur = new JMenu("Couleur du pointeur");
	
	JMenuItem nouveau = new JMenuItem("Effacer"),
	quitter = new JMenuItem("Quitter"),
	rond = new JMenuItem("Rond"),
	carre = new JMenuItem("Carré"),
	bleu = new JMenuItem("Bleu"),
	rouge = new JMenuItem("Rouge"),
	vert = new JMenuItem("Vert");
	
	// LA BARRE D'OUTILS
	
	JToolBar toolBar = new JToolBar();
	
	// Créer les fichiers et le dossier images
	
	// A utiliser quand j'aurais les images
	
	/*JButton square = new JButton(new ImageIcon("images/carré.jpg")),
			circle = new JButton(new ImageIcon("images/rond.jpg")),
					red = new JButton(new ImageIcon("images/rouge.jpg")),
							green = new JButton(new ImageIcon("images/vert.jpg")),
									blue = new JButton(new ImageIcon("images/bleu.jpg"));*/
	
	JButton square = new JButton("square"),
			circle = new JButton("circle"),
					red = new JButton("red"),
							green = new JButton("green"),
									blue = new JButton("blue");
	// LES ECOUTEURS
	
	private FormeListener fListener = new FormeListener();
	private CouleurListener cListener = new CouleurListener();
	
	// Notre zone de dessin
	
	private DrawPanel drawPanel = new DrawPanel();
	
	public Fenetre(){
		this.setSize(700,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// On initialise le menu
		
		this.initMenu();
		
		// Idem pour la barre d'outils
		
		this.initToolBar();
		
		// On positionne notre zone de dessin
		
		this.getContentPane().add(drawPanel,BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	// Initialise le menu
	
	private void initMenu(){
		nouveau.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent arg0){
				drawPanel.erase();
			}
		});
		
		nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
		
		quitter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				System.exit(0);
			}
		});
		
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_DOWN_MASK));
		
		fichier.add(nouveau);
		fichier.addSeparator();
		fichier.add(quitter);
		fichier.setMnemonic('F');
		
		carre.addActionListener(fListener);
		rond.addActionListener(fListener);
		forme.add(rond);
		forme.add(carre);
		
		rouge.addActionListener(cListener);
		vert.addActionListener(cListener);
		bleu.addActionListener(cListener);
		couleur.add(rouge);
		couleur.add(vert);
		couleur.add(bleu);
		
		edition.setMnemonic('E');
		edition.add(forme);
		edition.addSeparator();
		edition.add(couleur);
		
		menuBar.add(fichier);
		menuBar.add(edition);
		
		this.setJMenuBar(menuBar);
	}
			
			// Initialise la barre d'outils
	
	private void initToolBar(){
		
		JPanel panneau = new JPanel();
		square.addActionListener(fListener);
		circle.addActionListener(fListener);
		red.addActionListener(cListener);
		green.addActionListener(cListener);
		blue.addActionListener(cListener);
		
		toolBar.add(square);
		toolBar.add(circle);
		
		toolBar.addSeparator();
		toolBar.add(red);
		toolBar.add(blue);
		toolBar.add(green);
		
		this.getContentPane().add(toolBar,BorderLayout.NORTH);
		
		
	}
	
	//ECOUTEUR POUR LE CHANGEMENT DE FORME 
	
	class FormeListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().getClass().getName().equals("javax.swing.JMenuItem")){
				
				if(e.getSource()==carre)
					
					drawPanel.setPointerType("SQUARE");
				else
					drawPanel.setPointerType("CIRCLE");
					
			}
			
			else{
				if(e.getSource()==carre)
					drawPanel.setPointerType("SQUARE");
				else
					drawPanel.setPointerType("CIRCLE");
					
			}
		}
	}
	
	//ECOUTEUR POUR LE CHANGEMENT DE COULEUR
	
	class CouleurListener implements ActionListener{
		
		public void actionPerformed (ActionEvent e){
			
			System.out.println(e.getSource().getClass().getName());
			
			if(e.getSource().getClass().getName().equals("javax.swing.JMenuItem")){
				
				System.out.println("OK !");
				
				if(e.getSource()==vert)
					
					drawPanel.setPointerColor(Color.green);
				else
					
					if(e.getSource()==bleu)
						
						drawPanel.setPointerColor(Color.blue);
					else
						drawPanel.setPointerColor(Color.red);
						
			}
			
			else{
				
				if(e.getSource()==green)
					
					drawPanel.setPointerColor(Color.green);
				else
					
					if(e.getSource()==blue)
						
						drawPanel.setPointerColor(Color.blue);
					else
						
						drawPanel.setPointerColor(Color.red);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Fenetre fen = new Fenetre();

	}

}
