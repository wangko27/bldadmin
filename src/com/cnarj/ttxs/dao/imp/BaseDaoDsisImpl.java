package com.cnarj.ttxs.dao.imp;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.BaseDsisDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.Page.OrderType;
import com.cnarj.ttxs.util.LogUtil;
import com.cnarj.ttxs.util.PageUtil;

public class BaseDaoDsisImpl<T, PK extends Serializable> implements BaseDsisDao<T, PK> {

	private Class<T> entityClass;
	protected SessionFactory dsisSessionFactory;
	
	protected JdbcTemplate dsisJdbcTemplate;

	@SuppressWarnings("unchecked")
	public BaseDaoDsisImpl() {
		this.entityClass = null;
        Class c = getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            this.entityClass = (Class<T>) parameterizedType[0];
        }
	}

	public void setDsisSessionFactory(SessionFactory dsisSessionFactory) {
		this.dsisSessionFactory = dsisSessionFactory;
	}
	

	public void setDsisJdbcTemplate(JdbcTemplate dsisJdbcTemplate) {
		this.dsisJdbcTemplate = dsisJdbcTemplate;
	}

	protected Session getSession() {
		return dsisSessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T get(PK id) {
		Assert.notNull(id, "id is required");
		return (T) getSession().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public T load(PK id) {
		Assert.notNull(id, "id is required");
		return (T) getSession().load(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> get(PK[] ids) {
		Assert.notEmpty(ids, "ids must not be empty");
		String hql = "from " + entityClass.getName() + " as model where model.id in(:ids)";
		return getSession().createQuery(hql).setParameterList("ids", ids).list();
	}

	@SuppressWarnings("unchecked")
	public T get(String propertyName, Object value) {
		Assert.hasText(propertyName, "propertyName must not be empty");
		Assert.notNull(value, "value is required");
		String hql = " from " + entityClass.getName() + " as model where model." + propertyName + " = ?";
		return (T) getSession().createQuery(hql).setParameter(0, value).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getList(String propertyName, Object value) {
		Assert.hasText(propertyName, "propertyName must not be empty");
//		Assert.notNull(value, "value is required");
		String hql = "from " + entityClass.getName() + " as model where model." + propertyName;
		if(null == value || String.valueOf(value).length() == 0){
			hql += " is null or model."+propertyName+" = ''";
			return getSession().createQuery(hql).list();
		}
		else{
			hql += " = ?";
			return getSession().createQuery(hql).setParameter(0, value).list();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getList(String hql){
		Assert.notNull(hql, "hql is required");
		return getSession().createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		String hql = "from " + entityClass.getName();
		return getSession().createQuery(hql).list();
	}
	
	public Long getTotalCount() {
		String hql = "select count(*) from " + entityClass.getName();
		return (Long) getSession().createQuery(hql).uniqueResult();
	}
	
	public Long getTotalCount(String propertyName, Object value) {
		Assert.hasText(propertyName, "propertyName must not be empty");
		Assert.notNull(value, "value is required");
		String hql = "select count(*) from " + entityClass.getName() + " as model where model." + propertyName + " = ?";
		
		return (Long) getSession().createQuery(hql).setParameter(0, value).uniqueResult();
	}

	public boolean isUnique(String propertyName, Object oldValue, Object newValue) {
		Assert.hasText(propertyName, "propertyName must not be empty");
		Assert.notNull(newValue, "newValue is required");
		if (newValue == oldValue || newValue.equals(oldValue)) {
			return true;
		}
		if (newValue instanceof String) {
			if (oldValue != null && StringUtils.equalsIgnoreCase((String) oldValue, (String) newValue)) {
				return true;
			}
		}
		T object = get(propertyName, newValue);
		return (object == null);
	}
	
	public boolean isExist(String propertyName, Object value) {
		Assert.hasText(propertyName, "propertyName must not be empty");
		Assert.notNull(value, "value is required");
		T object = get(propertyName, value);
		return (object != null);
	}

	@SuppressWarnings("unchecked")
	public PK save(T entity) {
		Assert.notNull(entity, "entity is required");
		return (PK) getSession().save(entity);
	}

	public void update(T entity) {
		Assert.notNull(entity, "entity is required");
		getSession().update(entity);
	}

	public void delete(T entity) {
		Assert.notNull(entity, "entity is required");
		getSession().delete(entity);
	}

	public void delete(PK id) {
		Assert.notNull(id, "id is required");
		T entity = load(id);
		getSession().delete(entity);
	}

	public void delete(PK[] ids) {
		Assert.notEmpty(ids, "ids must not be empty");
		for (PK id : ids) {
			T entity = load(id);
			getSession().delete(entity);
		}
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	public void evict(Object object) {
		Assert.notNull(object, "object is required");
		getSession().evict(object);
	}
	
	public Result findByPager(Page pager) {
		if (pager == null) {
			pager = new Page();
		}
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(entityClass);
		return findByPager(pager, detachedCriteria);
	}

	public Result findByPager(Page pager, DetachedCriteria detachedCriteria) {
		if (pager == null) {
			pager = new Page();
		}
		int beginIndex = pager.getBeginIndex();//当前页
		int pageSize = pager.getEveryPage();// 每页记录数
		String property = pager.getProperty();// 查找属性名称
		String keyword = pager.getKeyword();// 查找关键字
		String orderBy = pager.getOrderBy();// 排序字段
		OrderType orderType = pager.getOrderType();// 排序方式
//		Integer totalCount = pager.getTotalCount();
		
		Criteria criteria = detachedCriteria.getExecutableCriteria(getSession());
		if (StringUtils.isNotEmpty(property) && StringUtils.isNotEmpty(keyword)) {
			String propertyString = "";
			if (property.contains(".")) {
				String propertyPrefix = StringUtils.substringBefore(property, ".");
				String propertySuffix = StringUtils.substringAfter(property, ".");
				criteria.createAlias(propertyPrefix, "model");
				propertyString = "model." + propertySuffix;
			} else {
				propertyString = property;
			}
			criteria.add(Restrictions.like(propertyString, "%" + keyword + "%"));
		}
		
		
		criteria.setProjection(null);
		criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		criteria.setFirstResult(beginIndex);
		criteria.setMaxResults(pageSize);
		if (StringUtils.isNotEmpty(orderBy) && orderType != null) {
			if (orderType == OrderType.asc) {
				criteria.addOrder(Order.asc(orderBy));
			} else {
				criteria.addOrder(Order.desc(orderBy));
			}
		}
		
		Result result = new Result();
		result.setPage(pager);
		result.setContent(criteria.list());
		return result;
	}
	
	
	/**
	 * 根据Page和sql语句进行查询(提供分页、查找、排序功能).
	 * 不需要先查询数据条数
	 * 
	 * @param pager
	 *            Pager对象
	 * @param sql
	 * 			  sql语句
	 * @return Pager对象
	 */
	protected Result findByPager(Page pager, String sql) {
		try{
			//查总数
			StringBuffer count= new StringBuffer();
			count.append("select count(*) ");
			sql = sql.substring(sql.indexOf("from"));
			count.append(sql);

			//总数目
			Long totalRecords =(Long)getSession().createQuery(count.toString()).uniqueResult();
			pager.setTotalCount(totalRecords.intValue());

			//创建页面
			pager = PageUtil.createPage(pager, totalRecords.intValue()); 
			
			//查分页数据
			List list=null;
			int first = 0,max = 0;
			first = (pager.getCurrentPage() - 1) * pager.getEveryPage();
			max = pager.getEveryPage();
			if(first<0){
				first=0;
			}
			try{
				list=this.getSession().createQuery(sql)
				.setFirstResult(first)
				.setMaxResults(max)
				.list();
			}catch(Exception ex){
				ex.printStackTrace();
			}
	
			Result result = new Result();
			result.setPage(pager);
			result.setContent(list);
			return result;
		}catch(Exception e){
			LogUtil.logger.error("basedao分页查询错误!");
			e.printStackTrace();
			
			return null;
		}
	}
	

	protected Result findByPager(Page pager, String hql,List values) {
		try{
			//查总数
			StringBuffer count= new StringBuffer();
			count.append("select count(*) ");
			hql = hql.substring(hql.indexOf("from"));
			count.append(hql);
			
			Query query = getSession().createQuery(count.toString());
			for(int i = 0;i < values.size();i++){
				query.setParameter(i, values.get(i));
			}
			
			//总数目
			Long totalRecords =(Long)query.uniqueResult();
			pager.setTotalCount(totalRecords.intValue());
			
			//创建页面
			pager = PageUtil.createPage(pager, totalRecords.intValue()); 
			
			//查分页数据
			List list=null;
			int first = 0,max = 0;
			first = (pager.getCurrentPage() - 1) * pager.getEveryPage();
			max = pager.getEveryPage();
			if(first<0){
				first=0;
			}
			try{
				Query query_ = getSession().createQuery(hql);
				for(int i = 0;i < values.size();i++){
					query_.setParameter(i, values.get(i));
				}
				
				list=query_.setFirstResult(first)
				.setMaxResults(max)
				.list();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			Result result = new Result();
			result.setPage(pager);
			result.setContent(list);
			return result;
		}catch(Exception e){
			LogUtil.logger.error("basedao分页查询错误!");
			e.printStackTrace();
			
			return null;
		}
	}
	
	/**
	 * jdbc分页查询
	 * @param pager
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result findByPagerForJdbc(Page pager, String sql) {
		try{
			//查询总行数
			int totalRecords =this.countrow(sql);
			if(totalRecords == 0){
				Result result = new Result();
				pager.setTotalCount(0);
				pager.setHasPrePage(true);
				pager.setHasNextPage(true);
				result.setPage(pager);
				return result;
			}
			pager.setTotalCount(totalRecords);
			//创建页面
			pager = PageUtil.createPage(pager, totalRecords); 
			
			//查分页数据
			List list=null;
			//起始行数
			int start_row = 0;
			//结束行数
			int end_row = 0;
			//如果传入的页数大于总页数,就设置传入的页数等于总页数
			if(pager.getCurrentPage() >= pager.getTotalPage()){
				pager.setCurrentPage(pager.getTotalPage());
			}else if(pager.getCurrentPage() < 1){// 如果传入的页数小于0,就设置传入的页数等于1
				pager.setCurrentPage(1);
			}
			
			start_row = (pager.getCurrentPage() - 1) * pager.getEveryPage();
			end_row  = pager.getCurrentPage() * pager.getEveryPage();
			if(start_row < 0){
				start_row = 0;
			}
			if(end_row > pager.getTotalCount()){
				end_row = pager.getTotalCount();
			}
			try{
				String sqlstr = getfeyeSql(sql, start_row, end_row, pager.getOrderBy(), pager.getOrderType());
				Object[] values = {start_row,end_row};
				list = dsisJdbcTemplate.queryForList(sqlstr, values);
//				System.out.println("sqlstr==="+sqlstr);
			}catch(Exception ex){
				ex.printStackTrace();
			}
	
			Result result = new Result();
			result.setPage(pager);
			result.setContent(list);
			return result;
		}catch(Exception e){
			LogUtil.logger.error("basedao分页查询错误!");
			e.printStackTrace();
			
			return null;
		}
	}

	/**
	 * 得行查询的总行数
	 * 
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected int countrow(String sql) {
		int row = 0;
		List list = null;
		Map map = null;
		try {
			StringBuffer sb = new StringBuffer(" select count(0) COUNT from ( " ).append(sql).append( ") b");
			list = dsisJdbcTemplate.queryForList(sb.toString());
			if(list != null && list.size() > 0){
				map = (Map) list.get(0);
				row = Integer.valueOf(map.get("COUNT").toString());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			LogUtil.logger.error("查询失败:" + sql);
		}
		return row;
	}
	

	/**
	 * jdbc分页查询语句
	 * @param sql
	 * @param start_row
	 * @param end_row
	 * @param oby
	 * @return
	 */
	private String getfeyeSql(String sql, int start_row, int end_row, String oby, OrderType orderType){
		StringBuffer sb = new StringBuffer();
		sb.append(" select rsb.* from (select rownum r ,rsa.* from (");
		sb.append(sql);
		sb.append(" ) rsa  ) rsb where ");
		sb.append(" r > ? and r <= ? ");
		if(oby != null && !"".equals(oby))
		{
			sb.append(" order by "+oby);
			if(orderType != null&& !"".equals(orderType)){
				if(orderType.name().equals("asc")){
					sb.append(" asc ");
				}
				if(orderType.name().equals("desc")){
					sb.append(" desc ");
				}
			}
		}
		return sb.toString();
	}

}
