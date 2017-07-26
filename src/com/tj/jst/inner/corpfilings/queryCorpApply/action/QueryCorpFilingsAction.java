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
 * ��ҵ����������ѯ
 * @author Administrator
 *
 */
public class QueryCorpFilingsAction extends BaseAction {
	
	//��ҵ����
	private String corpId;
	//��ҵ��֯��������
	private String corpCode;
	//��ҵ
	private Corp corp;
	//ʡcode
	private String provinceId;
	//��code
	private String cityNum;
	//ʡ
	private List<DictionaryClass> provinces;
	//��
	private List<DictionaryClass> citys;
	//��
	private List<DictionaryClass> areas;

	//������ʾ��Ϣ
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
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		IQueryCorpFilingsService service = new QueryCorpFilingsServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.queryDictionary();
		this.set(getActionName(), condition);
		return "queryPage";
	}
	
	/**
	 * ��ѯ��ҵ��ϸ��Ϣ
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
	 * ��ѯ��
	 * @return
	 */
	public String queryCity()
    {
		IQueryCorpFilingsService service = new QueryCorpFilingsServiceImpl();
		citys = service.queryCity(provinceId);
		JSONArray json = JSONArray.fromObject(citys);//��result��ֵ�����ݸ�ҳ�� 
        result = json.toString();
        return "success";
    }
	
	/**
	 * ��ѯ��
	 * @return
	 */
	public String queryArea()
    {
		IQueryCorpFilingsService service = new QueryCorpFilingsServiceImpl();
		areas = service.queryArea(cityNum);
		JSONArray json = JSONArray.fromObject(areas);//��result��ֵ�����ݸ�ҳ�� 
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
