package org.metasee.database.commonUtil.runCommand;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.metasee.database.model.MetaStormsCompareResult;
import org.metasee.database.model.ParallelMetaResult;
import org.metasee.database.util.HibernateUtil;
import org.metasee.database.commonUtil.constant.*;
public class MetaStormsCompareRunCommand extends Thread{
	MetaStormsCompareResult metaStormsCompareResult = new MetaStormsCompareResult();
	
	public void run(){
		StringBuffer parallelResultPathes = new StringBuffer();
		for(ParallelMetaResult parallelMetaResult : metaStormsCompareResult.getParallelMetaResults()){
			parallelResultPathes.append(GlobalConstant.uploadDir + metaStormsCompareResult.getWorkShop().getOwner().getUserName() + 
					File.separator + parallelMetaResult.getUploadFile().getUploadProject().getRandomFileName() + File.separator +
					parallelMetaResult.getFoldername() + File.separator + "classification.txt\n");
		}
		String outPath = GlobalConstant.uploadDir + metaStormsCompareResult.getWorkShop().getOwner().getUserName() + File.separator + GlobalConstant.METASTORMSCOMPARE + File.separator + metaStormsCompareResult.getId() + File.separator;
		
		File file = new File(GlobalConstant.uploadDir + metaStormsCompareResult.getWorkShop().getOwner().getUserName() + File.separator + GlobalConstant.METASTORMSCOMPARE + File.separator);
		if (!file.exists()) {
			file.mkdir();
		}
		file = new File(outPath);
		if (!file.exists()) {
			file.mkdir();
		}
		
		PrintStream logPrintStream;
	    FileOutputStream logFileStream;	    
	    File logFile = new File(outPath + "list.text");
	    try {
			logFileStream = new FileOutputStream(logFile);
			logPrintStream = new PrintStream(logFileStream);
			logPrintStream.println(parallelResultPathes.toString());
	    	logPrintStream.flush();
	    	logPrintStream.close();
	    	String command = GlobalConstant.metaStomrsPath+"bin"+File.separator+"comp_sam -l " + outPath + "list.text -o " + outPath + GlobalConstant.METASTORMSCOMPAREFILETXT + " -t 8";
	    	
			
	    	System.out.println("command: " + command);
	    	
	    	Runtime r=Runtime.getRuntime();   
		    Process p=r.exec(command);		 	
		    p.waitFor();

		    String rScriptCommand = "perl " + GlobalConstant.METASEEPATH + "metastormscompareplot.pl " + GlobalConstant.METASEEPATH + " " + outPath;
		    System.out.println("rScriptCommand: " + rScriptCommand);
		    Runtime rMetaSee=Runtime.getRuntime();
		    Process pMetaSee=rMetaSee.exec(rScriptCommand);
		    pMetaSee.waitFor();
		    
		    File srcFile = new File(outPath);
		    String zipFilePath = outPath + File.separator + "compare.zip";
		    if(srcFile.exists()) {
		    	File[] files = srcFile.listFiles();
		    	(new ZipMaker()).compressFiles2Zip(files, zipFilePath);
		    }
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			this.setError();
		} catch (IOException e) {
			e.printStackTrace();
			this.setError();
		}catch (InterruptedException e) {
			e.printStackTrace();
			this.setError();
		}
	   
	}
	private void setError(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		metaStormsCompareResult.setError(1);
		s.update(metaStormsCompareResult);
		s.getTransaction().commit();
	}
	public MetaStormsCompareResult getMetaStormsCompareResult() {
		return metaStormsCompareResult;
	}
	public void setMetaStormsCompareResult(
			MetaStormsCompareResult metaStormsCompareResult) {
		this.metaStormsCompareResult = metaStormsCompareResult;
	}
}
