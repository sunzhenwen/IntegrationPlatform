package com.tj.jst.inner.codeChange.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.codeChange.model.CodeChange;

/**
 * ��֯����������
 * @author hhc 2016-04-21
 *
 */
public interface ICodeChangeService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);

	/**
	 * ���
	 * @return
	 */
	public String add(CodeChange codeChange);
}
