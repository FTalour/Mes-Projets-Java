package tp1.exercice3;

import java.lang.String;

public class TestComplexe {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		Complexe c1 = new Complexe(1.0,-2.0);
		Complexe c2 = new Complexe(0.0,3.0);
		Complexe c3 = new Complexe(3.0,0.0);
		
		String s1 ="(1.0-2.0i)";
		String s2 ="(3.0i)";
		String s3 ="(3.0)";
			
		System.out.println(c1);
		System.out.println(s1.equals(c1.toString()));
		System.out.println(c2);
		System.out.println(s2.equals(c2.toString()));
		System.out.println(c3);
		System.out.println(s3.equals(c3.toString()));
	}
	
}
