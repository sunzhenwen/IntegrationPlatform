package com.tj.jst.outside.business.queryBusiness.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.construction.model.Regional;

/**
 * 项目报建
 * @author hhc
 *
 */
public interface IQueryConstructionService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept();
	
	//项目分类(字典表：TBPRJTYPEDIC)
	public List<DictionaryClass> queryPrjTypeNums();
	//建设性质(字典表：TBPRJPROPERTYDIC)
	public List<DictionaryClass> queryPrjPropertyNums(); 
	//工程用途(字典表：TBPRJFUNCTIONDIC)
	public List<DictionaryClass> queryPrjFuncitonNums();
	//查询省
	public List<DictionaryClass> queryProvince();
	//查询市
	public List<DictionaryClass> queryCity(String provinceId);
	//查询区
	public List<DictionaryClass> queryArea(String cityId);
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Construction queryById(String prjId);
	//立项级别
	public List<DictionaryClass> queryPrjApprovalLevelNums();
}
