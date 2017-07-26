package com.tj.jst.outside.business.queryBusiness.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.permit.dao.IPermitDao;
import com.tj.jst.outside.business.permit.dao.PermitDaoImpl;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.queryBusiness.dao.IQueryPermitDao;
import com.tj.jst.outside.business.queryBusiness.dao.QueryPermitDaoImpl;

/**
 * 施工许可
 * @author hhc
 *
 */
public class QueryPermitServiceImpl implements IQueryPermitService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQueryPermitDao dao = new QueryPermitDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Permit queryById(String permitId)
	{
		IQueryPermitDao dao = new QueryPermitDaoImpl();
		return dao.queryById(permitId);
	}
	
	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IQueryPermitDao dao = new QueryPermitDaoImpl();
		return dao.queryAppDept();
	}
	
	//证件类型
	public List<DictionaryClass> queryCardTypeNums()
	{
		IQueryPermitDao dao = new QueryPermitDaoImpl();
		return dao.queryCardTypeNums();
	}
}
