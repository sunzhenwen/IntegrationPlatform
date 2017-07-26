package com.tj.jst.outside.business.safety.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.safety.condition.SafetyCondition;
import com.tj.jst.outside.business.safety.model.ConstructionSafety;
import com.tj.jst.outside.business.safety.model.Labour;
import com.tj.jst.outside.business.safety.model.Major;
import com.tj.jst.outside.business.safety.model.Safety;
import com.tj.jst.outside.business.safety.service.ISafetyService;
import com.tj.jst.outside.business.safety.service.SafetyServiceImpl;

/**
 * 安全监督
 * @author hhc
 *
 */
public class SafetyAction extends BaseAction {
	
	//安全监督主键
	private String safetyId;
	//项目编号
	private String prjNum;
	//项目名称
	private String prjName;
	//安全监督
	private Safety safety;
	//审批部门
	private List<Regional> list;
	//返回提示信息
	private String message;
	private String result;
	private String treeStr;
	//企业组织机构代码
	private String corpCode;
	//企业名称
	private String corpName;
	//办公电话
	private String officePhone;
	//工程类型
	private List<DictionaryClass> projectTypes;
	//施工总承包单位现场专职安全管理人员
	private List<ConstructionSafety> constructionSafety; 
	//专业分包单位
	private List<Major> majors; 
	//劳务分包
	private List<Labour> labours; 
	private SafetyCondition condition = new SafetyCondition();
	
	public void setCondition(SafetyCondition condition) {
		this.condition = condition;
	}

	public SafetyCondition getCondition() {
		SafetyCondition sessionCondition = (SafetyCondition) get(getActionName());
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
		ISafetyService service = new SafetyServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 安全监督申请页面
	 * @return
	 */
	public String addPage()
	{
		Login login = (Login)this.get("login");
		//企业组织机构代码
		corpCode = login.getCorpCode();
		//企业名称
		corpName = login.getUserName();
		//办公电话
		officePhone = login.getOfficePhone();
		ISafetyService service = new SafetyServiceImpl();
		//工程类型
		projectTypes = service.queryProjectTypes();
		return "addPage";
	}
	
	/**
	 * 安全监督申请
	 * @return
	 */
	public String add()
	{
		ISafetyService service = new SafetyServiceImpl();
		safetyId = service.add(safety,constructionSafety,majors,labours);
		return "queryAdd";
	}
	
	/**
	 * 跳转安全监督申请修改页面
	 * @return
	 */
	public String modifyPage()
	{
		ISafetyService service = new SafetyServiceImpl();
		safety = service.queryById(safetyId);
		//工程类型
		projectTypes = service.queryProjectTypes();
		return "modifyPage";
	}
	
	/**
	 * 安全监督申请修改
	 * @return
	 */
	public String modify()
	{
		ISafetyService service = new SafetyServiceImpl();
		service.modify(safety,constructionSafety,majors,labours);
		return "query";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete()
	{
		ISafetyService service = new SafetyServiceImpl();
		service.delete(safetyId);
		return "query";
	}
	
	/**
	 * 查询审批部门
	 * @return
	 */
	public String queryAppDept()
	{
		ISafetyService service = new SafetyServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	
	public String queryPrjName()
	{
		ISafetyService service = new SafetyServiceImpl();
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

	public String getSafetyId() {
		return safetyId;
	}

	public void setSafetyId(String safetyId) {
		this.safetyId = safetyId;
	}

	public Safety getSafety() {
		return safety;
	}

	public void setSafety(Safety safety) {
		this.safety = safety;
	}

	public List<DictionaryClass> getProjectTypes() {
		return projectTypes;
	}

	public void setProjectTypes(List<DictionaryClass> projectTypes) {
		this.projectTypes = projectTypes;
	}

	public List<ConstructionSafety> getConstructionSafety() {
		return constructionSafety;
	}

	public void setConstructionSafety(List<ConstructionSafety> constructionSafety) {
		this.constructionSafety = constructionSafety;
	}

	public List<Major> getMajors() {
		return majors;
	}

	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}

	public List<Labour> getLabours() {
		return labours;
	}

	public void setLabours(List<Labour> labours) {
		this.labours = labours;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

}
