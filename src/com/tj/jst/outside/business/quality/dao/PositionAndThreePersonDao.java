package com.tj.jst.outside.business.quality.dao;

import java.util.List;

import pojo.PERSON_SLRY;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

public interface PositionAndThreePersonDao {
	
	/**
	 * ��ѯ��ҳ
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagePositionQuery(Condition condition);
	/**
	 * ��ѯ�Ƿ���ʡ
	 * @param corpname
	 * @return
	 */
	public boolean queryCorpBasicIndfo(String corpName,String corpCode);
	
	
	//��ȡ������Ա
	public List<PERSON_SLRY> queryPERSON_SLRYList(String FIdCertNo,String FEntName);
	
	
	
}
