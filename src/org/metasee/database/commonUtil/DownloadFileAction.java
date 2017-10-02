package org.metasee.database.commonUtil;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadFileAction extends ActionSupport {
	// �ļ����ص�·��,��struts.xml�ļ���,����Ϊupload�ļ���
	private String inputPath;
	// �����ļ�ʱ,�ڿͻ�����ʾ�������ļ�����
	private String fileName;
	// ��Ҫ���ص��ļ�����,�����ļ�ʱ ��Ҫ�����Ĳ�������
	private String downName;

	public String getDownName() {
		return downName;
	}

	public void setDownName(String downName) {
		this.downName = downName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	public String getInputPath() {
		return inputPath;
	}
	//��֤��Ҫ���ص��ļ��Ƿ����Ҫ��
	public String isValidate() throws Exception {
		if (downName == null || downName.trim().equals("")) {
			return ERROR;
		}
		//��֤��Ҫ���ص��ļ��Ƿ����,Ĭ��Ϊ�Ѿ�������
		boolean isExitst = true;
		if (isExitst) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public InputStream getTargetFile() throws Exception {
		inputPath = this.getInputPath() + "\\" + downName;
		this.setFileName(downName);
		return ServletActionContext.getServletContext().getResourceAsStream(
				this.getInputPath());
	}

}
