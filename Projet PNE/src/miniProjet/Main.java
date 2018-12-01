package miniProjet;

import java.awt.Point;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		///////////////////////////////
		//TODO change the value here
		/* ordonnées de points */
		double Txx = 1.00889;
		double Tyx = -0.00889188;
		
		/* abscisses de points */
		double Txy = 0.00407545;
		double Tyy = 0.995925;
		
		/* tx et ty représentent le décalage entre les deux images*/
		double  tx = -1.94715;
		double  ty = 0.947154;
		//TODO change the value here
		///////////////////////////////
		
		String pathToImagePrev = "prev.jpg";
		String pathToImageNext = "next.jpg"; 
		String pathToPrevPoints = "prev.txt";
		String pathToNextPoints = "next.txt";
		buildSVG(pathToImagePrev,pathToImageNext,loadPoints(pathToPrevPoints),loadPoints(pathToNextPoints),Txx,Txy,Tyx,Tyy,tx,ty);
	}
	
	public static void buildSVG(String pathToImagePrev,String pathToImageNext,Point[] prevPoints,Point[] nextPoints, double Txx,double Txy, double Tyx, double Tyy, double tx, double ty)
	{	
		/* Calcul de l'estimation des points */
		/* L'estimation ne dépend pas des points suivants (next.txt) */
		/* prevPoints[] contient les points de prev.txt et nextPoints[] contient les points de next.txt */
		Point[] estimedPoints = new Point[prevPoints.length];
		for(int i=0;i<prevPoints.length;i++){
			estimedPoints[i] = new Point();
			estimedPoints[i].x  = (int)(tx + Txx*prevPoints[i].x + Txy*prevPoints[i].y);
			estimedPoints[i].y = (int)(ty + Tyx*prevPoints[i].x + Tyy*prevPoints[i].y);
		}
		
		try
		{
			/* Les images avec les points sont stockés dans un fichier normalisé w3 appelé output.svg*/
			FileWriter stylot = new FileWriter("output.svg");
			stylot.write("<?xml version=\"1.0\" standalone=\"no\"?>\n");
			stylot.write("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n");
			stylot.write("<svg height=\"476px\" width=\"1404px\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink= \"http://www.w3.org/1999/xlink\">\n");
			stylot.write("\t<image xlink:href=\"" + pathToImagePrev + "\" x=\"0px\" height=\"476px\" width=\"702px\"/>\n");
			stylot.write("\t<image xlink:href=\"" + pathToImageNext + "\" x=\"702px\" height=\"476px\" width=\"702px\"/>\n");
			
			/* Les points bleu sont données dans prev.txt et next.txt */
			/* Les points jaune sont les points bleu de prev.txt sur la deuxième image */
			/* Les points vert sont les points estimés à partir de prev.txt */
			for(int i=0;i<prevPoints.length;i++){
				stylot.write("\t<circle cx=\"" + new Integer(prevPoints[i].x).toString() + "\" cy=\"" + new Integer(prevPoints[i].y).toString() + "\" r=\"3\" fill=\"blue\"/>\n");
				stylot.write("\t<circle cx=\"" + new Integer(nextPoints[i].x+702).toString() + "\" cy=\"" + new Integer(nextPoints[i].y).toString() + "\" r=\"3\" fill=\"blue\"/>\n");
				stylot.write("\t<circle cx=\"" + new Integer(prevPoints[i].x+702).toString() + "\" cy=\"" + new Integer(prevPoints[i].y).toString() + "\" r=\"3\" fill=\"yellow\"/>\n");
				stylot.write("\t<circle cx=\"" + new Integer(estimedPoints[i].x+702).toString() + "\" cy=\"" + new Integer(estimedPoints[i].y).toString() + "\" r=\"3\" fill=\"green\"/>\n");
			}
			stylot.write("</svg>\n");
			stylot.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Place les points contenues dans le fichier spécifié par path dans un tableau de Point.
	 * 
	 * Le premier nombre dans le fichier représente le nombre de points dans le fichier.
	 * 
	 * @param path
	 * @return Point[]
	 */
	public static Point[] loadPoints(String path)
	{
		try
		{
			Scanner scan = new Scanner(new File(path));
			int size = scan.nextInt();
			Point[] out = new Point[size];
			
			for(int i=0;i<size;i++)
			{
				out[i] = new Point();
				out[i].x = scan.nextInt();
				out[i].y = scan.nextInt();
			}
			scan.close();
			return out;
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			return new Point[0];
		}
	}
}
