package com.cnarj.ttxs.service.imp.learn;

import java.util.List;

import com.cnarj.ttxs.dao.learn.ISuperTeacherDao;
import com.cnarj.ttxs.pojo.learn.SuperTeacher;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.learn.ISuperTeacherService;

public class SuperTeacherServiceImpl extends BaseServiceImpl<SuperTeacher, String> implements ISuperTeacherService{

	private ISuperTeacherDao teacherDao;
	public ISuperTeacherDao getTeacherDao() {
		return teacherDao;
	}
	public void setTeacherDao(ISuperTeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}
	/*修改人气
	 * (non-Javadoc)
	 * @see com.cnarj.ttxs.service.learn.ISuperTeacherService#addHuman(com.cnarj.ttxs.pojo.learn.SuperTeacher)
	 */
	public void updateHuman(SuperTeacher teacher) {
		int i=teacher.getPeopleNum().intValue();
		i++;
		teacher.setPeopleNum(new Long(i));
		teacherDao.update(teacher);
//		/this.update(teacher);
	}
	public List<SuperTeacher> getsuperteacher(int num) {
		// TODO Auto-generated method stub
		return teacherDao.getsuperteacher(num);
	}
	public List<SuperTeacher> getnewteacher(int num) {
		// TODO Auto-generated method stub
		return teacherDao.getnewteacher(num);
	}
}
