package org.metasee.database.service.impl;

import java.util.List;

import org.metasee.database.model.ArticleClassfication;
import org.metasee.database.dao.ArticleClassficationDao;
import org.metasee.database.dao.impl.ArticleClassficationDaoImpl;

public class ArticleClassificationManagerImpl implements
		org.metasee.database.service.ArticleClassificationManager {
	ArticleClassficationDao articleClassficationDao = new ArticleClassficationDaoImpl();

	@Override
	public void save(ArticleClassfication articleClassfication)
			throws Exception {
		articleClassficationDao.save(articleClassfication);
	}

	@Override
	public ArticleClassfication getArticleClassficationByName(String name)
			throws Exception {
		return articleClassficationDao.getArticleClassficationByName(name);
	}

	@Override
	public boolean checkArticleClassficationName(
			ArticleClassfication articleClassfication) throws Exception {
		return articleClassficationDao.checkArticleClassficationName(articleClassfication);
	}

	@Override
	public void deleteById(int id) throws Exception {
		articleClassficationDao.deleteById(id);
	}

	@Override
	public void update(ArticleClassfication articleClassfication)
			throws Exception {
		articleClassficationDao.update(articleClassfication);
	}

	@Override
	public ArticleClassfication getArticleClassficationById(int id)
			throws Exception {
		return articleClassficationDao.getArticleClassficationById(id);
	}

	@Override
	public List<ArticleClassfication> getArticleClassfications()
			throws Exception {
		return articleClassficationDao.getArticleClassfications();
	}

}
