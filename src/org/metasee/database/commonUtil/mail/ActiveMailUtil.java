package org.metasee.database.commonUtil.mail;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.metasee.database.commonUtil.constant.*;

public class ActiveMailUtil {
	private String targetEmail;  
	private String message;
	private String subject = "Active your " + GlobalConstant.webTitle + " account";
	
	public void run() throws EmailException {  
		  HtmlEmail email = new HtmlEmail();  
          email.setHostName("mail.cstnet.cn");//
          email.setAuthentication("songbx@qibebt.ac.cn", "yifeiren07");//
          email.addTo(targetEmail,"Meta-BLAST");//
          email.setFrom("meta-mesh@qibebt.ac.cn", GlobalConstant.webTitle);//
          email.setSubject(subject);//锟斤拷锟斤拷  
          email.setCharset("UTF-8");//锟斤拷锟斤拷锟绞� 
          email.setHtmlMsg(message);//锟斤拷锟斤拷  
          email.send();//锟斤拷锟斤拷  
    }
	
	public String getTargetEmail() {
		return targetEmail;
	}
	public void setTargetEmail(String targetEmail) {
		this.targetEmail = targetEmail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}