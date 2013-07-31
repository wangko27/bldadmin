package com.cnarj.ttxs.dao.imp.member;

import java.util.ArrayList;
import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.member.IStudyDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.comm.ArticleSrc;

/**
 * 会员Dao接口实现类 - 品学论道
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年9月24日13:51:46
 */
public class StudyDaoImpl extends BaseDaoImpl<ArticleSrc,String> implements IStudyDao {

	/**
	 * 查询品学论道类型文章
	 */
	public Result getStudyListByM(Page page, String memberid) {
		
		String hql = "from ArticleSrc a where  a.member.memberid=? and a.articleType.articletypeid=? order by createdate desc";
		
		List values = new ArrayList();
		values.add(memberid);
		values.add("8a8081a131cd5fcd0131cd6a83e40004");//品学论道类别
		
		return super.findByPager(page, hql, values);
	}
}
