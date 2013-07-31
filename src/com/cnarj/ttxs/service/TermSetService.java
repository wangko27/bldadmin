package com.cnarj.ttxs.service;

import java.util.List;

import com.cnarj.ttxs.pojo.dsis.TTermSet;
import com.cnarj.ttxs.util.BusinessException;

/**
 * 学校学期接口类
 * @author hedan
 *
 */
public interface TermSetService extends  BaseDsisService<TTermSet, Long>{

   /**
    * 通过学校ID得到学期
    * @param xxid
    * @return
    */
	List<TTermSet> getTermListByXxid(String xxid)throws BusinessException;
   
}
