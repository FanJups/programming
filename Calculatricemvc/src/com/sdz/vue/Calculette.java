package com.sdz.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sdz.controler.AbstractControler;
import com.sdz.observer.Observer;

public class Calculette extends JFrame implements Observer {
	
	private JPanel container = new JPanel();
	
	String[] tab_string={"1","2","3","4","5","6","7","8","9","0",".","=","C","+","-","*","/"};
	
	JButton[] tab_button= new JButton[tab_string.length];
	
	private JLabel ecran = new JLabel();
	private Dimension dim = new Dimension(50,40);
	private Dimension dim2 = new Dimension(50,31);
	private double chiffre1;
	private boolean clicOperateur=false,update=false;
	private String operateur="";
	
	//L'instance de notre objet contrôleur
	private AbstractControler controler;
	
	public Calculette (AbstractControler controler) {
		
		this.setSize(240,260);
		this.setTitle("Calculette MVC");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		initComposant();
		this.controler=controler;
		this.setContentPane(container);
		this.setVisible(true);
	}
	
	public void initComposant(){
		Font police = new Font("Arial",Font.BOLD,20);
		ecran = new JLabel("0");
		ecran.setFont(police);
		ecran.setHorizontalAlignment(JLabel.RIGHT);
		ecran.setPreferredSize(new Dimension (220,20));
		
		JPanel operateur = new JPanel();
		operateur.setPreferredSize(new Dimension(55,225));
		
		JPanel chiffre = new JPanel();
		chiffre.setPreferredSize(new Dimension(165,225));
		
		JPanel panEcran = new JPanel();
		panEcran.setPreferredSize(new Dimension(220,30));
		
		//Nous utiliserons le même listener pour tous les opérateurs
		OperateurListener opeListener = new OperateurListener();
		
		for(int i=0;i<tab_string.length;i++)
		{
			tab_button[i]= new JButton (tab_string[i]);
			tab_button[i].setPreferredSize(dim);
			
			switch(i){
			
			case 11:
				tab_button[i].addActionListener(opeListener);
				chiffre.add(tab_button[i]);
				break;
			
			case 12:
				tab_button[i].setForeground(Color.red);
				tab_button[i].addActionListener(new ResetListener());
				tab_button[i].setPreferredSize(dim2);
				operateur.add(tab_button[i]);
				break;
			case 13:
			case 14:
			case 15:
			case 16:
				tab_button[i].setForeground(Color.red);
				tab_button[i].addActionListener(opeListener);
				tab_button[i].setPreferredSize(dim2);
				operateur.add(tab_button[i]);
				break;
			default:
				chiffre.add(tab_button[i]);
				tab_button[i].addActionListener(new ChiffreListener());
				break;
			
				
			}
		}
		
		panEcran.add(ecran);
		panEcran.setBorder(BorderFactory.createLineBorder(Color.black));
		container.add(panEcran,BorderLayout.NORTH);
		container.add(chiffre,BorderLayout.CENTER);
		container.add(operateur,BorderLayout.EAST);
	}
	
	//Les listeners pour nos boutons
	
	class ChiffreListener implements ActionListener{
		
		public void actionPerformed (ActionEvent e){
			
			//On affiche le chiffre en plus dans le label
			String str = ((JButton)e.getSource()).getText();
			if(!ecran.getText().equals("0"))
				str=ecran.getText()+str;
			
			controler.setNombre(((JButton)e.getSource()).getText());
		}
	}
	
	class OperateurListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			controler.setOperateur(((JButton)e.getSource()).getText());
		}
	}
	
	class ResetListener implements ActionListener{
		public void actionPerformed (ActionEvent arg0){
			controler.reset();
		}
	}
	
	//Implémentation du pattern observer
	
	public void update (String str){
		ecran.setText(str);
	}

}
