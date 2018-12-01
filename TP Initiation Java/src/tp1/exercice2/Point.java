package TP1.exercice2;

public class Point {
	
	/**
	 * Coordonnées du point
	 */
	public double x,y;
	
	/**
	 * Simple constructeur
	 * 
	 * @param x
	 * @param y
	 */
	public Point(double x, double y){
		this.x=x;
		this.y=y;
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double distance(Point a, Point b)
	{
		double xdiff=a.x-b.x;
		double ydiff=a.y-b.y;
		return Math.sqrt(xdiff * xdiff + ydiff * ydiff);
	}
	
	public double distance(Point autre)
	{
		return Point.distance(this, autre);
	}
	
	/**
	 * 
	 * @param borneInf
	 * @param borneSup
	 * @return
	 */
	public static double valeurAleatoire(double borneInf, double borneSup)
	{
		double r = Math.random();
		return (borneInf + r*(borneSup-borneInf));
	}
	
	@Override
	public String toString()
	{
		return "(x = " + x + " | y = " + y + ")";
	}
	
	@Override
	public boolean equals(Object obj)
	{
		double precision = 1e-5;	// 1e-5 règle la précision de l'"égalité"
		if(obj instanceof Point)
		{
			Point autrePoint = (Point)obj;
			if(autrePoint.x == this.x && autrePoint.y == this.y) return true;
			else if (autrePoint.distance(this) <  precision)
			{  
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) 
	{
		Point p1 = new Point(Point.valeurAleatoire(0.0,2.0),Point.valeurAleatoire(-1.0,0.0));
		System.out.println("p1 : "+p1);
		
		Point p2 = new Point(Point.valeurAleatoire(-1.0,1.0),Point.valeurAleatoire(-2.0,1.0));
		System.out.println("p2 : "+p2);
		
		System.out.println("distance(p1, p2) = "+ Point.distance(p1, p2));
		
		Point p3 = new Point(1,2);
		System.out.println("p3 : "+p3);
		
		Point p4 = new Point(1,2);
		System.out.println("p4 : "+p4);
		
		System.out.println(p3.equals(p4));
	}
}
