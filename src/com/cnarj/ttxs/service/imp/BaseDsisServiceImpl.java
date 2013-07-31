package com.cnarj.ttxs.service.imp;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.cnarj.ttxs.comm.Common;
import com.cnarj.ttxs.dao.BaseDsisDao;
import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.service.BaseDsisService;

public class BaseDsisServiceImpl<T, PK extends Serializable>implements BaseDsisService<T, PK>{

	private BaseDsisDao<T, PK> baseDao;
	
	public static Common common = new Common();
	
	
	
	public BaseDsisDao<T, PK> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDsisDao<T, PK> baseDao) {
		this.baseDao = baseDao;
	}
	
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


}
