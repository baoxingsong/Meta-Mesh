package org.metasee.database.service;

import java.util.ArrayList;
import java.util.List;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.model.MetaData;

public interface MetaDataManager {
	//public abstract boolean exists(MetaData metaData) throws Exception;

	public abstract void add(MetaData metaData,ArrayList<String> localsequencedata) throws Exception;
	
	public Page getMetaDatas(int page, int recordPerPage);
	public abstract MetaData getMetaDataByAcc(String acc);	
	public abstract MetaData getMetaDataById(int id);
	public Page getMetaDataSearch(String keyword,int page, int recordPerPage);
	public Page apiGetMetaDataSearch(String keyword);
	public abstract boolean checkMetaDataWithProjectNameAndSourceURL(MetaData metaData) throws Exception;
	public void update(MetaData metaData)  throws Exception;
	public void deleteById(int id) throws Exception;
	public Page apiGetMetaDataList();
}
