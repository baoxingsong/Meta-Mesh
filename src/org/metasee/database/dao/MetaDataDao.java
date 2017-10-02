package org.metasee.database.dao;

import java.util.ArrayList;
import java.util.List;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.model.MetaData;
import org.metasee.database.model.News;

public interface MetaDataDao {
	public void save(MetaData metaData,ArrayList<String> localsequencedata);
	//public boolean checkUserExistsWithProjectName(String projectName);  
	public Page getMetaDatas(int page, int recordPerPage);
	public MetaData getMetaDataById(int id);
	public Page getMetaDataSearch(String keyword, int page, int recordPerPage);
	public Page apiGetMetaDataSearch(String keyword);
	public boolean checkMetaDataWithProjectNameAndSourceURL(MetaData metaData);
	public MetaData getMetaDataByAcc(String database_source,String sourceId);
	public void deleteById(int id);
	public void update(MetaData metaData);
	public Page apiGetMetaDataList();
}
