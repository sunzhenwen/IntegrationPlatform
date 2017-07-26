package com.tj.jst.outside.business.queryBusiness.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.constructionFiling.fileWorld.model.FileWorld;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;

/**
 * 合同备案
 * @author hhc
 *
 */
public interface IQueryContractFilingService {
	
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
	public ContractFiling queryById(String recordId);
	
	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept();
	
	
	//合同类别
	public List<DictionaryClass> queryContractTypeNums();
	/**
	 * 查询项目
	 * @param condition
	 * @return
	 */
	public Page pagedPrjQuery(Condition condition);

	/**
	 * 查看合同列表
	 * @return
	 */
	public List<FileWorld> fileWorldList(String recordId);
	
	/**
	 * 查看合同
	 * @return
	 */
	public FileWorld fileWorld(String conId);
	
	/**
	 * 查看通用合同
	 * @return
	 */
	public FileWorld currencyFileWorld(String inCommon,String conType);

	
}
