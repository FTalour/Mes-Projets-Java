package TP1.exercice3;

import java.lang.Math;

public class Complexe
{
	/**
	 * Partie entière et imaginaire 
	 */
	private double x,y;
	
	/**
	 * 
	 * @param monX
	 * @param monY
	 */
	public Complexe(double monX, double monY)
	{
		x=monX;
		y=monY;
	}
	
	public Complexe()
	{
		x=y=0;
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
	public Complexe addition(Complexe autreComplexe)
	{
		return new Complexe(this.x + autreComplexe.x, this.y + autreComplexe.y);
	}
	
	/**
	 * 
	 * @param autreComplexe
	 * @return
	 */
	public Complexe multiplication(Complexe autreComplexe)
	{
		/* pour la multiplication deux complexes z1 et z2
		 * respectivement a+ib et c+id 
		 * on obtient pour Z = z1 * z2 
		 * 				   Z = ac-bd + (ad+cb)i
		 */
		return new Complexe(this.x*autreComplexe.x-this.y*autreComplexe.y,
				this.x*autreComplexe.y+this.y*autreComplexe.x);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof Complexe)
		{
			Complexe monComplexe = (Complexe)obj;
			if(this.x == monComplexe.x && this.y == monComplexe.y) return true;
		}
		return false;
	}
	
	public static double module(Complexe monComplexe)
	{
		return Math.sqrt(Math.pow(monComplexe.x,2)+Math.pow(monComplexe.y, 2));
	}
	
	public static double argument(Complexe monComplexe)
	{
		return Math.acos(monComplexe.x/module(monComplexe));
	}
	
}
