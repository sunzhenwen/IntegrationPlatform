package com.tj.jst.outside.business.quality.action;

import org.apache.struts2.ServletActionContext;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;
import com.tj.jst.outside.business.quality.condition.QualitylwCondition;

/**
 * 劳务分包单位
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
	 * 查询设计单位信息
	 * @return
	 */
	public String queryPagelw()
	{
		IContractFilingService service = new ContractFilingServiceImpl();
		ServletActionContext.getRequest().getSession().setAttribute("userr",j);
		//分页查询
		currentPage = service.pagedQuerylw(this.getCondition());
		this.set(getActionName(), condition);
        return "queryPrjPagelw";
	}	
}
