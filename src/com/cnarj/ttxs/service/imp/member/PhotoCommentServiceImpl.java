package com.cnarj.ttxs.service.imp.member;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.dao.member.IPhotoCommentDao;
import com.cnarj.ttxs.pojo.stuz.Albumcomment;
import com.cnarj.ttxs.pojo.stuz.Photocomment;
import com.cnarj.ttxs.pojo.stuz.Photos;
import com.cnarj.ttxs.pojo.stuz.albums;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.member.IPhotoCommentService;

/**
 * 空间service接口实现类 - 照片留言
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月29日19:25:37
 */
public class PhotoCommentServiceImpl extends BaseServiceImpl<Photocomment,String> implements
		IPhotoCommentService {

	private IPhotoCommentDao photoCommentDao;
	
	public IPhotoCommentDao getPhotoCommentDao() {
		return photoCommentDao;
	}
	public void setPhotoCommentDao(IPhotoCommentDao photoCommentDao) {
		this.photoCommentDao = photoCommentDao;
	}
	public void setBaseDao(IPhotoCommentDao photoCommentDao) {
		super.setBaseDao(photoCommentDao);
	}
	
	//排好序的留言内容
	List<Photocomment> tree;
	
	public List<Photocomment> getListByPhoto(String photoid) {

		//查询此博文的所有留言信息,包括留言和回复
		//按时间和上级ID排序
		List<Photocomment> list = photoCommentDao.getListByDate(photoid);
		tree = new ArrayList<Photocomment>();
		if(list.size() > 0){
			//排列留言数据
			commentTree(null,list);
		}
		
		return tree;
	}

	private void commentTree(String fid,List<Photocomment> listold){
		
		//循环查找子回复内容
		for(Photocomment b : listold){
			if(null == fid || fid.length()==0){
				if(null == b.getParent()){
					tree.add(b);
					commentTree(b.getCommentedid(),listold);
				}
			}
			else{
				if(null != b.getParent() && b.getParent().getCommentedid().equals(fid)){
					tree.add(b);
					commentTree(b.getCommentedid(),listold);
				}
			}
		}
	}

	public String saveCommentHtml(String photoid, Member member, String userIp,
			String comcontent, String fcommentedid) {
		//取当前时间
		Date now = new Date(System.currentTimeMillis());
		
		Photos a = new Photos();
		a.setPhotoid(photoid);
		
		Photocomment photocomm = new Photocomment();
		
		photocomm.setCommentedcontent(comcontent);//留言内容
		photocomm.setPhotos(a);//被留言的照片
		photocomm.setCommenteddate(now);//留言时间
		photocomm.setMember(member);//会员信息
		photocomm.setUserip(userIp);//留言用户IP
		photocomm.setUsername(member.getNikename());//留言用户姓名
		
		//处理父留言
		if(null!=fcommentedid && fcommentedid.length() > 0){
			Photocomment parent = new Photocomment();
			parent.setCommentedid(fcommentedid);
			photocomm.setParent(parent);
		}
		
		photoCommentDao.save(photocomm);

		//查询留言信息,已经排好序
		List<Photocomment> list = this.getListByPhoto(photoid);
		
		//处理留言HTML
		return appendHtml(list,photoid);
	}
	

	/**
	 * 生成要返回的Html 
	 * @param list 留言数据 
	 * @return HTML
	 */
	private String appendHtml(List<Photocomment> list,String albumid){
		
		StringBuffer html = new StringBuffer();
		html.append("<div class=\"poth_1 mari\">");
		html.append("<ul>");
		html.append("<li class=\"tm\" id=\"commnum\"><b>相片评论(共"+list.size()+"条)</b><a name=\"Aname\" id=\"Aid\"></a></li>");
		html.append("</ul>");
		html.append("</div>");
		html.append("<div class=\"poth_4\">");
		for(int i = 0;i < list.size();i++){
			if(null == list.get(i).getParent()){
				if(i != 0){
					html.append("</div>");
					html.append("</div>");
				}
				html.append("<div class=\"plun\">");
				html.append("<div class=\"cee\"><a href=\"Zone/index.action?TTid="+list.get(i).getMember().getMemberid()+"\"><img src=\""+list.get(i).getMember().getHeadpath()
						+"\" onerror=\"this.src='img/user_img/imgmo.gif'\" /></a></div>");
				html.append("<div class=\"cenn\">");
				html.append("<table width=\"384\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
				html.append("<tr>");
				html.append("<td><a href=\"Zone/index.action?TTid="+list.get(i).getMember().getMemberid()+"\">"+list.get(i).getUsername()+"</a> <span>"
						+list.get(i).getCommenteddate()+"</span></td>");
				html.append("</tr>");
				html.append("<tr>");
				html.append("<td><p>"+list.get(i).getCommentedcontent()+"</p>");
				html.append("<a href=\"javascript:;\" onclick=\"hffunction('hftable"+i+"');\">回复</a></td>");
				html.append("</tr>");
				html.append("</table>");
				html.append("<table id=\"hftable"+i+"\" width=\"384\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"display:none\">");
				html.append("<tr>");
				html.append("<td>");
				html.append("<textarea id=\"recomment"+i+"\" name=\"comcontent\" cols=\"\" rows=\"\" class=\"tex\"></textarea>");
				html.append("</td>");
				html.append("</tr>");
				html.append("<tr>");
				html.append("<td><input name=\"\" type=\"button\" onclick=\"hfsubmit('recomment"+i+"','"+list.get(i).getCommentedid()+"');\" value=\"确定\" class=\"quedd\"/>");
				html.append("<a href=\"#\" class=\"qqx\">取消</a></td>");
				html.append("</tr>");
				html.append("</table>");
			}
			else{
				html.append("<ul class=\"hui\">");
				html.append("<li class=\"tou\"><a href=\"Zone/index.action?TTid="+list.get(i).getMember().getMemberid()+"\"><img src=\""+list.get(i).getMember().getHeadpath()
						+"\" onerror=\"this.src='img/user_img/imgmo.gif'\" /></a></li>");
				html.append("<li>");
				html.append("<dl>");
				html.append("<dt><a href=\"Zone/index.action?TTid="+list.get(i).getMember().getMemberid()+"\">"+list.get(i).getUsername()+"</a> <span>"
						+list.get(i).getCommenteddate()+"</span></dt>");
				html.append("<dd>"+list.get(i).getCommentedcontent()+"</dd>");
				html.append("</dl>");
				html.append("</li>");
				html.append("</ul>");
				html.append("");
				html.append("");
			}
		}
		if(list.size() > 0){
			html.append("</div>");
			html.append("</div>");
		}
		html.append("<input type=\"hidden\" value=\""+albumid+"\" name=\"comcontent\" id=\"comcontent\"/>");
		html.append("<input type=\"hidden\" value=\""+albumid+"\" name=\"photoid\" id=\"photoid\"/>");
		html.append("<input type=\"hidden\" value=\"\" name=\"comid\" id=\"comid\"/>");
		
		return html.toString();
	}

	
}
