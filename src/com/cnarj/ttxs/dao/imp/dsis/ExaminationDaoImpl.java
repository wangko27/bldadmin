package com.cnarj.ttxs.dao.imp.dsis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.ExaminationDao;
import com.cnarj.ttxs.dao.imp.BaseDaoDsisImpl;
import com.cnarj.ttxs.pojo.dsis.TExamination;

/**
 * 考试信息表接口实现类
 * @author hedan
 *
 */
public class ExaminationDaoImpl extends BaseDaoDsisImpl<TExamination, Long> implements ExaminationDao{
  
	 private JdbcTemplate dsisJdbcTemplate;
	 
	 
	
	public JdbcTemplate getDsisJdbcTemplate() {
		return dsisJdbcTemplate;
	}

	public void setDsisJdbcTemplate(JdbcTemplate dsisJdbcTemplate) {
		this.dsisJdbcTemplate = dsisJdbcTemplate;
	}

	

	public List<TExamination> getListByTerm(Long termId, String month) {
		StringBuffer sb = new StringBuffer(" from  TExamination e where 1=1  ");
		if(termId != null){
			sb.append(" and e.TTermSet.termId = "+termId+" ");
		}
		if(month != null && !"".equals(month) ){
			if(!"-1".equals(month)){
				sb.append(" and e.examDate = '"+month+"' ");	
			}
		}
		return getList(sb.toString());
	}

	
	@SuppressWarnings("unchecked")
	public List<TExamination> getListByClassId(String xxid, Long classId) {
		StringBuffer sb = new StringBuffer("");
		sb.append(" select distinct  t.ks_id as exam_id ,e.term_id,e.exam_name,e.exam_date,e.xxid  ");
		sb.append(" from student_examresult t,t_examination e  where 1=1 and t.ks_id = e.exam_id ");
		sb.append(" and  t.bj_id = ? and t.xxid = ? ");
		Object[] args = {classId, xxid};
		List<Object> lstObj = dsisJdbcTemplate.queryForList(sb.toString(), args);
		List<TExamination> lst = new ArrayList();
		if(lstObj != null && lstObj.size() > 0){
			int  size = lstObj.size();
			TExamination examination = null;
			Map map = new HashMap();
			for(int i = 0; i < size; i++){
				examination = new TExamination();
				map = (Map)lstObj.get(i);
				examination.setExamId(map.get("exam_id") ==  null ? null : Long.parseLong(map.get("exam_id") +""));
				examination.setExamName(map.get("exam_name")+"");
				examination.setExamDate(map.get("exam_date")+"");
				examination.setXxid(map.get("xxid")+"");
				lst.add(examination);
			}
		}
		return lst;
	}

	
	public List<TExamination> getListByStuid(Long xs_id) {
		String sql = "  ";
		return null;
	}

	
	@SuppressWarnings("unchecked")
	public List<TExamination> getListByClassAndTerm(String classId, Long termId) {
		Assert.notNull(classId, "classId is required");
		Assert.notNull(termId, "termId is required");
		String hql = " from TExamination t where 1=1 and t.TTermSet.termId = "+termId+" and ( t.idstr like ('%"+classId+"%') or t.idstr like ('%"+classId+",%') or t.idstr like ('%,"+classId+",%') or t.idstr like ('%,"+classId+"%')) ";
		return getSession().createQuery(hql).list();
	}

}
 