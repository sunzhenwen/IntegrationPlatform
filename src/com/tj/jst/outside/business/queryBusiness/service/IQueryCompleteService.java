package com.tj.jst.outside.business.queryBusiness.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.construction.model.Regional;

/**
 * 竣工验收
 * @author hhc
 *
 */
public interface IQueryCompleteService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Complete queryById(String completeId);
	
	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept();
	
	//结构体系
	public List<DictionaryClass> queryPrjStructureTypeNums();
}
