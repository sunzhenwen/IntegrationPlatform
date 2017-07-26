package com.tj.jst.inner.codeChange.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.codeChange.dao.CodeChangeDaoImpl;
import com.tj.jst.inner.codeChange.dao.ICodeChangeDao;
import com.tj.jst.inner.codeChange.model.CodeChange;

/**
 * 组织机构代码变更
 * @author hhc 2016-04-21
 *
 */
public class CodeChangeServiceImpl implements ICodeChangeService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ICodeChangeDao dao = new CodeChangeDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * 添加
	 * @return
	 */
	public String add(CodeChange codeChange)
	{
		ICodeChangeDao dao = new CodeChangeDaoImpl();
		return dao.add(codeChange);
	}
}
