package com.tj.jst.inner.codeChange.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * ��ѯ��ҵ
 * @author hhc 2016-04-21
 *
 */
public interface IQueryCorpDao {
	
	/**
	 * ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
}
