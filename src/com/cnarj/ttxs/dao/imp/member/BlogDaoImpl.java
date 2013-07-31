package com.cnarj.ttxs.dao.imp.member;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.member.IBlogDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.stuz.Blog;

/**
 * 会员Dao接口实现类 - 博文
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:51:48
 */
public class BlogDaoImpl extends BaseDaoImpl<Blog,String> implements IBlogDao {

	public Blog getPre(Date date, String memberid,int type, List<String> memberidList) {
		Assert.notNull(date, "date 为空!");
		Assert.hasText(memberid, "memberid 为空!");
		
		String datestr = date.toString();
		datestr = datestr.substring(0, datestr.indexOf("."));
		
		StringBuffer hql = new StringBuffer();
		if(type==1){//自己
			hql.append(" from Blog b where b.createdate > to_date(?,'yyyy-mm-dd hh24:mi:ss') and  b.member.memberid = ?  order by createdate ");
			
		}
		else if(type==2){//好友
			hql.append(" from Blog as b where b.createdate > to_date(?,'yyyy-mm-dd hh24:mi:ss') ");
			
			for(int i = 0 ; i < memberidList.size();i++){
				if(i == 0){
					hql.append(" and  ( ");
				}
				else{
					hql.append(" or ");
				}
				hql.append(" b.member.memberid = ?");
				
				if(i == memberidList.size()-1){
					hql.append(" ) ");
				}
			}
			
			hql.append(" order by b.createdate ");
		}
		else if(type==3){//所有
			hql.append(" from Blog b where b.createdate > to_date(?,'yyyy-mm-dd hh24:mi:ss')  order by createdate ");
			
		}
		else{
			return null;
		}
		
		Query query = getSession().createQuery(hql.toString()).setParameter(0, datestr);
		
		int k = 0;
		if(type == 2 && null != memberidList){
			for(k = 0;k < memberidList.size();k++){
				query.setParameter(k+1, memberidList.get(k));
			}
		}
		if(type == 1 && memberid != null && memberid.length() > 0){
			query.setParameter(k+1, memberid);
		}
		
		List list = query.list();
		if(list.size() > 0){
			Blog blog = (Blog)list.get(0);
			if(list.size()>1){
				blog.setBlogpre(true);
				blog.setBlognext(true);
			}
			else{
				blog.setBlogpre(false);
				blog.setBlognext(true);
			}
			return blog;
		}
		else{
			return null;
		}
		
	}

	public boolean isHasPre(Date date, String memberid,int type, List<String> memberidList) {

		StringBuffer hql = new StringBuffer();
		if(type==1){
			hql.append("select count(*) from Blog b where b.createdate > to_date(?,'yyyy-mm-dd hh24:mi:ss')");
			hql.append("and b.member.memberid = ?  ");
			hql.append("and rownum = 1");
		}
		else if(type==2){//好友
			hql.append("select count(*) from Blog b where  b.createdate > to_date(?,'yyyy-mm-dd hh24:mi:ss') ");
			for(int i = 0 ; i < memberidList.size();i++){
				if(i == 0){
					hql.append(" and ( ");
				}
				else{
					hql.append(" or ");
				}
				hql.append(" b.member.memberid = ?");
				
				if(i == memberidList.size()-1){
					hql.append(" ) ");
				}
			}
			hql.append(" and rownum = 1 ");
		}
		else if(type==3){//所有人
			hql.append("select count(*) from Blog b where b.createdate > to_date(?,'yyyy-mm-dd hh24:mi:ss') ");
			hql.append("and rownum = 1 ");
		}
		else{
			return false;
		}
		
		String datestr = date.toString();
		datestr = datestr.substring(0, datestr.indexOf("."));

		Query query = getSession().createQuery(hql.toString()).setParameter(0, datestr);

		int k = 0;
		if(type == 2 && null != memberidList){
			for(k = 0;k < memberidList.size();k++){
				query.setParameter(k+1, memberidList.get(k));
			}
		}
		if(type == 1 && memberid != null && memberid.length() > 0){
			query.setParameter(k+1, memberid);
		}
		
		Long count = (Long)query.uniqueResult();
		
		return count.intValue() > 0;
	}

