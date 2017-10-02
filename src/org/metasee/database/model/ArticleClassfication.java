package org.metasee.database.model;

import java.util.HashSet;

public class ArticleClassfication {
	private int id;
	private HashSet<Article> articles;
	private String className;
	private int songChecked;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public HashSet<Article> getArticles() {
		return articles;
	}
	public void setArticles(HashSet<Article> articles) {
		this.articles = articles;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getSongChecked() {
		return songChecked;
	}
	public void setSongChecked(int songChecked) {
		this.songChecked = songChecked;
	}
	
}
