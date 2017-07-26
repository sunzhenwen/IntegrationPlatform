package com.tj.jst.outside.business.permit.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.permit.model.Permit;

/**
 * 施工许可
 * @author hhc
 *
 */
public interface IPermitDao {
	
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 施工许可申请
	 * @return
	 */
	public String add(Permit permit);
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Permit queryById(String permitId);
	
	/**
	 * 施工许可申请修改
	 * @return
	 */
	public void modify(Permit permit);
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String permitId);
	
	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept();
	/**
	 * 根据树形排序id查询区域编码
	 * @param appDept
	 * @return
	 */
	public String queryAppDeptId(String appDept);
	
	//证件类型
	public List<DictionaryClass> queryCardTypeNums();
	
	/**
	 * 施工许可,质量信息查询
	 * @author Administrator
	 *
	 */
	public Page pagedQueryQuality(Condition condition);
	
	/**
	 * 施工许可,安全信息查询
	 * @author Administrator
	 *
	 */
	public Page pagedQueryPermSafety(Condition condition);
	
	/**
	 * 施工许可,施工图审查合格书编号
	 * @param condition
	 * @return
	 */
	public Page pagedQueryPlanNum(Condition condition);
}
