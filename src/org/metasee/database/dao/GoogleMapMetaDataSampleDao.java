package org.metasee.database.dao;

import java.util.List;

import org.metasee.database.model.GoogleMapMetaDataSample;

public interface GoogleMapMetaDataSampleDao {
	public GoogleMapMetaDataSample getGoogleMapMetaDataSampleById(int id);
	public GoogleMapMetaDataSample getGoogleMapMetaDataSampleByAcc(String database_source,String metagenome);
	public List<GoogleMapMetaDataSample> searchGoogleMapMetaDataSample(String keyWord);
	public List<GoogleMapMetaDataSample> listGoogleMapMetaDataSample();
}
