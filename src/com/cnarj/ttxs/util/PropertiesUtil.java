package com.cnarj.ttxs.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 属性配置文件工具类
 * @author hedan
 *
 */
public class PropertiesUtil {


	/**
	 * 获得properties属性文件信息
	 * @return
	 */
	public static PropertiesBean getPropertiesInfo(){
		PropertiesBean propertiesBean = new PropertiesBean();
		InputStream in = null;
		Properties p = new Properties();
		try {
			in = PropertiesUtil.class.getResourceAsStream("/mail.properties");
			p.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		propertiesBean.setMailSmtpHost(p.getProperty("mail.smtp.host", "smtp.163.com").trim());
		propertiesBean.setMailSmtpAuth(p.getProperty("mail.smtp.auth", "true").trim());
		propertiesBean.setMailSmtpPort(p.getProperty("mail.smtp.port", "25").trim());
		propertiesBean.setEmailServer(p.getProperty("email.server", "heyuhan1688@163.com").trim());
		propertiesBean.setEmailUsername(p.getProperty("email.username", "heyuhan1688").trim());
		propertiesBean.setEmailPassword(p.getProperty("email.password", "430902").trim());
		return propertiesBean;
	}
}
