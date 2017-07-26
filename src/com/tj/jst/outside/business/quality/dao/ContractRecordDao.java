package com.tj.jst.outside.business.quality.dao;

import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

public interface ContractRecordDao {
	
	/**
	 * 查询合同备案
	 * 
	 * @param condition
	 * @return
	 */
	public Page pageContractRecordQuery(Condition condition);
	/**
	 * 查询招投标备案
	 * @param condition
	 * @return
	 */
	public Page pagedContractCorpQualQuery(Condition condition);
	
	
	
}
