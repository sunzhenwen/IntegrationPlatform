package com.tj.jst.outside.business.quality.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;
import com.tj.jst.outside.business.quality.condition.QualitysjCondition;

/**
 * ��Ŀ��Ϣ��ѯ
 * @author Administrator
 *
 */
public class QualitySJAction extends BaseAction {
	
/*----------------------------------------------------------------------------------------------------------*/	
	private QualitysjCondition condition = new QualitysjCondition();
	public void setKction(QualitysjCondition condition) {
		this.condition = condition;
	}
	public QualitysjCondition getCondition() {
		QualitysjCondition sessionCondition = (QualitysjCondition)get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	/**
	 * ��ѯ��Ƶ�λ��Ϣ
	 * @return
	 */
	public String queryPageSJ()
	{
		IContractFilingService service = new ContractFilingServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedkcQuery(this.getCondition());
		this.set(getActionName(), condition);
        return "queryPrjPagesj";
	}
	
	
}
