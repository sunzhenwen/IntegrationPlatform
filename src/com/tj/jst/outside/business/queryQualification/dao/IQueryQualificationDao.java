package com.tj.jst.outside.business.queryQualification.dao;

import java.util.List;

import com.tj.jst.outside.business.queryQualification.model.Qualification;


/**
 * ҵ���ѯ
 * 
 * @author Administrator
 *
 */
public interface IQueryQualificationDao {

	/**
	 * ��ѯ��ҳ
	 * 
	 * @param condition
	 * @return
	 */
	public List<Qualification> queryPage(String corpCode);


}

	