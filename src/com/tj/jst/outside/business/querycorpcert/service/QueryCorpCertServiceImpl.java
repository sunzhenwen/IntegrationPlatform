package com.tj.jst.outside.business.querycorpcert.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.querycorpcert.dao.IQueryCorpCertDao;
import com.tj.jst.outside.business.querycorpcert.dao.QueryCorpCertDaoImpl;

/**
 * ��ѯ��ҵӵ������
 * 
 * @author Administrator
 *
 */
public class QueryCorpCertServiceImpl implements IQueryCorpCertService {

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IQueryCorpCertDao dao = new QueryCorpCertDaoImpl();
		return dao.queryPage(condition);
	}

}
