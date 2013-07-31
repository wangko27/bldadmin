package com.cnarj.ttxs.admin.service.imp.learn;

import java.util.Date;
import java.util.List;

import com.cnarj.ttxs.admin.service.learn.IReadbookTypeService;
import com.cnarj.ttxs.dao.learn.IReadbookTypeDao;
import com.cnarj.ttxs.pojo.learn.ReadSrcType;
import com.cnarj.ttxs.service.imp.BaseServiceImpl;

/**
 * 学习频道后台Service实现类 - 博览群书类别
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author 唐其
 * @version 1.0
 * @since 2011年8月11日
 */
public class ReadbookTypeServiceImpl extends
		BaseServiceImpl<ReadSrcType, String> implements IReadbookTypeService {

	IReadbookTypeDao readbookTypeDao;

	public IReadbookTypeDao getReadbookTypeDao() {
		return readbookTypeDao;
	}

	public void setReadbookTypeDao(IReadbookTypeDao readbookTypeDao) {
		this.readbookTypeDao = readbookTypeDao;
	}

	public void setBaseDao(IReadbookTypeDao readbookTypeDao) {
		super.setBaseDao(readbookTypeDao);
	}

	/**
	 * 添加博览群书类别
	 * 
	 * @param readSrcType
	 */
	public void saveReadSrcType(ReadSrcType readSrcType) throws Exception {
		readSrcType.setCreatedate(new Date());
		readSrcType.setModifydate(new Date());
		readbookTypeDao.save(readSrcType);
	}

	/**
	 * 修改博览群书类别
	 * 
	 * @param readSrcType
	 * @throws Exception
	 */
	public void updateReadSrcType(ReadSrcType readSrcType) throws Exception {
		ReadSrcType newReadSrcType = getReadSrcTypeByTypeid(readSrcType
				.getSrctypeid());
		newReadSrcType.setSrctype(readSrcType.getSrctype());
		newReadSrcType.setModifydate(new Date());
		readbookTypeDao.update(newReadSrcType);
	}

	/**
	 * 根据博览群书类别ID删除博览群书类别
	 * 
	 * @param srctypeid
	 *            博览群书类别ID
	 * @throws Exception
	 */
	public void deleteReadSrcType(String srctypeid) throws Exception {
		readbookTypeDao.delete(srctypeid);
	}

	/**
	 * 根据博览群书类别ID获取博览群书类别信息
	 * 
	 * @param srctypeid
	 *            博览群书类别ID
	 * @return
	 * @throws Exception
	 */
	public ReadSrcType getReadSrcTypeByTypeid(String srctypeid)
			throws Exception {
		ReadSrcType readSrcType = readbookTypeDao.get(srctypeid);
		super.clear();
		return readSrcType;
	}

	/**
	 * 根据博览群书类别名称获取博览群书类别信息
	 * 
	 * @param srctypename
	 *            博览群书类别名称
	 * @return
	 * @throws Exception
	 */
	public ReadSrcType getReadSrcTypeByTypename(String srctypename)
			throws Exception {
		ReadSrcType readSrcType = readbookTypeDao.get("srctype", srctypename);
		super.clear();
		return readSrcType;
	}

	/**
	 * 获取所有博览群书类别信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<ReadSrcType> listReadSrcTypeAll() throws Exception {
		return readbookTypeDao.getAll();
	}

	/**
	 * 获取所有博览群书类别信息(第一级父类，上级类别)
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<ReadSrcType> listReadSrcTypeByParent() throws Exception {
		return readbookTypeDao.getList("readSrcType", null);
	}

	/**
	 * 根据上级类别查询所有博览群书类别信息
	 * 
	 * @param srctypeid
	 *            博览群书类别ID
	 * @return
	 * @throws Exception
	 */
	public List<ReadSrcType> listReadSrcTypeByChild(String srctypeid)
			throws Exception {
		return readbookTypeDao.listReadSrcTypeByChild(srctypeid);
	}

}
