package fr.polytech.ws;

import java.util.ArrayList;

public class Panier {
	private ArrayList<CoupleArticleQte> articles;
	
	public Panier(){
		articles = new ArrayList<CoupleArticleQte>();
	}
	
	public void ajouter(Article a) throws ExceptionArticle{
		CoupleArticleQte art = null;
		for(CoupleArticleQte c : articles){
			if(c.getArticle().equals(a))
				art=c;
		}
		if(art!=null){
			art.setQte(art.getQte()+1);
		}
		else{
			articles.add(new CoupleArticleQte(a,1));
		}
	}
	
	public void modifier(Article a, int qte) throws ExceptionArticle{
		CoupleArticleQte art = null;
		for(CoupleArticleQte c : articles){
			if(c.getArticle().equals(a))
				art=c;
		}
		if(art!=null){
			art.setQte(qte);
		}
		else{
			articles.add(new CoupleArticleQte(a,1));
		}
	}
	
	public void retirer(Article a) throws ExceptionArticle{
		CoupleArticleQte art = null;
		for(CoupleArticleQte c : articles){
			if(c.getArticle().equals(a))
				art=c;
		}
		if(art!=null){
			if(art.getQte()<=0)
				articles.remove(art);
		}
		else{
			throw new ExceptionArticle("Impossible de retirer un article qui n'est pas dans le panier !");
		}
	}
	
	public String afficherCommande(){
		double prixTotal=0;
		String strCommande = new String();
		for(CoupleArticleQte c : articles){
			prixTotal += c.getArticle().getPrix()*c.getQte();
			strCommande += c.getQte() + " * " + c.getArticle().getDesc() + "\n";
		}
		strCommande += "-------------------\nPrix total : "+prixTotal + "\n";
		return strCommande;
	}
}
