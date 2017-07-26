package com.tj.jst.outside.business.quality.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.quality.condition.QualityCondition;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.quality.service.IQualityService;
import com.tj.jst.outside.business.quality.service.QualityServiceImpl;

/**
 * 质量监督
 * @author hhc
 *
 */
public class QualityAction extends BaseAction {
	
	//质量监督主键
	private String qualityId;
	//项目编号
	private String prjNum;
	//项目名称
	private String prjName;
	//质量监督
	private Quality quality;
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
	
	private QualityCondition condition = new QualityCondition();
	
	public void setCondition(QualityCondition condition) {
		this.condition = condition;
	}

	public QualityCondition getCondition() {
		QualityCondition sessionCondition = (QualityCondition) get(getActionName());
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
		IQualityService service = new QualityServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 质量监督申请页面
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
		return "addPage";
	}
	
	/**
	 * 质量监督申请
	 * @return
	 */
	public String add()
	{
		IQualityService service = new QualityServiceImpl();
		qualityId = service.add(quality);
		return "queryAdd";
	}
	
	/**
	 * 跳转质量监督申请修改页面
	 * @return
	 */
	public String modifyPage()
	{
		IQualityService service = new QualityServiceImpl();
		quality = service.queryById(qualityId);
		return "modifyPage";
	}
	
	/**
	 * 质量监督申请修改
	 * @return
	 */
	public String modify()
	{
		IQualityService service = new QualityServiceImpl();
		service.modify(quality);
		return "query";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete()
	{
		IQualityService service = new QualityServiceImpl();
		service.delete(qualityId);
		return "query";
	}
	
	/**
	 * 查询审批部门
	 * @return
	 */
	public String queryAppDept()
	{
		IQualityService service = new QualityServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	
	public String queryPrjName()
	{
		IQualityService service = new QualityServiceImpl();
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

	public String getQualityId() {
		return qualityId;
	}

	public void setQualityId(String qualityId) {
		this.qualityId = qualityId;
	}

	public Quality getQuality() {
		return quality;
	}

	public void setQuality(Quality quality) {
		this.quality = quality;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

}
