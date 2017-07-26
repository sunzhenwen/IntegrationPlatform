package com.tj.jst.inner.projectconstruction.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.projectconstruction.condition.ProjectConstructionCondition;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;
import com.tj.jst.inner.projectconstruction.service.IProjectConstructionService;
import com.tj.jst.inner.projectconstruction.service.ProjectConstructionServiceImpl;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.upload.model.Upload;

public class ProjectConstructionAction extends BaseAction {

	// Model��
	private ProjectConstruction project;
	// ��Ŀ����
	private String prjName;
	// �����ĺ�
	private String prjApprovalNum;
	// ���赥λ����
	private String buildCorpName;
	// ���赥λ��֯��������֤
	private String buildCorpCode;
	// ����
	private String prjId;
	// ������ʾ��Ϣ
	private String message;
	// ��������
	private String[] ids;
	// ��Ŀ����
	private String prjNum;
	// �����б�
	private List<Upload> downloadlist;

	private ProjectConstructionCondition condition = new ProjectConstructionCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(ProjectConstructionCondition condition) {
		this.condition = condition;
	}

	public ProjectConstructionCondition getCondition() {
		ProjectConstructionCondition sessionCondition = (ProjectConstructionCondition) get(getActionName());
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
		IProjectConstructionService service = new ProjectConstructionServiceImpl();
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ת����ҳ��
	 * 
	 * @return
	 */
	public String queryapproval() {
		IProjectConstructionService service = new ProjectConstructionServiceImpl();
		project = service.queryApproval(prjId);
		// ProjectPageCondition procondition = new ProjectPageCondition(prjId);
		downloadlist = service.downloadInfo(prjId);
		// currentPage = service.projectPage(procondition);
		// �����ж��Ƿ��е�λ����
		// if (currentPage.getTotalCount() > 0) {
		// project.setUnitMark("1");
		// }

		return "approvalPage";
	}

	/**
	 * ����ͨ��
	 * 
	 * @return
	 */
	public String applySuccess() {
		IProjectConstructionService service = new ProjectConstructionServiceImpl();
		message = service.applySuccess(project);
		if(message.equals("�ɹ�")){
			message = service.updateAuthor(project);
		}
		return "query";
	}

	/**
	 * ����δͨ��
	 * 
	 * @return
	 */
	public String applyFaile() {
		IProjectConstructionService service = new ProjectConstructionServiceImpl();
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

	/**
	 * �鿴��Ŀ��¼
	 * 
	 * @return
	 */
	public String getProjectInfo() {
		IProjectConstructionService service = new ProjectConstructionServiceImpl();
		project = service.getProjectInfo(prjNum);
		return "getProjectInfo";
	}

	public ProjectConstruction getProject() {
		return project;
	}

	public void setProject(ProjectConstruction project) {
		this.project = project;
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

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

	public List<Upload> getDownloadlist() {
		return downloadlist;
	}

	public void setDownloadlist(List<Upload> downloadlist) {
		this.downloadlist = downloadlist;
	}

}
