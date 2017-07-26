package com.tj.jst.outside.business.queryBusiness.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;
import com.tj.jst.outside.business.constructionPlans.service.ConstructionPlansServiceImpl;
import com.tj.jst.outside.business.constructionPlans.service.IConstructionPlansService;
import com.tj.jst.outside.business.queryBusiness.condition.QueryConstructionPlansCondition;
import com.tj.jst.outside.business.queryBusiness.service.IQueryConstructionPlansService;
import com.tj.jst.outside.business.queryBusiness.service.QueryConstructionPlansServiceImpl;

/**
 * 施工图审查
 * @author hhc
 *
 */
public class QueryConstructionPlansAction extends BaseAction {
	
	//合同主键
	private String censorId;
	//项目编号
	private String prjNum;
	//项目名称
	private String prjName;
	//施工图审查实体类
	private ConstructionPlans constructionPlans;
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
	
	private QueryConstructionPlansCondition condition = new QueryConstructionPlansCondition();
	
	public void setCondition(QueryConstructionPlansCondition condition) {
		this.condition = condition;
	}

	public QueryConstructionPlansCondition getCondition() {
		QueryConstructionPlansCondition sessionCondition = (QueryConstructionPlansCondition) get(getActionName());
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
		IQueryConstructionPlansService service = new QueryConstructionPlansServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 跳转合同备案申请修改页面
	 * @return
	 */
	public String modifyPage()
	{
		IQueryConstructionPlansService service = new QueryConstructionPlansServiceImpl();
		constructionPlans = service.queryById(censorId);
		return "modifyPage";
	}
	
	/**
	 * 查询审批部门
	 * @return
	 */
	public String queryAppDept()
	{
		IQueryConstructionPlansService service = new QueryConstructionPlansServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	
	public String queryPrjName()
	{
		IQueryConstructionPlansService service = new QueryConstructionPlansServiceImpl();
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

	public String getCensorId() {
		return censorId;
	}

	public void setCensorId(String censorId) {
		this.censorId = censorId;
	}

	public ConstructionPlans getConstructionPlans() {
		return constructionPlans;
	}

	public void setConstructionPlans(ConstructionPlans constructionPlans) {
		this.constructionPlans = constructionPlans;
	}

}
