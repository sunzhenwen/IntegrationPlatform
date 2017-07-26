package com.tj.jst.outside.business.queryBusiness.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;

/**
 * 施工图审查
 * @author hhc
 *
 */
public interface IQueryConstructionPlansService {
	
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
	public ConstructionPlans queryById(String censorId);
	
	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept();
	

}
