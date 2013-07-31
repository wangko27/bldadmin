package com.cnarj.ttxs.dao.imp.learn;

import java.util.List;

import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.dao.learn.IOneDayOneTextDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrc;

/**
 * 学习频道Dao接口实现类 - 一天一课
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月10日
 */
public class OneDayOneTextDaoImpl extends BaseDaoImpl<ReadSrc, String>
		implements IOneDayOneTextDao {

	/**
	 * 得到今天的课程,按科目,年级,时间或热度(含分页) and
	 * to_char(r.createdate,'yyyy-mm-dd')=to_char(sysdate,'yyyy-mm-dd') 0为时间排序
	 * 1为热度排序
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result getToDayReadSrc(String hql, Page page) {
		return this.findByPager(page, hql);
	}

	/**
	 * 按id得到一天一课的详细内容
	 */
	public ReadSrc getByIdOneDateOneText(String readId) {
		return this.get(readId);
	}

	/**
	 * 查询昨日课堂5条信息(按科目,一天一课,)
	 */
	@SuppressWarnings("unchecked")
	public List<ReadSrc> getXiangGuangOneDayOneText(String hql, int num) {
		return this.getSession().createQuery(hql).setMaxResults(num).list();
	}

	@SuppressWarnings("unchecked")
	public List listReadOnedayByNew(String gradecode, int shownum)
			throws Exception {
		String hql = "from ReadSrc r where r.readSrcType.srctypeid='8a8081a131bbd5780131bbd5cdc30001' and r.gradeCode.gradecode='"
				+ gradecode + "' and r.isenable=1 order by createdate desc";
		return this.getSession().createQuery(hql).setMaxResults(shownum).list();
	}
	@SuppressWarnings("unchecked")
	public List<ReadSrc> getToDayReadSrc(String kemu, String clas, int num) {
		// TODO Auto-generated method stub
		String hql="from ReadSrc r where r.readSrcType.srctypeid='8a8081a131bbd5780131bbd5cdc30001' and r.gradeCode.gradecode='"
			+clas+"' and r.subjectCode.subjectcode='"+kemu+"' and r.isenable=1 order by r.modifydate desc";
		return this.getSession()
		.createQuery(hql)
		.setMaxResults(num)
		.list();
	};
}
