package com.tj.jst.outside.business.survey.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.survey.condition.SurveyCondition;
import com.tj.jst.outside.business.survey.model.Survey;
import com.tj.jst.outside.business.survey.model.SurveyQualification;
import com.tj.jst.outside.business.survey.service.ISurveyService;
import com.tj.jst.outside.business.survey.service.SurveyServiceImpl;

/**
 * 勘察
 * @author hhc
 *
 */
public class SurveyAction extends BaseAction {
	
	//勘察主键
	private String surveyId;
	//项目编号
	private String prjNum;
	//项目名称
	private String prjName;
	//勘察编码
	private String surveyCode;
	//勘察实体类
	private Survey survey;
	//勘察单位资质
	private List<SurveyQualification> surveyQualification;
	//审批部门
	private List<Regional> list;
	//项目报建实体主键
	private String prjId;
	
	
	
	

	//返回提示信息
	private String message;
	private String result;
	private String treeStr;
	//企业组织机构代码
	private String corpCode;
	//企业名称
	private String corpName;
	//从表主键
	private String id;
	
	private SurveyCondition condition = new SurveyCondition(((Login)this.get("login")).getCorpCode());
	
	public void setCondition(SurveyCondition condition) {
		this.condition = condition;
	}

	public SurveyCondition getCondition() {
		SurveyCondition sessionCondition = (SurveyCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		ISurveyService service = new SurveyServiceImpl();
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 跳转勘察申请页面
	 * @return
	 */
	public String addPage()
	{
		Login login = (Login)this.get("login");
		//企业组织机构代码
		corpCode = login.getCorpCode();
		//企业名称
		corpName = login.getUserName();
		//生成勘察编号
//		Calendar c = Calendar.getInstance();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmssSSS");
//        surveyCode = simpleDateFormat.format(c.getTime());
		
		return "addPage";
	}
	
	/**
	 * 勘察申请
	 * @return
	 */
	public String add()
	{
		ISurveyService service = new SurveyServiceImpl();
		Login login = (Login)this.get("login");
		survey.setApplyCorpCode(login.getCorpCode());
		surveyId = service.add(survey,surveyQualification);
		return "queryAdd";
	}
	
	/**
	 * 跳转勘察申请修改页面
	 * @return
	 */
	public String modifyPage()
	{
		ISurveyService service = new SurveyServiceImpl();
		survey = service.queryById(surveyId);
		return "modifyPage";
	}
	
	/**
	 * 勘察申请修改
	 * @return
	 */
	public String modify()
	{
		ISurveyService service = new SurveyServiceImpl();
		service.modify(survey,surveyQualification);
		return "query";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete()
	{
		ISurveyService service = new SurveyServiceImpl();
		service.delete(surveyId);
		return "query";
	}
	
	/**
	 * 查询审批部门
	 * @return
	 */
	public String queryAppDept()
	{
		ISurveyService service = new SurveyServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	
	/**
	 * 返回项目报建列表目录
	 * @return
	 */
	public String goList()
	{
		return "query";
	}
	
	/**
	 * 返回业务办理目录
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
