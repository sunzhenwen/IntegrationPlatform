package com.tj.jst.inner.codeChange.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * 查询企业
 * @author hhc 2016-04-21
 *
 */
public interface IQueryCorpDao {
	
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
}
