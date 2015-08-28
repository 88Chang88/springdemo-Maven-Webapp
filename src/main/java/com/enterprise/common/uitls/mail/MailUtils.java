package com.enterprise.common.uitls.mail;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;




public class MailUtils {
	
	public static Session createSession(String host,final String userName,final String password){
		
		Properties props =new Properties();
		//设置邮件服务器地址
		props.setProperty("mail.smtp.host", host);
		props.setProperty("mail.smtp.port", "25");
		//设置邮件服务器是否需要登录认证
		props.setProperty("mail.smtp.auth", "true");
		//创建认证器
		Authenticator auth =new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};
		//创建Session对象
		return Session.getInstance(props,auth);
	}
	
	/**
	 * 
	 * 发送指定邮件
	 * 
	 * @param session
	 * @param mail
	 * @throws MessagingException 
	 * @throws AddressException 
	 * @throws IOException 
	 */
	public static void send(Session session,Mail mail) throws AddressException, MessagingException, IOException{
		
		//
		MimeMessage msg=new MimeMessage(session);
		
		//
		msg.setFrom(new InternetAddress(mail.getFrom()));
		
		//
		msg.addRecipients(RecipientType.TO, mail.getToAddress());
		
		//
		String cc=mail.getCcAddress();
		if(!cc.isEmpty()){
			msg.addRecipients(RecipientType.CC, cc);
		}
		
		//
		String bcc=mail.getBccAddress();
		if(!bcc.isEmpty()){
			msg.addRecipients(RecipientType.BCC, bcc);
		}
		
		//
		msg.setSubject(mail.getSubject());
		
		//
		MimeMultipart parts = new MimeMultipart();// 创建部件集对象

		MimeBodyPart part = new MimeBodyPart();// 创建一个部件
		part.setContent(mail.getContent(), "text/html;charset=utf-8");// 设置邮件文本内容
		parts.addBodyPart(part);// 把部件添加到部件集中
		
		// 添加附件
		List<AttachBean> attachBeanList = mail.getAttachs();// 获取所有附件
		if (attachBeanList != null) {
			for (AttachBean attach : attachBeanList) {
				MimeBodyPart attachPart = new MimeBodyPart();// 创建一个部件
				attachPart.attachFile(attach.getFile());// 设置附件文件
				attachPart.setFileName(MimeUtility.encodeText(attach
						.getFileName()));// 设置附件文件名
				String cid = attach.getCid();
				if(cid != null) {
					attachPart.setContentID(cid);
				}
				parts.addBodyPart(attachPart);
			}
		}

		msg.setContent(parts);// 给邮件设置内容
		Transport.send(msg);// 发邮件
		
	}

}
