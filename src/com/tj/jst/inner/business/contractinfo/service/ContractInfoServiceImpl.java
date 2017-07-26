package com.tj.jst.inner.business.contractinfo.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.business.contractinfo.dao.ContractInfoDaoImpl;
import com.tj.jst.inner.business.contractinfo.dao.IContractInfoDao;
import com.tj.jst.inner.business.contractinfo.model.ContractInfo;

/**
 * ��ͬ��Ϣ������
 * 
 * @author Administrator
 *
 */
public class ContractInfoServiceImpl implements IContractInfoService {

	/**
	 * ��ҳ
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IContractInfoDao dao = new ContractInfoDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * ��ѯ��ϸ
	 */
	@Override
	public ContractInfo queryById(String conid) {
		// TODO Auto-generated method stub
		IContractInfoDao dao = new ContractInfoDaoImpl();
		return dao.queryById(conid);
	}

	/**
	 * ������Ϣ
	 */
	@Override
	public String addContractInfo(ContractInfo contract) {
		// TODO Auto-generated method stub
		IContractInfoDao dao = new ContractInfoDaoImpl();
		return dao.addContractInfo(contract);
	}

	/**
	 * �޸���Ϣ
	 */
	@Override
	public String modifyContractInfo(ContractInfo contract) {
		// TODO Auto-generated method stub
		IContractInfoDao dao = new ContractInfoDaoImpl();
		return dao.modifyContractInfo(contract);
	}

	/**
	 * ɾ����Ϣ
	 */
	@Override
	public String deleteContarctInfo(String conId) {
		// TODO Auto-generated method stub
		IContractInfoDao dao = new ContractInfoDaoImpl();
		return dao.deleteContarctInfo(conId);
	}

	/**
	 * ��ѯ��ͬ�������
	 */
	@Override
	public List<DictionaryClass> queryConTypeName() {
		// TODO Auto-generated method stub
		IContractInfoDao dao = new ContractInfoDaoImpl();
		return dao.queryConTypeName();
	}

}
