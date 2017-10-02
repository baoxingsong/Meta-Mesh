package org.metasee.database.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.metasee.database.dao.ArticleClassficationDao;
import org.metasee.database.model.Article;
import org.metasee.database.model.ArticleClassfication;
import org.metasee.database.util.HibernateUtil;

public class ArticleClassficationDaoImpl implements ArticleClassficationDao {

	@Override
	public void save(ArticleClassfication articleClassfication) {
		articleClassfication.setSongChecked(1);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(articleClassfication);
		s.getTransaction().commit();
	}

	@Override
	public ArticleClassfication getArticleClassficationByName(String name) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<ArticleClassfication> articleClassfications=(List<ArticleClassfication>)s.createQuery("from ArticleClassfication articleClassfication where articleClassfication.className='" + name+"' and articleClassfication.songChecked=1").list();
		s.getTransaction().commit();
		
		if(articleClassfications.size()>0){
			ArticleClassfication articleClassfication=articleClassfications.get(0);
			return articleClassfication;
		}
		return null;
	}

	@Override
	public boolean checkArticleClassficationName(
			ArticleClassfication articleClassfication) {
		String name=articleClassfication.getClassName();
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		long count = (Long)s.createQuery("select count(*) from ArticleClassfication articleClassfication where articleClassfication.className = :name").setString("name", name).uniqueResult();
		s.getTransaction().commit();
		
		if(count > 0) return true;
		return false;
	}

	@Override
	public void deleteById(int id) {
		ArticleClassfication articleClassfication=this.getArticleClassficationById(id);
		if(null!=articleClassfication){
			articleClassfication.setSongChecked(0);
			
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.getCurrentSession();
			s.beginTransaction();
			s.update(articleClassfication);
			s.getTransaction().commit();
			
			for(Article article : articleClassfication.getArticles()){
				(new ArticleDaoImpl()).deleteById(id);
			}
		}
	}

	@Override
	public void update(ArticleClassfication articleClassfication) {
		articleClassfication.setSongChecked(1);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.update(articleClassfication);
		s.getTransaction().commit();
	}

	@Override
	public ArticleClassfication getArticleClassficationById(int id) {
		if( 0 == id){
			return null;
		}
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<ArticleClassfication> articleClassfications=(List<ArticleClassfication>)s.createQuery("from ArticleClassfication articleClassfication where articleClassfication.id="+id+" and articleClassfication.songChecked=1").list();
		s.getTransaction().commit();
		
		if(articleClassfications.size()>0){
			ArticleClassfication articleClassfication=articleClassfications.get(0);
			return articleClassfication;
		}
		return null;
	}

	@Override
	public List<ArticleClassfication> getArticleClassfications() {
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<ArticleClassfication> articleClassfications=(List<ArticleClassfication>)s.createQuery("from ArticleClassfication articleClassfication where articleClassfication.songChecked=1").list();
		s.getTransaction().commit();
		
		return articleClassfications;
	}
}
