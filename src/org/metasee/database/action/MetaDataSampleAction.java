package org.metasee.database.action;

import java.util.ArrayList;
import java.util.List;

import org.metasee.database.model.MetaDataSample;
import org.metasee.database.model.News;
import org.metasee.database.service.MetaDataSampleManager;
import org.metasee.database.service.impl.MetaDataSampleManagerImpl;
import org.metasee.database.commonUtil.Page;

import com.opensymphony.xwork2.ActionSupport;

public class MetaDataSampleAction extends SuperClass{

	private static final long serialVersionUID = 1L;
	
	
	MetaDataSample metaDataSample;
	private int id;
	private String acc;
	
	private MetaDataSampleManager metaDataSampleManager = new MetaDataSampleManagerImpl();
	
	public MetaDataSampleAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String getMetaSampleDetail() throws Exception{
		String idString=this.id + "";
		if("".equals(idString) || "0".equals(idString) || null==idString){
			this.metaDataSample=this.metaDataSampleManager.getMetaDataSampleByAcc(acc);
			this.id=metaDataSample.getId();
		}else{
			this.metaDataSample=this.metaDataSampleManager.getMetaDataSampleById(id);
		}
		
		this.setWebPageTitle("metagenomic sample " + this.metaDataSample.getTitle());
		return SUCCESS;
	} 
	
	public String deleteById() throws Exception{
		metaDataSampleManager.deleteById(id);
		this.setWebPageTitle("metagenomic sample delete");
		return SUCCESS;
	}
	
	public String updateinput()throws Exception{
		this.metaDataSample=this.metaDataSampleManager.getMetaDataSampleById(id);
		this.setWebPageTitle("metagenomic sample edit");
		return SUCCESS;
	}
	
	public String update()throws Exception{
		MetaDataSample metaDataSample=new MetaDataSample();
		metaDataSample.setId(id);
		this.setWebPageTitle("metagenomic sample edit");
		return SUCCESS;
	}
	
	public MetaDataSample getMetaDataSample() {
		return metaDataSample;
	}

	public void setMetaDataSample(MetaDataSample metaDataSample) {
		this.metaDataSample = metaDataSample;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		System.out.println(id);
	}

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public MetaDataSampleManager getMetaDataSampleManager() {
		return metaDataSampleManager;
	}

	public void setMetaDataSampleManager(MetaDataSampleManager metaDataSampleManager) {
		this.metaDataSampleManager = metaDataSampleManager;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
