package com.tj.jst.outside.business.safety.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.safety.condition.SafetyStaffCondition;
import com.tj.jst.outside.business.safety.model.SafetyStaff;
import com.tj.jst.outside.business.safety.service.ISafetyStaffService;
import com.tj.jst.outside.business.safety.service.SafetyStaffServiceImpl;

/**
 * 施工安全从业人员
 * @author hhc
 *
 */
public class SafetyStaffAction extends BaseAction {
	
	//施工安全从业人员明细主键
	private String builderUserId;
	//项目编号
	private String prjNum;
	//项目名称
	private String prjName;
	//施工安全从业人员明细
	private SafetyStaff safetyStaff;
	//企业组织机构代码
	private String corpCode;
	//企业名称
	private String corpName;
	//证件类型
	private List<DictionaryClass> idCardTypeNums;
	
	private SafetyStaffCondition condition = new SafetyStaffCondition(((Login)this.get("login")).getCorpCode());
	
	public void setCondition(SafetyStaffCondition condition) {
		this.condition = condition;
	}

	public SafetyStaffCondition getCondition() {
		SafetyStaffCondition sessionCondition = (SafetyStaffCondition) get(getActionName());
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
		ISafetyStaffService service = new SafetyStaffServiceImpl();
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
		//企业组织机构代码
		corpCode = login.getCorpCode();
		//企业名称
		corpName = login.getUserName();
		ISafetyStaffService service = new SafetyStaffServiceImpl();
		idCardTypeNums = service.queryCardTypeNums();
		return "addPage";
	}
	
	/**
	 * 施工安全从业人员添加
	 * @return
	 */
	public String add()
	{
		ISafetyStaffService service = new SafetyStaffServiceImpl();
		service.add(safetyStaff);
		return "query";
	}
	
	/**
	 * 施工安全从业人员修改页面
	 * @return
	 */
	public String modifyPage()
	{
		ISafetyStaffService service = new SafetyStaffServiceImpl();
		safetyStaff = service.queryById(builderUserId);
		idCardTypeNums = service.queryCardTypeNums();
		return "modifyPage";
	}
	
	/**
	 * 施工安全从业人员修改
	 * @return
	 */
	public String modify()
	{
		ISafetyStaffService service = new SafetyStaffServiceImpl();
		service.modify(safetyStaff);
		return "query";
	}
	
	/**
	 * 施工安全从业人员删除
	 * @return
	 */
	public String delete()
	{
		ISafetyStaffService service = new SafetyStaffServiceImpl();
		service.delete(builderUserId);
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

	public String getBuilderUserId() {
		return builderUserId;
	}

	public void setBuilderUserId(String builderUserId) {
		this.builderUserId = builderUserId;
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

	public SafetyStaff getSafetyStaff() {
		return safetyStaff;
	}

	public void setSafetyStaff(SafetyStaff safetyStaff) {
		this.safetyStaff = safetyStaff;
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

	public List<DictionaryClass> getIdCardTypeNums() {
		return idCardTypeNums;
	}

	public void setIdCardTypeNums(List<DictionaryClass> idCardTypeNums) {
		this.idCardTypeNums = idCardTypeNums;
	}
	
}
