package com.Recherche.client;


public class Moteur {
		private String nom;
		private String webSearch;
		private String imgSearch;
		private String newsSearch;
		
		public Moteur() {}
		
		public Moteur(String nom, String webSearch, String imgSearch, String newsSearch) {
			setNom(nom);
			setWebSearch(webSearch);
			setImgSearch(imgSearch);
			setNewsSearch(newsSearch);
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getWebSearch() {
			return webSearch;
		}

		public void setWebSearch(String webSearch) {
			this.webSearch = webSearch;
		}

		public String getImgSearch() {
			return imgSearch;
		}

		public void setImgSearch(String imgSearch) {
			this.imgSearch = imgSearch;
		}

		public String getNewsSearch() {
			return newsSearch;
		}

		public void setNewsSearch(String newsSearch) {
			this.newsSearch = newsSearch;
		}
		
}
