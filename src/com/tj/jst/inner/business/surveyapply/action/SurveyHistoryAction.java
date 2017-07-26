package com.tj.jst.inner.business.surveyapply.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.surveyapply.condition.SurveyHistoryCondition;
import com.tj.jst.inner.business.surveyapply.condition.SurveyQualificationCondition;
import com.tj.jst.inner.business.surveyapply.model.SurveyApply;
import com.tj.jst.inner.business.surveyapply.service.ISurveyApplyService;
import com.tj.jst.inner.business.surveyapply.service.SurveyApplyServiceImpl;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;
import com.tj.jst.inner.projectconstruction.service.IProjectConstructionService;
import com.tj.jst.inner.projectconstruction.service.ProjectConstructionServiceImpl;
import com.tj.jst.login.model.Login;

public class SurveyHistoryAction extends BaseAction {
	// ����model��
	private SurveyApply project;
	
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
	private String surveyId;
	// ������ʾ��Ϣ
	private String message;

	private SurveyHistoryCondition condition = new SurveyHistoryCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(SurveyHistoryCondition condition) {
		this.condition = condition;
	}

	public SurveyHistoryCondition getCondition() {
		SurveyHistoryCondition sessionCondition = (SurveyHistoryCondition) get(getActionName());
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
		ISurveyApplyService service = new SurveyApplyServiceImpl();
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
		ISurveyApplyService service = new SurveyApplyServiceImpl();
		project = service.queryApproval(surveyId);
		SurveyQualificationCondition scondition = new SurveyQualificationCondition(
				surveyId);
		currentPage = service.sidebyPage(scondition);
		// �ж��Ƿ���������ҳ
		if (currentPage.getTotalCount() > 0) {
			project.setUnitMark("1");
		}
		
		IProjectConstructionService projectConstructionService = new ProjectConstructionServiceImpl();
		projectConstruction = projectConstructionService.getProjectInfo(project.getPrjNum());
		
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

	public SurveyApply getProject() {
		return project;
	}

	public void setProject(SurveyApply project) {
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

	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
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
