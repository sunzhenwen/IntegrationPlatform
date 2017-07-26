package com.tj.jst.inner.projectconstruction.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.projectconstruction.condition.HistoryCondition;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;
import com.tj.jst.inner.projectconstruction.service.IProjectConstructionService;
import com.tj.jst.inner.projectconstruction.service.ProjectConstructionServiceImpl;
import com.tj.jst.login.model.Login;

/**
 * ��ѯ������ʷ����
 * 
 * @author DarkFlameMaster
 *
 */
public class HistoryAction extends BaseAction {
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

	private HistoryCondition condition = new HistoryCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(HistoryCondition condition) {
		this.condition = condition;
	}

	public HistoryCondition getCondition() {
		HistoryCondition sessionCondition = (HistoryCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * ��ѯ������ʷ
	 * 
	 * @return
	 */
	public String queryHistoryPage() {
		IProjectConstructionService service = new ProjectConstructionServiceImpl();
		currentPage = service.historyPagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryHistoryPage";
	}

	/**
	 * ������ʷ��ϸ
	 * 
	 * @return
	 */
	public String queryHistory() {
		IProjectConstructionService service = new ProjectConstructionServiceImpl();
		project = service.queryApproval(prjId);
//		ProjectPageCondition procondition = new ProjectPageCondition(prjId);
//		currentPage = service.projectPage(procondition);
//		// �����ж��Ƿ��е�λ����
//		if (currentPage.getTotalCount() > 0) {
//			project.setUnitMark("1");
//		}
		return "info";
	}
	
	/**
	 * ����
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
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

}
