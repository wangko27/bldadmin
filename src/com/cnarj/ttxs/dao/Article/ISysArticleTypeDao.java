package com.cnarj.ttxs.dao.Article;




import java.util.List;

import com.cnarj.ttxs.dao.IBaseDao;
import com.cnarj.ttxs.pojo.comm.ArticleType;
import com.cnarj.ttxs.pojo.sys.SysArticleType;
import com.cnarj.ttxs.pojo.sys.Article;

/**
 * 测试Dao接口 - 用于测试的Dao接口
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author sly
 * @version 1.0
 * @since 2011年6月19日16:02:47
 */
public interface ISysArticleTypeDao extends IBaseDao<SysArticleType,String>{
	/**
	 * 获取所有上级类别.
	 * 
	 * @param id
	 *            记录ID
	 * @return 实体对象
	 */
	public List<SysArticleType> listBychildtype();
}
