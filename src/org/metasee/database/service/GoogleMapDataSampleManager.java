package org.metasee.database.service;

import java.util.List;

import org.metasee.database.model.GoogleMapMetaDataSample;

public interface GoogleMapDataSampleManager {
	public GoogleMapMetaDataSample getGoogleMapMetaDataSampleById(int id);
	public GoogleMapMetaDataSample getGoogleMapMetaDataSampleByAcc(String acc);
	public List<GoogleMapMetaDataSample> searchGoogleMapMetaDataSample(String keyWord);
	public List<GoogleMapMetaDataSample> listGoogleMapMetaDataSample();
}
