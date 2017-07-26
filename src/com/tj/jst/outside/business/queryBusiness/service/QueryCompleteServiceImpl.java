package com.tj.jst.outside.business.queryBusiness.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.complete.dao.CompleteDaoImpl;
import com.tj.jst.outside.business.complete.dao.ICompleteDao;
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.queryBusiness.dao.IQueryCompleteDao;
import com.tj.jst.outside.business.queryBusiness.dao.QueryCompleteDaoImpl;

/**
 * 竣工验收
 * @author hhc
 *
 */
public class QueryCompleteServiceImpl implements IQueryCompleteService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQueryCompleteDao dao = new QueryCompleteDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Complete queryById(String completeId)
	{
		IQueryCompleteDao dao = new QueryCompleteDaoImpl();
		return dao.queryById(completeId);
	}
	
	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IQueryCompleteDao dao = new QueryCompleteDaoImpl();
		return dao.queryAppDept();
	}
	
	//结构体系
	public List<DictionaryClass> queryPrjStructureTypeNums()
	{
		IQueryCompleteDao dao = new QueryCompleteDaoImpl();
		return dao.queryPrjStructureTypeNums();
	}
}
