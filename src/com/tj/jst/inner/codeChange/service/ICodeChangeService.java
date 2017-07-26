package com.tj.jst.inner.codeChange.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.codeChange.model.CodeChange;

/**
 * 组织机构代码变更
 * @author hhc 2016-04-21
 *
 */
public interface ICodeChangeService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);

	/**
	 * 添加
	 * @return
	 */
	public String add(CodeChange codeChange);
}
