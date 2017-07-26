package com.tj.jst.inner.business.contractinfo.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.business.contractinfo.model.ContractInfo;

/**
 * ��ͬ��Ϣ����ӿ�
 * 
 * @author Administrator
 *
 */
public interface IContractInfoService {

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * ��ѯ��ϸ
	 * 
	 * @param conid
	 * @return
	 */
	public ContractInfo queryById(String conid);

	/**
	 * ������Ϣ
	 * 
	 * @param contract
	 * @return
	 */
	public String addContractInfo(ContractInfo contract);

	/**
	 * �޸���Ϣ
	 * 
	 * @param contract
	 * @return
	 */
	public String modifyContractInfo(ContractInfo contract);

	/**
	 * ɾ����Ϣ
	 * 
	 * @param conId
	 * @return
	 */
	public String deleteContarctInfo(String conId);

	/**
	 * ��ѯ��ͬ�������
	 * 
	 * @return
	 */
	public List<DictionaryClass> queryConTypeName();

}
