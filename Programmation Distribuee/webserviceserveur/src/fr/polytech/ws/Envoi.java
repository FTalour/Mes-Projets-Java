package fr.polytech.ws;

import java.util.Date;
import java.util.HashMap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Envoi {
	private Catalogue catalogue;
	private HashMap<Integer, Panier> panier;
	private int numPanier = 0;
	
	public Envoi(){
		catalogue = new Catalogue();
		panier = new HashMap<Integer, Panier>();
	}
	
	@WebMethod
	public String viewCatalogue(int numCli){
		System.out.println("viewCatalogue : client "+numCli+" / "+new Date());
		return catalogue.catalogueV();
	}
	
	@WebMethod
	public void ajouterPanier(int numCli, int numArticle) throws ExceptionArticle{
		System.out.println("ajouterPanier : client "+numCli+" / "+new Date());
		panier.get(numCli).ajouter(catalogue.getArticleInst(numArticle));
	}
	
	@WebMethod
	public void retirerPanier(int numCli, int numArticle) throws ExceptionArticle{
		System.out.println("retirerPanier : client "+numCli+" / "+new Date());
		panier.get(numCli).retirer(catalogue.getArticleInst(numArticle));
	}
	
	@WebMethod
	public void modifierPanier(int numCli, int numArticle, int q) throws ExceptionArticle{
		System.out.println("modifierPanier : client "+numCli+" / "+new Date());
		panier.get(numCli).modifier(catalogue.getArticleInst(numArticle), q);
	}
	
	@WebMethod
	public int getNewPanier(){
		System.out.println("newPanier pour le client "+numPanier+" / "+new Date());
		panier.put(numPanier, new Panier());
		numPanier++;
		return numPanier-1;
	}
	
	@WebMethod
	public String afficherCommande(int numCli){
		return panier.get(numCli).afficherCommande();
	}
	
	
	
	public Catalogue getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}
}
