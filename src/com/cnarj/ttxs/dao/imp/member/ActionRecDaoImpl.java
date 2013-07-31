package com.cnarj.ttxs.dao.imp.member;


//import java.util.ArrayList;
import java.util.List;
//import java.util.Map;

//import org.apache.commons.lang.time.DateUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.member.IActionRecDao;
import com.cnarj.ttxs.pojo.stuz.ActionRec;
//import com.cnarj.ttxs.pojo.stuz.Blog;
//import com.cnarj.ttxs.pojo.stuz.Photos;
//import com.cnarj.ttxs.pojo.stuz.albums;
//import com.cnarj.ttxs.pojo.stuz.moods;
//import com.cnarj.ttxs.pojo.user.Member;
//import com.cnarj.ttxs.util.DateUtil;

public class ActionRecDaoImpl extends BaseDaoImpl<ActionRec,String> implements IActionRecDao {

	private JdbcTemplate jdbcTemplate;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@SuppressWarnings("unchecked")
	public List<ActionRec> openActionList(String memberid) {
		String hql = " from ActionRec as model where model.member.memberid = ? order by model.actiondate desc";	
		return super.getSession().createQuery(hql)
			.setParameter(0, memberid)
			.setFirstResult(0)
			.setMaxResults(20).list();
	}


	@SuppressWarnings("unchecked")
	public List<ActionRec> getListByFriend(String memberId, int length) {
		Assert.notNull(memberId, "会员id不能为空！");
		String hql = "  select rec from ActionRec rec where 1=1 and rec.member.memberid in (select f.memberByFrienduserid.memberid from FriendsInfo f where 1=1 and f.memberByUserid.memberid = ? ) order by rec.actiondate desc ";
		return getSession().createQuery(hql).setParameter(0, memberId).setMaxResults(length).list();
	}

	
	@SuppressWarnings("unchecked")
	public List<ActionRec> getListByMyself(String memberId, int length) {
		Assert.notNull(memberId,"会员id不能为空！");
		String  hql = " from ActionRec as model where model.member.memberid = ? order by model.actiondate desc";
		if(length <= 0){
			return getSession().createQuery(hql).setParameter(0, memberId).list();
		}else{
			return getSession().createQuery(hql).setParameter(0, memberId).setMaxResults(length).list();
		}
		
	}
	
//	@SuppressWarnings("unchecked")
//	public List<ActionRec> getListByFriend(String memberId, int length)throws Exception {
//		Assert.notNull(memberId, "会员id不能为空！");
//		StringBuffer sql = new StringBuffer(" select rownum, rsa.* from ");
//		sql.append(" (select t.actionrecid,t.actiontype,t.actiontitle,t.actionpath1,t.username,t.actiondate,t.userid,t.albumid,t.photoid,t.blogid,t.moodid,t.actionpath2,   ");
//		sql.append(" t.headpath,t.nikename,t.albumname,t.albumpath,t.photoname,t.photopath,t.blogtitle,t.blogcontent,t.moodtext ");
//		sql.append(" from v_actionrec_associate t ");
//		sql.append(" where 1=1 and t.userid  in ( select f.frienduserid from ttxs_stuz_friendsinfo f where 1=1 and f.userid = ? ) order by t.actiondate desc ");
//		sql.append(" ) rsa ");
//		sql.append(" where 1=1 and rownum <=? ");
//		Object[] values = {memberId, length};
//		List<Object> lstObj = jdbcTemplate.queryForList(sql.toString(), values);
//		List<ActionRec> lst = null;
//		if(lstObj != null && lstObj.size() > 0){
//			lst = new ArrayList<ActionRec>();
//			int size = lstObj.size();
//			Map map= null;
//			ActionRec actionRec = null;
//			Member member = null;
//			albums alb = null;
//			Photos photo = null;
//			Blog blog = null;
//			moods mood = null;
//			for(int i=0; i< size; i++){
//				actionRec = new ActionRec();
//				map = (Map)lstObj.get(i);
//				actionRec.setActionrecid(map.get("actionrecid")+"");
//				actionRec.setActiontype(map.get("actiontype") == null ? null : Long.valueOf(map.get("actiontype")+""));
//				actionRec.setActiontitle(map.get("actiontitle")+"");
//				actionRec.setActionpath1(map.get("actionpath1")== null ? null : (map.get("actionpath1")+""));
//				actionRec.setUsername(map.get("username") == null ? null : map.get("username")+"");
//				actionRec.setActiondate(map.get("actiondate") == null ? null : DateUtil.getDateInstance(map.get("actiondate")+"", "yyyy-MM-dd HH:mm:ss"));
//				
//				member = new Member();
//				member.setMemberid(map.get("userid")+"");
//				member.setHeadpath(map.get("headpath")== null ? null : map.get("headpath")+"");
//				member.setNikename(map.get("nikename")== null ? null : map.get("nikename")+"");
//				actionRec.setMember(member);
//				actionRec.setActionpath2(map.get("actionpath2")+"");
//				if(map.get("albumid") != null){
//					alb = new albums();
//					alb.setAlbumid(map.get("albumid")+"");
//					alb.setAlbumname(map.get("albumname") == null ? null : map.get("albumname")+"");
//					alb.setAlbumpath(map.get("albumpath") == null ? null : map.get("albumpath")+"");
//					actionRec.setAlbum(alb);
//				}
//				if(map.get("photoid") != null ){
//					photo = new Photos();
//					photo.setPhotoid(map.get("photoid")+"");
//					photo.setPhotoname(map.get("photoname") == null ? null : map.get("photoname")+"");
//					photo.setPhotopath(map.get("photopath") == null ? null : map.get("photopath")+"");
//					actionRec.setPhoto(photo);
//				}
//				if(map.get("blogid") != null){
//					blog = new Blog();
//					blog.setBlogid(map.get("blogid")+"");
//					blog.setBlogtitle(map.get("blogtitle") == null ? null : map.get("blogtitle")+"");
//					blog.setBlogcontent(map.get("blogcontent") == null ? null : map.get("blogcontent")+"");
//					actionRec.setBlog(blog);
//				}
//				if(map.get("moodid") != null ){
//					mood = new moods();
//					mood.setMoodid(map.get("moodid")+"");
//					mood.setMoodtext(map.get("moodtext") == null ? null : map.get("moodtext")+"");
//					actionRec.setMood(mood);
//				}
//				lst.add(actionRec);
//			}
//		}
//		return lst;
//	}


}
