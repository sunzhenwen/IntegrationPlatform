package com.tj.jst.inner.integrityShare.corpBadIntegrityShare.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * 不良行为代码
 * @author Administrator
 *
 */
public interface IQueryCreditCodeService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
}
