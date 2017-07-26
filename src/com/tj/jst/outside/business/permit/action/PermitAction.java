package com.tj.jst.outside.business.permit.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.permit.condition.PermitCondition;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.permit.service.IPermitService;
import com.tj.jst.outside.business.permit.service.PermitServiceImpl;

/**
 * 施工许可
 * @author hhc
 *
 */
public class PermitAction extends BaseAction {
	
	//施工许可主键
	private String permitId;
	//项目编号
	private String prjNum;
	//项目名称
	private String prjName;
	//施工许可
	private Permit permit;
	//证件类型
	private List<DictionaryClass> cardTypeNums;
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
	
	private PermitCondition condition = new PermitCondition();
	
	public void setCondition(PermitCondition condition) {
		this.condition = condition;
	}

	public PermitCondition getCondition() {
		PermitCondition sessionCondition = (PermitCondition) get(getActionName());
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
		IPermitService service = new PermitServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 施工许可申请页面
	 * @return
	 */
	public String addPage()
	{
		Login login = (Login)this.get("login");
		//企业组织机构代码
		corpCode = login.getCorpCode();
		//企业名称
		corpName = login.getUserName();
		IPermitService service = new PermitServiceImpl();
		cardTypeNums = service.queryCardTypeNums();
		return "addPage";
	}
	
	/**
	 * 施工许可申请
	 * @return
	 */
	public String add()
	{
		IPermitService service = new PermitServiceImpl();
		permitId = service.add(permit);
		return "queryAdd";
	}
	
	/**
	 * 跳转施工许可申请修改页面
	 * @return
	 */
	public String modifyPage()
	{
		IPermitService service = new PermitServiceImpl();
		cardTypeNums = service.queryCardTypeNums();
		permit = service.queryById(permitId);
		return "modifyPage";
	}
	
	/**
	 * 施工许可申请修改
	 * @return
	 */
	public String modify()
	{
		IPermitService service = new PermitServiceImpl();
		service.modify(permit);
		return "query";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete()
	{
		IPermitService service = new PermitServiceImpl();
		service.delete(permitId);
		return "query";
	}
	
	/**
	 * 查询审批部门
	 * @return
	 */
	public String queryAppDept()
	{
		IPermitService service = new PermitServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	
	public String queryPrjName()
	{
		IPermitService service = new PermitServiceImpl();
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

	public String getPermitId() {
		return permitId;
	}

	public void setPermitId(String permitId) {
		this.permitId = permitId;
	}

	public Permit getPermit() {
		return permit;
	}

	public void setPermit(Permit permit) {
		this.permit = permit;
	}

	public List<DictionaryClass> getCardTypeNums() {
		return cardTypeNums;
	}

	public void setCardTypeNums(List<DictionaryClass> cardTypeNums) {
		this.cardTypeNums = cardTypeNums;
	}

}
