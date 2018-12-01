package Calculatrice;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class CalculAction extends AbstractAction{
	private CalculatriceFenetre fenetre;
	
	public CalculAction(CalculatriceFenetre fenetre, String texte) {
		// TODO Auto-generated constructor stub
		super(texte);
		
		this.fenetre = fenetre;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String nombre1String = fenetre.getTextField1().getText();//On récupère la valeur dans le premier champ
		double nombre1 = Double.parseDouble(nombre1String);//On convertit cette valeur en un nombre
 
		String nombre2String = fenetre.getTextField2().getText();//On récupère la valeur dans le deuxième champ
		double nombre2 = Double.parseDouble(nombre2String);//On convertit cette valeur en un nombre
 
		String operateur = fenetre.getModelOperateurs().getSelectedOperateur();
		
		double resultat = 0;
		
		if(operateur.equals("+")){
			resultat = nombre1 + nombre2;
		}else if(operateur.equals("-")){
			resultat = nombre1 - nombre2;
		}else if(operateur.equals("*")){
			resultat = nombre1 * nombre2;
		}else if(operateur.equals("/")){
			resultat = nombre1 / nombre2;
		}
		
		fenetre.getLabel().setText("Resultat =" + resultat);
	}

}
