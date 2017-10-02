package org.metasee.database.dao;

import java.util.List;

import org.metasee.database.model.ArticleClassfication;

public interface ArticleClassficationDao {
	public void save(ArticleClassfication articleClassfication);
	public ArticleClassfication getArticleClassficationByName(String name);
	public boolean checkArticleClassficationName(ArticleClassfication articleClassfication);
	public void deleteById(int id);
	public void update(ArticleClassfication articleClassfication);
	public ArticleClassfication getArticleClassficationById(int id);
	public List<ArticleClassfication> getArticleClassfications();
}
