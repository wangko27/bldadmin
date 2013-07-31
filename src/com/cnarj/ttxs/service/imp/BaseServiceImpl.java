package com.cnarj.ttxs.service.imp;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.cnarj.ttxs.comm.Common;
import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.service.IBaseService;


/**
 * Service实现类 - Service实现类基类
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月24日11:22:09
 */

public class BaseServiceImpl<T, PK extends Serializable> implements IBaseService<T, PK> {

	private IBaseDao<T, PK> baseDao;
	
	public IBaseDao<T, PK> getBaseDao() {		return baseDao;	}
	public void setBaseDao(IBaseDao<T, PK> baseDao) {		this.baseDao = baseDao;	}
	public static Common common = new Common();

	public T get(PK id) {
		return baseDao.get(id);
	}

	public T load(PK id) {
		return baseDao.load(id);
	}
	
	public List<T> get(PK[] ids) {
		return baseDao.get(ids);
	}
	
	public T get(String propertyName, Object value) {
		return baseDao.get(propertyName, value);
	}
	
	public List<T> getList(String propertyName, Object value) {
		return baseDao.getList(propertyName, value);
	}

	public List<T> getList(String propertyName, Object value, String oderyPropertypeName, String orderType) {
		return baseDao.getList(propertyName, value, oderyPropertypeName, orderType);
	}
	
	public List<T> getAll() {
		return baseDao.getAll();
	}
	
	public Long getTotalCount() {
		return baseDao.getTotalCount();
	}
	
	public Long getTotalCount(String propertyName, Object value){
		return baseDao.getTotalCount(propertyName, value);
	}

	public boolean isUnique(String propertyName, Object oldValue, Object newValue) {
		return baseDao.isUnique(propertyName, oldValue, newValue);
	}
	
	public boolean isExist(String propertyName, Object value) {
		return baseDao.isExist(propertyName, value);
	}

	public PK save(T entity) {
		return baseDao.save(entity);
	}

	public void update(T entity) {
	
		baseDao.update(entity);
	}

	public void delete(T entity) {
		baseDao.delete(entity);
	}

	public void delete(PK id) {
		baseDao.delete(id);
	}

	public void delete(PK[] ids) {
		baseDao.delete(ids);
	}
	
	public void flush() {
		baseDao.flush();
	}

	public void clear() {
		baseDao.clear();
	}
	
	public void evict(Object object) {
		baseDao.evict(object);
	}

	public Result findByPager(Page pager) {
		return baseDao.findByPager(pager);
	}
	
	public Result findByPager(Page pager, DetachedCriteria detachedCriteria) {
		return baseDao.findByPager(pager, detachedCriteria);
	}
	
	public boolean isExist(Hashtable<String, Object> table1) {
		// TODO Auto-generated method stub
		return baseDao.isExist(table1);
	}
	public T get(Hashtable<String, Object> table) {
		// TODO Auto-generated method stub
		return baseDao.get(table);
	}
	public List<T> getList(Hashtable<String, Object> table) {
		// TODO Auto-generated method stub
		return baseDao.getList(table);
	}
	public List<T> getList(String hql) {
		// TODO Auto-generated method stub
		return baseDao.getList(hql);
	}
	public int delete(Hashtable<String, Object> table) {
		// TODO Auto-generated method stub
		return baseDao.delete(table);
	}

}
