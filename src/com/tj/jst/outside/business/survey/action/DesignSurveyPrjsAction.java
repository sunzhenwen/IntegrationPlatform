package com.tj.jst.outside.business.survey.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;
import com.tj.jst.outside.business.survey.condition.DesignSurveyPrjsCondition;

/**
 * ��Ŀ��Ϣ��ѯ
 * @author Administrator
 *
 */
public class DesignSurveyPrjsAction extends BaseAction {
	
		
	private DesignSurveyPrjsCondition condition = new DesignSurveyPrjsCondition(((Login)this.get("login")).getCorpCode());
	
	public void setCondition(DesignSurveyPrjsCondition condition) {
		this.condition = condition;
	}

	public DesignSurveyPrjsCondition getCondition() {
		DesignSurveyPrjsCondition sessionCondition = (DesignSurveyPrjsCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		IContractFilingService service = new ContractFilingServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedPrjQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPrjPage";
	}
	
}
