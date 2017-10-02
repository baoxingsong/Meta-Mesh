package org.metasee.database.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.metasee.database.dao.GoogleMapMetaDataSampleDao;
import org.metasee.database.model.GoogleMapMetaDataSample;
import org.metasee.database.util.HibernateUtil;

public class GoogleMapDataSampleDaoImpl implements GoogleMapMetaDataSampleDao {

	@Override
	public GoogleMapMetaDataSample getGoogleMapMetaDataSampleById(int id) {
		// TODO Auto-generated method stub
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<GoogleMapMetaDataSample> googleMapMetaDataSamples=(List<GoogleMapMetaDataSample>)s.createQuery("from GoogleMapMetaDataSample googleMapMetaDataSample where googleMapMetaDataSample.id=" + id+" and googleMapMetaDataSample.songChecked=1").list();
		s.getTransaction().commit();
		
		GoogleMapMetaDataSample googleMapMetaDataSample = null;
		if(googleMapMetaDataSamples.size()>0){
			googleMapMetaDataSample=googleMapMetaDataSamples.get(0);
		}return googleMapMetaDataSample;
	}

	@Override
	public GoogleMapMetaDataSample getGoogleMapMetaDataSampleByAcc(
			String database_source, String metagenome) {
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<GoogleMapMetaDataSample> googleMapMetaDataSamples=(List<GoogleMapMetaDataSample>)s.createQuery("from GoogleMapMetaDataSample googleMapMetaDataSample where googleMapMetaDataSample.database_source='" + database_source + "' and googleMapMetaDataSample.metagenome='" + metagenome + "' and googleMapMetaDataSample.songChecked=1").list();
		s.getTransaction().commit();
		
		GoogleMapMetaDataSample googleMapMetaDataSample=null;
		if(googleMapMetaDataSamples.size()>0){
			googleMapMetaDataSample=googleMapMetaDataSamples.get(0);
		}
		return googleMapMetaDataSample;
	}

	@Override
	public List<GoogleMapMetaDataSample> searchGoogleMapMetaDataSample(
			String keyWord) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<GoogleMapMetaDataSample> googleMapMetaDataSamples=(List<GoogleMapMetaDataSample>)s.createQuery("from GoogleMapMetaDataSample googleMapMetaDataSample where googleMapMetaDataSample.database_source like '%"+keyWord+"%' or googleMapMetaDataSample.metagenome like '%"+keyWord+"%' and googleMapMetaDataSample.songChecked=1").list();
		s.getTransaction().commit();
		
		return googleMapMetaDataSamples;
	}

	@Override
	public List<GoogleMapMetaDataSample> listGoogleMapMetaDataSample() {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<GoogleMapMetaDataSample> googleMapMetaDataSamples=(List<GoogleMapMetaDataSample>)s.createQuery("from GoogleMapMetaDataSample googleMapMetaDataSample where googleMapMetaDataSample.songChecked=1").list();
		s.getTransaction().commit();
		
		return googleMapMetaDataSamples;
	}
}
