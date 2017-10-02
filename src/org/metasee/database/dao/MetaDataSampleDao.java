package org.metasee.database.dao;

import java.util.ArrayList;
import java.util.List;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.model.MetaDataSample;

public interface MetaDataSampleDao {
	//public void save(MetaData metaData,ArrayList<String> localsequencedata);
	//public boolean checkUserExistsWithProjectName(String projectName);  
	//public Page getMetaDatas(int page, int recordPerPage);
	public MetaDataSample getMetaDataSampleById(int id);
	public MetaDataSample getMetaDataSampleByAcc(String database_source,String metagenome);
	//public Page getMetaDataSearch(String keyword, int page, int recordPerPage);
	//public boolean checkMetaDataWithProjectNameAndSourceURL(MetaData metaData);
	public void deleteById(int id);
	public void update(MetaDataSample metaDataSample);
}
