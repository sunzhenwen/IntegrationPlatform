package com.tj.jst.outside.business.quality.dao;

import java.util.List;

import pojo.PERSON_SLRY;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

public interface PositionAndThreePersonDao {
	
	/**
	 * 查询分页
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagePositionQuery(Condition condition);
	/**
	 * 查询是否外省
	 * @param corpname
	 * @return
	 */
	public boolean queryCorpBasicIndfo(String corpName,String corpCode);
	
	
	//获取三类人员
	public List<PERSON_SLRY> queryPERSON_SLRYList(String FIdCertNo,String FEntName);
	
	
	
}