	public boolean isHasNext(Date date, String memberid,int type, List<String> memberidList) {

		StringBuffer hql = new StringBuffer();
		if(type==1){
			hql.append("select count(*) from Blog b where b.createdate < to_date(?,'yyyy-mm-dd hh24:mi:ss')");
			hql.append("and b.member.memberid = ?  ");
			hql.append("and rownum = 1 order by createdate desc");
		}
		else if(type==2){//好友
			hql.append("select count(*) from Blog b where  b.createdate < to_date(?,'yyyy-mm-dd hh24:mi:ss') ");
			for(int i = 0 ; i < memberidList.size();i++){
				if(i == 0){
					hql.append("  and ( ");
				}
				else{
					hql.append(" or ");
				}
				hql.append(" b.member.memberid = ?");
				
				if(i == memberidList.size()-1){
					hql.append(" ) ");
				}
			}
			hql.append(" and rownum = 1 order by createdate desc");
		}
		else if(type==3){//所有人
			hql.append("select count(*) from Blog b where b.createdate < to_date(?,'yyyy-mm-dd hh24:mi:ss') ");
			hql.append("and rownum = 1 order by createdate desc");
		}
		else{
			return false;
		}
		
		
		String datestr = date.toString();
		datestr = datestr.substring(0, datestr.indexOf("."));

		Query query = getSession().createQuery(hql.toString()).setParameter(0, datestr);

		int k = 0;
		if(type == 2 && null != memberidList){
			for(k = 0;k < memberidList.size();k++){
				query.setParameter(k+1, memberidList.get(k));
			}
		}
		if(type == 1 && memberid != null && memberid.length() > 0){
			query.setParameter(k+1, memberid);
		}
		
		Long count = (Long)query.uniqueResult();
		
		return count.intValue() > 0;
	}

	public Blog getNext(Date date, String memberid,int type, List<String> memberidList) {
		Assert.notNull(date, "date 为空!");
		Assert.hasText(memberid, "memberid 为空!");
		
		String datestr = date.toString();
		datestr = datestr.substring(0, datestr.indexOf("."));
		

		StringBuffer hql = new StringBuffer();
		if(type==1){//自己
			hql.append(" from Blog b where b.createdate < to_date(?,'yyyy-mm-dd hh24:mi:ss') and  b.member.memberid = ?  order by createdate desc");
			
		}
		else if(type==2){//好友
			hql.append(" from Blog as b where b.createdate < to_date(?,'yyyy-mm-dd hh24:mi:ss') ");
			
			for(int i = 0 ; i < memberidList.size();i++){
				if(i == 0){
					hql.append("  and ( ");
				}
				else{
					hql.append(" or ");
				}
				hql.append(" b.member.memberid = ?");
				
				if(i == memberidList.size()-1){
					hql.append(" ) ");
				}
			}
			
			hql.append(" order by b.createdate desc");
		}
		else if(type==3){//所有
			hql.append(" from Blog b where b.createdate < to_date(?,'yyyy-mm-dd hh24:mi:ss')  order by createdate desc");
			
		}
		else{
			return null;
		}
		
		Query query = getSession().createQuery(hql.toString()).setParameter(0, datestr);
		
		int k = 0;
		if(type == 2 && null != memberidList){
			for(k = 0;k < memberidList.size();k++){
				query.setParameter(k+1, memberidList.get(k));
			}
		}
		if(type == 1 && memberid != null && memberid.length() > 0){
			query.setParameter(k+1, memberid);
		}
		
		
		List list = query.list();;
		if(list.size() > 0){
			Blog blog = (Blog)list.get(0);
			if(list.size()>1){
				blog.setBlogpre(true);
				blog.setBlognext(true);
			}
			else{
				blog.setBlogpre(true);
				blog.setBlognext(false);
			}
			return blog;
		}
		else{
			return null;
		}
		
	}

