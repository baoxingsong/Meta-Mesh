package org.metasee.database.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;

import com.opensymphony.xwork2.ActionContext;
import com.sun.xml.internal.ws.api.addressing.WSEndpointReference.Metadata;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.metasee.database.commonUtil.Page;
import org.metasee.database.dao.MetaDataSampleDao;
import org.metasee.database.model.MetaDataSample;
import org.metasee.database.model.News;
import org.metasee.database.util.HibernateUtil;

public class MetaDataSampleDaoImpl implements MetaDataSampleDao {
	@Override
	public MetaDataSample getMetaDataSampleById(int id) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<MetaDataSample> metadataSamples=(List<MetaDataSample>)s.createQuery("from MetaDataSample metaDataSample where metaDataSample.id=" + id+" and metaDataSample.songChecked=1").list();
		s.getTransaction().commit();
		
		MetaDataSample metaDataSample=null;
		if(metadataSamples.size()>0){
			metaDataSample=metadataSamples.get(0);
		}
		return metaDataSample;
	}

	@Override
	public MetaDataSample getMetaDataSampleByAcc(String database_source,
			String metagenome) {
		SessionFactory sf=new HibernateUtil().getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<MetaDataSample> metadataSamples=(List<MetaDataSample>)s.createQuery("from MetaDataSample metaDataSample where metaDataSample.database_source='" + database_source + "' and metaDataSample.metagenome='" + metagenome + "' and metaDataSample.songChecked=1").list();
		s.getTransaction().commit();
		
		MetaDataSample metaDataSample=null;
		if(metadataSamples.size()>0){
			metaDataSample=metadataSamples.get(0);
		}
		return metaDataSample;
	}
	@Override
	public void deleteById(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<MetaDataSample> metaDataSamples=(List<MetaDataSample>)s.createQuery("from MetaDataSample metaDataSample where metaDataSample.id=" + id+"and metaDataSample.songChecked=1").list();
		s.getTransaction().commit();
		
		MetaDataSample metaDataSample=metaDataSamples.get(0);
		metaDataSample.setSongChecked(0);
		
		sf = HibernateUtil.getSessionFactory();
		s = sf.getCurrentSession();
		s.beginTransaction();
		s.update(metaDataSample);
		s.getTransaction().commit();
	}
	
	@Override
	public void update(MetaDataSample metaDataSample) {
		metaDataSample.setSongChecked(1);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.update(metaDataSample);
		s.getTransaction().commit();
	}
}
