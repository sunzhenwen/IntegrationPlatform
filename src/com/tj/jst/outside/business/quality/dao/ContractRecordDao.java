package com.tj.jst.outside.business.quality.dao;

import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

public interface ContractRecordDao {
	
	/**
	 * ��ѯ��ͬ����
	 * 
	 * @param condition
	 * @return
	 */
	public Page pageContractRecordQuery(Condition condition);
	/**
	 * ��ѯ��Ͷ�걸��
	 * @param condition
	 * @return
	 */
	public Page pagedContractCorpQualQuery(Condition condition);
	
	
	
}
