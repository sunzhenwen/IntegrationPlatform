package com.tj.jst.inner.integrity.corpBadIntegrity.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * ������Ϊ����
 * @author Administrator
 *
 */
public interface IQueryCreditCodeDao {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
}
