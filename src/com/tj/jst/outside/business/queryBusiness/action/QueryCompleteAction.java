package com.tj.jst.outside.business.queryBusiness.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.business.promiseapply.service.IPromiseApplyService;
import com.tj.jst.inner.business.promiseapply.service.PromiseApplyServiceImpl;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;
import com.tj.jst.inner.projectconstruction.service.IProjectConstructionService;
import com.tj.jst.inner.projectconstruction.service.ProjectConstructionServiceImpl;
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.queryBusiness.condition.QueryCompleteCondition;
import com.tj.jst.outside.business.queryBusiness.service.IQueryCompleteService;
import com.tj.jst.outside.business.queryBusiness.service.QueryCompleteServiceImpl;

/**
 * 竣工验收
 * @author hhc
 *
 */
public class QueryCompleteAction extends BaseAction {
	
	//竣工验收主键
	private String completeId;
	//项目编号
	private String prjNum;
	//项目名称
	private String prjName;
	//竣工验收
	private Complete complete;
	//结构体系
	private List<DictionaryClass> prjStructureTypeNums;
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
	
	private Permit permit;// Model类
	private ProjectConstruction projectConstruction;
	
	
	//判断打印用
	private String appType;

	
	private QueryCompleteCondition condition = new QueryCompleteCondition();
	
	public void setCondition(QueryCompleteCondition condition) {
		this.condition = condition;
	}

	public QueryCompleteCondition getCondition() {
		QueryCompleteCondition sessionCondition = (QueryCompleteCondition) get(getActionName());
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
		IQueryCompleteService service = new QueryCompleteServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 跳转竣工验收申请修改页面
	 * @return
	 */
	public String modifyPage()
	{
		IQueryCompleteService service = new QueryCompleteServiceImpl();
		prjStructureTypeNums = service.queryPrjStructureTypeNums();
		complete = service.queryById(completeId);
		
		IPromiseApplyService service1 = new PromiseApplyServiceImpl();
		permit = service1.queryApproval(complete.getPrjNum());
		
		
		IProjectConstructionService projectConstructionService = new ProjectConstructionServiceImpl();
		projectConstruction = projectConstructionService.getProjectInfo(complete.getPrjNum());
		
		
		return "modifyPage";
	}
	
	/**
	 * 查询审批部门
	 * @return
	 */
	public String queryAppDept()
	{
		IQueryCompleteService service = new QueryCompleteServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	
	public String queryPrjName()
	{
		IQueryCompleteService service = new QueryCompleteServiceImpl();
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

	public String getCompleteId() {
		return completeId;
	}

	public void setCompleteId(String completeId) {
		this.completeId = completeId;
	}

	public Complete getComplete() {
		return complete;
	}

	public void setComplete(Complete complete) {
		this.complete = complete;
	}

	public List<DictionaryClass> getPrjStructureTypeNums() {
		return prjStructureTypeNums;
	}

	public void setPrjStructureTypeNums(List<DictionaryClass> prjStructureTypeNums) {
		this.prjStructureTypeNums = prjStructureTypeNums;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public Permit getPermit() {
		return permit;
	}

	public void setPermit(Permit permit) {
		this.permit = permit;
	}

	public ProjectConstruction getProjectConstruction() {
		return projectConstruction;
	}

	public void setProjectConstruction(ProjectConstruction projectConstruction) {
		this.projectConstruction = projectConstruction;
	}

}
