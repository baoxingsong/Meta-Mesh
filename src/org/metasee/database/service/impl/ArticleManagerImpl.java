package org.metasee.database.service.impl;

import java.util.List;

import org.metasee.database.dao.impl.ArticleDaoImpl;
import org.metasee.database.dao.ArticleDao;
import org.metasee.database.model.Article;
import org.metasee.database.service.ArticleManager;

public class ArticleManagerImpl implements ArticleManager {
	ArticleDao articleDao = new ArticleDaoImpl();
	@Override
	public void save(Article article) throws Exception {
		articleDao.save(article);
	}

	@Override
	public Article getArticleByKeyword(String keyword) throws Exception {
		return articleDao.getArticleByKeyword(keyword);
	}

	@Override
	public boolean checkArticleWithKeyword(Article article) throws Exception {
		return articleDao.checkArticleWithKeyword(article);
	}

	@Override
	public void deleteById(int id) throws Exception {
		articleDao.deleteById(id);
	}

	@Override
	public void update(Article article) throws Exception {
		articleDao.update(article);
	}

	@Override
	public Article getArticleById(int id) throws Exception {
		return articleDao.getArticleById(id);
	}

	@Override
	public List<Article> getArticles() throws Exception {
		return articleDao.getArticles();
	}

}
