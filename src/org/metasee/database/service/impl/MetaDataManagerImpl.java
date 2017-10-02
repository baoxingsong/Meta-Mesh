package org.metasee.database.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.dao.MetaDataDao;
import org.metasee.database.dao.impl.MetaDataDaoImpl;
import org.metasee.database.model.MetaData;
import org.metasee.database.model.News;
import org.metasee.database.service.MetaDataManager;

public class MetaDataManagerImpl implements MetaDataManager {
	private MetaDataDaoImpl metaDataDao = new MetaDataDaoImpl();
	
	
	
	public MetaDataDaoImpl getMetaDataDao() {
		return metaDataDao;
	}

	public void setMetaDataDao(MetaDataDaoImpl metaDataDao) {
		this.metaDataDao = metaDataDao;
	}
/*
	@Override
	public boolean exists(MetaData metaData) throws Exception {
		return metaDataDao.checkUserExistsWithProjectName(metaData.getProjectName());
	}
*/
	@Override
	public void add( MetaData metaData,ArrayList<String> localsequencedata) throws Exception {
		metaDataDao.save(metaData, localsequencedata);
	}

	@Override
	public Page getMetaDatas(int page, int recordPerPage) {
		return this.metaDataDao.getMetaDatas(page, recordPerPage);
	}

	@Override
	public MetaData getMetaDataById(int id) {
		// TODO Auto-generated method stub
		return this.metaDataDao.getMetaDataById(id);
	}

	@Override
	public Page getMetaDataSearch(String keyword,int page, int recordPerPage) {
		// TODO Auto-generated method stub
		return this.metaDataDao.getMetaDataSearch(keyword, page, recordPerPage);
	}

	@Override
	public boolean checkMetaDataWithProjectNameAndSourceURL(MetaData metaData)
			throws Exception {
		return metaDataDao.checkMetaDataWithProjectNameAndSourceURL(metaData);
	}

	@Override
	public MetaData getMetaDataByAcc(String acc) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("(\\S+)_(\\S+)");
		Matcher matcher = pattern.matcher(acc);
		String database_source=new String();
		String sourceId=new String();
		if(matcher.find()){
			database_source=matcher.group(1);
			sourceId=matcher.group(2);
		}
		//System.out.println(database_source);
		//System.out.println(metagenome);
		return this.metaDataDao.getMetaDataByAcc(database_source, sourceId);
	}
	@Override
	public void update(MetaData metaData){
		metaDataDao.update(metaData);
	}
	
	@Override
	public void deleteById(int id) throws Exception {
		metaDataDao.deleteById(id);
	}

	@Override
	public Page apiGetMetaDataSearch(String keyword) {
		// TODO Auto-generated method stub
		return metaDataDao.apiGetMetaDataSearch(keyword);
	}

	@Override
	public Page apiGetMetaDataList() {
		// TODO Auto-generated method stub
		return metaDataDao.apiGetMetaDataList();
	}

}
