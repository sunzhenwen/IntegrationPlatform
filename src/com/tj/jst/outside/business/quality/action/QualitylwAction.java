package com.tj.jst.outside.business.quality.action;

import org.apache.struts2.ServletActionContext;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;
import com.tj.jst.outside.business.quality.condition.QualitylwCondition;

/**
 * ����ְ���λ
 * @author Administrator
 *
 */
public class QualitylwAction extends BaseAction {

	private String j;

	public String getJ() {
		return j;
	}

	public void setJ(String j) {
		this.j = j;
	}
	/*----------------------------------------------------------------------------------------------------------*/	
	private QualitylwCondition condition = new QualitylwCondition();	
	public void setCondition(QualitylwCondition condition) {
		this.condition = condition;
	}
	public QualitylwCondition getCondition() {
		QualitylwCondition sessionCondition = (QualitylwCondition)get(getActionName());
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
	public String queryPagelw()
	{
		IContractFilingService service = new ContractFilingServiceImpl();
		ServletActionContext.getRequest().getSession().setAttribute("userr",j);
		//��ҳ��ѯ
		currentPage = service.pagedQuerylw(this.getCondition());
		this.set(getActionName(), condition);
        return "queryPrjPagelw";
	}	
}
