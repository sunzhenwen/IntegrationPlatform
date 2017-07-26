package com.tj.jst.outside.business.queryBusiness.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.queryBusiness.condition.QueryConstructionCondition;
import com.tj.jst.outside.business.queryBusiness.service.IQueryConstructionService;
import com.tj.jst.outside.business.queryBusiness.service.QueryConstructionServiceImpl;

/**
 * 项目报建
 * @author hhc
 *
 */
public class QueryConstructionAction extends BaseAction {
	
	//项目报建实体主键
	private String prjId;
	//项目报建实体类
	private Construction construction;

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
	//从表主键
	private String id;
	
	private QueryConstructionCondition condition = new QueryConstructionCondition();
	
	public void setCondition(QueryConstructionCondition condition) {
		this.condition = condition;
	}

	public QueryConstructionCondition getCondition() {
		QueryConstructionCondition sessionCondition = (QueryConstructionCondition) get(getActionName());
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
		IQueryConstructionService service = new QueryConstructionServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		prjTypeNums = service.queryPrjTypeNums();
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 查询审批部门
	 * @return
	 */
	public String queryAppDept()
	{
		IQueryConstructionService service = new QueryConstructionServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	
	/**
	 * 查询市
	 * @return
	 */
	public String queryCity()
    {
		IQueryConstructionService corpService = new QueryConstructionServiceImpl();
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
		IQueryConstructionService corpService = new QueryConstructionServiceImpl();
		areas = corpService.queryArea(cityNum);
		JSONArray json = JSONArray.fromObject(areas);//给result赋值，传递给页面 
        result = json.toString();
        return "success";
    }
	
	/**
	 * 跳转详细页面
	 * @return
	 */
	public String queryById()
	{
		IQueryConstructionService service = new QueryConstructionServiceImpl();
		construction = service.queryById(prjId);
		//查询省
		provinces = service.queryProvince();
		prjTypeNums = service.queryPrjTypeNums();
		//建设性质(字典表：TBPRJPROPERTYDIC)
		prjPropertyNums = service.queryPrjPropertyNums(); 
		//工程用途(字典表：TBPRJFUNCTIONDIC)
		prjFuncitonNums = service.queryPrjFuncitonNums();
		//立项级别(字典表：TBLXJBDIC)
		prjApprovalLevelNums = service.queryPrjApprovalLevelNums();
		return "modifyPage";
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

	public List<DictionaryClass> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<DictionaryClass> provinces) {
		this.provinces = provinces;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public List<DictionaryClass> getCitys() {
		return citys;
	}

	public void setCitys(List<DictionaryClass> citys) {
		this.citys = citys;
	}

	public String getCityNum() {
		return cityNum;
	}

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}

	public List<DictionaryClass> getAreas() {
		return areas;
	}

	public void setAreas(List<DictionaryClass> areas) {
		this.areas = areas;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<DictionaryClass> getPrjTypeNums() {
		return prjTypeNums;
	}

	public void setPrjTypeNums(List<DictionaryClass> prjTypeNums) {
		this.prjTypeNums = prjTypeNums;
	}

	public Construction getConstruction() {
		return construction;
	}

	public void setConstruction(Construction construction) {
		this.construction = construction;
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

}
