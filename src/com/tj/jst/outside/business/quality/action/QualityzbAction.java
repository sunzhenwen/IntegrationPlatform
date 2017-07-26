package com.tj.jst.outside.business.quality.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;
import com.tj.jst.outside.business.quality.condition.QualityzbCondition;

/**
 * 项目信息查询
 * @author Administrator
 *
 */
public class QualityzbAction extends BaseAction {
	private String prjnum;
	
	public String getPrjnum() {
		return prjnum;
	}

	public void setPrjnum(String prjnum) {
		this.prjnum = prjnum;
	}
	private String result;
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
/*----------------------------------------------------------------------------------------------------------*/	
	private QualityzbCondition condition = new QualityzbCondition();
	public void setKction(QualityzbCondition condition) {
		this.condition = condition;
	}
	public QualityzbCondition getCondition() {
		QualityzbCondition sessionCondition = (QualityzbCondition)get(getActionName());
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
	public String queryPagezb()
	{

		//String prjNum = (String)this.get("prjNum");
		IContractFilingService service = new ContractFilingServiceImpl();
		if(prjnum!=null&&""!=prjnum){
			this.getCondition().setPrjNum(prjnum);				
		}else{
			this.getCondition().setPrjNum(prjnum);
		}
		//分页查询
		currentPage = service.pagedQueryzb(this.getCondition());
		this.set(getActionName(), condition);
        return "queryPrjPagezb";
	}
	
	
}
