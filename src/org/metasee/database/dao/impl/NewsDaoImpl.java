package org.metasee.database.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.sun.xml.internal.ws.api.addressing.WSEndpointReference.Metadata;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.metasee.database.commonUtil.Page;
import org.metasee.database.dao.NewsDao;
import org.metasee.database.model.News;
import org.metasee.database.util.HibernateUtil;

public class NewsDaoImpl implements NewsDao {

	@Override
	public void save(News news) {
		news.setCreateTime(new Date());
		news.setSongChecked(1);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(news);
		s.getTransaction().commit();
	}

	@Override
	public Page getNewss(int page, int recordPerPage) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<News> metadatas=(List<News>)s.createQuery("from News news where news.songChecked=1 order by news.id desc").list();
		s.getTransaction().commit();
		
		int totlaCount = metadatas.size();
		
		if(metadatas.size()-1-(page-1)*recordPerPage > recordPerPage){
			return new Page(totlaCount, metadatas.subList((page-1)*recordPerPage, (page-1)*recordPerPage+recordPerPage));
		}else{
			return new Page(totlaCount, metadatas.subList((page-1)*recordPerPage, metadatas.size()));
		}
	}

	@Override
	public News getNewById(int id) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<News> newss=(List<News>)s.createQuery("from News news where news.id=" + id+" and news.songChecked=1").list();
		s.getTransaction().commit();
		
		News news=newss.get(0);
		return news;
	}

	@Override
	public boolean checkNewsWithTitle(News news) {
		String title=news.getTitle();
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		long count = (Long)s.createQuery("select count(*) from News nw where nw.title = :title").setString("title", title).uniqueResult();
		s.getTransaction().commit();
		
		if(count > 0) return true;
		return false;
	}

	@Override
	public void deleteById(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<News> newss=(List<News>)s.createQuery("from News news where news.id=" + id+"and news.songChecked=1").list();
		s.getTransaction().commit();
		
		News news=newss.get(0);
		news.setSongChecked(0);
		
		sf = HibernateUtil.getSessionFactory();
		s = sf.getCurrentSession();
		s.beginTransaction();
		s.update(news);
		s.getTransaction().commit();
	}
	
	@Override
	public void update(News news) {
		news.setCreateTime(new Date());
		news.setSongChecked(1);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.update(news);
		s.getTransaction().commit();
	}
}
