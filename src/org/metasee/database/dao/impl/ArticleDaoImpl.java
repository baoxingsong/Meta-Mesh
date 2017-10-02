package org.metasee.database.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.metasee.database.dao.ArticleDao;
import org.metasee.database.model.Article;
import org.metasee.database.util.HibernateUtil;

public class ArticleDaoImpl implements ArticleDao {

	@Override
	public void save(Article article) {
		article.setSongChecked(1);
		article.setCreateTime(new Date());
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(article);
		s.getTransaction().commit();
	}

	@Override
	public Article getArticleByKeyword(String keyword) {
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<Article> articles=(List<Article>)s.createQuery("from Article article where article.keyWord='" + keyword+"' and article.songChecked=1").list();
		s.getTransaction().commit();
		
		if(articles.size()>0){
			Article article=articles.get(0);
			return article;
		}
		return null;		
	}

	@Override
	public boolean checkArticleWithKeyword(Article article) {
		String keyWord=article.getKeyWord();
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		long count = (Long)s.createQuery("select count(*) from Article article where article.keyWord = :keyWord").setString("keyWord", keyWord).uniqueResult();
		s.getTransaction().commit();
		
		if(count > 0) return true;
		return false;
	}

	@Override
	public void deleteById(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<Article> articles=(List<Article>)s.createQuery("from Article article where article.id=" + id+"and article.songChecked=1").list();
		s.getTransaction().commit();
		
		Article article=articles.get(0);
		article.setSongChecked(0);
		
		sf = HibernateUtil.getSessionFactory();
		s = sf.getCurrentSession();
		s.beginTransaction();
		s.update(article);
		s.getTransaction().commit();
	}

	@Override
	public void update(Article article) {
		article.setCreateTime(new Date());
		article.setSongChecked(1);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.update(article);
		s.getTransaction().commit();
	}

	@Override
	public Article getArticleById(int id) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<Article> articles=(List<Article>)s.createQuery("from Article article where Article.id="+id+" and Article.songChecked=1").list();
		s.getTransaction().commit();
		
		if(articles.size()>0){
			Article article=articles.get(0);
			return article;
		}
		return null;
	}

	@Override
	public List<Article> getArticles() {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<Article> articles=(List<Article>)s.createQuery("from Article article where Article.songChecked=1").list();
		s.getTransaction().commit();
		
		return articles;
	}
}
