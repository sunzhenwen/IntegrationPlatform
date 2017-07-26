package com.tj.jst.outside.business.queryBusiness.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.queryBusiness.dao.IQuerySafetyDao;
import com.tj.jst.outside.business.queryBusiness.dao.QuerySafetyDaoImpl;
import com.tj.jst.outside.business.safety.dao.ISafetyDao;
import com.tj.jst.outside.business.safety.dao.SafetyDaoImpl;
import com.tj.jst.outside.business.safety.model.Safety;

/**
 * 安全监督
 * @author hhc
 *
 */
public class QuerySafetyServiceImpl implements IQuerySafetyService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQuerySafetyDao dao = new QuerySafetyDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Safety queryById(String qualityId)
	{
		IQuerySafetyDao dao = new QuerySafetyDaoImpl();
		return dao.queryById(qualityId);
	}
	
	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IQuerySafetyDao dao = new QuerySafetyDaoImpl();
		return dao.queryAppDept();
	}
	//工程类型
	public List<DictionaryClass> queryProjectTypes()
	{
		IQuerySafetyDao dao = new QuerySafetyDaoImpl();
		return dao.queryProjectTypes();
	}
}
