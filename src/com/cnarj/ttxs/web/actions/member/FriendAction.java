package com.cnarj.ttxs.web.actions.member;

import java.sql.Date;
import java.util.Hashtable;
import java.util.List;

import com.cnarj.ttxs.comm.CommStaticNum;
import com.cnarj.ttxs.pojo.dsis.CoChinaXzqh;
import com.cnarj.ttxs.pojo.stuz.FriendType;
import com.cnarj.ttxs.pojo.stuz.FriendsInfo;
import com.cnarj.ttxs.pojo.user.Member;
import com.cnarj.ttxs.service.member.IFriendTypeService;
import com.cnarj.ttxs.service.member.IFriendsInfoService;
import com.cnarj.ttxs.web.actions.base.PageAction;

/**
 * 用户Action类 - 好友
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年8月25日10:55:53
 */
public class FriendAction extends PageAction {

	private IFriendTypeService friendTypeService;
	private IFriendsInfoService friendService;
	
	private String memberid;
	private FriendType friendtype;
	private FriendsInfo friendinfo;
	private String typeid;
	private String typeidpage;
	private String xm;
	private List<Member> mList;
	private List<FriendType> typeList;
	private List<FriendsInfo> friendList;
	private Member mfriend;
	private String friendinfoid;
	
	public String getTypeidpage() {		return typeidpage;	}
	public void setTypeidpage(String typeidpage) {		this.typeidpage = typeidpage;	}
	public String getFriendinfoid() {		return friendinfoid;	}
	public void setFriendinfoid(String friendinfoid) {		this.friendinfoid = friendinfoid;	}
	public Member getMfriend() {		return mfriend;	}
	public void setMfriend(Member mfriend) {		this.mfriend = mfriend;	}
	public List<FriendType> getTypeList() {		return typeList;	}
	public void setTypeList(List<FriendType> typeList) {		this.typeList = typeList;	}
	public List<FriendsInfo> getFriendList() {		return friendList;	}
	public void setFriendList(List<FriendsInfo> friendList) {		this.friendList = friendList;	}
	public String getXm() {		return xm;	}
	public void setXm(String xm) {		this.xm = xm;	}
	public List<Member> getMList() {		return mList;	}
	public void setMList(List<Member> list) {		mList = list;	}
	public String getTypeid() {		return typeid;	}
	public void setTypeid(String typeid) {		this.typeid = typeid;	}
	public String getMemberid() {		return memberid;	}
	public void setMemberid(String memberid) {		this.memberid = memberid;	}
	public FriendType getFriendtype() {		return friendtype;	}
	public void setFriendtype(FriendType friendtype) {		this.friendtype = friendtype;	}
	public FriendsInfo getFriendinfo() {		return friendinfo;	}
	public void setFriendinfo(FriendsInfo friendinfo) {		this.friendinfo = friendinfo;	}
	public IFriendTypeService getFriendTypeService() {		return friendTypeService;	}
	public void setFriendTypeService(IFriendTypeService friendTypeService) {		this.friendTypeService = friendTypeService;	}
	public IFriendsInfoService getFriendService() {		return friendService;	}
	public void setFriendService(IFriendsInfoService friendService) {		this.friendService = friendService;	}
	

	
	/**
	 * 分类管理 添加 
	 * @return
	 */
	public String addFriendType(){
		try{
			//取当前时间
			Date now = new Date(System.currentTimeMillis());
	
			Member m = new Member();
			m.setMemberid(memberid);
			m.setNikename(Member.LOGIN_MEMBER_NIKENAME);
			
			this.friendtype.setCreatedate(now);
			friendtype.setMember(m);
			friendtype.setIsdefault("0");
			friendtype.setFriendnum(new Long("0"));
			
			friendTypeService.save(friendtype);

			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("添加失败!");
			return ERROR;
		}
	}
	public void validateAddFriendType(){
		if(this.friendtype == null || friendtype.getFriendtypename().length() == 0){
			this.addActionError("好友类别名称不能为空");
		}
	}

	/**
	 * 分类管理 删除 
	 * @return
	 */
	public String delFriendType(){
		try{
			//查询
			Hashtable table = new Hashtable();
			table.put("friendtypeid", this.typeid);
			table.put("member.memberid", memberid);
			
			FriendType ft = friendTypeService.get(table);
			if(null == ft){
				this.addActionMessage("错误!");
				return ERROR;
			}
			else if(ft.getFriendnum() > 0){
				this.addActionMessage("该分类下还有好友,未删除！");
				return SUCCESS;
			}
			
			//删除
			friendTypeService.delete(ft);
			//删除后查询的好友列表是所有的，所以清空typeid
			this.typeid = "";
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("删除失败!");
			return ERROR;
		}
	}
	public void validateDelFriendType(){
		if(null == this.typeid || this.typeid.length() == 0){
			this.addActionError("错误!");
		}
	}

