package org.metasee.database.service;

import java.util.List;

import org.metasee.database.model.ArticleClassfication;

public interface ArticleClassificationManager {
	public void save(ArticleClassfication articleClassfication) throws Exception;
	public ArticleClassfication getArticleClassficationByName(String name) throws Exception;
	public boolean checkArticleClassficationName(ArticleClassfication articleClassfication) throws Exception;
	public void deleteById(int id) throws Exception;
	public void update(ArticleClassfication articleClassfication) throws Exception;
	public ArticleClassfication getArticleClassficationById(int id) throws Exception;
	public List<ArticleClassfication> getArticleClassfications() throws Exception;
}
