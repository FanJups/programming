import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Fenetre extends JFrame {
	
	private JPanel container = new JPanel();
	private JComboBox combo = new JComboBox();
	private JLabel label = new JLabel("Une ComboBox");
	
	public Fenetre(){
		
		this.setTitle("Animation");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		combo.setPreferredSize(new Dimension(100,20));
		combo.setForeground(Color.blue);
		
		String[] tab = {"Option 1","Option 2","Option 3", "Option 4"};
		combo = new JComboBox (tab);
		
		/*combo.addItem("Option 1");
		combo.addItem("Option 2");
		combo.addItem("Option 3");
		combo.addItem("Option 4");*/
		
		// Ajout du listener
		
		combo.addItemListener(new ItemState());
		combo.addActionListener(new ItemAction());
		
		
		JPanel top=new JPanel();
		top.add(label);
		top.add(combo);
		container.add(top,BorderLayout.NORTH);
		this.setContentPane(container);
		this.setVisible(true);
		
	}
	
	// Classe interne implémentant l'interface ItemListener
	
	class ItemState implements ItemListener {
		public void itemStateChanged (ItemEvent e){
			System.out.println("évènement déclenché sur: "+e.getItem());
		}
	}
	
	// Classe interne implémentant l'interface ActionListener
	
	class ItemAction implements ActionListener {
		public void actionPerformed (ActionEvent e){
			System.out.println("ActionListener : action sur "+combo.getSelectedItem());
		}
	}
	
	

}
