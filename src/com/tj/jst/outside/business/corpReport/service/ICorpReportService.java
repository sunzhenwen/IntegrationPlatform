package com.tj.jst.outside.business.corpReport.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.corpReport.model.CorpReport;

/**
 * 建筑企业统计报表
 * @author hhc
 *
 */
public interface ICorpReportService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 添加
	 * @param construction
	 * @return
	 */
	public void add(CorpReport corpReport);
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public CorpReport queryById(String prjId);
	
	/**
	 * 修改
	 * @param construction
	 * @return
	 */
	public void modify(CorpReport corpReport);
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String id);
	
}
