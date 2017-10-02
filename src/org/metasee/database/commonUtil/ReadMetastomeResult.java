package org.metasee.database.commonUtil;

import org.metasee.database.commonUtil.constant.GlobalConstant;
import org.metasee.database.model.MetaStormsResult;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadMetastomeResult {
	private MetaStormsResult metaStormsResult;
	
	public void readDisplayTableInformation(){
		String fileName = GlobalConstant.uploadDir + metaStormsResult.getParallelMetaResult().getUploadFile().getUploadProject().getWorkShop().getOwner().getUserName() + File.separator + metaStormsResult.getParallelMetaResult().getUploadFile().getUploadProject().getRandomFileName() + File.separator + "metastorm" + File.separator+metaStormsResult.getId();
		String readContent;
		try{
			File file=new File(fileName);
			FileReader in=new FileReader(file);
			BufferedReader inTwo=new BufferedReader(in);
			StringBuffer stringbuffer= new StringBuffer();
			StringBuffer stringbuffermatch= new StringBuffer();
			String s=null;
			
			Pattern idp=Pattern.compile("Match (\\d)");
			Pattern metaidp=Pattern.compile("Sample path: .*?/([_\\.\\w]+)/([_\\.\\w]+)/([\\._\\w-]+)/parallel-meta$");
			Pattern scorep=Pattern.compile("Similarity: (.+)");
			
			while((s=inTwo.readLine())!=null){
				Matcher idm =idp.matcher(s);
				Matcher metaidm=metaidp.matcher(s);
				Matcher scorem=scorep.matcher(s);
				byte bb[]=s.getBytes();
				if(idm.find()){
					stringbuffermatch.append("<td>"+idm.group(1)+"</td>");
				}
				if(scorem.find()){
					stringbuffermatch.append("<td>"+scorem.group(1)+"</td>");
				}
				if(metaidm.find()){
					String metaMeshAcc = metaidm.group(1) + "_" + metaidm.group(3);
					stringbuffermatch.append("<td><a href=\"metasample/?acc="+metaMeshAcc+"\" target=\"_blank\">" + metaMeshAcc + "</a></td>");
					stringbuffer.append("<tr>"+stringbuffermatch+"</tr>");
					stringbuffermatch=new StringBuffer();
				}				
			}
			readContent=new String("<table style=\"width:700px; margin-left:20px;\" border=\"1\" align=\"center\" cellspacing=\"1\" cellpadding=\"3\"><tr><td>No.</td><td>Score</td><td>ACC</td></tr>"+stringbuffer+"</table>");
			if(readContent.equals("<table style=\"width:700px; margin-left:20px;\" border=\"1\" align=\"center\" cellspacing=\"1\" cellpadding=\"3\"><tr><td>No.</td><td>Score</td><td>ACC</td></tr></table>")){
				readContent=new String("<h3>Sorry, no similar record was found.</h3>");
			}
		}catch(IOException e){
			readContent="";
		}
		metaStormsResult.setDisplayTableInformation(readContent);
	}

	public MetaStormsResult getMetaStormsResult() {
		return metaStormsResult;
	}

	public void setMetaStormsResult(MetaStormsResult metaStormsResult) {
		this.metaStormsResult = metaStormsResult;
	}
	
}
