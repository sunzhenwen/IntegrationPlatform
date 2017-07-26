package com.tj.jst.outside.business.quality.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;
import com.tj.jst.outside.business.quality.condition.QualityzbCondition;

/**
 * ��Ŀ��Ϣ��ѯ
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
	 * ��ѯ��Ƶ�λ��Ϣ
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
		//��ҳ��ѯ
		currentPage = service.pagedQueryzb(this.getCondition());
		this.set(getActionName(), condition);
        return "queryPrjPagezb";
	}
	
	
}
