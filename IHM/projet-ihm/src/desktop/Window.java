package desktop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window {

	protected JButton closeBt = new JButton(new ImageIcon("./img/close.png"));
	protected JPanel fenetre;
	protected JPanel barre;
	protected JLabel title;
	protected Point pt = new Point();

	public Window(int x, int y) {

		fenetre = new JPanel();

		pt.x = x;
		pt.y = y;

		// barre pour close
		barre = new JPanel();
		title = new JLabel("  Fenetre");

		closeBt.setBounds(280, 0, 20, 20);
		closeBt.setSize(new Dimension(20, 20));
		closeBt.setLayout(new BorderLayout());
		closeBt.setPreferredSize(new Dimension(20, 20));
		closeBt.setMaximumSize(new Dimension(20, 20));

		barre.setSize(new Dimension(300, 20));
		barre.setPreferredSize(new Dimension(300, 20));
		barre.setMinimumSize(new Dimension(300, 20));
		barre.setLayout(new BorderLayout());
		barre.add(title);
		title.setBounds(10, 0, 200, 20);
		barre.add(closeBt, BorderLayout.EAST);

		fenetre.add(barre, BorderLayout.NORTH);
		fenetre.setSize(300, 300);
		fenetre.setBounds(x, y, 300, 300);
		fenetre.setLayout(new BorderLayout());

		// rendre la fentre transparente
		fenetre.setBackground(new Color(1f, 1f, 1f, .8f));

		closeBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fenetre.setVisible(false);
				fenetre.setBounds(pt.x, pt.y, 300, 300);
			}
		});

		fenetre.setVisible(true);

	}

	public void ajouter(ArrayList<JLabel> X) {
		for (int i = 0; i < X.size(); i++)
			fenetre.add(X.get(i));
	}

}
