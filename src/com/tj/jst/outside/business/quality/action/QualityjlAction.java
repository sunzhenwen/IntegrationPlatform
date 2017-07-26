package com.tj.jst.outside.business.quality.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;
import com.tj.jst.outside.business.quality.condition.QualityjlCondition;

/**
 * 监理公司信息查询
 * @author Administrator
 *
 */
public class QualityjlAction extends BaseAction {
	
/*----------------------------------------------------------------------------------------------------------*/	
	private QualityjlCondition condition = new QualityjlCondition();
	public void setKction(QualityjlCondition condition) {
		this.condition = condition;
	}
	public QualityjlCondition getCondition() {
		QualityjlCondition sessionCondition = (QualityjlCondition)get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	/**
	 * 查询设计单位信息
	 * @return
	 */
	public String queryPagejl()
	{
		IContractFilingService service = new ContractFilingServiceImpl();
		//分页查询
		currentPage = service.pagedQueryjl(this.getCondition());
		this.set(getActionName(), condition);
        return "queryPrjPagesj";
	}
	
	
}
