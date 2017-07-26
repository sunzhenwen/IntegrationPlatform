package com.tj.jst.inner.business.filingapply.action;

import org.apache.struts2.ServletActionContext;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.filingapply.condition.FilingBusinessCondition;
import com.tj.jst.inner.business.filingapply.model.ContractBusiness;
import com.tj.jst.inner.business.filingapply.service.FilingApplyServiceImpl;
import com.tj.jst.inner.business.filingapply.service.IFilingApplyService;
import com.tj.jst.login.model.Login;
import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;

/**
 * ��ͬ
 * 
 * @author Administrator
 *
 */
public class FilingBusinessAction extends BaseAction {

	private ContractBusiness contract;// ��ͬmodel
	private String conId;// ��ͬ����
	private String recordId;
	private String id;// ��ѯ����
	private String type;//�ж��Ƿ��ǲ�ѯҳ���ѯ��1����ת��ѯҳ��ĺ�ͬģ���б�

	private FilingBusinessCondition condition = new FilingBusinessCondition();

	public void setCondition(FilingBusinessCondition condition) {
		this.condition = condition;
	}

	public FilingBusinessCondition getCondition() {
		FilingBusinessCondition sessionCondition = (FilingBusinessCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * ��ͬ��ҳ
	 * 
	 * @return
	 */
	public String queryPage() {
		IFilingApplyService service = new FilingApplyServiceImpl();
		condition.setConId(conId);
		currentPage = service.queryBusinessPage(condition);
		this.set(getActionName(), condition);
		if("1".equals(type))
		{
			return "queryUnBusinessPage";
		}else
		{
			return "queryBusinessPage";
		}
		
	}

	/**
	 * ��ͬ��ʷ��ѯ
	 * 
	 * @return
	 */
	public String queryInfo() {
		IFilingApplyService service = new FilingApplyServiceImpl();
		contract = service.queryByConId(conId);
		
		String url = "";
		//linux
		url = contract.getLinkAddress().substring(contract.getLinkAddress().indexOf("/cip"), contract.getLinkAddress().length());
		//windows
		//url = contract.getLinkAddress();
		
		//��worldģ��
		PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(ServletActionContext.getRequest());
    	poCtrl1.setServerPage("poserver.do"); //���б���
    	// Create custom toolbar
    	poCtrl1.addCustomToolButton("ȫ���л�", "SetFullScreen()", 4);
    	poCtrl1.webOpen(url, OpenModeType.docReadOnly, ((Login)this.get("login")).getDepartment());
    	poCtrl1.setTagId("PageOfficeCtrl2"); //���б���
		
		return "historyPage";
	}

	public ContractBusiness getContract() {
		return contract;
	}

	public void setContract(ContractBusiness contract) {
		this.contract = contract;
	}

	public String getConId() {
		return conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
