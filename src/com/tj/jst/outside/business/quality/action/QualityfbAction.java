package com.tj.jst.outside.business.quality.action;

import org.apache.struts2.ServletActionContext;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;
import com.tj.jst.outside.business.quality.condition.QualityfbCondition;

/**
 * 专业分包单位
 * @author Administrator
 *
 */
public class QualityfbAction extends BaseAction {
	
	private String k;

	public String getK() {
		return k;
	}

	public void setK(String k) {
		this.k = k;
	}
	/*----------------------------------------------------------------------------------------------------------*/	
	private QualityfbCondition condition = new QualityfbCondition();
	public void setKction(QualityfbCondition condition) {
		this.condition = condition;
	}
	public QualityfbCondition getCondition() {
		QualityfbCondition sessionCondition = (QualityfbCondition)get(getActionName());
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
	public String queryPagefb()
	{
		IContractFilingService service = new ContractFilingServiceImpl();
		ServletActionContext.getRequest().getSession().setAttribute("userrr",k);
		//分页查询
		currentPage = service.pagedQueryfb(this.getCondition());
		this.set(getActionName(), condition);
        return "queryPrjPagefb";
	}
	
}
