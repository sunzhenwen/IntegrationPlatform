package com.tj.jst.outside.business.constructionFiling.mainContractor.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;

/**
 * 施工合同备案
 * @author hhc
 *
 */
public interface IConstructionContractDao {
	
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 合同备案申请
	 * @return
	 */
	public String add(ContractFiling contractFiling);
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public ContractFiling queryById(String recordId);
	
	/**
	 * 合同备案申请修改
	 * @return
	 */
	public void modify(ContractFiling contractFiling);
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String recordId);
	
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
	//合同类别
	public List<DictionaryClass> queryContractTypeNums();
	/**
	 * 查询项目
	 * @param condition
	 * @return
	 */
	public Page pagedPrjQuery(Condition condition);
	
	/**
	 * 查询招投标项目
	 * @param condition
	 * @return
	 */
	public Page pagedTbInfoQuery(Condition condition);
	
	/**
	 * 查询企业资质
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQuery(Condition condition);
	
	/**
	 * 提交
	 * @return
	 */
	public void sub(String recordId);
}
