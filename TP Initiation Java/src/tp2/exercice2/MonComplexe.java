package TP2.exercice2;

import complexe.Complexe;

public class MonComplexe extends Complexe {
	
	/**
	 * Partie entière et imaginaire
	 */
	private double x=super.getRe();
	private double y=super.getIm();
	
	/**
	 * @param monX
	 * @param monY
	 */
	public MonComplexe(double monX, double monY)
	{
		super(monX,monY);
	}
		
	public MonComplexe()
	{
		super(0,0);
	}
		
	@Override
	public String toString()
	{
		String maChaine="(";
		if(x!=0)
		{
			maChaine+=x;
		}
		if(y!=0)
		{
			if(y>0 && x!=0)maChaine+="+";
			maChaine+=y+"i";
		}
		return maChaine+=")";
	}
	
	/**
	 * 
	 * @param autreComplexe
	 * @return
	 */
	public MonComplexe addition(MonComplexe autreComplexe)
	{
		return new MonComplexe(this.x + autreComplexe.x, this.y + autreComplexe.y);
	}
	
	/**
	 * 
	 * @param autreComplexe
	 * @return
	 */
	public MonComplexe multiplication(MonComplexe autreComplexe)
	{
		/* pour la multiplication deux complexes z1 et z2
		 * respectivement a+ib et c+id 
		 * on obtient pour Z = z1 * z2 
		 * 				   Z = ac-bd + (ad+cb)i
		 */
		return new MonComplexe(this.x*autreComplexe.x-this.y*autreComplexe.y,
				this.x*autreComplexe.y+this.y*autreComplexe.x);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof MonComplexe)
		{
			MonComplexe monComplexe = (MonComplexe)obj;
			if(this.x == monComplexe.x && this.y == monComplexe.y) return true;
		}
		return false;
	}
	
	public static double module(MonComplexe monComplexe)
	{
		return Math.sqrt(Math.pow(monComplexe.x,2)+Math.pow(monComplexe.y, 2));
	}
	
	public static double argument(MonComplexe monComplexe)
	{
		return Math.acos(monComplexe.x/module(monComplexe));
	}
	
	public void setRe(double module, double argument){
		super.setRe(module*Math.cos(argument));
	}
	
	public void setIm(double module, double argument){
		super.setIm(module*Math.sin(argument));
		
	}
}
