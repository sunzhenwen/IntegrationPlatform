package com.tj.jst.outside.business.querycorpcert.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * 查询企业拥有资质
 * 
 * @author Administrator
 *
 */
public interface IQueryCorpCertService {

	/**
	 * 分页查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

}
