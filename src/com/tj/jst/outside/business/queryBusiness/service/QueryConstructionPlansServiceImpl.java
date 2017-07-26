package com.tj.jst.outside.business.queryBusiness.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.constructionPlans.dao.ConstructionPlansDaoImpl;
import com.tj.jst.outside.business.constructionPlans.dao.IConstructionPlansDao;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;
import com.tj.jst.outside.business.queryBusiness.dao.IQueryConstructionPlansDao;
import com.tj.jst.outside.business.queryBusiness.dao.QueryConstructionPlansDaoImpl;

/**
 * 施工图审查
 * @author hhc
 *
 */
public class QueryConstructionPlansServiceImpl implements IQueryConstructionPlansService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQueryConstructionPlansDao dao = new QueryConstructionPlansDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public ConstructionPlans queryById(String censorId)
	{
		IQueryConstructionPlansDao dao = new QueryConstructionPlansDaoImpl();
		return dao.queryById(censorId);
	}
	
	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IQueryConstructionPlansDao dao = new QueryConstructionPlansDaoImpl();
		return dao.queryAppDept();
	}
}
