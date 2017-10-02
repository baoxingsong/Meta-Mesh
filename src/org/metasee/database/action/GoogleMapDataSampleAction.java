package org.metasee.database.action;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.metasee.database.model.GoogleMapMetaDataSample;
import org.metasee.database.service.impl.GoogleMapDataSampleManagerImpl;
import org.metasee.database.service.GoogleMapDataSampleManager;

import com.google.gson.Gson;

public class GoogleMapDataSampleAction extends SuperClass {
	private int sampleId;
	private String keyWord;
	private String acc;
	GoogleMapMetaDataSample googleMapMetaDataSample = new GoogleMapMetaDataSample();
	List<GoogleMapMetaDataSample> googleMapMetaDataSamples = new ArrayList<GoogleMapMetaDataSample>();
	GoogleMapDataSampleManager googleMapDataSampleManager = new GoogleMapDataSampleManagerImpl();
	private String jsonData;
	private String ajaxUrl;
	
	public String view(){
		String idString=this.sampleId + "";
		if(null!=idString && !"".equals(idString) && !"0".equals(idString)){
			ajaxUrl = "map_getSample?sampleId=" + sampleId;
		}else if(null!=acc && !"".equals(acc)){
			ajaxUrl = "map_getSample?acc=" + acc;
		}else if(null!=keyWord && !"".equals(keyWord)){
			ajaxUrl = "map_list?keyWord=" + keyWord;
		}else{
			ajaxUrl = "map_list";
		}
		return "viewsuccess";
	}
	
	public String getSample(){
		String idString=this.sampleId + "";
		if(null==idString || "".equals(idString) || "0".equals(idString)){
			googleMapMetaDataSample = googleMapDataSampleManager.getGoogleMapMetaDataSampleByAcc(acc);
		}else{
			googleMapMetaDataSample = googleMapDataSampleManager.getGoogleMapMetaDataSampleById(sampleId);
		}
		googleMapMetaDataSamples.add(googleMapMetaDataSample);
		this.getJsonString(googleMapMetaDataSamples);
		return SUCCESS;
	}
	public String list(){
		if(null == keyWord || "".equals(keyWord)){
			googleMapMetaDataSamples = googleMapDataSampleManager.listGoogleMapMetaDataSample();
		}else{
			googleMapMetaDataSamples = googleMapDataSampleManager.searchGoogleMapMetaDataSample(keyWord);
		}
		this.getJsonString(googleMapMetaDataSamples);
		return SUCCESS;
	}
	
	private void getJsonString(GoogleMapMetaDataSample googleMapMetaDataSampleJson){
		MapJson mapJson = null;
		if(null != googleMapMetaDataSampleJson.getLatitude() && null != googleMapMetaDataSampleJson.getLongitude() && 0!=googleMapMetaDataSampleJson.getLatitude() && 0!=googleMapMetaDataSampleJson.getLongitude()){
			mapJson = new MapJson(googleMapMetaDataSampleJson);
		}
		Gson gson = new Gson();  
		jsonData = gson.toJson(mapJson);
		jsonData = "{\"data\":" + jsonData + "}";
	}
	
	private void getJsonString(List<GoogleMapMetaDataSample> googleMapMetaDataSampleJsons){
		Set<MapJson> mapJsons = new HashSet<MapJson>();
		for(GoogleMapMetaDataSample googleMapMetaDataSampleJson : googleMapMetaDataSampleJsons){
			if(null != googleMapMetaDataSampleJson.getLatitude() && null != googleMapMetaDataSampleJson.getLongitude() && 0!=googleMapMetaDataSampleJson.getLatitude() && 0!=googleMapMetaDataSampleJson.getLongitude()){
				MapJson mapJson = new MapJson(googleMapMetaDataSampleJson);
				mapJsons.add(mapJson);
			}
		}
		Gson gson = new Gson();  
		jsonData = gson.toJson(mapJsons);
		jsonData = "{\"data\":" + jsonData + "}";
	}
	
	
	private class MapJson {
		private int id;
		private double lat;
		private double lng;
		private String title;
		private String body;
		MapJson(GoogleMapMetaDataSample googleMapMetaDataSampleJson){
			this.id = googleMapMetaDataSampleJson.getId();
			this.lat = googleMapMetaDataSampleJson.getLatitude();
			this.lng = googleMapMetaDataSampleJson.getLongitude();
			this.title = "Metagenome Sample";
			this.body = "Latitude:" + lat + "<br />Longitude:"+lng +"<br />ID:"+id+"<br /><br /><a href=\"sampleview?id=" + id + "\" target=\"_blank\">View</a>&nbsp;&nbsp;&nbsp;&nbsp; <a href=\"metasample/?id=" + id + "\" target=\"_blank\">Information</a>&nbsp;&nbsp;&nbsp;&nbsp; <a href=\"sampleMetormsinput?id=" + id + "\" target=\"_blank\">Search</a>";
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public double getLng() {
			return lng;
		}
		public void setLng(double lng) {
			this.lng = lng;
		}
		public double getLat() {
			return lat;
		}
		public void setLat(double lat) {
			this.lat = lat;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
	}

	public int getSampleId() {
		return sampleId;
	}

	public void setSampleId(int sampleId) {
		this.sampleId = sampleId;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public GoogleMapMetaDataSample getGoogleMapMetaDataSample() {
		return googleMapMetaDataSample;
	}

	public void setGoogleMapMetaDataSample(
			GoogleMapMetaDataSample googleMapMetaDataSample) {
		this.googleMapMetaDataSample = googleMapMetaDataSample;
	}

	public GoogleMapDataSampleManager getGoogleMapDataSampleManager() {
		return googleMapDataSampleManager;
	}

	public void setGoogleMapDataSampleManager(
			GoogleMapDataSampleManager googleMapDataSampleManager) {
		this.googleMapDataSampleManager = googleMapDataSampleManager;
	}

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	public List<GoogleMapMetaDataSample> getGoogleMapMetaDataSamples() {
		return googleMapMetaDataSamples;
	}

	public void setGoogleMapMetaDataSamples(
			List<GoogleMapMetaDataSample> googleMapMetaDataSamples) {
		this.googleMapMetaDataSamples = googleMapMetaDataSamples;
	}

	public String getAjaxUrl() {
		return ajaxUrl;
	}

	public void setAjaxUrl(String ajaxUrl) {
		this.ajaxUrl = ajaxUrl;
	}
}
