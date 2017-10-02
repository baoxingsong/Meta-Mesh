package org.metasee.database.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.metasee.database.dao.impl.GoogleMapDataSampleDaoImpl;
import org.metasee.database.model.GoogleMapMetaDataSample;
import org.metasee.database.service.GoogleMapDataSampleManager;

public class GoogleMapDataSampleManagerImpl implements
		GoogleMapDataSampleManager {
	GoogleMapDataSampleDaoImpl googleMapDataSampleDao = new GoogleMapDataSampleDaoImpl();
	@Override
	public GoogleMapMetaDataSample getGoogleMapMetaDataSampleById(int id) {
		// TODO Auto-generated method stub
		return googleMapDataSampleDao.getGoogleMapMetaDataSampleById(id);
	}
	@Override
	public GoogleMapMetaDataSample getGoogleMapMetaDataSampleByAcc(
			String acc) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("(\\S+?)_(\\S+)");
		Matcher matcher = pattern.matcher(acc);
		String database_source="MGRAST";
		String metagenome="4440640.3";
		//String database_source=new String();
		//String metagenome=new String();
		if(matcher.find()){
			database_source=matcher.group(1);
			metagenome=matcher.group(2);
		}
		return googleMapDataSampleDao.getGoogleMapMetaDataSampleByAcc(database_source, metagenome);
	}
	@Override
	public List<GoogleMapMetaDataSample> searchGoogleMapMetaDataSample(
			String keyWord) {
		// TODO Auto-generated method stub
		return googleMapDataSampleDao.searchGoogleMapMetaDataSample(keyWord);
	}
	@Override
	public List<GoogleMapMetaDataSample> listGoogleMapMetaDataSample() {
		// TODO Auto-generated method stub
		return googleMapDataSampleDao.listGoogleMapMetaDataSample();
	}
}