	public Result getmyblog(Page pager,String memberid) {
		StringBuffer hql = new StringBuffer();
		hql.append(" from Blog as b where b.member.memberid = ? order by b.createdate desc");
		
		List list = new ArrayList();
		list.add(memberid);
		return super.findByPager(pager, hql.toString(),list);
	}

	/**
	 * 查询一组用户的博文列表
	 * @param pager
	 * @param memberidList 用户ID列表
	 * @return
	 */
	public Result getMListblog(Page pager, List<String> memberidList) {
		Assert.notNull(memberidList,"memberidList must not null");
		Assert.notEmpty(memberidList, "memberidList must not empty");
		
		
		StringBuffer hql = new StringBuffer();
		hql.append(" from Blog as b where 1 = 1 ");
		
		for(int i = 0 ; i < memberidList.size();i++){
			if(i == 0){
				hql.append(" and ( ");
			}
			else{
				hql.append(" or ");
			}
			hql.append(" b.member.memberid = ?");
			
			if(i == memberidList.size()-1){
				hql.append(" ) ");
			}
		}
		
		hql.append(" order by b.createdate desc");
		
		return super.findByPager(pager, hql.toString(),memberidList);
	}

	/**
	 * 查询所有用户的博文列表 按时间倒序
	 * @param pager
	 * @return
	 */
	public Result getAllBelog(Page pager) {	
		
		StringBuffer hql = new StringBuffer();
		hql.append(" from Blog as b where b.viewperm <> 3 order by b.createdate desc");
		
		return super.findByPager(pager, hql.toString(),null);
	}
	public void updateReadNum(String blogid) {
		Assert.hasText(blogid, "blogid must not be empty");
		String hql = "update Blog b set b.readnum = b.readnum + 1 where b.blogid = ?";
		getSession().createQuery(hql).setParameter(0, blogid).executeUpdate();
	}

	public void updateCommentNum(String blogid) {
		Assert.hasText(blogid, "blogid must not be empty");
		String hql = "update Blog b set b.commentnum = b.commentnum + 1 where b.blogid = ?";
		getSession().createQuery(hql).setParameter(0, blogid).executeUpdate();
	}

	


	/**************************他人空间******************************************/
	
	public Result openGetBlogList(Page pager, String memberid, List<Long> powerList) {
		Assert.hasText(memberid, "memberid must not be empty");
		Assert.notNull(powerList,"powerList must not null");
		
		StringBuffer hql = new StringBuffer();
		hql.append(" from Blog as b where b.member.memberid = ? ");

		List list = new ArrayList();
		list.add(memberid);
		for(int i = 0 ; i < powerList.size();i++){
			if(i == 0){
				hql.append(" and ( ");
			}
			else{
				hql.append(" or ");
			}
			hql.append(" b.viewperm = ?");
			
			if(i == powerList.size()-1){
				hql.append(" ) ");
			}
			list.add(powerList.get(i));
		}
		
		hql.append(" order by b.createdate desc");
		
		
		return super.findByPager(pager, hql.toString(),list);
	}

	public boolean openisHasPre(Date date, String memberid, List<Long> powerList) {

		StringBuffer hql = new StringBuffer();
		hql.append("select count(*) from Blog b where b.member.memberid = ?");
		hql.append(" and b.createdate > to_date(?,'yyyy-mm-dd hh24:mi:ss')  ");
		List list = new ArrayList();
		list.add(memberid);
		for(int i = 0 ; i < powerList.size();i++){
			if(i == 0){
				hql.append(" and ( ");
			}
			else{
				hql.append(" or ");
			}
			hql.append(" b.viewperm = ?");
			
			if(i == powerList.size()-1){
				hql.append(" ) ");
			}
			list.add(powerList.get(i));
		}
		hql.append(" and rownum = 1 order by createdate desc");

		String datestr = date.toString();
		datestr = datestr.substring(0, datestr.indexOf("."));

		Query query = getSession().createQuery(hql.toString());
		query.setParameter(0, memberid);
		query.setParameter(1, datestr);
		for(int i = 0;i < powerList.size();i++){
			query.setParameter(i+2, powerList.get(i));
		}
		Long count = (Long)query.uniqueResult();
		return count.intValue() > 0;
	}

