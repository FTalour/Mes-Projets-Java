/**
 * 
 */
/**
 * @author ftalou1
 *
 */
package TP3.exercice2;

import TP3.exercice3.PorteLogique;

public class NAND extends PorteLogique{
	
	public NAND(Boolean entrer1, Boolean entrer2) {
		// TODO Auto-generated constructor stub
		super(entrer1,entrer2);
	}
	
	public boolean sortie(){
		if(getE1()==true && getE2()==true)
			return false;
		else return true;
	}

}