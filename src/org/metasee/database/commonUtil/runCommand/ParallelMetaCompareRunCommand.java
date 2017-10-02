package org.metasee.database.commonUtil.runCommand;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.metasee.database.model.ParallelMetaCompareResult;
import org.metasee.database.model.ParallelMetaResult;
import org.metasee.database.util.HibernateUtil;
import org.metasee.database.commonUtil.constant.*;
public class ParallelMetaCompareRunCommand extends Thread{
	ParallelMetaCompareResult parallelMetaCompareResult = new ParallelMetaCompareResult();
	
	public void run(){
		StringBuffer parallelResultPathes = new StringBuffer();
		for(ParallelMetaResult parallelMetaResult : parallelMetaCompareResult.getParallelMetaResults()){
			parallelResultPathes.append(GlobalConstant.uploadDir + parallelMetaCompareResult.getWorkShop().getOwner().getUserName() + 
					File.separator + parallelMetaResult.getUploadFile().getUploadProject().getRandomFileName() + File.separator +
					parallelMetaResult.getFoldername() + File.separator + "classification.txt\n");
		}
		String outPath = GlobalConstant.uploadDir + parallelMetaCompareResult.getWorkShop().getOwner().getUserName() + File.separator + GlobalConstant.PARALLELMETACOMPARE + File.separator + parallelMetaCompareResult.getId() + File.separator;
		
		System.out.println("parallelResultPathes" + parallelResultPathes.toString());
		
		File file = new File(GlobalConstant.uploadDir + parallelMetaCompareResult.getWorkShop().getOwner().getUserName() + File.separator + GlobalConstant.PARALLELMETACOMPARE + File.separator);
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
	    	String command = GlobalConstant.parallelmetapath+"bin"+File.separator+"class-tax -l " + outPath + "list.text -o " + outPath;
	    	System.out.println("command: " + command);
	    	Runtime r=Runtime.getRuntime();   
		    Process p=r.exec(command);		 	
		    p.waitFor();
		    String metaSeeCommand = "perl " + GlobalConstant.METASEEPATH + "WorkShopMetaSee.pl " + GlobalConstant.METASEEPATH + " " + outPath;
		    System.out.println("metaSeeCommand: " + metaSeeCommand);
		    
		    Runtime rMetaSee=Runtime.getRuntime();
		    Process pMetaSee=rMetaSee.exec(metaSeeCommand);
		    pMetaSee.waitFor();
		    
		    File srcFile = new File(outPath);
		    String zipFilePath = outPath + File.separator + "combine.zip";
		    if(srcFile.exists()) {
		    	File[] files = srcFile.listFiles();
		    	(new ZipMaker()).compressFiles2Zip(files, zipFilePath);
		    }
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.setError();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.setError();
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.setError();
		}
	   
	}
	private void setError(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		parallelMetaCompareResult.setError(1);
		s.update(parallelMetaCompareResult);
		s.getTransaction().commit();
	}

	public ParallelMetaCompareResult getParallelMetaCompareResult() {
		return parallelMetaCompareResult;
	}

	public void setParallelMetaCompareResult(
			ParallelMetaCompareResult parallelMetaCompareResult) {
		this.parallelMetaCompareResult = parallelMetaCompareResult;
	}
		
	
}
