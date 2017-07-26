package com.tj.jst.inner.business.designapply.action;

import java.sql.Date;
import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.designapply.condition.DesignApplyCondition;
import com.tj.jst.inner.business.designapply.condition.DesignQualificationCondition;
import com.tj.jst.inner.business.designapply.model.DesignApply;
import com.tj.jst.inner.business.designapply.service.DesignApplyServiceImpl;
import com.tj.jst.inner.business.designapply.service.IDesignApplyService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.upload.model.Upload;

public class DesignApplyAction extends BaseAction {

	// Model��
	private DesignApply project;
	// ��Ŀ����
	private String prjName;
	// �����ĺ�
	private String prjApprovalNum;
	// ���赥λ����
	private String buildCorpName;
	// ���赥λ��֯��������֤
	private String buildCorpCode;
	// ����
	private String designId;
	// ������ʾ��Ϣ
	private String message;
	// �����б�
	private List<Upload> downloadlist;

	private DesignApplyCondition condition = new DesignApplyCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(DesignApplyCondition condition) {
		this.condition = condition;
	}

	public DesignApplyCondition getCondition() {
		DesignApplyCondition sessionCondition = (DesignApplyCondition) get(getActionName());
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
		IDesignApplyService service = new DesignApplyServiceImpl();
		currentPage = service.pagedQuery(condition);
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ת����ҳ��
	 * 
	 * @return
	 */
	public String queryapproval() {
		IDesignApplyService service = new DesignApplyServiceImpl();
		project = service.queryApproval(designId);
		DesignQualificationCondition qcondition = new DesignQualificationCondition(
				designId);
		downloadlist = service.downloadInfo(designId);
		currentPage = service.sidebyPage(qcondition);
		// �ж��Ƿ��е�λ����
		if (currentPage.getTotalCount() > 0) {
			project.setUnitMark("1");
		}
		return "approvalPage";
	}

	/**
	 * ����ͨ��
	 * 
	 * @return
	 */
	public String applySuccess() {
		IDesignApplyService service = new DesignApplyServiceImpl();
		Login login = (Login) this.get("login");
		project.setAppSteffId(login.getDepartmentID());
		project.setAppSteffName(login.getDepartment());
		project.setAppDate(new Date(new java.util.Date().getTime()));
		message = service.applySuccess(project);
		if (message.equals("�ɹ�")) {
			service.updateProjectInfo(project.getPrjNum());
		}
		return "query";
	}

	/**
	 * ����δͨ��
	 * 
	 * @return
	 */
	public String applyFaile() {
		IDesignApplyService service = new DesignApplyServiceImpl();
		Login login = (Login) this.get("login");
		project.setAppSteffId(login.getDepartmentID());
		project.setAppSteffName(login.getDepartment());
		project.setAppDate(new Date(new java.util.Date().getTime()));
		message = service.applyFaile(project);
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

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getPrjApprovalNum() {
		return prjApprovalNum;
	}

	public void setPrjApprovalNum(String prjApprovalNum) {
		this.prjApprovalNum = prjApprovalNum;
	}

	public String getBuildCorpName() {
		return buildCorpName;
	}

	public void setBuildCorpName(String buildCorpName) {
		this.buildCorpName = buildCorpName;
	}

	public String getBuildCorpCode() {
		return buildCorpCode;
	}

	public void setBuildCorpCode(String buildCorpCode) {
		this.buildCorpCode = buildCorpCode;
	}

	public String getDesignId() {
		return designId;
	}

	public void setDesignId(String designId) {
		this.designId = designId;
	}

	public DesignApply getProject() {
		return project;
	}

	public void setProject(DesignApply project) {
		this.project = project;
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

}
