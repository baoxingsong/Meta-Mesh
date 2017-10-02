package org.metasee.database.commonUtil;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadFileAction extends ActionSupport {
	// 文件下载的路径,在struts.xml文件中,参数为upload文件夹
	private String inputPath;
	// 下载文件时,在客户端显示的下载文件名称
	private String fileName;
	// 需要下载的文件名称,下载文件时 需要传进的参数名称
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
	//验证需要下载的文件是否符合要求
	public String isValidate() throws Exception {
		if (downName == null || downName.trim().equals("")) {
			return ERROR;
		}
		//验证需要下载的文件是否存在,默认为已经存在了
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
