package com.cnarj.ttxs.dao.imp.dsis;

import java.util.Calendar;
import java.util.Date;

import com.cnarj.ttxs.dao.SmsPublishedMsgDao;
import com.cnarj.ttxs.dao.imp.BaseDaoDsisImpl;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.Page.OrderType;
import com.cnarj.ttxs.pojo.dsis.SmsPublishedMsg;
import com.cnarj.ttxs.util.BusinessException;
import com.cnarj.ttxs.util.DateUtil;

public class SmsPublishedMsgDaoImpl extends BaseDaoDsisImpl<SmsPublishedMsg, Long> implements SmsPublishedMsgDao  {

	
	public Result getSmsMsgPage(String mobile, String startDate,
			String endDate, Page page) {
		StringBuffer sbf = new StringBuffer("");
		sbf.append(" select p.category_name,t.msm_content,t.xs_id,s.xs_xming,to_char(t.display_date,'yyyy-mm-dd hh24:mi') as display_date ");
		sbf.append(" from sms_published_msg t ");
		sbf.append(" inner join sms_published_type p on t.sms_type_id = p.publish_type_id ");
		sbf.append(" inner join t_student s on s.xs_id = t.xs_id ");
		sbf.append(" where 1=1 and exists ( select m.xs_id from student_binding_mobile m where 1=1 and t.xs_id = m.xs_id and m.mobile = '"+mobile+"') ");
		sbf.append(" and t.isaudit = 1 ");
		try {
			String nowDate = DateUtil.setDateFormat(new Date(), "yyyy-MM-dd");
			if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)){
			}else{//查询当天
				startDate = nowDate;
				endDate = nowDate;
			}
			sbf.append(" and to_char(t.display_date,'yyyy-mm-dd') >= '"+startDate+"' and  to_char(t.display_date,'yyyy-mm-dd') <= '"+endDate+"' ");
			
