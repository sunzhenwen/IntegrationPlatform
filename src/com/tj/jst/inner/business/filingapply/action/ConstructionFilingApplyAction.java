package com.tj.jst.inner.business.filingapply.action;

import java.sql.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.filingapply.condition.ConstructionFilingApplyCondition;
import com.tj.jst.inner.business.filingapply.model.ContractBusiness;
import com.tj.jst.inner.business.filingapply.service.FilingApplyServiceImpl;
import com.tj.jst.inner.business.filingapply.service.IFilingApplyService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.upload.model.Upload;
import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;

/**
 * 施工合同
 * @author Administrator
 *
 */
public class ConstructionFilingApplyAction extends BaseAction {

	private String recordId;// 主键
	private String conId;
	private ContractBusiness contractB;
	private ContractFiling filing;// Model类
	private String message;// 提示信息
	// 下载列表
	private List<Upload> downloadlist;

	private ConstructionFilingApplyCondition condition = new ConstructionFilingApplyCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(ConstructionFilingApplyCondition condition) {
		this.condition = condition;
	}

	public ConstructionFilingApplyCondition getCondition() {
		ConstructionFilingApplyCondition sessionCondition = (ConstructionFilingApplyCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	public String queryPage() {
		IFilingApplyService service = new FilingApplyServiceImpl();
		currentPage = service.pagedQuery(condition);
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 审批页面
	 * 
	 * @return
	 */
	public String queryapproval() {
		IFilingApplyService service = new FilingApplyServiceImpl();
		filing = service.queryApproval(recordId);
		downloadlist = service.downloadInfo(recordId);
		return "approvalPage";
	}

	/**
	 * 审批通过
	 * 
	 * @return
	 */
	public String approvalSuccess() {
		IFilingApplyService service = new FilingApplyServiceImpl();
		Login login = (Login) this.get("login");
		filing.setAppDate(new Date(new java.util.Date().getTime()));
		filing.setAppSteffId(login.getPersonalID());
		filing.setAppSteffName(login.getName());
		message = service.approvalSuccess(filing);
		service.changeBusinessType(filing.getRecordId(),"1");
//		if (message.equals("成功")) {
//			message = service.queryPlans(filing.getPrjNum());
//			if (message.equals("成功")) {
//				service.updateProjectInfo(filing.getPrjNum());
//				// message = service.changeAuthor(filing.getPrjNum());//更改授权状态
//			}
//		}
		if (message.equals("成功")) {
			service.updateProjectInfo(filing.getPrjNum());
			// message = service.changeAuthor(filing.getPrjNum());//更改授权状态
		}
		return "query";
	}

	/**
	 * 审批不通过
	 * 
	 * @return
	 */
	public String approvalFailed() {
		IFilingApplyService service = new FilingApplyServiceImpl();
		Login login = (Login) this.get("login");
		filing.setAppDate(new Date(new java.util.Date().getTime()));
		filing.setAppSteffId(login.getPersonalID());
		filing.setAppSteffName(login.getName());
		message = service.approvalFailed(filing);
		message = service.changeBusinessType(filing.getRecordId(),"0");
		return "query";
	}

	/**
	 * 返回
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	/**
	 * 返回
	 * 
	 * @return
	 */
	public String goList() {
		return "queryBus";
	}
	
	/**
	 * 合同详细页面
	 * 
	 * @return
	 */
	public String queryContractInfoPage() {
		IFilingApplyService service = new FilingApplyServiceImpl();
		contractB = service.queryByConId(conId);
		
		String url = "";
		//linux
		url = contractB.getLinkAddress().substring(contractB.getLinkAddress().indexOf("/cip"), contractB.getLinkAddress().length());
		//windows
		//url = contractB.getLinkAddress();
		
		//打开world模板
		PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(ServletActionContext.getRequest());
    	poCtrl1.setServerPage("poserver.do"); //此行必须
    	// Create custom toolbar
    	poCtrl1.addCustomToolButton("全屏切换", "SetFullScreen()", 4);
    	poCtrl1.webOpen(url, OpenModeType.docReadOnly, ((Login)this.get("login")).getDepartment());
    	poCtrl1.setTagId("PageOfficeCtrl2"); //此行必须
		return "contractPage";
	}

	/**
	 * 更改状态
	 * 
	 * @return
	 */
	public String contractBusiness() {
		IFilingApplyService service = new FilingApplyServiceImpl();
		message = service.modifyContractBusiness(contractB);
		message = service.insertContractBusiness(contractB);
		return "queryBus";
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public ContractFiling getFiling() {
		return filing;
	}

	public void setFiling(ContractFiling filing) {
		this.filing = filing;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Upload> getDownloadlist() {
		return downloadlist;
	}

	public void setDownloadlist(List<Upload> downloadlist) {
		this.downloadlist = downloadlist;
	}

	public ContractBusiness getContractB() {
		return contractB;
	}

	public void setContractB(ContractBusiness contractB) {
		this.contractB = contractB;
	}

	public String getConId() {
		return conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
	}

}
