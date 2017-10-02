package org.metasee.database.dao.impl;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.metasee.database.util.HibernateUtil;

import org.metasee.database.commonUtil.DeleteFile;
import org.metasee.database.commonUtil.Page;
import org.metasee.database.commonUtil.runCommand.MetaStormsRunCommand;
import org.metasee.database.dao.MetaStormsResultDao;

import org.metasee.database.model.MetaStormMatch;
import org.metasee.database.model.MetaStormsResult;
import org.metasee.database.commonUtil.constant.*;

public class MetaStormsResultDaoImpl implements MetaStormsResultDao {
	@Override
	public void removeById(int metaStormsResultId) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<MetaStormsResult> metaStormsResults=(List<MetaStormsResult>)s.createQuery("from MetaStormsResult metaStormsResult where metaStormsResult.id =" + metaStormsResultId + "and metaStormsResult.songChecked=1").list();
		s.getTransaction().commit();
		
		if(metaStormsResults.size()>0){
			MetaStormsResult metaStormsResult=metaStormsResults.get(0);
			try {
				String path = GlobalConstant.uploadDir+metaStormsResult.getParallelMetaResult().getUploadFile().getUploadProject().getWorkShop().getOwner().getUserName()+File.separator+metaStormsResult.getParallelMetaResult().getUploadFile().getUploadProject().getRandomFileName() + File.separator + GlobalConstant.METASTORM + File.separator+metaStormsResult.getId();
				DeleteFile deleteFile = new DeleteFile(path);
				deleteFile.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sf = HibernateUtil.getSessionFactory();
			s = sf.getCurrentSession();
			s.beginTransaction();
			s.delete(metaStormsResult);
			s.getTransaction().commit();
		}
		
	}

	@Override
	public MetaStormsResult getMetaStormsResultById(int metaStormsResultId) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<MetaStormsResult> metaStormsResults=(List<MetaStormsResult>)s.createQuery("from MetaStormsResult metaStormsResult where metaStormsResult.id =" + metaStormsResultId + "and metaStormsResult.songChecked=1").list();
		s.getTransaction().commit();
		
		if(metaStormsResults.size()>0){
			MetaStormsResult metaStormsResult=metaStormsResults.get(0);
			return metaStormsResult;
		}
		return null;
	}

	private MetaStormsResult getDetailedResult(MetaStormsResult metaStormsResult) {
		MetaStormMatch metaStormMatch=new MetaStormMatch();;
		String fileName=GlobalConstant.webroot+"upload"+File.separator+metaStormsResult.getParallelMetaResult().getUploadFile().getUploadProject().getRandomFileName()+File.separator+metaStormsResult.getId();
		
		File file=new File(fileName);
		try{
			FileReader in=new FileReader(file);
			BufferedReader inTwo=new BufferedReader(in);
			StringBuffer stringbuffer= new StringBuffer();
			StringBuffer stringbuffermatch= new StringBuffer();
			String s=null;
			
			Pattern idp=Pattern.compile("Match (\\d+)");
			Pattern scorep=Pattern.compile("Similarity: (.+)");
			Pattern groupP=Pattern.compile("Sample Group: (.*)");
			Pattern metaidp=Pattern.compile("Sample path: (.*)");
			int lineNumber=0;
			while((s=inTwo.readLine())!=null){
				Matcher idm =idp.matcher(s);
				Matcher metaidm=metaidp.matcher(s);
				Matcher scorem=scorep.matcher(s);
				Matcher groupm=groupP.matcher(s);
				lineNumber++;
				
				if(idm.find()){
					if(lineNumber<3){
						
					}else{
						metaStormsResult.getMetaStormMatch().add(metaStormMatch);
						System.out.println(metaStormMatch.getMatch());
					}
					metaStormMatch=new MetaStormMatch();
					metaStormMatch.setMatch(idm.group(1));
				}
				if(scorem.find()){
					metaStormMatch.setSimilarity(scorem.group(1));
				}
				if(metaidm.find()){
					metaStormMatch.setSamplePath(metaidm.group(1));
				}
				if(groupm.find()){
					metaStormMatch.setSampleGroup(groupm.group(1));
				}
			}
			metaStormsResult.getMetaStormMatch().add(metaStormMatch);
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("catch");
		}
		return metaStormsResult;
	}

	@Override
	public void updateCommentById(int metaStormsResultId, String comment) {
		MetaStormsResult metaStormsResult=this.getMetaStormsResultById(metaStormsResultId);
		if(null != metaStormsResult){
			metaStormsResult.setComment(comment);
			
			SessionFactory sf=HibernateUtil.getSessionFactory();
			Session s=sf.getCurrentSession();
			s.beginTransaction();
			s.update(metaStormsResult);
			s.getTransaction().commit();
		}
	}

	@Override
	public void addMetaStormsResult(MetaStormsResult metaStormsResult) {
		if(null != metaStormsResult){
			metaStormsResult.setSongChecked(1);
			metaStormsResult.setCreateTime(new Date());
			
			SessionFactory sf=HibernateUtil.getSessionFactory();
			Session s=sf.getCurrentSession();
			s.beginTransaction();
			s.save(metaStormsResult);
			s.getTransaction().commit();
			
			try {
				MetaStormsRunCommand runCommand=new MetaStormsRunCommand();
				runCommand.setMetaStormsResult(metaStormsResult);
				runCommand.start();
			} catch (Exception e) {
				metaStormsResult.setError(1);
				
				sf=HibernateUtil.getSessionFactory();
				s = sf.getCurrentSession();
				s.beginTransaction();
				s.update(metaStormsResult);
				s.getTransaction().commit();
				
				e.printStackTrace();
			}
		}
	}

	@Override
	public Page getMetaStormsResultsByParallelMetaResultId(
			int parallelMetaResultId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
