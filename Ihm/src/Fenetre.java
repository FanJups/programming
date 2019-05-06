import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
public class Fenetre extends JFrame {
	
private Panneau pan = new Panneau();
private JButton bouton = new JButton("mon bouton");
private JPanel container = new JPanel();
	
	public Fenetre(){
		
		this.setTitle("Animation");
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.add(pan,BorderLayout.CENTER);
		container.add(bouton,BorderLayout.SOUTH);
		this.setContentPane(container);
		this.setVisible(true);
		go();
		
	}
	
	private void go(){
		/*for (;;){
			int x=pan.getPosX(),y=pan.getPosY();
			x++;
			y++;
			pan.setPosX(x);
			pan.setPosY(y);
			pan.repaint();
			try {
				Thread.sleep(10);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			// Si nos coordonnées arrivent au bord de notre composant
			// On réinitialise
			
			if(x==pan.getWidth()|| y== pan.getHeight()){
				pan.setPosX(-50);
				pan.setPosY(-50);
			}
			
		}*/
		
		// Les coordonnées de départ de notre rond
		int x=pan.getPosX(),y=pan.getPosY();
		// Le booléen pour savoir si l'on recule ou non sur l'axe x
		
		boolean backX=false;
		
		// Le booléen pour savoir si l'on recule ou non sur l'axe y
		
		boolean backY=false;
		
		while(true){
			// Si la coordonnée x est inférieure à 1 , on avance
			
			if(x<1)
				backX=false;
			
			// Si la coordonnée x est supérieure à la taille du Panneau moins la taille du rond, on recule
			
			if(x>pan.getWidth()-50)
				backX=true;
			
			// Idem pour l'axe y
			
			if(y<1)
				backY=false;
			if(y>pan.getHeight()-50)
				backY=true;
			
			// Si on avance, on incrémente la coordonnée
			// backX est un booléen, donc !backX revient à écrire
			// if(backX==false)
			
			if(!backX)
				pan.setPosX(++x);
			// Sinon, on décrémente
			
			else
				pan.setPosX(--x);
			// Idem pour l'axe Y
			
			if(!backY)
				pan.setPosY(++y);
			// Sinon, on décrémente
			
			else
				pan.setPosY(--y);
			
			// On redesine notre Panneau
			
			pan.repaint();
			
			// Comme on dit: la pause s'impose ! Ici, 3 millièmes de secondes
			
			try {
				Thread.sleep(3);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			
				
		}
		
		
	}

}
