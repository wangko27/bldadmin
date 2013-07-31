package com.cnarj.ttxs.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

/**
 * 邮件工具类
 * @author hedan
 *
 */
public class MailUtil {
	
	protected static Logger logger = Logger.getLogger(MailUtil.class);

	/**
	 * 发送邮件
	 * @param subject 主题
	 * @param toEmail 收件人邮箱
	 */
	public static void sendMail(String subject,String content, String contentType, String toEmail){
		Properties properties = null;
		Session mailSession = null;
		Message message = null;
		PropertiesBean propertiesBean = null;
		Transport transport = null;
		try {
			logger.info("邮件发送开始");
			propertiesBean = PropertiesUtil.getPropertiesInfo();//获得配置信息
			properties = new Properties();
			properties.put("mail.smtp.host",propertiesBean.getMailSmtpHost());//指定SMTP服务器
			properties.put("mail.smtp.auth",propertiesBean.getMailSmtpAuth());//指定是否需要SMTP验证
//			properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//			properties.setProperty("mail.smtp.socketFactory.fallback", "false");
//			properties.setProperty("mail.smtp.port", propertiesBean.getMailSmtpPort());
//			properties.setProperty("mail.smtp.socketFactory.port", propertiesBean.getMailSmtpPort());

			mailSession = Session.getDefaultInstance(properties);
			mailSession.setDebug(false);//是否在控制台显示debug信息
			
			message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress(propertiesBean.getEmailServer()));//设置发件人
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));//设置收件人
			message.setSubject(subject);//设置邮件主题
			message.setContent(content,contentType);//设置信件内容及格式
			
			transport = mailSession.getTransport("smtp");
			//设置服务器以及账号和密码
			transport.connect(propertiesBean.getMailSmtpHost(), Integer.parseInt(propertiesBean.getMailSmtpPort()), propertiesBean.getEmailUsername(), propertiesBean.getEmailPassword());
			transport.sendMessage(message, message.getAllRecipients());
			logger.info("邮件发送成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("提示：邮件下发出错了 Err:"+e.getMessage());
			throw new BusinessException("提示：邮件下发出错了 Err:"+e.getMessage());
		}finally{
			try {
				transport.close();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}
	
//	public static void main(String[] args) {
//		StringBuffer  content = new StringBuffer("");
//		content.append("尊敬的贺丹　　　先生，您好！<br/>");
//		content.append("您的招行YOUNG卡信用卡黑色信用卡邮寄后退回，请您拨打客服热线进行处理，谢谢！<br/>");
//		content.append("招行信用卡客服热线：4008205555-714 <br/>");
//		content.append("招行商务卡客服热线：4008205558-702");
//		sendMail("爱瑞杰天天向上会员注册验证码", content.toString(), "text/html;charset=gbk;", "290815671@qq.com");
//	}
}
