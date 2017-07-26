package com.tj.jst.inner.querycorpreport.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.corpReport.model.CorpReport;

/**
 * ��ҵͳ�Ʊ��������ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public interface IQueryCorpReportService {

	/**
	 * ��ҳ����
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * �鿴��ϸ��Ϣ
	 * 
	 * @param id
	 * @return
	 */
	public CorpReport queryInfo(String id);

}
