package org.metasee.database.commonUtil;
import java.io.File;
public class DeleteFile extends Thread {
	public static void main(String[] args) {
		   DeleteFile deleteFile = new DeleteFile("/home/songbaoxing/Downloads/Workspaces");
		   deleteFile.start();
	}
	String sPath;
	public DeleteFile(String sPath){
		this.sPath = sPath;
	}
	public void run(){
		File file = new File(sPath);
		if (file.isFile()) {
           deleteFile(sPath);   
        } else {
           deleteDirectory(sPath);   
        }
	}
	private void deleteDirectory(String sPath) {
		if (!sPath.endsWith(File.separator)) {   
	        sPath = sPath + File.separator;   
	    }   
	    File dirFile = new File(sPath);
	    File[] files = dirFile.listFiles();
	    for (int i = 0; i < files.length; i++) {   
	        if (files[i].isFile()) {   
	            deleteFile(files[i].getAbsolutePath());   
	        } else {   
	           deleteDirectory(files[i].getAbsolutePath());
	           files[i].delete();
	        }  
	    }
	    dirFile.delete();
	}
	private void deleteFile(String sPath) {
		File file = new File(sPath);
		file.delete();		
	}
}
