/**
 * 
 */
/**
 * @author ftalou1
 *
 */
package tp3.exercice3;

import tp3.exercice2.NOR;

public class BasculeRS{
	NOR porteRNonQ;
	NOR porteQS;
	
	Boolean q;
	
	public boolean getS(){
		return porteQS.getE2();
	}
	
	public boolean getR(){
		return porteRNonQ.getE1();
	}
	
	public boolean getQ(){
		return q;
	}
	
	public boolean getNonQ(){
		if(q==false)
			return true;
		else return false;
	}
	
	public void setS(boolean s){
		porteQS.setE1(getQ());
		porteQS.setE2(s);
		porteRNonQ.setE2(porteQS.sortie());
		q=porteQS.sortie();
		
	}
	
	public void setR(){
		porteRNonQ.setE1(false);
		porteRNonQ.setE2(getNonQ());
		porteQS.setE1(getQ());
		porteQS.setE2(false);
		
	}
	
	public void calculerQ(){
		if(porteRNonQ.getE1()==true && porteQS.getE2()==true);
		else {
			q=porteRNonQ.sortie();
			porteQS.sortie();
		}
		
		if(porteRNonQ.getE1()==true && porteQS.getE2()==true);
	}
	
	public static void main(String[] args){
		@SuppressWarnings("unused")
		BasculeRS ma_bascule= new BasculeRS();
		//tester set s et faire set R
	}
}