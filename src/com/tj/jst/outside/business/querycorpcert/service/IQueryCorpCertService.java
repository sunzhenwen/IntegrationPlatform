package com.tj.jst.outside.business.querycorpcert.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * ��ѯ��ҵӵ������
 * 
 * @author Administrator
 *
 */
public interface IQueryCorpCertService {

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

}