			int diffDate = DateUtil.DateDiff(startDate, "yyyy-MM-dd", nowDate,"yyyy-MM-dd", Calendar.DATE);
			if(diffDate > 7){//系统当前时间大于7天，则查询备份表中的数据
				sbf.append(" union ");
				sbf.append(" select p.category_name,bak.msm_content,bak.xs_id,s.xs_xming,to_char(bak.display_date,'yyyy-mm-dd hh24:mi') as display_date ");
				sbf.append(" from sms_published_msg_bak bak ");
				sbf.append(" inner join sms_send_log l on bak.sms_send_id = l.sms_send_id ");
				sbf.append(" inner join sms_published_type p on l.publish_type_id = p.publish_type_id ");
				sbf.append(" inner join t_student s on s.xs_id = bak.xs_id ");
				sbf.append(" where 1=1 and exists ( select m.xs_id from student_binding_mobile m where 1=1 and bak.xs_id = m.xs_id and m.mobile = '"+mobile+"') ");
				sbf.append(" and bak.isaudit = 1 ");
				sbf.append(" and to_char(bak.display_date,'yyyy-mm-dd') >= '"+startDate+"' and  to_char(bak.display_date,'yyyy-mm-dd') <= '"+endDate+"' ");
			}
		} catch (Exception e) {
			throw new BusinessException(e.toString());
		}
		page.setOrderBy("display_date");
		page.setOrderType(OrderType.desc);
		return findByPagerForJdbc(page, sbf.toString());
	}

	public Result getSmsMsgPage(Long xsId, String startDate, String endDate,
			Page page) {
		StringBuffer sbf = new StringBuffer("");
		sbf.append(" select p.category_name,t.msm_content,t.xs_id,s.xs_xming,to_char(t.display_date,'yyyy-mm-dd hh24:mi') as display_date");
		sbf.append(" from sms_published_msg t ");
		sbf.append(" inner join sms_published_type p on t.sms_type_id = p.publish_type_id ");
		sbf.append(" inner join t_student s on s.xs_id = t.xs_id ");
		sbf.append(" where 1=1 and t.xs_id = "+xsId);
		sbf.append(" and t.isaudit = 1 ");
		try {
			String nowDate = DateUtil.setDateFormat(new Date(), "yyyy-MM-dd");
			if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)){
			}else{//查询当天
				startDate = nowDate;
				endDate = nowDate;
			}
			sbf.append(" and to_char(t.display_date,'yyyy-mm-dd') >= '"+startDate+"' and  to_char(t.display_date,'yyyy-mm-dd') <= '"+endDate+"' ");
			
			int diffDate = DateUtil.DateDiff(startDate, "yyyy-MM-dd", nowDate,"yyyy-MM-dd", Calendar.DATE);
			if(diffDate > 7){//系统当前时间大于7天，则查询备份表中的数据
				sbf.append(" union ");
				sbf.append(" select p.category_name,bak.msm_content,bak.xs_id,s.xs_xming,to_char(bak.display_date,'yyyy-mm-dd hh24:mi') as display_date ");
				sbf.append(" from sms_published_msg_bak bak ");
				sbf.append(" inner join sms_send_log l on bak.sms_send_id = l.sms_send_id ");
				sbf.append(" inner join sms_published_type p on l.publish_type_id = p.publish_type_id ");
				sbf.append(" inner join t_student s on s.xs_id = bak.xs_id ");
				sbf.append(" where 1=1 and bak.xs_id = "+xsId);
				sbf.append(" and bak.isaudit = 1 ");
				sbf.append(" and to_char(bak.display_date,'yyyy-mm-dd') >= '"+startDate+"' and  to_char(bak.display_date,'yyyy-mm-dd') <= '"+endDate+"' ");
			}
		} catch (Exception e) {
			throw new BusinessException(e.toString());
		}
		page.setOrderBy("display_date");
		page.setOrderType(OrderType.desc);
		return findByPagerForJdbc(page, sbf.toString());
	}

	public Result getSmsMsgPage(Page page, String startDate, String endDate,
			Long classId) {
		StringBuffer sbf = new StringBuffer("");
		sbf.append(" select p.category_name,t.msm_content,t.xs_id,s.xs_xming,to_char(t.display_date,'yyyy-mm-dd hh24:mi') as display_date");
		sbf.append(" from sms_published_msg t ");
		sbf.append(" inner join sms_published_type p on t.sms_type_id = p.publish_type_id ");
		sbf.append(" inner join t_student s on s.xs_id = t.xs_id ");
		sbf.append(" where 1=1 and exists ( select 1 from t_student m where 1=1 and t.xs_id = m.xs_id and m.bj_id = "+classId+") ");
		sbf.append(" and t.isaudit = 1 ");
		try {
			String nowDate = DateUtil.setDateFormat(new Date(), "yyyy-MM-dd");
			if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)){
			}else{//查询当天
				startDate = nowDate;
				endDate = nowDate;
			}
			sbf.append(" and to_char(t.display_date,'yyyy-mm-dd') >= '"+startDate+"' and  to_char(t.display_date,'yyyy-mm-dd') <= '"+endDate+"' ");
			
			int diffDate = DateUtil.DateDiff(startDate, "yyyy-MM-dd", nowDate,"yyyy-MM-dd", Calendar.DATE);
			if(diffDate > 7){//系统当前时间大于7天，则查询备份表中的数据
				sbf.append(" union ");
				sbf.append(" select p.category_name,bak.msm_content,bak.xs_id,s.xs_xming,to_char(bak.display_date,'yyyy-mm-dd hh24:mi') as display_date ");
				sbf.append(" from sms_published_msg_bak bak ");
				sbf.append(" inner join sms_send_log l on bak.sms_send_id = l.sms_send_id ");
				sbf.append(" inner join sms_published_type p on l.publish_type_id = p.publish_type_id ");
				sbf.append(" inner join t_student s on s.xs_id = bak.xs_id ");
				sbf.append(" where 1=1 and  exists ( select 1 from t_student m where 1=1 and bak.xs_id = m.xs_id and m.bj_id = "+classId+") ");
				sbf.append(" and bak.isaudit = 1 ");
				sbf.append(" and to_char(bak.display_date,'yyyy-mm-dd') >= '"+startDate+"' and  to_char(bak.display_date,'yyyy-mm-dd') <= '"+endDate+"' ");
			}
		} catch (Exception e) {
			throw new BusinessException(e.toString());
		}
		page.setOrderBy("display_date");
		page.setOrderType(OrderType.desc);
		return findByPagerForJdbc(page, sbf.toString());
	}
	

}
