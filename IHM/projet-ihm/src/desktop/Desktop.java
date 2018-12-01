package desktop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.*;

import javax.swing.*;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Desktop extends JFrame {

	Container pane;
	protected Icone Icones;
	protected Dossier Dossier1;
	protected JLabel tmp, delete, copie;
	final Point pos = new Point();
	boolean copier_couper = false;
	// protected ArrayList<Point> tab_pos = new ArrayList<Point>();
	protected ArrayList<Point> tab_pos = new ArrayList<Point>();
	protected ArrayList<JLabel> tab_label = new ArrayList<JLabel>();
	JPanel window = new JPanel();
	JPanel inter = new JPanel();
	protected int a = 0;
	protected Window window1 = new Window(0, 0);
	protected boolean mousepressed = true;
	protected boolean winvisib = true;
	// protected Point[] tab = new Point[10];

	// image de fond
	ImagePanel fond;

	// variables du menu contextuel
	private JPopupMenu jpm = new JPopupMenu();
	private JMenuItem couper = new JMenuItem("Couper");
	private JMenuItem copier = new JMenuItem("Copier");
	private JMenuItem coller = new JMenuItem("Coller");
	private JMenuItem supprimer = new JMenuItem("Supprimer");
	private JMenu nouveau = new JMenu("nouveau");
	private JMenuItem organiser = new JMenuItem("organiser");
	private JMenu edit = new JMenu("edit");
	private JMenuItem redo = new JMenuItem("redo");
	private JMenuItem undo = new JMenuItem("undo");
	private JMenuItem word;
	private JMenuItem excel;
	private JMenuItem pdf;

	// listner pour le popmenu
	private CouperActionListener couperAction = new CouperActionListener();
	private CopierActionListener copierAction = new CopierActionListener();
	private CollerActionListener collerAction = new CollerActionListener();
	private SupprimerActionListener supprimerAction = new SupprimerActionListener();
	private organiserActionListener organiserAction = new organiserActionListener();
	private wordActionListener wordAction = new wordActionListener();
	private excelActionListener excelAction = new excelActionListener();
	private pdfActionListener pdfAction = new pdfActionListener();
	private redoActionListener redoAction = new redoActionListener();
	private undoActionListener undoAction = new undoActionListener();

	// constucteur du projet
	public Desktop(String title) {
		super(title);
		this.setLayout(null);

		pane = getContentPane();
		pane.setLayout(null);
		// pane.setBackground(Color.blue);

		// initialisation des images de base du bureau
		Icones = new Icone();
		Dossier1 = new Dossier();
		Dossier.pos.x = 300;
		Dossier.pos.y = 300;
		tmp = new JLabel();
		delete = new JLabel();
		copie = new JLabel();

		// icones des popmenu
		word = new JMenuItem("microsoft word", new ImageIcon("img/word.png"));
		excel = new JMenuItem("microsoft excel", new ImageIcon("img/excel.png"));
		pdf = new JMenuItem("fichier pdf", new ImageIcon("img/pdf.png"));

		coller.setEnabled(false);
		couper.addActionListener(couperAction);
		copier.addActionListener(copierAction);
		coller.addActionListener(collerAction);
		supprimer.addActionListener(supprimerAction);
		organiser.addActionListener(organiserAction);
		word.addActionListener(wordAction);
		excel.addActionListener(excelAction);
		pdf.addActionListener(pdfAction);
		redo.addActionListener(redoAction);
		undo.addActionListener(undoAction);

		// ajout du fond d'ecran
		fond = new ImagePanel(new ImageIcon("img/fond.jpg").getImage());
		fond.setLayout(null);

		// ajout de mouse listener pour le fond
		fond.addMouseListener(myMouseListener);

		// Ajouter les icones au desktop
		for (JLabel icon : Icone.LabelIcone) {
			icon.addMouseListener(myMouseListener);
			icon.addMouseMotionListener(myMouseMotionListener);
			fond.add(icon);
		}

		window1 = new Window(Dossier.pos.x, Dossier.pos.y);
		// ajout des listers pour le dossier
		Dossier1.folder.addMouseListener(myMouseListener);
		Dossier1.folder.addMouseMotionListener(myMouseMotionListener);
		Dossier1.folder.setBounds(Dossier.pos.x, Dossier.pos.y, 80, 80);
		repaint();
		fond.add(Dossier1.folder);

		this.setContentPane(fond);
		init();
	}

	public ArrayList<JLabel> arraycopy(ArrayList<JLabel> A) {
		ArrayList<JLabel> B = new ArrayList<JLabel>();
		for (int i = 0; i < A.size(); i++) {
			JLabel tmp = A.get(i);
			B.add(tmp);
		}
		return B;
	}

	/**
	 * Initialize the desktop window
	 */
	public void init() {

		// Resize window and make it visible
		Dimension dimension = new Dimension(1370, 730);

		// this.setResizable(false);
		this.setPreferredSize(dimension);
		this.setMinimumSize(dimension);

		// this.setLocationRelativeTo(null);

		// Close the application when the user closes the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Icone.Organiser();
		this.setVisible(true);

	}

	// fonction de deplacement des icones
	MouseListener myMouseListener = new MouseListener() {
		public void mousePressed(MouseEvent e) {

			if (e.getComponent() instanceof JLabel) {

				tab_label.add((JLabel) e.getComponent());
				Point point = new Point();
				point.x = e.getComponent().getX();
				point.y = e.getComponent().getY();
				System.out.print(point.x + "\t");
				System.out.print(point.y + "\n");
				tab_pos.add(new Point(point.x, point.y));

			}

			pos.setLocation(e.getX(), e.getY());
			if (e.getComponent() instanceof JLabel)
				tmp = (JLabel) e.getComponent();
		}

		public void mouseClicked(MouseEvent e) {

			if (e.getClickCount() == 2) {

				if (e.getComponent() == Dossier1.folder) {
					if (winvisib == false)
						window1.fenetre.setVisible(true);
					else {
						// window1 = new Window(Dossier1.pos.x,Dossier1.pos.y);
						window1.ajouter(Dossier.contenu);
						fond.add(window1.fenetre);
						validate();
						repaint();
						window1.fenetre.addMouseListener(myMouseListener);
						window1.fenetre
								.addMouseMotionListener(myMouseMotionListener);
						winvisib = false;
						repaint();
					}

				}

				// executable de VLC
				if (Icone.LabelIcone.get(1) != null
						&& e.getComponent() == Icone.LabelIcone.get(1)) {
					try {
						new ProcessBuilder(
								"C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe")
								.start();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

				// executable de chrome
				if (Icone.LabelIcone.size() == 10
						&& e.getComponent() == Icone.LabelIcone.get(10)) {
					try {
						new ProcessBuilder(
								"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe")
								.start();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

				// executable de excel
				if (Icone.LabelIcone.get(5) != null
						&& e.getComponent() == Icone.LabelIcone.get(5)) {
					try {
						new ProcessBuilder(
								"C:\\Program Files (x86)\\Microsoft Office\\Office14\\EXCEL.EXE")
								.start();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

				// executable de word
				if (Icone.LabelIcone.get(4) != null
						&& e.getComponent() == Icone.LabelIcone.get(4)) {
					try {
						new ProcessBuilder(
								"C:\\Program Files (x86)\\Microsoft Office\\Office14\\WINWORD.EXE")
								.start();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					// Icone.LabelIcone = arraycopy(undo_1) ;
					// repaint();
				}
			}
		}

		// fait apparaitre le menu contextuel
		public void mouseReleased(MouseEvent e) {

			revalidate();
			fond.repaint();
			if (e.getComponent() != Dossier1.folder
					&& e.getButton() == MouseEvent.BUTTON1
					&& e.getComponent() instanceof JLabel) {
				JLabel label = new JLabel();
				label = (JLabel) e.getComponent();
				if (Point.distance(Dossier.pos.x, Dossier.pos.y,
						label.getX(), label.getY()) < 64) {
					for (int i = 0; i < Icone.LabelIcone.size(); i++)
						if (label == Icone.LabelIcone.get(i)) {
							fond.remove(Icone.LabelIcone.get(i));
							Icone.LabelIcone.remove(Icone.LabelIcone.get(i));
						}
					// label.addMouseListener(myMouseListener);
					// label.addMouseMotionListener(myMouseMotionListener);
					Dossier.contenu.add(label);

					Dossier.contenu.add(label);
					for (int i = 0; i < Dossier.contenu.size(); i++)
						window1.fenetre.add(Dossier.contenu.get(i));
					validate();
					repaint();
				}

				// Dossier1.organiser(Dossier1.pos);
			}

			if (e.getButton() == MouseEvent.BUTTON3) {

				pos.x = e.getX();
				pos.y = e.getY();
				if (e.getComponent() instanceof JLabel) {
					JLabel label = (JLabel) e.getComponent();
					jpm.removeAll();
					jpm.add(couper);
					jpm.add(copier);
					jpm.add(supprimer);
					jpm.show(getContentPane(), label.getX() + e.getX(),
							label.getY() + e.getY());
				} else {
					jpm.removeAll();
					jpm.add(coller);
					jpm.add(nouveau);
					nouveau.add(word);
					nouveau.add(excel);
					nouveau.add(pdf);
					jpm.add(organiser);
					edit.add(redo);
					edit.add(undo);
					jpm.add(edit);
					if (e.getComponent() instanceof JPanel) {
						JPanel panel = (JPanel) e.getComponent();
						jpm.show(getContentPane(), panel.getX() + e.getX(),
								panel.getY() + e.getY());
					} else
						jpm.show(getContentPane(), e.getX(), e.getY());
				}
			}
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}
	};

	MouseMotionListener myMouseMotionListener = new MouseMotionListener() {
		public void mouseDragged(MouseEvent e) {

			if (e.getComponent() instanceof JLabel)

				// faire bouger les icones
				if (e.getComponent() instanceof JLabel) {

					JLabel label = (JLabel) e.getComponent();

					// ajouter le if pour que seul le clic gauche fasse bouger
					// l'icone
					if (SwingUtilities.isLeftMouseButton(e)) {
						fond.setComponentZOrder(label, 0);
						label.setLocation(label.getX() + e.getX() - pos.x,
								label.getY() + e.getY() - pos.y);
						mousepressed = true;
						setCursor(Cursor
								.getPredefinedCursor(Cursor.HAND_CURSOR));
						if (Dossier1.folder == e.getComponent()) {
							Dossier.pos.x = label.getX() + e.getX() - pos.x;
							Dossier.pos.y = label.getY() + e.getY() - pos.y;
						}

					}

				}

			// faire bouger les fenetre
			if (e.getComponent() instanceof JPanel) {
				JPanel panel = (JPanel) e.getComponent();
				// ajouter le if pour que seul le clic gauche fasse bouger
				// l'icone
				if (SwingUtilities.isLeftMouseButton(e)) {
					fond.setComponentZOrder(panel, 0);
					panel.setLocation(panel.getX() + e.getX() - pos.x,
							panel.getY() + e.getY() - pos.y);
					setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					window1.pt.x = panel.getX() + e.getX();
					window1.pt.y = panel.getY() + e.getY();
				}
			}

		}

		public void mouseMoved(MouseEvent e) {
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
	};

	// fonctions d'actions du menu contextuel
	public class CouperActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			coller.setEnabled(true);
			copier_couper = true;
			for (int i = 0; i < Icone.LabelIcone.size(); i++) {
				if (tmp == Icone.LabelIcone.get(i))
					delete = Icone.LabelIcone.get(i);
			}
		}
	}

	public class CopierActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			coller.setEnabled(true);
			for (int i = 0; i < Icone.LabelIcone.size(); i++) {
				if (tmp == Icone.LabelIcone.get(i)) {
					copie = Icone.LabelIcone.get(i);
					copie.setText(Icone.LabelIcone.get(i).getText());
					copie.setHorizontalTextPosition(JLabel.CENTER);
					copie.setVerticalTextPosition(JLabel.BOTTOM);
				}
				if (tmp == Dossier1.folder) {
					copie = Dossier1.folder;
					copie.setText(Dossier1.folder.getText());
					copie.setHorizontalTextPosition(JLabel.CENTER);
					copie.setVerticalTextPosition(JLabel.BOTTOM);
				}
			}
		}
	}

	public class CollerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			// copier sur le
			if (copier_couper == true) {
				Icones.supprimer(delete);
				fond.remove(delete);
				Icones.ajout(delete, pos);
				// ajout des lisener pour la nouvelle icone
				Icone.LabelIcone.get(Icone.LabelIcone.size() - 1)
						.addMouseListener(myMouseListener);
				Icone.LabelIcone.get(Icone.LabelIcone.size() - 1)
						.addMouseMotionListener(myMouseMotionListener);
				fond.add(Icone.LabelIcone.get(Icone.LabelIcone.size() - 1));
				coller.setEnabled(false);
				repaint();
				copier_couper = false;
			} else {
				Icones.ajout(copie, pos);
				// ajout des lisener pour la nouvelle icone
				Icone.LabelIcone.get(Icone.LabelIcone.size() - 1)
						.addMouseListener(myMouseListener);
				Icone.LabelIcone.get(Icone.LabelIcone.size() - 1)
						.addMouseMotionListener(myMouseMotionListener);
				fond.add(Icone.LabelIcone.get(Icone.LabelIcone.size() - 1));
				coller.setEnabled(false);
				repaint();
			}
		}
	}

	public class SupprimerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Icones.supprimer(tmp);
			fond.remove(tmp);
			repaint();
		}
	}

	public class organiserActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Icone.Organiser();
			repaint();
		}

	}

	public class wordActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JLabel label = new JLabel();
			label.setText("word");
			label.setForeground(new Color(255, 255, 255));
			label.setHorizontalTextPosition(JLabel.CENTER);
			label.setVerticalTextPosition(JLabel.BOTTOM);
			label.addMouseListener(myMouseListener);
			label.addMouseMotionListener(myMouseMotionListener);
			label.setIcon(new ImageIcon("img/word.png"));
			label.setBounds(pos.x, pos.y, 80, 80);
			Icone.LabelIcone.add(label);
			fond.add(Icone.LabelIcone.get(Icone.LabelIcone.size() - 1));
		}
	}

	public class excelActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JLabel label = new JLabel();
			label.setText("excel");
			label.setForeground(new Color(255, 255, 255));
			label.setHorizontalTextPosition(JLabel.CENTER);
			label.setVerticalTextPosition(JLabel.BOTTOM);
			// label.setHorizontalTextPosition(10);
			label.addMouseListener(myMouseListener);
			label.addMouseMotionListener(myMouseMotionListener);
			label.setIcon(new ImageIcon("img/excel.png"));
			label.setBounds(pos.x, pos.y, 80, 80);
			Icone.LabelIcone.add(label);
			fond.add(Icone.LabelIcone.get(Icone.LabelIcone.size() - 1));
		}
	}

	public class pdfActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JLabel label = new JLabel();
			label.setText("pdf");
			label.setForeground(new Color(255, 255, 255));
			label.setHorizontalTextPosition(JLabel.CENTER);
			label.setVerticalTextPosition(JLabel.BOTTOM);
			label.addMouseListener(myMouseListener);
			label.addMouseMotionListener(myMouseMotionListener);
			label.setIcon(new ImageIcon("img/pdf.png"));
			label.setBounds(pos.x, pos.y, 80, 80);
			Icone.LabelIcone.add(label);
			fond.add(Icone.LabelIcone.get(Icone.LabelIcone.size() - 1));
		}
	}

	public class redoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (copier_couper == true) {
				Icones.supprimer(delete);
				fond.remove(delete);
				Icones.ajout(delete, pos);
				// ajout des lisener pour la nouvelle icone
				Icone.LabelIcone.get(Icone.LabelIcone.size() - 1)
						.addMouseListener(myMouseListener);
				Icone.LabelIcone.get(Icone.LabelIcone.size() - 1)
						.addMouseMotionListener(myMouseMotionListener);
				fond.add(Icone.LabelIcone.get(Icone.LabelIcone.size() - 1));
				coller.setEnabled(false);
				repaint();
				copier_couper = false;
			} else {
				Icones.ajout(copie, pos);
				// ajout des lisener pour la nouvelle icone
				Icone.LabelIcone.get(Icone.LabelIcone.size() - 1)
						.addMouseListener(myMouseListener);
				Icone.LabelIcone.get(Icone.LabelIcone.size() - 1)
						.addMouseMotionListener(myMouseMotionListener);
				fond.add(Icone.LabelIcone.get(Icone.LabelIcone.size() - 1));
				coller.setEnabled(false);
				repaint();
			}
		}
	}

	public class undoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			for (int i = 0; i < Icone.LabelIcone.size(); i++)
				if (tab_label.get(tab_label.size() - 1) == Icone.LabelIcone
						.get(i)) {
					Icone.LabelIcone.get(i).setBounds(
							(int) (tab_pos.get(tab_pos.size() - 1).getX()),
							(int) (tab_pos.get(tab_pos.size() - 1).getY()), 80,
							80);
					tab_label.remove(tab_label.get(tab_label.size() - 1));
					tab_pos.remove(tab_pos.get(tab_pos.size() - 1));
					break;
				}
		}

	}

	public boolean dans_la_fenetre(int x, int y, int lookfor_x, int lookfor_y) {
		if (lookfor_x > x && lookfor_x < (x + 300) && lookfor_y > y
				&& lookfor_y < (y + 300))
			return false;
		return true;
	}

	// main
	public static void main(String[] args) {
		new Desktop("Desktop");
	}

}
