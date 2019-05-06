import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Point {
	
	// Couleur du point
	private Color color=Color.red;
	
	// Taille
	private int size=10;
	
	// Position sur l'axe X: initialisé au dehors du conteneur
	private int x=-10;
	
	// Position sur l'axe Y: initialisé au dehors du conteneur
	private int y=-10;
	
	// Type de point
	private String type="ROND";
	
	// Constructeur par défaut
	
	public Point(){}
	
	public Point(int x,int y, int size,Color color,String type){
		this.size=size;
		this.color=color;
		this.x=x;
		this.y=y;
		this.type=type;
	}
	
	//ACCESSEURS
	
	public Color getColor(){
		return color;
	}
	
	public void setColor (Color color){
		this.color=color;
	}
	
	public int getSize(){
		return size;
	}
	
	public void setSize(int size){
		this.size=size;
	}
	
	public int getX(){
		return x;
	}
	
	public void setX(int x){
		this.x=x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int y){
		this.y=y;
	}
	
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type=type;
	}
	
	

}
