package com.tj.jst.outside.business.quality.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;
import com.tj.jst.outside.business.quality.condition.QualityjlCondition;

/**
 * ����˾��Ϣ��ѯ
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
	 * ��ѯ��Ƶ�λ��Ϣ
	 * @return
	 */
	public String queryPagejl()
	{
		IContractFilingService service = new ContractFilingServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedQueryjl(this.getCondition());
		this.set(getActionName(), condition);
        return "queryPrjPagesj";
	}
	
	
}
