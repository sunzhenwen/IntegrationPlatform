package com.tj.jst.inner.codeChange.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.codeChange.dao.IQueryCorpDao;
import com.tj.jst.inner.codeChange.dao.QueryCorpDaoImpl;

/**
 * ��ѯ��ҵ
 * @author hhc 2016-04-21
 *
 */
public class QueryCorpServiceImpl implements IQueryCorpService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQueryCorpDao dao = new QueryCorpDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
}
