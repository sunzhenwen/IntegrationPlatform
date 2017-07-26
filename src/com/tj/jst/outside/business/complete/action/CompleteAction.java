package com.tj.jst.outside.business.complete.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.complete.condition.CompleteCondition;
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.complete.service.CompleteServiceImpl;
import com.tj.jst.outside.business.complete.service.ICompleteService;
import com.tj.jst.outside.business.construction.model.Regional;

/**
 * 竣工验收
 * @author hhc
 *
 */
public class CompleteAction extends BaseAction {
	
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
	
	private CompleteCondition condition = new CompleteCondition();
	
	public void setCondition(CompleteCondition condition) {
		this.condition = condition;
	}

	public CompleteCondition getCondition() {
		CompleteCondition sessionCondition = (CompleteCondition) get(getActionName());
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
		ICompleteService service = new CompleteServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 竣工验收申请页面
	 * @return
	 */
	public String addPage()
	{
		Login login = (Login)this.get("login");
		//企业组织机构代码
		corpCode = login.getCorpCode();
		//企业名称
		corpName = login.getUserName();
		ICompleteService service = new CompleteServiceImpl();
		prjStructureTypeNums = service.queryPrjStructureTypeNums();
		return "addPage";
	}
	
	/**
	 * 竣工验收申请
	 * @return
	 */
	public String add()
	{
		ICompleteService service = new CompleteServiceImpl();
		completeId = service.add(complete);
		return "queryAdd";
	}
	
	/**
	 * 跳转竣工验收申请修改页面
	 * @return
	 */
	public String modifyPage()
	{
		ICompleteService service = new CompleteServiceImpl();
		prjStructureTypeNums = service.queryPrjStructureTypeNums();
		complete = service.queryById(completeId);
		return "modifyPage";
	}
	
	/**
	 * 竣工验收申请修改
	 * @return
	 */
	public String modify()
	{
		ICompleteService service = new CompleteServiceImpl();
		service.modify(complete);
		return "query";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete()
	{
		ICompleteService service = new CompleteServiceImpl();
		service.delete(completeId);
		return "query";
	}
	
	/**
	 * 查询审批部门
	 * @return
	 */
	public String queryAppDept()
	{
		ICompleteService service = new CompleteServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	
	public String queryPrjName()
	{
		ICompleteService service = new CompleteServiceImpl();
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

}
