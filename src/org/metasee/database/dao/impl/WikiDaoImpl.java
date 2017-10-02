package org.metasee.database.dao.impl;

import java.util.List;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.metasee.database.commonUtil.Page;
import org.metasee.database.dao.WikiDao;
import org.metasee.database.model.Wiki;
import org.metasee.database.util.HibernateUtil;

public class WikiDaoImpl implements WikiDao {
	
	public boolean checkWikiWithKeyword(Wiki wiki){
		String keyWord=wiki.getKeyWord();
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		long count = (Long)s.createQuery("select count(*) from Wiki wk where wk.keyWord = :keyWord").setString("keyWord", keyWord).uniqueResult();
		s.getTransaction().commit();
		
		if(count > 0) return true;
		return false;
	}
	
	public void save(Wiki wiki) {
		wiki.setCreateTime(new Date());
		wiki.setSongChecked(1);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(wiki);
		s.getTransaction().commit();
	}
	@Override
	public Wiki getWikiByKeyword(String word) {
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<Wiki> wikis=(List<Wiki>)s.createQuery("from Wiki wiki where wiki.keyWord='" + word+"' and wiki.songChecked=1").list();
		s.getTransaction().commit();
		
		if(wikis.size()>0){
			Wiki wiki=wikis.get(0);
			return wiki;
		}
		return null;
	}
	@Override
	public Wiki getWikiById(int id) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<Wiki> wikis=(List<Wiki>)s.createQuery("from Wiki wiki where wiki.id="+id+" and wiki.songChecked=1").list();
		s.getTransaction().commit();
		
		if(wikis.size()>0){
			Wiki wiki=wikis.get(0);
			return wiki;
		}
		return null;
	}

	@Override
	public Page getWikis(int page, int recordPerPage) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<Wiki> wikis=(List<Wiki>)s.createQuery("from Wiki wiki where wiki.songChecked=1 order by wiki.id desc").list();
		s.getTransaction().commit();
		
		int totalCount = wikis.size();
		
		if(wikis.size()-1-(page-1)*recordPerPage > recordPerPage){
			return new Page(totalCount, wikis.subList((page-1)*recordPerPage, (page-1)*recordPerPage+recordPerPage));
		}else{
			return new Page(totalCount, wikis.subList((page-1)*recordPerPage, wikis.size()));
		}
	}
	@Override
	public void deleteById(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<Wiki> wikis=(List<Wiki>)s.createQuery("from Wiki wiki where wiki.id=" + id+"and wiki.songChecked=1").list();
		s.getTransaction().commit();
		
		Wiki wiki=wikis.get(0);
		wiki.setSongChecked(0);
		
		sf = HibernateUtil.getSessionFactory();
		s = sf.getCurrentSession();
		s.beginTransaction();
		s.update(wiki);
		s.getTransaction().commit();
	}
	
	@Override
	public void update(Wiki wiki) {
		wiki.setCreateTime(new Date());
		wiki.setSongChecked(1);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.update(wiki);
		s.getTransaction().commit();
	}
}
