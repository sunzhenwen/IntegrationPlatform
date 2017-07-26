package com.tj.jst.inner.querycorpreport.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.querycorpreport.dao.IQueryCorpReportDao;
import com.tj.jst.inner.querycorpreport.dao.QueryCorpReportDaoImpl;
import com.tj.jst.outside.business.corpReport.model.CorpReport;

/**
 * ��ҵͳ�Ʊ������ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryCorpReportServiceImpl implements IQueryCorpReportService {

	/**
	 * ��ҳ����
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IQueryCorpReportDao dao = new QueryCorpReportDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * �鿴��ϸ
	 */
	@Override
	public CorpReport queryInfo(String id) {
		// TODO Auto-generated method stub
		IQueryCorpReportDao dao = new QueryCorpReportDaoImpl();
		return dao.queryInfo(id);
	}

}
