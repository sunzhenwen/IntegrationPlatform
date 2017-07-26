package com.tj.jst.outside.business.quality.action;

import com.tj.jst.base.action.BaseAction;

import com.tj.jst.outside.business.quality.condition.ContractRecordCondition;
import com.tj.jst.outside.business.quality.dao.ContractRecordDao;
import com.tj.jst.outside.business.quality.dao.ContractRecordDaoImpl;

public class ContractRecordAction extends BaseAction{
	/**
	 * ≤È—Ø
	 * @return
	 */
	public String queryPage()
	{
		//IContractFilingService service = new ContractFilingServiceImpl();
		ContractRecordDao contractRecordDao=new ContractRecordDaoImpl();
		//∑÷“≥≤È—Ø
		currentPage = contractRecordDao.pageContractRecordQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryContractRecord";
	}

	private ContractRecordCondition condition = new ContractRecordCondition();
	
	public void setCondition(ContractRecordCondition condition) {
		this.condition = condition;
	}

	public ContractRecordCondition getCondition() {
		ContractRecordCondition sessionCondition = (ContractRecordCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
}