	public boolean openisHasNext(Date date, String memberid, List<Long> powerList) {

		StringBuffer hql = new StringBuffer();
		hql.append("select count(*) from Blog b where b.member.memberid = ? ");
		hql.append(" and b.createdate < to_date(?,'yyyy-mm-dd hh24:mi:ss') ");
		
		for(int i = 0 ; i < powerList.size();i++){
			if(i == 0){
				hql.append(" and ( ");
			}
			else{
				hql.append(" or ");
			}
			hql.append(" b.viewperm = ?");
			
			if(i == powerList.size()-1){
				hql.append(" ) ");
			}
		}
		hql.append(" and rownum = 1 order by createdate desc");

		String datestr = date.toString();
		datestr = datestr.substring(0, datestr.indexOf("."));

		Query query = getSession().createQuery(hql.toString());
		query.setParameter(0, memberid);
		query.setParameter(1, datestr);
		for(int i = 0;i < powerList.size();i++){
			query.setParameter(i+2, powerList.get(i));
		}
		Long count = (Long)query.uniqueResult();
		
		return count.intValue() > 0;
	}
	

	public Blog opengetPre(Date date, String memberid, List<Long> powerList) {
		Assert.notNull(date, "date 为空!");
		Assert.hasText(memberid, "memberid 为空!");
		
		String datestr = date.toString();
		datestr = datestr.substring(0, datestr.indexOf("."));

		StringBuffer hql = new StringBuffer();
		hql.append(" from Blog b where b.member.memberid = ? and b.createdate < to_date(?,'yyyy-mm-dd hh24:mi:ss') ");

		for(int i = 0 ; i < powerList.size();i++){
			if(i == 0){
				hql.append(" and ( ");
			}
			else{
				hql.append(" or ");
			}
			hql.append(" b.viewperm = ?");
			
			if(i == powerList.size()-1){
				hql.append(" ) ");
			}
		}
		
		hql.append("order by createdate desc");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter(0, memberid);
		query.setParameter(1, datestr);
		for(int i = 0;i < powerList.size();i++){
			query.setParameter(i+2, powerList.get(i));
		}
		List list = query.list();
		
		if(list.size() > 0){
			Blog blog = (Blog)list.get(0);
			if(list.size()>1){
				blog.setBlogpre(true);
				blog.setBlognext(true);
			}
			else{
				blog.setBlogpre(false);
				blog.setBlognext(true);
			}
			return blog;
		}
		else{
			return null;
		}
		
	}

	public Blog opengetNext(Date date, String memberid, List<Long> powerList) {
		Assert.notNull(date, "date 为空!");
		Assert.hasText(memberid, "memberid 为空!");
		
		String datestr = date.toString();
		datestr = datestr.substring(0, datestr.indexOf("."));

		StringBuffer hql = new StringBuffer();
		hql.append(" from Blog b where b.member.memberid = ? and b.createdate > to_date(?,'yyyy-mm-dd hh24:mi:ss') ");
		
		for(int i = 0 ; i < powerList.size();i++){
			if(i == 0){
				hql.append(" and ( ");
			}
			else{
				hql.append(" or ");
			}
			hql.append(" b.viewperm = ?");
			
			if(i == powerList.size()-1){
				hql.append(" ) ");
			}
		}
		
		hql.append("order by createdate");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter(0, memberid);
		query.setParameter(1, datestr);
		for(int i = 0;i < powerList.size();i++){
			query.setParameter(i+2, powerList.get(i));
		}
		List list = query.list();
		
		if(list.size() > 0){
			Blog blog = (Blog)list.get(0);
			if(list.size()>1){
				blog.setBlogpre(true);
				blog.setBlognext(true);
			}
			else{
				blog.setBlogpre(true);
				blog.setBlognext(false);
			}
			return blog;
		}
		else{
			return null;
		}
		
	}

}
