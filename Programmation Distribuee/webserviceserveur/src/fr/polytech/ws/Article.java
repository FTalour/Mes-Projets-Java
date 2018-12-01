package fr.polytech.ws;

import java.util.Date;

public class Article {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6105297144942112921L;
	private int cle;
	private String desc;
	private double prix;
	private Date dateDisp;
	
	
	public Article(int n, String d, double p, Date da){
		cle = n;
		desc = d;
		prix = p;
		dateDisp = da;

	}
	
	public String toString(){
		return "Article n° "+ getCle() + "\t"+ getDesc() +"\n Son prix est : " + getPrix() + " " + getDateDisp(); 
		
	}

	
	public int getCle() {
		return cle;
	}
	public void setCle(int cle) {
		this.cle = cle;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getDateDisp() {
		if (dateDisp == null)
			return "Dispo";
		else{
			return "L'article sera disponible le : "+dateDisp.toString();
		}
	}
	public void setDateDisp(Date dateDisp) {
		this.dateDisp = dateDisp;
	}
		
	

}
