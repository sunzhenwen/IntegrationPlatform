package com.tj.jst.outside.business.queryBusiness.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.queryBusiness.condition.QuerySafetyCondition;
import com.tj.jst.outside.business.queryBusiness.service.IQuerySafetyService;
import com.tj.jst.outside.business.queryBusiness.service.QuerySafetyServiceImpl;
import com.tj.jst.outside.business.safety.model.Safety;

/**
 * 安全监督
 * @author hhc
 *
 */
public class QuerySafetyAction extends BaseAction {
	
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
	//工程类型
	private List<DictionaryClass> projectTypes;
	
	private QuerySafetyCondition condition = new QuerySafetyCondition();
	
	public void setCondition(QuerySafetyCondition condition) {
		this.condition = condition;
	}

	public QuerySafetyCondition getCondition() {
		QuerySafetyCondition sessionCondition = (QuerySafetyCondition) get(getActionName());
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
		IQuerySafetyService service = new QuerySafetyServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 跳转安全监督申请修改页面
	 * @return
	 */
	public String modifyPage()
	{
		IQuerySafetyService service = new QuerySafetyServiceImpl();
		//工程类型
		projectTypes = service.queryProjectTypes();
		safety = service.queryById(safetyId);
		return "modifyPage";
	}
	
	/**
	 * 查询审批部门
	 * @return
	 */
	public String queryAppDept()
	{
		IQuerySafetyService service = new QuerySafetyServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	
	public String queryPrjName()
	{
		IQuerySafetyService service = new QuerySafetyServiceImpl();
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

}
