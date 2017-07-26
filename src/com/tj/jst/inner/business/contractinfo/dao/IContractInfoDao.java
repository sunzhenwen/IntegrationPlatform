package com.tj.jst.inner.business.contractinfo.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.business.contractinfo.model.ContractInfo;

/**
 * 合同信息数据库接口
 * 
 * @author Administrator
 *
 */
public interface IContractInfoDao {

	/**
	 * 分页查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * 查询详细
	 * 
	 * @param conid
	 * @return
	 */
	public ContractInfo queryById(String conid);

	/**
	 * 增加信息
	 * 
	 * @param contract
	 * @return
	 */
	public String addContractInfo(ContractInfo contract);

	/**
	 * 修改信息
	 * 
	 * @param contract
	 * @return
	 */
	public String modifyContractInfo(ContractInfo contract);

	/**
	 * 删除信息
	 * 
	 * @param conId
	 * @return
	 */
	public String deleteContarctInfo(String conId);

	/**
	 * 查询合同类别名称
	 * 
	 * @return
	 */
	public List<DictionaryClass> queryConTypeName();

}
