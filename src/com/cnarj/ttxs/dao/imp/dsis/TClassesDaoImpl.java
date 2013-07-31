package com.cnarj.ttxs.dao.imp.dsis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.TClassesDao;
import com.cnarj.ttxs.dao.imp.BaseDaoDsisImpl;
import com.cnarj.ttxs.pojo.dsis.TClasses;

/**
 * 班级接口实现类
 * @author hedan
 *
 */
public class TClassesDaoImpl extends BaseDaoDsisImpl<TClasses, Long> implements TClassesDao{

	private JdbcTemplate dsisJdbcTemplate;
	
	public JdbcTemplate getDsisJdbcTemplate() {
		return dsisJdbcTemplate;
	}

	public void setDsisJdbcTemplate(JdbcTemplate dsisJdbcTemplate) {
		this.dsisJdbcTemplate = dsisJdbcTemplate;
	}
	
	@SuppressWarnings("unchecked")
	public List<TClasses> getList(Long xs_id) {
		Assert.notNull(xs_id, "xs_id is required");
		String sql = " select v.bj_id,v.bj_mcheng,v.bj_ztai from v_grade_class_student v where 1=1 and v.xs_id = ? ";
		Object[] values = {xs_id};
		List<Object> lst = dsisJdbcTemplate.queryForList(sql,values);
		List<TClasses> lst_classes = new ArrayList();
		if(lst != null && lst.size() > 0){
			int size = lst.size();
			Map map = new HashMap();
			TClasses classes = null;
			for(int i=0; i<size; i++){
				classes = new TClasses();
				map = (Map)lst.get(i);
				classes.setBjId(map.get("bj_id") == null ? 0 : Long.parseLong(map.get("bj_id")+""));
				classes.setBjMcheng(map.get("bj_mcheng")+"");
				classes.setBjZtai(map.get("bj_ztai") == null ? 70 : Long.parseLong(map.get("bj_ztai")+""));
				lst_classes.add(classes);
			}
		}
		return lst_classes;
	}


	@SuppressWarnings("unchecked")
	public List<TClasses> getClassesListByBindGrade(Long gradeId, Long teacherId) {
		Assert.notNull(gradeId,"gradeId is required");
		Assert.notNull(teacherId,"teacherId is required");
		List lst = null;
		StringBuffer sql = new StringBuffer(" select distinct c.bj_id,c.nj_id,c.bj_bma,c.bj_mcheng,c.bj_ztai,c.xxid ");
					 sql.append(" from  r_teacher_class t , t_stugrade s, t_teacherinfo te ,t_classes c ");
					 sql.append(" where t.nj_id = s.nj_id and t.teacherid = te.teacherid and t.bj_id = c.bj_id and c.bj_ztai = 70 ");
		 //全部班级
		 if(gradeId == -1){
			 sql.append(" and t.teacherid = ? order by c.bj_mcheng asc  ");
			 Object[] params = {teacherId};
			 lst =  dsisJdbcTemplate.queryForList(sql.toString(), params);
		 }else{
			
			 sql.append(" and t.nj_id = ? and t.teacherid = ?  order by c.bj_mcheng asc  ");
			 Object[] params = {gradeId, teacherId};
			 lst =  dsisJdbcTemplate.queryForList(sql.toString(), params);
		 }
		if(lst != null && lst.size() > 0){
			int l_size = lst.size();
			TClasses l_classes = null;
			List<TClasses> lstClasses = new ArrayList<TClasses>();
			Map l_map = null;
			Long l_bjId , l_bjZtai;
			//循环转换成班级列表
			for(int i = 0; i < l_size ; i++ ){
				l_map = (Map)lst.get(i);
				l_classes = new TClasses();
				l_bjId = l_map.get("BJ_ID") != null ? Long.parseLong(l_map.get("BJ_ID").toString()) : new Long(0);
				l_classes.setBjId(l_bjId);
				l_classes.setBjBma(l_map.get("BJ_BMA") + "");
				l_classes.setBjMcheng(l_map.get("BJ_MCHENG") + "");
				l_bjZtai = l_map.get("BJ_ZTAI") !=  null ? Long.parseLong(l_map.get("BJ_ZTAI").toString()) : new Long(0);
				l_classes.setBjZtai(l_bjZtai);
				l_classes.setXxid(l_map.get("XXID") + "");
				lstClasses.add(l_classes);
			}
			return lstClasses;
		}
		return null;
	}

}
