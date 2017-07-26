package com.tj.jst.inner.constrModify.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.constrModify.condition.ConstrModifyCondition;
import com.tj.jst.inner.constrModify.service.ConstrModifyServiceImpl;
import com.tj.jst.inner.constrModify.service.IConstrModifyService;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.construction.service.ConstructionServiceImpl;
import com.tj.jst.outside.business.construction.service.IConstructionService;

/**
 * 项目报建修改,主管部门修改
 * 
 * @author hhc
 *
 */
public class ConstrModifyAction extends BaseAction {
	// Model类
	private ProjectConstruction project;
	// 项目名称
	private String prjName;
	// 立项文号
	private String prjApprovalNum;
	// 建设单位名称
	private String buildCorpName;
	// 建设单位组织机构代码证
	private String buildCorpCode;
	// 主键
	private String prjId;
	// 返回提示信息
	private String message;
	// 批量审批
	private String[] ids;
	// 项目编码
	private String prjNum;

	
	
	//省code
	private String provinceId;
	//市code
	private String cityNum;
	//省
	private List<DictionaryClass> provinces;
	//市
	private List<DictionaryClass> citys;
	//区
	private List<DictionaryClass> areas;
	//项目分类(字典表：TBPRJTYPEDIC)
	private List<DictionaryClass> prjTypeNums; 
	//建设性质(字典表：TBPRJPROPERTYDIC)
	private List<DictionaryClass> prjPropertyNums; 
	//工程用途(字典表：TBPRJFUNCTIONDIC)
	private List<DictionaryClass> prjFuncitonNums; 
	//立项级别(字典表：TBLXJBDIC)
	private List<DictionaryClass> prjApprovalLevelNums; 
	private String result;
	
	private ConstrModifyCondition condition = new ConstrModifyCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(ConstrModifyCondition condition) {
		this.condition = condition;
	}

	public ConstrModifyCondition getCondition() {
		ConstrModifyCondition sessionCondition = (ConstrModifyCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 列表查询
	 * 
	 * @return
	 */
	public String queryPage() {
		IConstrModifyService service = new ConstrModifyServiceImpl();
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 跳转修改页面
	 * 
	 * @return
	 */
	public String queryById() {
		IConstrModifyService service = new ConstrModifyServiceImpl();
		project = service.queryById(prjId);
		
		IConstructionService serviceImpl = new ConstructionServiceImpl();
		//查询省
		provinces = serviceImpl.queryProvince();
		prjTypeNums = serviceImpl.queryPrjTypeNums();
		//建设性质(字典表：TBPRJPROPERTYDIC)
		prjPropertyNums = serviceImpl.queryPrjPropertyNums(); 
		//工程用途(字典表：TBPRJFUNCTIONDIC)
		prjFuncitonNums = serviceImpl.queryPrjFuncitonNums();
		//立项级别(字典表：TBLXJBDIC)
		prjApprovalLevelNums = serviceImpl.queryPrjApprovalLevelNums();
		
		return "queryById";
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String update()
	{
		IConstrModifyService service = new ConstrModifyServiceImpl();
		service.update(project);
		return "query";
	}
	
	/**
	 * 查询市
	 * @return
	 */
	public String queryCity()
    {
		IConstructionService corpService = new ConstructionServiceImpl();
		citys = corpService.queryCity(provinceId);
		JSONArray json = JSONArray.fromObject(citys);//给result赋值，传递给页面 
        result = json.toString();
        return "success";
    }
	
	/**
	 * 查询区
	 * @return
	 */
	public String queryArea()
    {
		IConstructionService corpService = new ConstructionServiceImpl();
		areas = corpService.queryArea(cityNum);
		JSONArray json = JSONArray.fromObject(areas);//给result赋值，传递给页面 
        result = json.toString();
        return "success";
    }
	
	/**
	 * 返回
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	public ProjectConstruction getProject() {
		return project;
	}

	public void setProject(ProjectConstruction project) {
		this.project = project;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getPrjApprovalNum() {
		return prjApprovalNum;
	}

	public void setPrjApprovalNum(String prjApprovalNum) {
		this.prjApprovalNum = prjApprovalNum;
	}

	public String getBuildCorpName() {
		return buildCorpName;
	}

	public void setBuildCorpName(String buildCorpName) {
		this.buildCorpName = buildCorpName;
	}

	public String getBuildCorpCode() {
		return buildCorpCode;
	}

	public void setBuildCorpCode(String buildCorpCode) {
		this.buildCorpCode = buildCorpCode;
	}

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityNum() {
		return cityNum;
	}

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}

	public List<DictionaryClass> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<DictionaryClass> provinces) {
		this.provinces = provinces;
	}

	public List<DictionaryClass> getCitys() {
		return citys;
	}

	public void setCitys(List<DictionaryClass> citys) {
		this.citys = citys;
	}

	public List<DictionaryClass> getAreas() {
		return areas;
	}

	public void setAreas(List<DictionaryClass> areas) {
		this.areas = areas;
	}

	public List<DictionaryClass> getPrjTypeNums() {
		return prjTypeNums;
	}

	public void setPrjTypeNums(List<DictionaryClass> prjTypeNums) {
		this.prjTypeNums = prjTypeNums;
	}

	public List<DictionaryClass> getPrjPropertyNums() {
		return prjPropertyNums;
	}

	public void setPrjPropertyNums(List<DictionaryClass> prjPropertyNums) {
		this.prjPropertyNums = prjPropertyNums;
	}

	public List<DictionaryClass> getPrjFuncitonNums() {
		return prjFuncitonNums;
	}

	public void setPrjFuncitonNums(List<DictionaryClass> prjFuncitonNums) {
		this.prjFuncitonNums = prjFuncitonNums;
	}

	public List<DictionaryClass> getPrjApprovalLevelNums() {
		return prjApprovalLevelNums;
	}

	public void setPrjApprovalLevelNums(List<DictionaryClass> prjApprovalLevelNums) {
		this.prjApprovalLevelNums = prjApprovalLevelNums;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
