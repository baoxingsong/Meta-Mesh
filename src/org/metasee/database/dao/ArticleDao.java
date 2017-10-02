package org.metasee.database.dao;

import java.util.List;

import org.metasee.database.model.Article;


public interface ArticleDao {
	public void save(Article article);
	public Article getArticleByKeyword(String keyword);
	public boolean checkArticleWithKeyword(Article article);
	public void deleteById(int id);
	public void update(Article article);
	public Article getArticleById(int id);
	public List<Article> getArticles();
}
