package fr.polytech.ws;

public class CoupleArticleQte{
	private Article a;
	private int q;
	
	public CoupleArticleQte(Article a, int q){
		this.a=a;
		this.q=q;
	}
	
	public Article getArticle(){
		return a;
	}

	public void setArticle(Article a) {
		this.a = a;
	}

	public int getQte() {
		return q;
	}

	public void setQte(int q) {
		this.q = q;
	}


	
	
}
