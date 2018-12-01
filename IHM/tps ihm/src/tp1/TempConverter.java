package tp1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Container.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.security.auth.kerberos.KeyTab;
import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class TempConverter extends JFrame {

	// Variables
	private JLabel labelC = new JLabel("Celsius"); // Name of the Celsius field
	private JLabel labelF = new JLabel("Fahrenheit"); // Name of the Fahrenheit
														// field
	private JTextField textFieldC = new JTextField(5); // Celsius field
	private JTextField textFieldF = new JTextField(5); // Fahrenheit field
	
	private JButton buttonReset = new JButton("Reset"); // Button for reseting
														// the fields
	private JButton buttonClose = new JButton("Close"); // Button for closing
														// the window

	/*
	 * Listener of the Celsius field: convert the data from Clesius to
	 * Fahrenheit when the "enter" keyboard button is hit (in the Clesius field)
	 */
	private ActionListener textFieldCListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String value = textFieldC.getText();
			try {
				float valC = new Float(value);
				float valF = valC * 1.8f + 32;
				textFieldF.setText(Float.toString(valF));
			} catch (Exception exp) {
				textFieldF.setText("");
				textFieldC.setText("");
			}
		}
	};

	// appuie sur une touche
	private KeyListener textFieldCKListener = new KeyListener() {

		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			String value = textFieldC.getText();
			try {
				float valC = new Float(value);
				float valF = valC * 1.8f + 32;
				textFieldF.setText(Float.toString(valF));
			} catch (Exception exp) {
				textFieldF.setText("");
				textFieldC.setText("");
			}
		}

		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}
	};

	/*
	 * Listener of the Fahrenheit field: Convert the data from Fahrenheit to
	 * Celsius when the "enter" keyboard button is hit (in the Fahrenheit field)
	 */
	private ActionListener textFieldFListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String value = textFieldF.getText();
			try {
				float valF = new Float(value);
				float valC = (valF - 32) / 1.8f;
				textFieldC.setText(Float.toString(valC));
			} catch (Exception exp) {
				textFieldF.setText("");
				textFieldC.setText("");
			}
		}
	};

	private KeyListener textFieldFKListener = new KeyListener() {

		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			String value = textFieldF.getText();
			try {
				float valF = new Float(value);
				float valC = (valF - 32) / 1.8f;
				textFieldC.setText(Float.toString(valC));
			} catch (Exception exp) {
				textFieldF.setText("");
				textFieldC.setText("");
			}
		}

		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}
	};

	/*
	 * Listener of the Reset button: Reset the value in the text field when the
	 * Reset button is pressed
	 */
	private ActionListener buttonResetListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			textFieldF.setText("");
			textFieldC.setText("");
		}
	};

	/*
	 * Listener of the Close button: Close the program window when the Close
	 * button is pressed
	 */
	private ActionListener buttonCloseListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// Ferme la fenêtre
			dispose();
		}
	};

	/**
	 * Constructor of the temperature converter
	 * 
	 * @param title
	 *            title of the window
	 */
	public TempConverter(String title) {
		super(title);
		init();
	};

	/**
	 * Initialize the converter window
	 */
	public void init() {

		// pour créer deux boutons A et B
		/*
		 * Container panel = getContentPane();
		 * 
		 * JPanel panelA = new JPanel(); panel.add(panelA); panelA.add(new
		 * JLabel("A")); panelA.add(new JTextField(5));
		 * 
		 * JPanel panelB = new JPanel(); panel.add(panelB); panelB.add(new
		 * JLabel("B")); panelB.add(new JTextField(5));
		 */

		// boutton Clesius
		JPanel paneC = new JPanel();
		paneC.setLayout(new BoxLayout(paneC, BoxLayout.Y_AXIS));
		paneC.add(labelC);
		paneC.add(textFieldC);
		textFieldC.addActionListener(textFieldCListener);
		textFieldC.addKeyListener(textFieldCKListener);

		// boutton Fahrenheit
		JPanel paneF = new JPanel();
		paneF.setLayout(new BoxLayout(paneF, BoxLayout.Y_AXIS));
		paneF.add(labelF);
		paneF.add(textFieldF);
		textFieldF.addActionListener(textFieldFListener);
		textFieldF.addKeyListener(textFieldFKListener);

		// boutton regroupant les deux précedants
		JPanel tempPane = new JPanel();
		tempPane.add(paneC);
		tempPane.add(paneF);

		// deux boutons cancel et reset
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.X_AXIS));
		buttonPane.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

		buttonPane.add(Box.createHorizontalGlue());
		buttonPane.add(buttonReset);
		buttonReset.addActionListener(buttonResetListener);

		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPane.add(buttonClose);
		buttonClose.addActionListener(buttonCloseListener);

		Container mainPane = getContentPane();
		mainPane.setLayout(new BorderLayout());

		// l'ensemble au milieu
		mainPane.add(tempPane, BorderLayout.CENTER);

		// reset et cancel en bas
		mainPane.add(buttonPane, BorderLayout.SOUTH);

		// Resize window and make it visible
		pack();
		setVisible(true);
		// Close the application when the user closes the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	};

	public static void main(String[] args) {
		new TempConverter("Temperature converter");
	};

}
