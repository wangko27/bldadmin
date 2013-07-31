package com.cnarj.ttxs.util;

import java.util.Random;

public class ValidateUtil {

	public final static String  VALIDATE_SESSION_KEY = "autoKey";//存放在session中的key
	
	/**
	 * 获得六位数的验证码
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public static String getRandSixKey()throws Exception{
		
		Random random = new Random();
		String sRand = "";
		String rand = null;
		for(int i=0; i<6; i++){
			rand = String.valueOf(random.nextInt(10));
			sRand += rand;
		}
		return sRand;
	}
	
	
}
