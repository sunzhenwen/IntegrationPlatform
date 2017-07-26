package com.tj.jst.outside.business.corpReport.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.corpReport.dao.CorpReportDaoImpl;
import com.tj.jst.outside.business.corpReport.dao.ICorpReportDao;
import com.tj.jst.outside.business.corpReport.model.CorpReport;

/**
 * 建筑企业统计报表
 * @author hhc
 *
 */
public class CorpReportServiceImpl implements ICorpReportService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ICorpReportDao dao = new CorpReportDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * 添加
	 * @param construction
	 * @return
	 */
	public void add(CorpReport corpReport)
	{
		ICorpReportDao dao = new CorpReportDaoImpl();
		dao.add(corpReport);
	}
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public CorpReport queryById(String id)
	{
		ICorpReportDao dao = new CorpReportDaoImpl();
		return dao.queryById(id);
	}
	
	/**
	 * 修改
	 * @param construction
	 * @return
	 */
	public void modify(CorpReport corpReport)
	{
		ICorpReportDao dao = new CorpReportDaoImpl();
		dao.modify(corpReport);
	}
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String id)
	{
		ICorpReportDao dao = new CorpReportDaoImpl();
		dao.delete(id);
	}
	
}
