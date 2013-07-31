package com.cnarj.ttxs.service.learn;

import java.util.List;

import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.service.IBaseService;

/**
 * 学习频道Service接口类 - 一天一课
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 李万余
 * @version 1.0
 * @since 2011年8月10日
 */
public interface IOneDayOneTextService extends IBaseService<ReadSrc, String> {

	/**
	 * 得到今天的课程,按科目,年级,时间或热度(含分页)
	 * 
	 * @return
	 */
	public Result getToDayReadSrc(String kemu, String clas,String oneTime, int type, Page page);
	/**
	 * 得到今天的课程,按科目,年级
	 * 
	 * @return
	 */
	public List<ReadSrc> getToDayReadSrc(String kemu, String clas, int num);

	/**
	 * 按id得到一天一课的详细内容
	 */
	public ReadSrc getByIdOneDayOneText(String readId);

	/**
	 * 查询昨日课堂5条信息(按科目,一天一课,行数)除本条信息以外
	 */
	public List<ReadSrc> getXiangGuangOneDayOneText(String subjectId, int num,
			String readId);

	/**
	 * 查询最新的一天一课
	 * 
	 * @param gradecode
	 *            年级数量
	 * @param shownum
	 *            显示数量
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List listReadOnedayByNew(String gradecode, int shownum)
			throws Exception;

	public void updateOneDayOneText(ReadSrc readSrc);
}
