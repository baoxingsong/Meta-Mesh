package org.metasee.database.dao.impl;

import java.util.Date;
import java.util.List;

import com.sun.xml.internal.ws.api.addressing.WSEndpointReference.Metadata;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.metasee.database.commonUtil.Page;
import org.metasee.database.dao.DocumentDao;
import org.metasee.database.model.Document;
import org.metasee.database.model.News;
import org.metasee.database.util.HibernateUtil;

public class DocumentDaoImpl implements DocumentDao {

	@Override
	public void save(Document document) {
		document.setCreateTime(new Date());
		document.setSongChecked(1);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(document);
		s.getTransaction().commit();
	}

	@Override
	public Page getDocuments(int page, int recordPerPage) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<Document> metadatas=(List<Document>)s.createQuery("from Document document where document.songChecked=1 order by document.id desc").list();
		s.getTransaction().commit();
		
		int totlaCount=metadatas.size();
		if(metadatas.size()-1-(page-1)*recordPerPage > recordPerPage){
			return new Page(totlaCount, metadatas.subList((page-1)*recordPerPage, (page-1)*recordPerPage+recordPerPage));
		}else{
			return new Page(totlaCount, metadatas.subList((page-1)*recordPerPage, metadatas.size()));
		}
	}

	@Override
	public Document getDocumentById(int id) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<Document> metadatas=(List<Document>)s.createQuery("from Document document where document.id=" + id+" and document.songChecked=1").list();
		s.getTransaction().commit();
		
		Document metaData=metadatas.get(0);
		return metaData;
	}

	@Override
	public boolean checkDocumentWithTitle(Document document) {
		String title=document.getTitle();
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		long count = (Long)s.createQuery("select count(*) from Document dt where dt.title = :title").setString("title", title).uniqueResult();
		s.getTransaction().commit();
		
		if(count > 0) return true;
		return false;
	}
	@Override
	public void deleteById(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<Document> documents=(List<Document>)s.createQuery("from Document document where document.id=" + id+"and document.songChecked=1").list();
		s.getTransaction().commit();
		
		Document document=documents.get(0);
		
		document.setSongChecked(0);
		
		sf = HibernateUtil.getSessionFactory();
		s = sf.getCurrentSession();
		s.beginTransaction();
		s.update(document);
		s.getTransaction().commit();
	}
	
	@Override
	public void update(Document document) {
		document.setCreateTime(new Date());
		document.setSongChecked(1);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.update(document);
		s.getTransaction().commit();
	}
}
