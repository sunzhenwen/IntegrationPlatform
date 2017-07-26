package com.tj.jst.inner.querycorpreport.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.querycorpreport.dao.IQueryCorpReportDao;
import com.tj.jst.inner.querycorpreport.dao.QueryCorpReportDaoImpl;
import com.tj.jst.outside.business.corpReport.model.CorpReport;

/**
 * 企业统计报表服务接口
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryCorpReportServiceImpl implements IQueryCorpReportService {

	/**
	 * 分页工具
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IQueryCorpReportDao dao = new QueryCorpReportDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * 查看详细
	 */
	@Override
	public CorpReport queryInfo(String id) {
		// TODO Auto-generated method stub
		IQueryCorpReportDao dao = new QueryCorpReportDaoImpl();
		return dao.queryInfo(id);
	}

}
