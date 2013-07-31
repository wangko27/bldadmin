package com.cnarj.ttxs.service.imp.learn;

import com.cnarj.ttxs.dao.learn.IPinXueDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.learn.IPingXueService;

public class PinXueServiceImpl extends BaseServiceImpl<ArticleSrc, String> implements IPingXueService {

	private IPinXueDao pinXueDao;
	/**
	 * 
	 * @param type 是否为全部// 1. 学生, 2. 家长,  3. 教师
	 * @param sId 学生id
	 * @param Tid 老师id
	 * @param Jid 家长id
	 * @return 结果
	 */
	public Result getAllPinXue(String type, String id ,Page page) {
		StringBuffer hql=new StringBuffer();
		hql.append("from ArticleSrc a where 1=1").append(" and a.articleType.articletypeid='8a8081a131cd5fcd0131cd6a83e40004' and a.isrecommend=1");
		if(type==null||type.trim().equals("")){
			hql.append(" order by a.createdate desc");
		}else if(type.equals("1")){
				hql.append(" and a.member.memberType='").append(id).append("'")
				.append(" order by a.createdate desc");
		}
		
		return pinXueDao.getAllPingArticle(hql.toString(), page);
	}
	public IPinXueDao getPinXueDao() {
		return pinXueDao;
	}
	public void setPinXueDao(IPinXueDao pinXueDao) {
		this.pinXueDao = pinXueDao;
	}

}
