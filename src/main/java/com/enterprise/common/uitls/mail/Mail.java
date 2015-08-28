package com.enterprise.common.uitls.mail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Mail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String from;
	
	private StringBuilder toAddress=new StringBuilder();
	
	private StringBuilder ccAddress=new StringBuilder();
	
	private StringBuilder bccAddress=new StringBuilder();
	
	private String subject;
	
	private String content;
	
	private List<AttachBean> attachList=new ArrayList<AttachBean>();

	public Mail() {
		super();
	}

	public Mail(String from, StringBuilder toAddress) {
		super();
		this.from = from;
		this.toAddress = toAddress;
	}

	public Mail(String from, StringBuilder toAddress, StringBuilder ccAddress,
			StringBuilder bccAddress, String subject, String content,
			List<AttachBean> attachList) {
		super();
		this.from = from;
		this.toAddress = toAddress;
		this.ccAddress = ccAddress;
		this.bccAddress = bccAddress;
		this.subject = subject;
		this.content = content;
		this.attachList = attachList;
	}

	@Override
	public String toString() {
		return "Mail [from=" + from + ", toAddress=" + toAddress
				+ ", ccAddress=" + ccAddress + ", bccAdress=" + bccAddress
				+ ", subject=" + subject + ", content=" + content
				+ ", attachList=" + attachList + "]";
	}

	/**
	 * 返回发件人
	 * @return
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	
	/**
	 * 返回发件人
	 * @return
	 */
	public String getFrom() {
		return from;
	}
	
	/**
	 * 返回主题
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * 设置主题
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 获取主题内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置主题内容
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取收件人
	 * @return
	 */
	public String getToAddress() {
		return toAddress.toString();
	}

	/**
	 * 获取抄送
	 * @return
	 */
	public String getCcAddress() {
		return ccAddress.toString();
	}

	/**
	 * 获取暗送
	 * @return
	 */
	public String getBccAddress() {
		return bccAddress.toString();
	}

	/**
	 * 添加收件人,可以是多个收件人
	 * @param to
	 */
	public void addToAddress(String to) {
		if(this.toAddress.length() > 0) {
			this.toAddress.append(",");
		}
		this.toAddress.append(to);
	}

	/**
	 * 添加抄送人，可以是多个抄送人
	 * @param cc
	 */
	public void addCcAddress(String cc) {
		if(this.ccAddress.length() > 0) {
			this.ccAddress.append(",");
		}
		this.ccAddress.append(cc);
	}

	/**
	 * 添加暗送人，可以是多个暗送人
	 * @param bcc
	 */
	public void addBccAddress(String bcc) {
		if(this.bccAddress.length() > 0) {
			this.bccAddress.append(",");
		}
		this.bccAddress.append(bcc);
	}
	
	/**
	 * 添加附件，可以添加多个附件
	 * @param attachBean
	 */
	public void addAttach(AttachBean attachBean) {
		this.attachList.add(attachBean);
	}
	
	/**
	 * 获取所有附件
	 * @return
	 */
	public List<AttachBean> getAttachs() {
		return this.attachList;
	}
	
	

}
