package com.cnarj.ttxs.util;


import java.lang.reflect.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/*************************************************
md5 ��ʵ����RSA Data Security, Inc.���ύ��IETF
��RFC1321�е�MD5 message-digest �㷨��
*************************************************/

public class MD5 {
	
	public MD5(){
		
	}
	
	/**
	 * MD5���ܷ���
	 * method:getMD5ofStr
	 * @param srcstr
	 * @return
	 */
    public static String getMD5ofStr(String srcstr){
    	MessageDigest messageDigest;
    	String digestedPwdString="";
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(srcstr.getBytes());
        	byte[] bin = messageDigest.digest();
        	digestedPwdString=byte2hex(bin);
        	digestedPwdString=digestedPwdString.toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			digestedPwdString="";
		}
		return digestedPwdString;
    }
    
    /**
     * ��ת����ַ�������ʮ����Ƶ��ַ�
     * @param b
     * @return
     */
    private static String byte2hex(byte[] b){
        String hs="";
        String stmp="";
        for (int n=0; n<b.length; n++){
            stmp=(java.lang.Integer.toHexString(b[n] & 0xFF));   //toHexString:ת��16���ơ�b[n] & 0xff �������ǽ��з�ŵ�byte���ͱ���޷�����ͣ�ͨ�����������ô�������
                                                                 //����ֵ�����0-255�������ˡ����ת�к����С��16������ת�����ַ��ʱ��һ��0��ǰ�档����֤ÿ����ռ}���ַ� 
                                                                //    ����java���ṩ�޷������������ת������ʹ�á�
            if (stmp.length()==1) hs=hs+"0"+stmp;
                else hs=hs+stmp;                    
        }
        return hs;
    } 

    /**
     * ���Դ���
     * @param args
     */
    public static void main(String args[]) {
        MD5 m = new MD5(); 
		String str2 = MD5.getMD5ofStr("123456");
		System.out.println(str2);
    }

}

