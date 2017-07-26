package com.tj.jst.outside.business.quality.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.quality.condition.ContractCorpQualCondition;
import com.tj.jst.outside.business.quality.dao.ContractRecordDao;
import com.tj.jst.outside.business.quality.dao.ContractRecordDaoImpl;

public class ContractCorpQualAction extends BaseAction{
	
	/**
	 * 查询勘察单位
	 * @return
	 */
	public String queryPageA()
	{
		//IContractFilingService service = new ContractFilingServiceImpl();
		ContractRecordDao contractRecordDao=new ContractRecordDaoImpl();
		//分页查询
		currentPage = contractRecordDao.pagedContractCorpQualQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryContractCorpQualA";
	}

	/**
	 * 查询设计单位
	 * @return
	 */
	public String queryPageB()
	{
		//IContractFilingService service = new ContractFilingServiceImpl();
		ContractRecordDao contractRecordDao=new ContractRecordDaoImpl();
		//分页查询
		currentPage = contractRecordDao.pagedContractCorpQualQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryContractCorpQualB";
	}
	
	/**
	 * 监理单位
	 * @return
	 */
	public String queryPageC()
	{
		//IContractFilingService service = new ContractFilingServiceImpl();
		ContractRecordDao contractRecordDao=new ContractRecordDaoImpl();
		//分页查询
		currentPage = contractRecordDao.pagedContractCorpQualQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryContractCorpQualC";
	}
	
	public String queryPageD()
	{
		//IContractFilingService service = new ContractFilingServiceImpl();
		ContractRecordDao contractRecordDao=new ContractRecordDaoImpl();
		//分页查询
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
