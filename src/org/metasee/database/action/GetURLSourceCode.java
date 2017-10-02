package org.metasee.database.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.opensymphony.xwork2.ActionSupport;

public class GetURLSourceCode  extends SuperClass{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String sourceURL;
	public String sourceCode;
	
	public String javaGetSourceCode(){
		URL url;
		try {
			url=new URL(sourceURL);
			HttpURLConnection connection=(HttpURLConnection)url.openConnection();
			connection.setConnectTimeout(20000);
			InputStream is=connection.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(is, "UTF-8"));
			StringBuffer sb=new StringBuffer();
			String line=null;
			while((line=br.readLine())!=null){
				if("" != line && null != line && "\n" != line && " " != line){
					sb.append(line +"\n");
				}
			}
			this.sourceCode=sb.toString();
			sourceCode = sourceCode.replaceAll("<!DOCTYPE metasee SYSTEM \\\"http://www.metasee.org/xmldtd/metasee1.1.dtd\\\">\n", "");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String getSourceCode() {
		return sourceCode;
	}
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	
	public String getSourceURL() {
		return sourceURL;
	}
	public void setSourceURL(String sourceURL) {
		this.sourceURL = sourceURL;
	}
	
}
