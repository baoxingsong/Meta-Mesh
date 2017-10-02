package org.metasee.database.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.dao.MetaDataSampleDao;
import org.metasee.database.dao.impl.MetaDataSampleDaoImpl;
import org.metasee.database.model.MetaDataSample;
import org.metasee.database.model.News;
import org.metasee.database.service.MetaDataSampleManager;

public class MetaDataSampleManagerImpl implements MetaDataSampleManager {
	private MetaDataSampleDaoImpl metaDataSampleDao = new MetaDataSampleDaoImpl();
	
	@Override
	public MetaDataSample getMetaDataSampleById(int id) {
		// TODO Auto-generated method stub
		return this.metaDataSampleDao.getMetaDataSampleById(id);
	}
	
	public MetaDataSample getMetaDataSampleByAcc(String acc) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("(\\S+?)_(\\S+)");
		Matcher matcher = pattern.matcher(acc);
		String database_source="MGRAST";
		String metagenome="4440640.3";
		if(matcher.find()){
			database_source=matcher.group(1);
			metagenome=matcher.group(2);
		}
		return this.metaDataSampleDao.getMetaDataSampleByAcc(database_source, metagenome);
	}
	
	@Override
	public void update(MetaDataSample metaDataSample){
		metaDataSampleDao.update(metaDataSample);
	}
	
	@Override
	public void deleteById(int id) throws Exception {
		metaDataSampleDao.deleteById(id);
	}
}
