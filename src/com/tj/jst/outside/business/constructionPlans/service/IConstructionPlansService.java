package com.tj.jst.outside.business.constructionPlans.service;

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
public interface IConstructionPlansService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 施工图审查申请
	 * @return
	 */
	public String add(ConstructionPlans constructionPlans);
	
	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept();
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public ConstructionPlans queryById(String censorId);
	
	/**
	 * 合同备案申请修改
	 * @return
	 */
	public void modify(ConstructionPlans constructionPlans);
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String censorId);
}
