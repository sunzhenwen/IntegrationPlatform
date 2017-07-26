package com.tj.jst.outside.business.corpReport.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.corpReport.dao.CorpReportDaoImpl;
import com.tj.jst.outside.business.corpReport.dao.ICorpReportDao;
import com.tj.jst.outside.business.corpReport.model.CorpReport;

/**
 * ������ҵͳ�Ʊ���
 * @author hhc
 *
 */
public class CorpReportServiceImpl implements ICorpReportService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ICorpReportDao dao = new CorpReportDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * ���
	 * @param construction
	 * @return
	 */
	public void add(CorpReport corpReport)
	{
		ICorpReportDao dao = new CorpReportDaoImpl();
		dao.add(corpReport);
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public CorpReport queryById(String id)
	{
		ICorpReportDao dao = new CorpReportDaoImpl();
		return dao.queryById(id);
	}
	
	/**
	 * �޸�
	 * @param construction
	 * @return
	 */
	public void modify(CorpReport corpReport)
	{
		ICorpReportDao dao = new CorpReportDaoImpl();
		dao.modify(corpReport);
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String id)
	{
		ICorpReportDao dao = new CorpReportDaoImpl();
		dao.delete(id);
	}
	
}
