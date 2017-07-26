package com.tj.jst.outside.business.queryQualification.dao;

import java.util.List;

import com.tj.jst.outside.business.queryQualification.model.Qualification;


/**
 * 业务查询
 * 
 * @author Administrator
 *
 */
public interface IQueryQualificationDao {

	/**
	 * 查询分页
	 * 
	 * @param condition
	 * @return
	 */
	public List<Qualification> queryPage(String corpCode);


}

	