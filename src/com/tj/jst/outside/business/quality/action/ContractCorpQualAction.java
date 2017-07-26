package com.tj.jst.outside.business.quality.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.quality.condition.ContractCorpQualCondition;
import com.tj.jst.outside.business.quality.dao.ContractRecordDao;
import com.tj.jst.outside.business.quality.dao.ContractRecordDaoImpl;

public class ContractCorpQualAction extends BaseAction{
	
	/**
	 * ��ѯ���쵥λ
	 * @return
	 */
	public String queryPageA()
	{
		//IContractFilingService service = new ContractFilingServiceImpl();
		ContractRecordDao contractRecordDao=new ContractRecordDaoImpl();
		//��ҳ��ѯ
		currentPage = contractRecordDao.pagedContractCorpQualQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryContractCorpQualA";
	}

	/**
	 * ��ѯ��Ƶ�λ
	 * @return
	 */
	public String queryPageB()
	{
		//IContractFilingService service = new ContractFilingServiceImpl();
		ContractRecordDao contractRecordDao=new ContractRecordDaoImpl();
		//��ҳ��ѯ
		currentPage = contractRecordDao.pagedContractCorpQualQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryContractCorpQualB";
	}
	
	/**
	 * ����λ
	 * @return
	 */
	public String queryPageC()
	{
		//IContractFilingService service = new ContractFilingServiceImpl();
		ContractRecordDao contractRecordDao=new ContractRecordDaoImpl();
		//��ҳ��ѯ
		currentPage = contractRecordDao.pagedContractCorpQualQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryContractCorpQualC";
	}
	
	public String queryPageD()
	{
		//IContractFilingService service = new ContractFilingServiceImpl();
		ContractRecordDao contractRecordDao=new ContractRecordDaoImpl();
		//��ҳ��ѯ
		currentPage = contractRecordDao.pagedContractCorpQualQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryContractCorpQualD";
	}
	
	
	private ContractCorpQualCondition condition = new ContractCorpQualCondition();
	
	public void setCondition(ContractCorpQualCondition condition) {
		this.condition = condition;
	}

	public ContractCorpQualCondition getCondition() {
		ContractCorpQualCondition sessionCondition = (ContractCorpQualCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
}
