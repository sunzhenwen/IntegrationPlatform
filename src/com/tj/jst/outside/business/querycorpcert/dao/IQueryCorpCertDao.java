package com.tj.jst.outside.business.querycorpcert.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * ��ѯ��ҵӵ������
 * 
 * @author Administrator
 *
 */
public interface IQueryCorpCertDao {

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

}
