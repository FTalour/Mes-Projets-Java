package Calculatrice;

import java.awt.Color;
import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;



import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CalculatriceFenetre extends JFrame /*implements ActionListener*/{
	private JButton bouton;
	private JLabel label;
	private JTextField textField1;
	private JTextField textField2;
	private JComboBox<String> liste;
	
	public CalculatriceFenetre(){
		super();
		
		build(); //On initialise notre fenêtre
	}
	
	private void build(){
		setTitle("Calculatrice"); //On donne un titre à l'application
		setSize(400,200); //On donne une taille à notre fenêtre
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(false); //On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
		setContentPane(buildContentPane());
	}
	
	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.white);

		textField1 = new JTextField();
		textField1.setColumns(10);
		panel.add(textField1);
		
		liste = new JComboBox<String>(new OperateursModel());
		panel.add(liste);
		
		textField2 = new JTextField();
		textField2.setColumns(10);
		panel.add(textField2);
		
		bouton = new JButton(new CalculAction(this,"Calculer"));
		panel.add(bouton);
		
		label = new JLabel("Résultat : Pas encore calculé");
		panel.add(label);
						
		return panel;
	}
	
	public JLabel getLabel(){
		return label;
	}
	
	public JTextField getTextField1(){
		return textField1;
	}
	
	public JTextField getTextField2(){
		return textField2;
	}

	public OperateursModel getModelOperateurs(){
		return (OperateursModel) liste.getModel();
	}
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		Object source = e.getSource();
//		
//		if(source == bouton){
//			System.out.println("Vous avez cliqué sur Calculer.");
//		}
//	}
}
