package org.metasee.database.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Date;
import java.util.Set;

import com.sun.xml.internal.ws.api.addressing.WSEndpointReference.Metadata;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.metasee.database.commonUtil.Page;
import org.metasee.database.dao.MetaDataDao;
import org.metasee.database.model.LocalSequenceData;
import org.metasee.database.model.MetaData;
import org.metasee.database.model.MetaDataSample;
import org.metasee.database.model.News;
import org.metasee.database.util.HibernateUtil;

public class MetaDataDaoImpl implements MetaDataDao {
	
	public boolean checkMetaDataWithProjectNameAndSourceURL(MetaData metaData){
		String projectname=metaData.getProjectName();
		String sourceUrl=metaData.getSourceURL();
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		long count = (Long)s.createQuery("select count(*) from MetaData md where md.projectName = :projectname and md.sourceURL = :sourceUrl").setString("projectname", projectname).setString("sourceUrl", sourceUrl).uniqueResult();
		s.getTransaction().commit();
		
		if(count > 0) return true;
		return false;
	}
	
	public void save(MetaData metaData, ArrayList<String> localsequencedata) {
		metaData.setCreateTime(new Date());
		metaData.setSongChecked(1);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		metaData.getSourcecodeOfOriginalPage().setMetaData(metaData);
		metaData.getMetaDiscriptionSourceCode().setMetaData(metaData);
		s.save(metaData);
		s.getTransaction().commit();
		
		for(int i=0;i<localsequencedata.size();i++){
			LocalSequenceData localSequenceData=new LocalSequenceData(localsequencedata.get(i));
			localSequenceData.setMetaData(metaData);
			
			sf = HibernateUtil.getSessionFactory();
			s = sf.getCurrentSession();
			s.beginTransaction();
			s.persist(localSequenceData);
			s.getTransaction().commit();
		}
		
	}

	@Override
	public Page getMetaDatas(int page, int recordPerPage) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<MetaData> metadatas=(List<MetaData>)s.createQuery("from MetaData metadata where metadata.songChecked=1  order by metadata.id desc").list();
		s.getTransaction().commit();
		
