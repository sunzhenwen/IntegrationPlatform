package com.tj.jst.outside.business.quality.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;
import com.tj.jst.outside.business.quality.condition.QualityPrjsCondition;

/**
 * ��Ŀ��Ϣ��ѯ
 * @author Administrator
 *
 */
public class QualityPrjsAction extends BaseAction {
	
	private String checkType;
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
	private QualityPrjsCondition condition = new QualityPrjsCondition();
	public void setCondition(QualityPrjsCondition condition) {
		this.condition = condition;
	}

	public QualityPrjsCondition getCondition() {
		QualityPrjsCondition sessionCondition = (QualityPrjsCondition) get(getActionName());
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
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);	
		//��ҳ��ѯ
		currentPage = service.pagedPrjQuery(this.getCondition());
		this.set(getActionName(), condition);
		if("1".equals(checkType))
		{
			return "querySafetyPage";
		}else{
			return "queryPrjPage";
		}
	}
	/**
	 * ��ѯ�޸ķ���
	 * @return
	 */
	public String queryPageModify()
	{
		
		IContractFilingService service = new ContractFilingServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);	
		//��ҳ��ѯ
		currentPage = service.pagedPrjQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPageModify";
	}
	/**
	 * ��ѯ��ͬ������Ϣ
	 * @return
	 */
	public String queryPagee()
	{

		IContractFilingService service = new ContractFilingServiceImpl();
		List<ContractFiling> list=service.queryByNum(prjnum);
		this.set("prjNum", prjnum);
		JSONArray json = JSONArray.fromObject(list);//��result��ֵ�����ݸ�ҳ�� 
        result = json.toString();
        return "success";
	}
/*----------------------------------------------------------------------------------------------------------*/	
//	private QualitykcsCondition kction = new QualitykcsCondition();
//	public void setKction(QualitykcsCondition kction) {
//		this.kction = kction;
//	}
//	public QualitykcsCondition getkction() {
//		QualitykcsCondition sessionCondition = (QualitykcsCondition)get(getActionName());//���������
//		if (sessionCondition != null)
//		{
//			kction = sessionCondition;
//		}
//		return kction;
//	}
//	/**
//	 * ��ѯ���쵥λ��Ϣ
//	 * @return
//	 */
//	public String queryPagekc()
//	{
//		
//		IContractFilingService service = new ContractFilingServiceImpl();
//		this.getkction().setPrjNum("2303001510230101");	
//		//��ҳ��ѯ
//		currentPage = service.pagedkcQuery(this.getkction());
//		this.set(getActionName(), kction);
//        return "queryPrjPagekc";
//	}
//	

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}
	
}
