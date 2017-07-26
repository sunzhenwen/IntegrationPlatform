package com.tj.jst.inner.corpfilings.queryCorpApply.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.corpfilings.queryCorpApply.condition.QueryCorpFilingsCondition;
import com.tj.jst.inner.corpfilings.queryCorpApply.service.IQueryCorpFilingsService;
import com.tj.jst.inner.corpfilings.queryCorpApply.service.QueryCorpFilingsServiceImpl;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * 企业备案审批查询
 * @author Administrator
 *
 */
public class QueryCorpFilingsAction extends BaseAction {
	
	//企业主键
	private String corpId;
	//企业组织机构代码
	private String corpCode;
	//企业
	private Corp corp;
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

	//返回提示信息
	private String message;
	private String result;
	
	private QueryCorpFilingsCondition condition = new QueryCorpFilingsCondition(((Login)this.get("login")).getDepartmentID());
	
	public void setCondition(QueryCorpFilingsCondition condition) {
		this.condition = condition;
	}

	public QueryCorpFilingsCondition getCondition() {
		QueryCorpFilingsCondition sessionCondition = (QueryCorpFilingsCondition) get(getActionName());
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
		IQueryCorpFilingsService service = new QueryCorpFilingsServiceImpl();
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.queryDictionary();
		this.set(getActionName(), condition);
		return "queryPage";
	}
	
	/**
	 * 查询企业详细信息
	 * @return
	 */
	public String queryCorpInfo()
	{
		IQueryCorpFilingsService service = new QueryCorpFilingsServiceImpl();
		corp = service.queryCorpInfo(corpId);
		provinces = service.queryProvince();
		this.queryDictionary();
		return "queryCorpInfo";
	}
	
	/**
	 * 查询市
	 * @return
	 */
	public String queryCity()
    {
		IQueryCorpFilingsService service = new QueryCorpFilingsServiceImpl();
		citys = service.queryCity(provinceId);
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
		IQueryCorpFilingsService service = new QueryCorpFilingsServiceImpl();
		areas = service.queryArea(cityNum);
		JSONArray json = JSONArray.fromObject(areas);//给result赋值，传递给页面 
        result = json.toString();
        return "success";
    }
	
	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public Corp getCorp() {
		return corp;
	}

	public void setCorp(Corp corp) {
		this.corp = corp;
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

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

}
