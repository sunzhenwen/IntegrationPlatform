package com.tj.jst.inner.business.contractinfo.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.business.contractinfo.condition.ContractInfoCondition;
import com.tj.jst.inner.business.contractinfo.model.ContractInfo;
import com.tj.jst.inner.business.contractinfo.service.ContractInfoServiceImpl;
import com.tj.jst.inner.business.contractinfo.service.IContractInfoService;

/**
 * ��ͬ��Ϣ����
 * 
 * @author Administrator
 *
 */
public class ContractInfoAction extends BaseAction {

	private ContractInfo contract;// Model��
	private String conId;// ��ѯ����
	private String message;// ������Ϣ
	private List<DictionaryClass> conTypes;// ��ͬ����

	private ContractInfoCondition condition = new ContractInfoCondition();

	public void setCondition(ContractInfoCondition condition) {
		this.condition = condition;
	}

	public ContractInfoCondition getCondition() {
		ContractInfoCondition sessionCondition = (ContractInfoCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * ��ҳ��ѯ
	 * 
	 * @return
	 */
	public String queryPage() {
		IContractInfoService service = new ContractInfoServiceImpl();
		currentPage = service.queryPage(condition);
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ����ҳ��
	 * 
	 * @return
	 */
	public String addPage() {
		return "addPage";
	}

	/**
	 * ���ӷ���
	 * 
	 * @return
	 */
	public String addMethod() {
		IContractInfoService service = new ContractInfoServiceImpl();
		message = service.addContractInfo(contract);
		return "query";
	}

	/**
	 * �޸�ҳ��
	 * 
	 * @return
	 */
	public String modifyPage() {
		IContractInfoService service = new ContractInfoServiceImpl();
		contract = service.queryById(conId);
		return "modifyPage";
	}

	/**
	 * �޸ķ���
	 * 
	 * @return
	 */
	public String modifyMethod() {
		IContractInfoService service = new ContractInfoServiceImpl();
		message = service.modifyContractInfo(contract);
		return "query";
	}

	/**
	 * ɾ������
	 * 
	 * @return
	 */
	public String deleteMethod() {
		IContractInfoService service = new ContractInfoServiceImpl();
		message = service.deleteContarctInfo(conId);
		return "query";
	}

	/**
	 * ����
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	public ContractInfo getContract() {
		return contract;
	}

	public void setContract(ContractInfo contract) {
		this.contract = contract;
	}

	public String getConId() {
		return conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<DictionaryClass> getConTypes() {
		return conTypes;
	}

	public void setConTypes(List<DictionaryClass> conTypes) {
		this.conTypes = conTypes;
	}

}
