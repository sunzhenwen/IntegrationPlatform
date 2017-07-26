package com.tj.jst.outside.business.design.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.design.condition.DesignCondition;
import com.tj.jst.outside.business.design.model.Design;
import com.tj.jst.outside.business.design.model.DesignQualification;
import com.tj.jst.outside.business.design.service.DesignServiceImpl;
import com.tj.jst.outside.business.design.service.IDesignService;

/**
 * 设计
 * @author hhc
 *
 */
public class DesignAction extends BaseAction {
	
	//设计主键
	private String designId;
	//项目编号
	private String prjNum;
	//项目名称
	private String prjName;
	//设计编码
	private String designCode;
	//设计实体类
	private Design design;
	//设计单位资质
	private List<DesignQualification> designQualifications;
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
	
	private DesignCondition condition = new DesignCondition(((Login)this.get("login")).getCorpCode());
	
	public void setCondition(DesignCondition condition) {
		this.condition = condition;
	}

	public DesignCondition getCondition() {
		DesignCondition sessionCondition = (DesignCondition) get(getActionName());
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
		IDesignService service = new DesignServiceImpl();
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
		//生成设计编号
//		Calendar c = Calendar.getInstance();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmssSSS");
//        designCode = simpleDateFormat.format(c.getTime());
		
		return "addPage";
	}
	
	/**
	 * 设计申请
	 * @return
	 */
	public String add()
	{
		IDesignService service = new DesignServiceImpl();
		Login login = (Login)this.get("login");
		design.setApplyCorpCode(login.getCorpCode());
		designId = service.add(design,designQualifications);
		return "queryAdd";
	}
	
	/**
	 * 跳转设计申请修改页面
	 * @return
	 */
	public String modifyPage()
	{
		IDesignService service = new DesignServiceImpl();
		design = service.queryById(designId);
		return "modifyPage";
	}
	
	/**
	 * 设计申请修改
	 * @return
	 */
	public String modify()
	{
		IDesignService service = new DesignServiceImpl();
		service.modify(design,designQualifications);
		return "query";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete()
	{
		IDesignService service = new DesignServiceImpl();
		service.delete(designId);
		return "query";
	}
	
	/**
	 * 查询审批部门
	 * @return
	 */
	public String queryAppDept()
	{
		IDesignService service = new DesignServiceImpl();
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

	public String getDesignCode() {
		return designCode;
	}

	public void setDesignCode(String designCode) {
		this.designCode = designCode;
	}

	public Design getDesign() {
		return design;
	}

	public void setDesign(Design design) {
		this.design = design;
	}

	public List<DesignQualification> getDesignQualifications() {
		return designQualifications;
	}

	public void setDesignQualifications(
			List<DesignQualification> designQualifications) {
		this.designQualifications = designQualifications;
	}

	public String getDesignId() {
		return designId;
	}

	public void setDesignId(String designId) {
		this.designId = designId;
	}

}
