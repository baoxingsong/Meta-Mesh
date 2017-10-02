package org.metasee.database.commonUtil.runCommand;

import org.metasee.database.commonUtil.runCommand.ZipMaker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


import org.metasee.database.commonUtil.constant.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.metasee.database.model.ParallelMetaResult;
import org.metasee.database.model.UploadFile;
import org.metasee.database.util.HibernateUtil;

public class ParallelMetaRunCommand{
	ParallelMetaResult parallelMetaResult=new ParallelMetaResult();
	String outPath;
	public ParallelMetaRunCommand(){
		
	}
	public void run() {
		this.setStart();
		List<String> cmdList= new ArrayList<String>();
		
		StringBuffer comman=new StringBuffer();
		outPath = org.metasee.database.commonUtil.constant.GlobalConstant.uploadDir+parallelMetaResult.getUploadFile().getUploadProject().getWorkShop().getOwner().getUserName()+File.separator+parallelMetaResult.getUploadFile().getUploadProject().getRandomFileName()+File.separator+parallelMetaResult.getFoldername();
		String logPath = outPath + File.separator + "log";
		comman.append(GlobalConstant.parallelmetapath+"bin"+File.separator+"parallel-meta ");
		cmdList.add(GlobalConstant.parallelmetapath+"bin"+File.separator+"parallel-meta");
		if(parallelMetaResult.getType().equals("m")){
			comman.append("-l "+parallelMetaResult.getLength()+" -m ");
			cmdList.add("-l");
			cmdList.add(parallelMetaResult.getLength());
			cmdList.add("-m");
		}else if(parallelMetaResult.getType().equals("r")){
			comman.append("-r ");
			cmdList.add("-r");
		}
				
		comman.append(org.metasee.database.commonUtil.constant.GlobalConstant.uploadDir);
		comman.append(parallelMetaResult.getUploadFile().getUploadProject().getWorkShop().getOwner().getUserName()+File.separator+parallelMetaResult.getUploadFile().getUploadProject().getRandomFileName());
		comman.append(File.separator+parallelMetaResult.getUploadFile().getFileName());
		cmdList.add(org.metasee.database.commonUtil.constant.GlobalConstant.uploadDir+parallelMetaResult.getUploadFile().getUploadProject().getWorkShop().getOwner().getUserName()+File.separator+parallelMetaResult.getUploadFile().getUploadProject().getRandomFileName()+File.separator+parallelMetaResult.getUploadFile().getFileName());
		comman.append("-o" + outPath);
		cmdList.add("-o");
		cmdList.add(outPath);
		comman.append(" -d "+ parallelMetaResult.getDatabase()+" -e "+parallelMetaResult.getEvalue()+" -f "+parallelMetaResult.getFormat()+" -p "+parallelMetaResult.getPhylogeneticanalysis());
		cmdList.add("-d");
		cmdList.add(parallelMetaResult.getDatabase());
		cmdList.add("-e ");
		cmdList.add(parallelMetaResult.getEvalue());
		cmdList.add("-f");
		cmdList.add(parallelMetaResult.getFormat());
		cmdList.add("-p");
		cmdList.add(parallelMetaResult.getPhylogeneticanalysis());
		String parallelCommand=comman.toString();
		System.out.println("parallelCommand:"+parallelCommand);
		System.out.println("cmdList:"+cmdList);
		String[] cmdarray = new String[cmdList.size()];
		cmdList.toArray(cmdarray);
		try {
			 File file = new File(outPath + File.separator);
			 if (!file.exists()) {
				file.mkdir();
			 }
			 Runtime r=Runtime.getRuntime();   
		     Process p=r.exec(cmdarray);
		     Thread.sleep(6000);
		     BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream())); 
		     BufferedReader er=new BufferedReader(new InputStreamReader(p.getErrorStream()));
		     
		     String inline;
		     PrintStream logPrintStream;
		     FileOutputStream logFileStream;
		     
		     File logFile = new File(outPath + File.separator + "log");
		     logFileStream = new FileOutputStream(logFile);
		     logPrintStream = new PrintStream(logFileStream);
		     
		     while(null!=(inline=br.readLine())){
		    	 //this.creatEmptyLogFile(logFile);
		    	 logPrintStream.println(inline);
		    	 logPrintStream.flush();
		     }   
		     while(null!=(inline=er.readLine())){
		    	 //this.creatEmptyLogFile(logFile);
		    	 logPrintStream.println(inline);
		    	 logPrintStream.flush();
		     }
		     p.waitFor();
		     //logPrintStream.close();
		     File srcFile = new File(outPath);
		     String zipFilePath = outPath + File.separator + "parallelMeta.zip";
		     if(srcFile.exists()) {
				File[] files = srcFile.listFiles();
				(new ZipMaker()).compressFiles2Zip(files, zipFilePath);
		     }		     
		     
		} catch (IOException e) {
			this.setError();
			e.printStackTrace();
		} catch (InterruptedException e) {
			this.setError();
			e.printStackTrace();
		} catch (Exception e) {
			this.setError();
			e.printStackTrace();
		}
		this.setCompleted();
		
	}
	public void setStart(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		this.parallelMetaResult.setStart(1);
		s.update(parallelMetaResult);
		s.getTransaction().commit();
	}
	public void setError(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		this.parallelMetaResult.setError(1);
		s.update(parallelMetaResult);
		s.getTransaction().commit();
	}
	public void setCompleted(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		this.parallelMetaResult.setComplete(1);
		s.update(parallelMetaResult);
		s.getTransaction().commit();
	}
	
	private void creatEmptyLogFile(File logFile){
		if(!logFile.exists()){
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ParallelMetaResult getParallelMetaResult() {
		return parallelMetaResult;
	}

	public void setParallelMetaResult(ParallelMetaResult parallelMetaResult) {
		this.parallelMetaResult = parallelMetaResult;
	}
}