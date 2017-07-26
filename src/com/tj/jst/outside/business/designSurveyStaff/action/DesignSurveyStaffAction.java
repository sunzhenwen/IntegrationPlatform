package com.tj.jst.outside.business.designSurveyStaff.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.designSurveyStaff.condition.DesignSurveyStaffCondition;
import com.tj.jst.outside.business.designSurveyStaff.model.DesignSurveyStaff;
import com.tj.jst.outside.business.designSurveyStaff.service.DesignSurveyStaffServiceImpl;
import com.tj.jst.outside.business.designSurveyStaff.service.IDesignSurveyStaffService;

/**
 * 勘察设计审图人员
 * @author hhc
 *
 */
public class DesignSurveyStaffAction extends BaseAction {
	
	//主键
	private String dsId;
	//项目编号
	private String prjNum;
	//项目名称
	private String prjName;
	//勘察设计审图人员
	private DesignSurveyStaff dsStaff;
//	//企业组织机构代码
//	private String corpCode;
//	//企业名称
//	private String corpName;
	//报建单位组织机构代码
	private String conCorpCode;
	//报检单位企业名称
	private String conCorpName;
	//证件类型
	private List<DictionaryClass> idCardTypeNums;
	//注册类型及等级
	private List<DictionaryClass> specialtyTypNums;
	//承担角色
	private List<DictionaryClass> prjDutys;
	
	private DesignSurveyStaffCondition condition = new DesignSurveyStaffCondition(((Login)this.get("login")).getCorpCode());
	
	public void setCondition(DesignSurveyStaffCondition condition) {
		this.condition = condition;
	}

	public DesignSurveyStaffCondition getCondition() {
		DesignSurveyStaffCondition sessionCondition = (DesignSurveyStaffCondition) get(getActionName());
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
		IDesignSurveyStaffService service = new DesignSurveyStaffServiceImpl();
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 施工安全从业人员添加页面
	 * @return
	 */
	public String addPage()
	{
		Login login = (Login)this.get("login");
		//报建企业组织机构代码
		conCorpCode = login.getCorpCode();
		//报建企业名称
		conCorpName = login.getUserName();
		IDesignSurveyStaffService service = new DesignSurveyStaffServiceImpl();
		//证件类型
		idCardTypeNums = service.queryCardTypeNums();
		//注册类型及等级
		specialtyTypNums = service.querySpecialtyTypNums();
		//承担角色
		prjDutys = service.queryPrjDutys();
		return "addPage";
	}
	
	/**
	 * 施工安全从业人员添加
	 * @return
	 */
	public String add()
	{
		IDesignSurveyStaffService service = new DesignSurveyStaffServiceImpl();
		service.add(dsStaff);
		return "query";
	}
	
	/**
	 * 施工安全从业人员修改页面
	 * @return
	 */
	public String modifyPage()
	{
		IDesignSurveyStaffService service = new DesignSurveyStaffServiceImpl();
		dsStaff = service.queryById(dsId);
		//证件类型
		idCardTypeNums = service.queryCardTypeNums();
		//注册类型及等级
		specialtyTypNums = service.querySpecialtyTypNums();
		//承担角色
		prjDutys = service.queryPrjDutys();
		return "modifyPage";
	}
	
	/**
	 * 施工安全从业人员修改
	 * @return
	 */
	public String modify()
	{
		IDesignSurveyStaffService service = new DesignSurveyStaffServiceImpl();
		service.modify(dsStaff);
		return "query";
	}
	
	/**
	 * 施工安全从业人员删除
	 * @return
	 */
	public String delete()
	{
		IDesignSurveyStaffService service = new DesignSurveyStaffServiceImpl();
		service.delete(dsId);
		return "query";
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

	public String getDsId() {
		return dsId;
	}

	public void setDsId(String dsId) {
		this.dsId = dsId;
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

	public DesignSurveyStaff getDsStaff() {
		return dsStaff;
	}

	public void setDsStaff(DesignSurveyStaff dsStaff) {
		this.dsStaff = dsStaff;
	}

//	public String getCorpCode() {
//		return corpCode;
//	}
//
//	public void setCorpCode(String corpCode) {
//		this.corpCode = corpCode;
//	}
//
//	public String getCorpName() {
//		return corpName;
//	}
//
//	public void setCorpName(String corpName) {
//		this.corpName = corpName;
//	}

	public List<DictionaryClass> getIdCardTypeNums() {
		return idCardTypeNums;
	}

	public void setIdCardTypeNums(List<DictionaryClass> idCardTypeNums) {
		this.idCardTypeNums = idCardTypeNums;
	}

	public List<DictionaryClass> getSpecialtyTypNums() {
		return specialtyTypNums;
	}

	public void setSpecialtyTypNums(List<DictionaryClass> specialtyTypNums) {
		this.specialtyTypNums = specialtyTypNums;
	}

	public List<DictionaryClass> getPrjDutys() {
		return prjDutys;
	}

	public void setPrjDutys(List<DictionaryClass> prjDutys) {
		this.prjDutys = prjDutys;
	}

	public String getConCorpCode() {
		return conCorpCode;
	}

	public void setConCorpCode(String conCorpCode) {
		this.conCorpCode = conCorpCode;
	}

	public String getConCorpName() {
		return conCorpName;
	}

	public void setConCorpName(String conCorpName) {
		this.conCorpName = conCorpName;
	}
	
}
