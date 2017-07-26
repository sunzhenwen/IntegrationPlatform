package com.tj.jst.outside.business.queryBusiness.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.permit.dao.IPermitDao;
import com.tj.jst.outside.business.permit.dao.PermitDaoImpl;
import com.tj.jst.outside.business.permit.model.Permit;

/**
 * 施工许可
 * @author hhc
 *
 */
public interface IQueryPermitDao {
	
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Permit queryById(String permitId);
	
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
}
