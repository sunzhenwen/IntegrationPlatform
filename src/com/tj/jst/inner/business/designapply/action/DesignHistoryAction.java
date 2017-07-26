package com.tj.jst.inner.business.designapply.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.designapply.condition.DesignHistoryCondition;
import com.tj.jst.inner.business.designapply.condition.DesignQualificationCondition;
import com.tj.jst.inner.business.designapply.model.DesignApply;
import com.tj.jst.inner.business.designapply.service.DesignApplyServiceImpl;
import com.tj.jst.inner.business.designapply.service.IDesignApplyService;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;
import com.tj.jst.inner.projectconstruction.service.IProjectConstructionService;
import com.tj.jst.inner.projectconstruction.service.ProjectConstructionServiceImpl;
import com.tj.jst.login.model.Login;

/**
 * ��ʷ��ѯ����
 * 
 * @author DarkFlameMaster
 *
 */
public class DesignHistoryAction extends BaseAction {
	// Model��
	private DesignApply project;
	
	private ProjectConstruction projectConstruction;
	
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

	private DesignHistoryCondition condition = new DesignHistoryCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(DesignHistoryCondition condition) {
		this.condition = condition;
	}

	public DesignHistoryCondition getCondition() {
		DesignHistoryCondition sessionCondition = (DesignHistoryCondition) get(getActionName());
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
	public String queryHistoryPage() {
		IDesignApplyService service = new DesignApplyServiceImpl();
		currentPage = service.pagedQuery(condition);
		this.set(getActionName(), condition);
		return "queryHistoryPage";
	}

	/**
	 * ��ת����ҳ��
	 * 
	 * @return
	 */
	public String queryHistory() {
		IDesignApplyService service = new DesignApplyServiceImpl();
		project = service.queryApproval(designId);
		DesignQualificationCondition qcondition = new DesignQualificationCondition(
				designId);
		currentPage = service.sidebyPage(qcondition);
		// �ж��Ƿ��е�λ����
		if (currentPage.getTotalCount() > 0) {
			project.setUnitMark("1");
		}
		
		IProjectConstructionService projectConstructionService = new ProjectConstructionServiceImpl();
		projectConstruction = projectConstructionService.getProjectInfo(project.getPrjNum());
		
		return "info";
	}

	public DesignApply getProject() {
		return project;
	}

	public void setProject(DesignApply project) {
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

	public String getDesignId() {
		return designId;
	}

	public void setDesignId(String designId) {
		this.designId = designId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ProjectConstruction getProjectConstruction() {
		return projectConstruction;
	}

	public void setProjectConstruction(ProjectConstruction projectConstruction) {
		this.projectConstruction = projectConstruction;
	}

}
