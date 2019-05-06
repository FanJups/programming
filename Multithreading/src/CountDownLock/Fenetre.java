package CountDownLock;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

	JButton bouton = new JButton("Décrémenter le compte à rebours");
	JLabel info = new JLabel();

	CountDownLatch lock;

	public Fenetre(CountDownLatch pLock) {
		lock = pLock;

		JPanel panneau = new JPanel();
		panneau.setLayout(new BorderLayout());

		info.setText("Compte à rebours : " + lock.getCount());
		info.setHorizontalAlignment(JLabel.CENTER);

		panneau.add(bouton, BorderLayout.NORTH);
		panneau.add(info, BorderLayout.SOUTH);

		getContentPane().add(panneau);

		setTitle("CountDownLatch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		pack();

		bouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lock.countDown();
				info.setText("Compte à rebours : " + lock.getCount());
			}
		});

		setVisible(true);

	}

}
