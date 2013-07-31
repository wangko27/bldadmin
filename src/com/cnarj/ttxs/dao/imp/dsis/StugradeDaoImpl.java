package com.cnarj.ttxs.dao.imp.dsis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.StugradeDao;
import com.cnarj.ttxs.dao.imp.BaseDaoDsisImpl;
import com.cnarj.ttxs.pojo.dsis.TStugrade;

public class StugradeDaoImpl extends BaseDaoDsisImpl<TStugrade, Long> implements StugradeDao{

	private JdbcTemplate dsisJdbcTemplate;
	
	
	public JdbcTemplate getDsisJdbcTemplate() {
		return dsisJdbcTemplate;
	}

	public void setDsisJdbcTemplate(JdbcTemplate dsisJdbcTemplate) {
		this.dsisJdbcTemplate = dsisJdbcTemplate;
	}



	@SuppressWarnings("unchecked")
	public Long getStugrade(Long xs_id) {
		Assert.notNull(xs_id, "xs_id is required");
		String sql =" select s.nj_id,s.nj_mcheng  from t_stugrade s inner join t_classes c on c.nj_id = s.nj_id  inner join t_student t on t.bj_id = c.bj_id  where 1=1 and t.xs_id = ? ";
		Object[] values = {xs_id};
		List<Object> lst = dsisJdbcTemplate.queryForList(sql,values);
		Long njId = null;
		if(lst != null && lst.size() > 0){
			Map map = (Map)lst.get(0);
			njId = Long.parseLong(map.get("nj_id")+"");
		}
		return njId;
	}

	
	@SuppressWarnings("unchecked")
	public List<TStugrade> getList(Long xs_id) {
		Assert.notNull(xs_id, "xs_id is required");
		String sql = " select v.nj_id,v.nj_mcheng,v.nj_ztai from v_grade_class_student v where 1=1 and v.xs_id = ?";
		Object[] values = {xs_id};
		List<Object> lst = dsisJdbcTemplate.queryForList(sql,values);
		List<TStugrade> lst_grades = new ArrayList();
		if(lst != null && lst.size() > 0){
			int size = lst.size();
			Map map = new HashMap();
			TStugrade grade = null;
			for(int i=0; i<size; i++){
				grade = new TStugrade();
				map = (Map)lst.get(i);
				grade.setNjId(map.get("nj_id") == null ? 0 : Long.parseLong(map.get("nj_id")+""));
				grade.setNjMcheng(map.get("nj_mcheng")+"");
				grade.setNjZtai(map.get("nj_ztai") == null ? 50 : Long.parseLong(map.get("nj_ztai")+""));
				lst_grades.add(grade);
			}
		}
		return lst_grades;
	}


	@SuppressWarnings("unchecked")
	public List<TStugrade> getGradeListByBind(Long teacherId) {
		StringBuffer hql = new StringBuffer("");
		hql.append("select v.NJ_ID,v.NJ_MCHENG,v.NJ_BMA,v.NJ_ZTAI,v.NJ_XSMING,v.XXID,v.teacherid from v_grade_class_teacher v ");
		hql.append(" where 1=1 and v.teacherid = ? ");
		Object[] values = {teacherId};
		List<Object> lst = dsisJdbcTemplate.queryForList(hql.toString(),values);
		List<TStugrade> lst_grades = new ArrayList();
		if(lst != null && lst.size() > 0){
			int size = lst.size();
			Map map = new HashMap();
			TStugrade grade = null;
			for(int i=0; i<size; i++){
				grade = new TStugrade();
				map = (Map)lst.get(i);
				grade.setNjId(map.get("nj_id") == null ? 0 : Long.parseLong(map.get("nj_id")+""));
				grade.setNjMcheng(map.get("nj_mcheng")+"");
				grade.setNjZtai(map.get("nj_ztai") == null ? 50 : Long.parseLong(map.get("nj_ztai")+""));
				grade.setNjXsming(map.get("NJ_XSMING")+"");
				lst_grades.add(grade);
			}
		}
		return lst_grades;
	}

}
