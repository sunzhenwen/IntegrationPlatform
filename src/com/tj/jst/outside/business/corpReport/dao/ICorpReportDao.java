package com.tj.jst.outside.business.corpReport.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.corpReport.model.CorpReport;

/**
 * ������ҵͳ�Ʊ���
 * @author hhc
 *
 */
public interface ICorpReportDao {
	
	/**
	 * ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * ���
	 * @param construction
	 * @return
	 */
	public void add(CorpReport corpReport);
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public CorpReport queryById(String id);
	
	/**
	 * �޸�
	 * @param construction
	 * @return
	 */
	public void modify(CorpReport corpReport);
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String id);
	
}
