package com.tj.jst.inner.business.contractinfo.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.business.contractinfo.dao.ContractInfoDaoImpl;
import com.tj.jst.inner.business.contractinfo.dao.IContractInfoDao;
import com.tj.jst.inner.business.contractinfo.model.ContractInfo;

/**
 * 合同信息服务类
 * 
 * @author Administrator
 *
 */
public class ContractInfoServiceImpl implements IContractInfoService {

	/**
	 * 分页
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IContractInfoDao dao = new ContractInfoDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * 查询详细
	 */
	@Override
	public ContractInfo queryById(String conid) {
		// TODO Auto-generated method stub
		IContractInfoDao dao = new ContractInfoDaoImpl();
		return dao.queryById(conid);
	}

	/**
	 * 增加信息
	 */
	@Override
	public String addContractInfo(ContractInfo contract) {
		// TODO Auto-generated method stub
		IContractInfoDao dao = new ContractInfoDaoImpl();
		return dao.addContractInfo(contract);
	}

	/**
	 * 修改信息
	 */
	@Override
	public String modifyContractInfo(ContractInfo contract) {
		// TODO Auto-generated method stub
		IContractInfoDao dao = new ContractInfoDaoImpl();
		return dao.modifyContractInfo(contract);
	}

	/**
	 * 删除信息
	 */
	@Override
	public String deleteContarctInfo(String conId) {
		// TODO Auto-generated method stub
		IContractInfoDao dao = new ContractInfoDaoImpl();
		return dao.deleteContarctInfo(conId);
	}

	/**
	 * 查询合同类别名称
	 */
	@Override
	public List<DictionaryClass> queryConTypeName() {
		// TODO Auto-generated method stub
		IContractInfoDao dao = new ContractInfoDaoImpl();
		return dao.queryConTypeName();
	}

}
