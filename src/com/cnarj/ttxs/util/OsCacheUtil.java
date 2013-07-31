package com.cnarj.ttxs.util;

import java.util.Date;

import com.opensymphony.oscache.base.NeedsRefreshException;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;

/**
 * 工具类--缓存
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author hedan
 * @version 1.0
 * @since 2011年6月28日11:22:09
 */
public class OsCacheUtil{
	
	public static final String GENERAL_CACHE_ADMINISTRATOR_BEAN_NAME = "cacheManager";// GeneralCacheAdministrator注入Bean名称

	private GeneralCacheAdministrator generalCacheAdministrator;
	
	public OsCacheUtil(){
		if(generalCacheAdministrator == null){
			generalCacheAdministrator = (GeneralCacheAdministrator)ApplicationContextFactory.getBean(GENERAL_CACHE_ADMINISTRATOR_BEAN_NAME);
		}
	}
	
	/**
	 * 根据Key读取缓存
	 * 
	 * @return 缓存对象
	 */
	public Object getFromCache(String key) throws Exception {
		Object object = null;
		try {
			object = generalCacheAdministrator.getFromCache(key);
		} catch (NeedsRefreshException e) {
			generalCacheAdministrator.cancelUpdate(key);
		}
		
		return object;
	}

	/**
	 * 加入对象到缓存
	 * 
	 */
	public void putInCache(String key , Object object){
		generalCacheAdministrator.putInCache(key, object);
	}
	
	/**
	 * 根据Key刷新缓存对象
	 * 
	 */
	public void flushEntry(String key){
		generalCacheAdministrator.flushEntry(key);
	}
	
	/**
	 * 刷新组对象
	 * @param group
	 */
	public void flushGroup(String group){
		generalCacheAdministrator.flushGroup(group);
	}
	
	/**
	 * 刷新所有对象
	 */
	public void flushAll(){
		generalCacheAdministrator.flushAll();
	}
	
	/**
	 * 根据时间段刷新缓存
	 * @param date
	 */
	public void flushAll(Date date){
		generalCacheAdministrator.flushAll(date);
	}

}
