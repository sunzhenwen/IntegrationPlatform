package com.tj.jst.inner.business.filingapply.action;

import java.sql.Date;
import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.filingapply.condition.FilingApplyCondition;
import com.tj.jst.inner.business.filingapply.model.ContractBusiness;
import com.tj.jst.inner.business.filingapply.service.FilingApplyServiceImpl;
import com.tj.jst.inner.business.filingapply.service.IFilingApplyService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * �����ͬ
 * @author Administrator
 *
 */
public class FilingApplyAction extends BaseAction {

	private String recordId;// ����
	private String conId;
	private ContractBusiness contractB;
	private ContractFiling filing;// Model��
	private String message;// ��ʾ��Ϣ
	// �����б�
	private List<Upload> downloadlist;

	private FilingApplyCondition condition = new FilingApplyCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(FilingApplyCondition condition) {
		this.condition = condition;
	}

	public FilingApplyCondition getCondition() {
		FilingApplyCondition sessionCondition = (FilingApplyCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * ��ҳ��ѯ
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
	 * ����ҳ��
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
	 * ����ͨ��
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
//		if (message.equals("�ɹ�")) {
//			message = service.queryPlans(filing.getPrjNum());
//			if (message.equals("�ɹ�")) {
//				service.updateProjectInfo(filing.getPrjNum());
//				// message = service.changeAuthor(filing.getPrjNum());//������Ȩ״̬
//			}
//		}
		if (message.equals("�ɹ�")) {
			service.updateProjectInfo(filing.getPrjNum());
			// message = service.changeAuthor(filing.getPrjNum());//������Ȩ״̬
		}
		return "query";
	}

	/**
	 * ������ͨ��
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
	 * ����
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	/**
	 * ����
	 * 
	 * @return
	 */
	public String goList() {
		return "queryBus";
	}
	
	/**
	 * ��ͬ��ϸҳ��
	 * 
	 * @return
	 */
	public String queryContractInfoPage() throws Exception {
		IFilingApplyService service = new FilingApplyServiceImpl();
		contractB = service.queryByConId(conId);
		return "contractPage";
	}

	/**
	 * ����״̬
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