		int totlaCount = metadatas.size();
		if(metadatas.size()-1-(page-1)*recordPerPage > recordPerPage){
			return new Page(totlaCount, metadatas.subList((page-1)*recordPerPage, (page-1)*recordPerPage+recordPerPage));
		}else{
			return new Page(totlaCount, metadatas.subList((page-1)*recordPerPage, metadatas.size()));
		}
	}

	@Override
	public Page getMetaDataSearch(String keyword, int page, int recordPerPage) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<MetaData> metadatas=(List<MetaData>)s.createQuery("from MetaData metaData where metaData.projectName like '%"+keyword+"%' or metaData.description like '%"+keyword+"%' or metaData.contactInformation like '%"+keyword+"%'  or metaData.metaDiscription like '%"+keyword+"%' and metaData.songChecked=1  order by metaData.id desc").list();
		s.getTransaction().commit();
		
		int totlaCount = metadatas.size();
		if(metadatas.size()-1-(page-1)*recordPerPage > recordPerPage){
			return new Page(totlaCount, metadatas.subList((page-1)*recordPerPage, (page-1)*recordPerPage+recordPerPage));
		}else{
			return new Page(totlaCount, metadatas.subList((page-1)*recordPerPage, metadatas.size()));
		}
	}
	
	public MetaData getMetaDataById(int id) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<MetaData> metadatas=(List<MetaData>)s.createQuery("from MetaData metaData where metaData.id=" + id +" and metaData.songChecked=1").list();
		s.getTransaction().commit();
		
		MetaData metaData=metadatas.get(0);
		
		sf=HibernateUtil.getSessionFactory();
		s=sf.getCurrentSession();
		s.beginTransaction();	
		List<MetaDataSample> metaDataSamples=(List<MetaDataSample>)s.createQuery("from MetaDataSample as metaDataSample where metaDataSample.project_id ='"+ metaData.getSourceId()+"' and metaDataSample.database_source='" + metaData.getDatabaseSource() + "' and metaDataSample.songChecked=1").list();
		s.getTransaction().commit();
		
		Set<MetaDataSample> metaDataSamplesHash=new HashSet<MetaDataSample>();
		metaDataSamplesHash.addAll(metaDataSamples);
		metaDataSamples.clear();
		metaData.setMetaDataSample(metaDataSamplesHash);
		//Iterator<MetaDataSample> itr=metaDataSamplesHash.iterator();
		//while (itr.hasNext()){
			//System.out.print(itr.next().getTitle());
		//}
		return metaData;
	}

	@Override
	public MetaData getMetaDataByAcc(String database_source,
			String sourceId) {
		// TODO Auto-generated method stub
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<MetaData> metadatas=(List<MetaData>)s.createQuery("from MetaData metaData where metaData.databaseSource='" + database_source + "' and metaData.sourceId='" + sourceId + "' and metaData.songChecked=1").list();
		s.getTransaction().commit();
		
		MetaData metadata=metadatas.get(0);
		
		sf=HibernateUtil.getSessionFactory();
		s=sf.getCurrentSession();
		s.beginTransaction();	
		List<MetaDataSample> metaDataSamples=(List<MetaDataSample>)s.createQuery("from MetaDataSample as metaDataSample where metaDataSample.project_id ='"+ metadata.getSourceId()+"' and metaDataSample.songChecked=1").list();
		s.getTransaction().commit();
		
		Set<MetaDataSample> metaDataSamplesHash=new HashSet<MetaDataSample>();
		metaDataSamplesHash.addAll(metaDataSamples);
		metaDataSamples.clear();
		metadata.setMetaDataSample(metaDataSamplesHash);
		return metadata;
	}
	@Override
	public void deleteById(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<MetaData> metaDatas=(List<MetaData>)s.createQuery("from MetaData metaData where metaData.id=" + id+"and metaData.songChecked=1").list();
		s.getTransaction().commit();
		
		MetaData metaData=metaDatas.get(0);
		metaData.setSongChecked(0);
		
		sf = HibernateUtil.getSessionFactory();
		s = sf.getCurrentSession();
		s.beginTransaction();
		s.update(metaData);
		s.getTransaction().commit();
	}
	
	@Override
	public void update(MetaData metaData) {
		metaData.setCreateTime(new Date());
		metaData.setSongChecked(1);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.update(metaData);
		s.getTransaction().commit();
	}

	@Override
	public Page apiGetMetaDataSearch(String keyword) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<MetaData> metadatas=(List<MetaData>)s.createQuery("from MetaData metaData where metaData.projectName like '%"+keyword+"%' or metaData.description like '%"+keyword+"%' or metaData.contactInformation like '%"+keyword+"%'  or metaData.metaDiscription like '%"+keyword+"%' and metaData.songChecked=1  order by metaData.id desc").list();
		s.getTransaction().commit();
		
		for(MetaData metadata : metadatas){
			
			sf=HibernateUtil.getSessionFactory();
			s=sf.getCurrentSession();
			s.beginTransaction();
			List<MetaDataSample> metaDataSamples=(List<MetaDataSample>)s.createQuery("from MetaDataSample as metaDataSample where metaDataSample.project_id ='"+ metadata.getSourceId()+"' and metaDataSample.database_source='" + metadata.getDatabaseSource() + "' and metaDataSample.songChecked=1").list();
			s.getTransaction().commit();
			
			Set<MetaDataSample> metaDataSamplesHash=new HashSet<MetaDataSample>();
			metaDataSamplesHash.addAll(metaDataSamples);
			metaDataSamples.clear();
			metadata.setMetaDataSample(metaDataSamplesHash);
		}
		return new Page(metadatas.size(), metadatas);
	}
	
	@Override
	public Page apiGetMetaDataList() {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<MetaData> metadatas=(List<MetaData>)s.createQuery("from MetaData metaData where metaData.songChecked=1  order by metaData.id desc").list();
		s.getTransaction().commit();
		
		for(MetaData metadata : metadatas){
			
			sf=HibernateUtil.getSessionFactory();
			s=sf.getCurrentSession();
			s.beginTransaction();
			List<MetaDataSample> metaDataSamples=(List<MetaDataSample>)s.createQuery("from MetaDataSample as metaDataSample where metaDataSample.project_id ='"+ metadata.getSourceId()+"' and metaDataSample.database_source='" + metadata.getDatabaseSource() + "' and metaDataSample.songChecked=1").list();
			s.getTransaction().commit();
			
			Set<MetaDataSample> metaDataSamplesHash=new HashSet<MetaDataSample>();
			metaDataSamplesHash.addAll(metaDataSamples);
			metaDataSamples.clear();
			metadata.setMetaDataSample(metaDataSamplesHash);
		}
		return new Page(metadatas.size(), metadatas);
	}
}
