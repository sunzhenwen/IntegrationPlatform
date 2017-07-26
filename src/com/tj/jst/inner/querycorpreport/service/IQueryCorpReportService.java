package com.tj.jst.inner.querycorpreport.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.corpReport.model.CorpReport;

/**
 * 企业统计报表服务类接口
 * 
 * @author DarkFlameMaster
 *
 */
public interface IQueryCorpReportService {

	/**
	 * 分页工具
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * 查看详细信息
	 * 
	 * @param id
	 * @return
	 */
	public CorpReport queryInfo(String id);

}
