package com.cnarj.ttxs.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * 该类为读取要过滤的次或词组(评论那块)
 * @author Administrator
 *
 */
public class ReadCharacterInfo {

	private List<String> charaList=null;//存放空间

	private void getChara(){
		//读取属性文件
		Properties pro=new Properties();
		charaList=new ArrayList<String>();
		try {
			pro.load(this.getClass().getResourceAsStream("/charaFilter.properties"));
			//System.out.println(pro.getProperty("3"));
			Set set=pro.keySet();
			for(Iterator iter=set.iterator();iter.hasNext();){
				//System.out.println(iter.next());
				charaList.add(pro.getProperty((String) iter.next()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ReadCharacterInfo() {
		getChara();
	}

	public List<String> getCharaList() {
		//System.out.println(charaList.get(1));
		return charaList;
	}

	public void setCharaList(List<String> charaList) {
		this.charaList = charaList;
	}
}
