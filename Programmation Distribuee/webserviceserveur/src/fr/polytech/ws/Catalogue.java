package fr.polytech.ws;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;



public class Catalogue {
	public HashMap<Integer, Article> art;
	
	public Catalogue(){
		art = new HashMap<Integer, Article>();
	}
	
	public void addArt(Article a){
		art.put(a.getCle(), a);
		
	}
	
	public String catalogueV(){
		Set<Integer> cles = art.keySet();
		Iterator<Integer> it = cles.iterator();
		String s = new String();
		while (it.hasNext()){
		   Integer cle = it.next(); // tu peux typer plus finement ici
		   Article valeur = art.get(cle); // tu peux typer plus finement ici
		  s = s + valeur.toString() +"\n";
		}
		return s;
	}
	
	public String getArticle(int cle) throws ExceptionArticle{
		if(art.containsKey(cle))
			return art.get(cle).toString();
		else throw new ExceptionArticle("Article Inexistant");
		
	}
	
	public Article getArticleInst(int cle) throws ExceptionArticle{
		if(art.containsKey(cle))
			return art.get(cle);
		else throw new ExceptionArticle("Article Inexistant");
		
	}
	
	
}