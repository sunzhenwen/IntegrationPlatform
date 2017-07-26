package com.tj.jst.outside.business.quality.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;
import com.tj.jst.outside.business.quality.condition.QualitykcsCondition;

/**
 * 项目信息查询
 * @author Administrator
 *
 */
public class QualitykcAction extends BaseAction {
	
	/*----------------------------------------------------------------------------------------------------------*/	
	private QualitykcsCondition condition = new QualitykcsCondition();
	public void setKction(QualitykcsCondition condition) {
		this.condition = condition;
	}
	public QualitykcsCondition getCondition() {
		QualitykcsCondition sessionCondition = (QualitykcsCondition)get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	/**
	 * 查询勘察单位信息
	 * @return
	 */
	public String queryPagekc()
	{
		IContractFilingService service = new ContractFilingServiceImpl();
		//分页查询
		currentPage = service.pagedkcQuery(this.getCondition());
		this.set(getActionName(), condition);
        return "queryPrjPagekc";
	}
	
	
}
