package com.tj.jst.inner.projectShare.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.projectShare.condition.SurveyShareCondition;
import com.tj.jst.inner.projectShare.service.IProjectShareService;
import com.tj.jst.inner.projectShare.service.ProjectShareServiceImpl;
import com.tj.jst.outside.business.survey.model.Survey;

/**
 * ��Ŀ����
 * @author Administrator
 *
 */
public class SurveyShareAction extends BaseAction {

	//��������
	private String surveyId;
	//����ʵ����
	private Survey survey;
	
	/**
	 * ����
	 */
	private SurveyShareCondition condition = new SurveyShareCondition();

	public void setSurveyShareCondition(SurveyShareCondition condition) {
		this.condition = condition;
	}

	public SurveyShareCondition getCondition() {
		SurveyShareCondition sessionCondition = (SurveyShareCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}
	
	
	
	/**
	 * ����
	 */
	public String queryPage() {
		IProjectShareService service = new ProjectShareServiceImpl();
		currentPage = service.querySurveySharePage(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ������ϸ
	 * @return
	 */
	public String queryInfo() {
		IProjectShareService service = new ProjectShareServiceImpl();
		survey = service.querySurveyShareInfo(surveyId);
		return "queryInfo";
	}
	
	/**
	 * ���췵��
	 * 
	 * @return
	 */
	public String goPage() {
		return "goPage";
	}
	
	
	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

}
