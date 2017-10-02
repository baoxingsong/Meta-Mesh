package org.metasee.database.commonUtil.runCommand;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.metasee.database.commonUtil.constant.GlobalConstant;

import org.metasee.database.action.SampleMetaStormsAction;

public class SampleMetaStormsRunCommand extends Thread{
	SampleMetaStormsAction sampleMetaStormsAction = new SampleMetaStormsAction();
	public SampleMetaStormsRunCommand(SampleMetaStormsAction sampleMetaStormsAction){
		this.sampleMetaStormsAction = sampleMetaStormsAction;
	}
	public void run(){
		try {
			this.runMetaStorms();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void runMetaStorms()  throws Exception{ 
		StringBuffer comman=new StringBuffer();
		comman.append(org.metasee.database.commonUtil.constant.GlobalConstant.metaStomrsPath+"bin"+File.separator+"query_index -i ");

		String outPath = GlobalConstant.sampleMetaStormsTemp + sampleMetaStormsAction.getUuid() + File.separator;	
	
		comman.append(GlobalConstant.AllparallelMetaResult + sampleMetaStormsAction.getSourceDatabase() + File.separator + sampleMetaStormsAction.getSourceId() + File.separator + sampleMetaStormsAction.getSourceAcc() + File.separator + "parallel-meta" + File.separator + "classification.txt");
		comman.append(" -o " + outPath + GlobalConstant.METASTORMS);
		
		comman.append(" -d " + org.metasee.database.commonUtil.constant.GlobalConstant.webroot+"metastormdatabase"+" -n " + sampleMetaStormsAction.getHitNumber()+" -t 8");
		if(sampleMetaStormsAction.getDatabase().equals("1") || sampleMetaStormsAction.getDatabase().equals("0")){
			comman.append(" -g " + sampleMetaStormsAction.getDatabase());
		}
		if(sampleMetaStormsAction.getExhaustiveSearch().endsWith("y")){
			comman.append(" -e");
		}
		
		String metaStomrsCommand=comman.toString();
		System.out.println("metaStomrsCommand" + metaStomrsCommand);
		
		File file = new File(outPath);
		if (!file.exists()) {
			 file.mkdir();
		}
		Runtime r=Runtime.getRuntime();
		
		Process p=r.exec(metaStomrsCommand);   
		BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream())); 
		BufferedReader er=new BufferedReader(new InputStreamReader(p.getErrorStream()));
		String inline;   
		while(null!=(inline=br.readLine())){   
			 System.out.println(inline);
		}   
		while(null!=(inline=er.readLine())){   
			System.out.println(inline);
		}
		p.waitFor();
		 
		File logFile = new File(outPath + GlobalConstant.METASTORMS);
		FileOutputStream logFileStream = new FileOutputStream(logFile,true);
		PrintStream logPrintStream = new PrintStream(logFileStream);
		logPrintStream.print("metaStomrsCommand: " + metaStomrsCommand);
		
		
	}
}