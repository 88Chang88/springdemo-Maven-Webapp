package com.enterprise.common.uitls.mail;

import java.io.File;
import java.io.Serializable;

public class AttachBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cid;//文件ID
	
	private File file;//文件内容
	
	private String fileName;//文件名

	@Override
	public String toString() {
		return "AttachBean [cid=" + cid + ", file=" + file + ", fileName="
				+ fileName + "]";
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public AttachBean(String cid, File file, String fileName) {
		super();
		this.cid = cid;
		this.file = file;
		this.fileName = fileName;
	}

	public AttachBean() {
		super();
	}

}
