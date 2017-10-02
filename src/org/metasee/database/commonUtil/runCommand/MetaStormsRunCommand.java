package org.metasee.database.commonUtil.runCommand;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import org.metasee.database.commonUtil.constant.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.metasee.database.model.MetaStormsResult;

import org.metasee.database.util.HibernateUtil;


public class MetaStormsRunCommand extends Thread{
	MetaStormsResult metaStormsResult=new MetaStormsResult();
	
	public MetaStormsRunCommand(){
		
	}
	
	public void run() { 
		StringBuffer comman=new StringBuffer();
		comman.append(GlobalConstant.metaStomrsPath+"bin"+File.separator+"query_index -i ");
		
		/**
		 * database·
		 * */
		String outPath = GlobalConstant.uploadDir+metaStormsResult.getParallelMetaResult().getUploadFile().getUploadProject().getWorkShop().getOwner().getUserName()+File.separator+metaStormsResult.getParallelMetaResult().getUploadFile().getUploadProject().getRandomFileName() + File.separator + GlobalConstant.METASTORM + File.separator;	
		comman.append(org.metasee.database.commonUtil.constant.GlobalConstant.uploadDir);
		comman.append(metaStormsResult.getParallelMetaResult().getUploadFile().getUploadProject().getWorkShop().getOwner().getUserName()+File.separator+metaStormsResult.getParallelMetaResult().getUploadFile().getUploadProject().getRandomFileName());
		comman.append(File.separator+metaStormsResult.getParallelMetaResult().getFoldername()+File.separator+"classification.txt ");
		comman.append(" -o " + outPath + File.separator+metaStormsResult.getId());
		
		comman.append(" -d "+ org.metasee.database.commonUtil.constant.GlobalConstant.webroot+"metastormdatabase"+File.separator+" -n "+metaStormsResult.getHitNumber()+" -t 8");
		if(metaStormsResult.getDatabase().equals("1") || metaStormsResult.getDatabase().equals("0")){
			comman.append(" -g " + metaStormsResult.getDatabase());
		}
		if(metaStormsResult.getExhaustiveSearch().endsWith("y")){
			comman.append(" -e");
		}
		String metaStomrsCommand=comman.toString();
		System.out.println("metaStomrsCommand"+metaStomrsCommand);
		try {
			 File file = new File(outPath);
			 if (!file.exists()) {
				file.mkdir();
			 }
			 Runtime r=Runtime.getRuntime();   
		     Process p=r.exec(metaStomrsCommand);   
		     BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream())); 
		     BufferedReader er=new BufferedReader(new InputStreamReader(p.getErrorStream()));
		     //StringBuffer sb=new StringBuffer();
		     
		     String inline;   
		     while(null!=(inline=br.readLine())){   
		    	 //sb.append(inline).append("\n");
		    	 System.out.println(inline);
		     }   
		     while(null!=(inline=er.readLine())){   
		    	 //sb.append(inline).append("\n");
		    	 System.out.println(inline);
		     }
		     //System.out.println(sb.toString());
		     p.waitFor();
		        
		} catch (IOException e) {
			this.setError();
			// TODO Auto-generated catch block
			System.out.println(metaStomrsCommand+"ioioioioio");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			this.setError();
			System.out.println(metaStomrsCommand+"inininininini");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.setError();
			System.out.println(metaStomrsCommand+"xexexexeex");
			e.printStackTrace();
		}
		System.out.println("out of exception");
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		this.metaStormsResult.setComplete(1);
		s.update(metaStormsResult);
		s.getTransaction().commit();
	}
	
	public void setError(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		this.metaStormsResult.setError(1);
		s.update(metaStormsResult);
		s.getTransaction().commit();
	}

	public MetaStormsResult getMetaStormsResult() {
		return metaStormsResult;
	}

	public void setMetaStormsResult(MetaStormsResult metaStormsResult) {
		this.metaStormsResult = metaStormsResult;
	}



	
}