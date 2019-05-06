import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
public class Panneau extends JPanel {
	
	private int posX =-50;
	private int posY =-50;
	
	public void paintComponent (Graphics g){
		// Vous verrez  cette phrase chaque fois que la méthode sera invoquée
		
		/*System.out.println("Je suis exécutée !");
		g.fillOval(20,20,75,75);*/
		
		//int x1= this.getWidth()/4;
		//int y1= this.getHeight()/4;
		
		//g.drawOval(x1,y1,getWidth()/2,getWidth()/2);
		//g.drawOval(x1,y1,getWidth()/2,getWidth()/2);
		
		//g.drawRect(10,10,50,60);
		//g.fillRect(65, 65, 30, 40);
		
		 //g.drawRoundRect(10,10,30,50,10,10);
		//g.fillRoundRect(55, 65, 55, 30,5,5);
		
		//g.drawLine(0,0,this.getWidth(),this.getHeight());
				//g.drawLine(0, this.getHeight(), this.getWidth(), 0);
		
		/*int x[]={20,30,50,60,60,50,30,20};
		int y[]={30,20,20,30,50,60,60,50};
		g.drawPolyline(x,y,8);
		
		int x2[]={50,60,80,90,90,80,60,50};
		int y2[]={60,50,50,60,80,90,90,80};
		g.fillPolygon(x2,y2,8);*/
		
		// On choisit une couleur de fond pour le rectangle
		g.setColor(Color.white);
		// On le dessine de sorte qu'il occupe toute la surface
		
		g.fillRect(0,0,this.getWidth(),this.getHeight());
		
		// On redéfinit une couleur pour le rond
		
		g.setColor(Color.red);
		
		//On le dessine aux coordonnées souhaitées
		g.fillOval(posX,posY,50,50);
		
		
	}
	
	public int getPosX(){
		return posX;
	}
	
	public void setPosX (int posX){
		this.posX=posX;
	}
	
	public int getPosY(){
		return posY;
	}
	
	public void setPosY (int posY){
		this.posY=posY;
	}
	

}
