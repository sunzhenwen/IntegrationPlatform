package com.tj.jst.outside.business.contractFiling.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.contractFiling.condition.SurveyContractFilingCondition;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;

/**
 * 勘察合同备案
 * @author hhc
 *
 */
public class SurveyContractFilingAction extends BaseAction {
	
	//合同主键
	private String recordId;
	//项目编号
	private String prjNum;
	//项目名称
	private String prjName;
	//合同备案实体类
	private ContractFiling contractFiling;
	//合同类别
	private List<DictionaryClass> contractTypeNums;
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
	
	private SurveyContractFilingCondition condition = new SurveyContractFilingCondition();
	
	public void setCondition(SurveyContractFilingCondition condition) {
		this.condition = condition;
	}

	public SurveyContractFilingCondition getCondition() {
		SurveyContractFilingCondition sessionCondition = (SurveyContractFilingCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * 跳转 勘察合同备案、设计合同备案、监理合同备案、施工合同备案 页面
	 * @return
	 */
	public String filingIndex()
	{
		return "filingIndex";
	}
	
	/**
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		IContractFilingService service = new ContractFilingServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 跳转设计申请页面
	 * @return
	 */
	public String addPage()
	{
		Login login = (Login)this.get("login");
		//企业组织机构代码
		corpCode = login.getCorpCode();
		//企业名称
		corpName = login.getUserName();
		IContractFilingService service = new ContractFilingServiceImpl();
		//合同类别
		contractTypeNums = service.queryContractTypeNums();
		return "addPage";
	}
	
	/**
	 * 合同备案申请
	 * @return
	 */
	public String add()
	{
		IContractFilingService service = new ContractFilingServiceImpl();
		recordId = service.add(contractFiling);
		return "queryAdd";
	}
	
	/**
	 * 跳转合同备案申请修改页面
	 * @return
	 */
	public String modifyPage()
	{
		IContractFilingService service = new ContractFilingServiceImpl();
		//合同类别
		contractTypeNums = service.queryContractTypeNums();
		contractFiling = service.queryById(recordId);
		return "modifyPage";
	}
	
	/**
	 * 合同备案申请修改
	 * @return
	 */
	public String modify()
	{
		IContractFilingService service = new ContractFilingServiceImpl();
		service.modify(contractFiling);
		return "query";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete()
	{
		IContractFilingService service = new ContractFilingServiceImpl();
		service.delete(recordId);
		return "query";
	}
	
	/**
	 * 查询审批部门
	 * @return
	 */
	public String queryAppDept()
	{
		IContractFilingService service = new ContractFilingServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	
	public String queryPrjName()
	{
		IContractFilingService service = new ContractFilingServiceImpl();
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

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public ContractFiling getContractFiling() {
		return contractFiling;
	}

	public void setContractFiling(ContractFiling contractFiling) {
		this.contractFiling = contractFiling;
	}

	public List<DictionaryClass> getContractTypeNums() {
		return contractTypeNums;
	}

	public void setContractTypeNums(List<DictionaryClass> contractTypeNums) {
		this.contractTypeNums = contractTypeNums;
	}

}
