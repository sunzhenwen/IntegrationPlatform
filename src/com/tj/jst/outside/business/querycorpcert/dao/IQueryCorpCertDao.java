package com.tj.jst.outside.business.querycorpcert.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * 查询企业拥有资质
 * 
 * @author Administrator
 *
 */
public interface IQueryCorpCertDao {

	/**
	 * 分页查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

}