	/**
	 * 分类管理 修改 
	 * @return
	 */
	public String updFriendType(){
		try{
			int re = this.friendTypeService.updFriendType(this.friendtype,this.memberid);
			if(re == 0){
				this.addActionMessage("修改后的分类已经存在!");
				return ERROR;
			}
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("删除失败!");
			return ERROR;
		}
	}
	public void validateUpdFriendType(){
		if(null == this.friendtype || null == this.friendtype.getFriendtypename() || this.friendtype.getFriendtypename().length() == 0){
			this.addActionError("类型名称不能为空!");
		}
	}

	/**
	 * 跳转到修改分类
	 * @return
	 */
	public String updFriendTypeGo(){
		try{
			this.friendtype = friendTypeService.get(this.typeid);
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("提取数据失败!");
			return ERROR;
		}
	}
	public void validateUpdFriendTypeGo(){
		if(null == this.typeid || this.typeid.length() == 0){
			this.addActionError("必须选择类型!");
		}
	}

	/**
	 * 用户查询自己的所有的好友分类
	 */
	public String listFriendType(){
		try{
			this.typeList = friendTypeService.getList("member.memberid",this.memberid);
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("查询失败!");
			return ERROR;
		}
	}
	
	public String listtype(){
		try{
			this.typeList = friendTypeService.getList("member.memberid",this.memberid);

			//组装需要的语句
			StringBuffer sbtype = new StringBuffer();
			for (FriendType t : typeList) {
				sbtype.append("<option value=\"");
				sbtype.append(t.getFriendtypeid());
				sbtype.append("\">");
				sbtype.append(t.getFriendtypename());
				sbtype.append("</option>");
			}

			return super.ajaxText(sbtype.toString());
		}catch(Exception e){
			e.printStackTrace();
			return super.ajaxText("exception");
		}
	}
	
	
	/**
	 * 查找好友 按姓名
	 */
	public String findFriends(){
		try{
			//page分页信息
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_FINDFRIENDS);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));

			result = friendTypeService.getMemberList(page, this.xm);
			this.mList = result.getContent();
			
			this.typeList = friendTypeService.getList("member.memberid",this.memberid);
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("查询失败!");
			return ERROR;
		}
	}
	
	/**
	 * 查询我的好友列表 
	 * @return
	 */
	public String listFriend(){
		try{
			//page分页信息
			// 设置每页显示的条数
			page.setEveryPage(CommStaticNum.PAGENUM_MYFRIENDS);
			// 根据statePage进行Page对象设置，并查询
			if (gotoPage == null || gotoPage.length() == 0) {
				gotoPage = "1";
			}
			page.setCurrentPage(Integer.parseInt(gotoPage));
			
			//好友类别
			result = friendService.getFriendList(page, this.memberid,this.typeidpage);
			this.friendList = result.getContent();
			
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("查询失败!");
			return ERROR;
		}
	}
	
	/**
	 * 加为好友
	 * @return
	 */
	public String addFriend(){
		try{
			
			if(memberid.equals(this.mfriend.getMemberid())){
				this.addActionMessage("不能添加自己为好友！");
				this.typeid = "";
				return ERROR;
			}
			
			//好友ID，分类ID，好友姓名
			Member m = new Member();
			m.setMemberid(memberid);
			
			Member mf = new Member();
			mf.setMemberid(this.mfriend.getMemberid());
			mf.setNikename(this.mfriend.getNikename());
			
			
			
			FriendType type = new FriendType();
			type.setFriendtypeid(this.typeid);
			
			int temp = friendService.addFriend(m, mf, type);
			if(temp == 0){
				this.addActionMessage("该用户已经是你的好友");
			}
			
			//添加完了后查询所有列表下的用户信息
			this.typeid = "";
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("添加失败!");
			this.typeid = "";
			return ERROR;
		}
	}

	/**
	 * 修改好友所在分组 
	 * @return
	 */
	public String updFriendInType(){
		try{
			friendService.updFriendInType(friendinfoid, this.friendtype);

			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("修改失败!");
			return ERROR;
		}
	}
	public void validateUpdFriendInType(){
		if(null == this.friendinfoid || this.friendinfoid.length() == 0){
			this.addActionError("错误，传入ID为空!");
		}
	}

	/**
	 * 解除好友关系
	 * @return
	 */
	public String delFriend(){
		try{
			int re = friendService.delFriend(this.friendinfoid,this.memberid);
			if(re == 0){

				this.addActionMessage("没有该好友!");
				return ERROR;
			}
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			this.addActionMessage("关系解除失败!");
			return ERROR;
		}
	}
	public void validateDelFriend(){
		if(null == this.friendinfoid || this.friendinfoid.length() == 0){
			this.addActionError("错误，传入ID为空!");
		}
	}

	
	@Override
	/**
	 * 所有的方法都要判断用户信息
	 */
	public void validate() {
		//取当前用户ID
		this.memberid = (String)super.getSession(Member.LOGIN_MEMBER_ID_SESSION_NAME);
		if(null == memberid || memberid.length() == 0){
			this.addActionError("请登录!!");
		}
	}
}
