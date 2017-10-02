package org.metasee.database.service;

import java.util.List;

import org.metasee.database.model.Article;

public interface ArticleManager {
	public void save(Article article) throws Exception;
	public Article getArticleByKeyword(String keyword) throws Exception;
	public boolean checkArticleWithKeyword(Article article) throws Exception;
	public void deleteById(int id) throws Exception;
	public void update(Article article) throws Exception;
	public Article getArticleById(int id) throws Exception;
	public List<Article> getArticles() throws Exception;
}
