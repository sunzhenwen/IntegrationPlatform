package com.tj.jst.inner.integrityShare.corpBadIntegrityShare.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.integrity.corpBadIntegrity.dao.IQueryCreditCodeDao;
import com.tj.jst.inner.integrity.corpBadIntegrity.dao.QueryCreditCodeDaoImpl;

/**
 * 不良行为代码
 * @author Administrator
 *
 */
public class QueryCreditCodeServiceImpl implements IQueryCreditCodeService {

	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQueryCreditCodeDao dao = new QueryCreditCodeDaoImpl();
		return dao.pagedQuery(condition);
	}

}
