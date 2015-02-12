package com.Recherche.client;

public class Moteur {
	private String nom;
	private String webSearch;
	private String imageSearch;
	private String newsSearch;
	private String imageSearchSuffixe;
	private String newsSearchSuffixe;
	
	
/* Constructeurs */
	public Moteur (){}
	
	public Moteur(String pNom, String pWebSearch, String pImageSearch, String pNewsSearch, String pImageSearchSuffixe, String pNewsSearchSuffixe) {
		this.nom = pNom;
		this.webSearch = pWebSearch;
		this.imageSearch = pImageSearch;
		this.newsSearch = pNewsSearch;
		this.imageSearchSuffixe = pImageSearchSuffixe;
		this.newsSearchSuffixe = pNewsSearchSuffixe;
	}

	/* Getters and setters */
	public String getNom() {
		return nom;
	}
	public void setNom(String pNom) {
		this.nom = pNom;
	}
	public String getWebSearch() {
		return webSearch;
	}
	public void setWebSearch(String pWebSearch) {
		this.webSearch = pWebSearch;
	}
	public String getImageSearch() {
		return imageSearch;
	}
	public void setImageSearch(String pImageSearch) {
		this.imageSearch = pImageSearch;
	}
	public String getNewsSearch() {
		return newsSearch;
	}
	public void setNewsSearch(String pNewsSearch) {
		this.newsSearch = pNewsSearch;
	}
	
/* Methodes */
	public String constructRqtWeb(String pRequete){
		return webSearch+pRequete;
	}
	
	public String constructRqtImages(String pRequete){
		return imageSearch+pRequete+imageSearchSuffixe;
	}
	
	public String constructRqtNews(String pRequete){
		return newsSearch+pRequete+newsSearchSuffixe;
	}
}
