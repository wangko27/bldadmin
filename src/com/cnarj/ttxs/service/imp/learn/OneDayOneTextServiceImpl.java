package com.cnarj.ttxs.service.imp.learn;

import java.util.List;

import com.cnarj.ttxs.dao.learn.IOneDayOneTextDao;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.learn.ReadSrc;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;
import com.cnarj.ttxs.service.learn.IOneDayOneTextService;

public class OneDayOneTextServiceImpl extends BaseServiceImpl<ReadSrc, String>
		implements IOneDayOneTextService {

	private IOneDayOneTextDao oneTextDao;

	public IOneDayOneTextDao getOneTextDao() {
		return oneTextDao;
	}

	public void setOneTextDao(IOneDayOneTextDao oneTextDao) {
		this.oneTextDao = oneTextDao;
	}

	public Result getToDayReadSrc(String hql, Page page) {
		return oneTextDao.getToDayReadSrc(hql, page);
	}

	/**
	 * 得到今天的课程,按科目,年级,时间或热度(含分页)(isenable 是否发布)
	 * 
	 * @return
	 */
	public Result getToDayReadSrc(String kemu, String clas, String oneTime,int type, Page page) {
		StringBuffer buffer = new StringBuffer();
		buffer
				.append("from ReadSrc r where r.readSrcType.srctypeid='8a8081a131bbd5780131bbd5cdc30001' and r.isenable=1");
		if (kemu != null && !kemu.trim().equals("")) {
			buffer.append(" and r.subjectCode.subjectcode='").append(kemu)
					.append("'");
		}
		if (clas != null && !clas.trim().equals("")) {
			buffer.append(" and r.gradeCode.gradecode='").append(clas).append(
					"'");
		}
		if(oneTime!=null&&!oneTime.trim().equals("")&&!oneTime.equals("查看日期")){
			String srt[]=oneTime.split("-");
			for(int i=0;i<srt.length;i++){
				if(Integer.parseInt(srt[i])<10 && srt[i].length()==1){
					srt[i]="0"+srt[i];
				}
			}
			oneTime=srt[0]+"-"+srt[1]+"-"+srt[2];
			buffer.append(" and to_char(r.createdate,'yyyy-mm-dd')='").append(oneTime).append("'");
		}
		if (type == 0) {
			buffer.append(" order by r.createdate desc");
		} else if (type == 1) {
			buffer.append(" order by r.downloadnum desc");
		}
		
		return oneTextDao.getToDayReadSrc(buffer.toString(), page);
	}

	public ReadSrc getByIdOneDayOneText(String readId) {
		if (readId != null && !readId.trim().equals("")) {
			ReadSrc readSrc = oneTextDao.getByIdOneDateOneText(readId);
			return readSrc;
		}
		return null;
	}

	/**
	 * 查询昨日课堂5条信息(按科目,一天一课,行数)除本条信息以外
	 */
	public List<ReadSrc> getXiangGuangOneDayOneText(String subjectId, int num,
			String readId) {
		StringBuffer hql_b = new StringBuffer();
		hql_b
				.append("from ReadSrc r where r.readSrcType.srctypeid='8a8081a131bbd5780131bbd5cdc30001' and r.isenable=1");
		if (subjectId != null) {
			hql_b.append(" and r.subjectCode.subjectcode='").append(subjectId)
					.append("'");
		}
		hql_b
				.append(
						" and to_char(r.createdate,'yyyy-mm')=to_char(sysdate,'yyyy-mm')")
				.append(
						" and to_char(r.createdate,'dd')=to_char(sysdate,'dd')-1")
				.append(" and r.readsrcid<>'").append(readId).append("'");
		return oneTextDao.getXiangGuangOneDayOneText(hql_b.toString(), num);
	}

	@SuppressWarnings("unchecked")
	public List listReadOnedayByNew(String gradecode, int shownum)
			throws Exception {
		return oneTextDao.listReadOnedayByNew(gradecode, shownum);
	}

	public void updateOneDayOneText(ReadSrc readSrc) {
		int i=readSrc.getReadnum().intValue();
		i++;
		readSrc.setReadnum(new Long(i));
		oneTextDao.update(readSrc);
	}

	public List<ReadSrc> getToDayReadSrc(String kemu, String clas, int num) {
		// TODO Auto-generated method stub
		 return oneTextDao.getToDayReadSrc(kemu, clas, num);
	}

}
