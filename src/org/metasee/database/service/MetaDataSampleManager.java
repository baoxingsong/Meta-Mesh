package org.metasee.database.service;

import java.util.ArrayList;
import java.util.List;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.model.MetaDataSample;

public interface MetaDataSampleManager {
	public abstract MetaDataSample getMetaDataSampleById(int id);
	public abstract MetaDataSample getMetaDataSampleByAcc(String acc);
	public void update(MetaDataSample metaDataSample);
	public void deleteById(int id) throws Exception;
}
