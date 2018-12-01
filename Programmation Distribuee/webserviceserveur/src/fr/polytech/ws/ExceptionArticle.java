package fr.polytech.ws;

public class ExceptionArticle extends Exception{
	public ExceptionArticle(String s){
		super("ArticleException : "+s);
	}
}
