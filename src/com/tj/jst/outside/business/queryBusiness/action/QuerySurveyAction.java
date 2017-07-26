package com.tj.jst.outside.business.queryBusiness.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.queryBusiness.condition.QuerySurveyCondition;
import com.tj.jst.outside.business.queryBusiness.service.IQuerySurveyService;
import com.tj.jst.outside.business.queryBusiness.service.QuerySurveyServiceImpl;
import com.tj.jst.outside.business.survey.model.Survey;
import com.tj.jst.outside.business.survey.model.SurveyQualification;
import com.tj.jst.outside.business.survey.service.ISurveyService;
import com.tj.jst.outside.business.survey.service.SurveyServiceImpl;

/**
 * ����
 * @author hhc
 *
 */
public class QuerySurveyAction extends BaseAction {
	
	//�������
	private String surveyId;
	//��Ŀ���
	private String prjNum;
	//��Ŀ����
	private String prjName;
	//��Ʊ���
	private String surveyCode;
	//���ʵ����
	private Survey survey;
	//��Ƶ�λ����
	private List<SurveyQualification> surveyQualification;
	//��������
	private List<Regional> list;
	//��Ŀ����ʵ������
	private String prjId;
	
	
	
	

	//������ʾ��Ϣ
	private String message;
	private String result;
	private String treeStr;
	//��ҵ��֯��������
	private String corpCode;
	//��ҵ����
	private String corpName;
	//�ӱ�����
	private String id;
	
	private QuerySurveyCondition condition = new QuerySurveyCondition(((Login)this.get("login")).getCorpCode());
	
	public void setCondition(QuerySurveyCondition condition) {
		this.condition = condition;
	}

	public QuerySurveyCondition getCondition() {
		QuerySurveyCondition sessionCondition = (QuerySurveyCondition) get(getActionName());
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
		IQuerySurveyService service = new QuerySurveyServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ת��������޸�ҳ��
	 * @return
	 */
	public String modifyPage()
	{
		IQuerySurveyService service = new QuerySurveyServiceImpl();
		survey = service.queryById(surveyId);
		return "modifyPage";
	}
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public String queryAppDept()
	{
		IQuerySurveyService service = new QuerySurveyServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	
	/**
	 * ������Ŀ�����б�Ŀ¼
	 * @return
	 */
	public String goList()
	{
		return "query";
	}
	
	/**
	 * ����ҵ�����Ŀ¼
	 * @return
	 */
	public String goBack()
	{
		return "goBusiness";
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Regional> getList() {
		return list;
	}

	public void setList(List<Regional> list) {
		this.list = list;
	}

	public String getTreeStr() {
		return treeStr;
	}

	public void setTreeStr(String treeStr) {
		this.treeStr = treeStr;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}


	public String getSurveyCode() {
		return surveyCode;
	}

	public void setSurveyCode(String surveyCode) {
		this.surveyCode = surveyCode;
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

	public List<SurveyQualification> getSurveyQualification() {
		return surveyQualification;
	}

	public void setSurveyQualification(List<SurveyQualification> surveyQualification) {
		this.surveyQualification = surveyQualification;
	}

}
