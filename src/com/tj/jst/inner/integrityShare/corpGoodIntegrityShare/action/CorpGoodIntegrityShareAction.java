package com.tj.jst.inner.integrityShare.corpGoodIntegrityShare.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.corpGoodIntegrity.condition.CorpGoodIntegrityCondition;
import com.tj.jst.inner.integrity.corpGoodIntegrity.model.CorpGoodIntegrity;
import com.tj.jst.inner.integrity.corpGoodIntegrity.service.CorpGoodIntegrityServiceImpl;
import com.tj.jst.inner.integrity.corpGoodIntegrity.service.ICorpGoodIntegrityService;
import com.tj.jst.inner.integrityShare.corpGoodIntegrityShare.condition.CorpGoodIntegrityShareCondition;
import com.tj.jst.inner.integrityShare.corpGoodIntegrityShare.service.CorpGoodIntegrityShareServiceImpl;
import com.tj.jst.inner.integrityShare.corpGoodIntegrityShare.service.ICorpGoodIntegrityShareService;
import com.tj.jst.login.model.Login;

public class CorpGoodIntegrityShareAction extends BaseAction {

	// 企业良好行为信息Model
	private CorpGoodIntegrity corpGoodIntegrity;
	// 省code
	private String provinceId;
	// 市code
	private String cityNum;
	// 省
	private List<DictionaryClass> provinces;
	// 市
	private List<DictionaryClass> citys;
	// 区
	private List<DictionaryClass> areas;
	// 企业类型(TBAPTITUDEKINDDIC)
	private List<DictionaryClass> certTypeNums;
	// 结果
	private String result;
	// Id
	private String corpGoodCreditId;

	private CorpGoodIntegrityShareCondition condition = new CorpGoodIntegrityShareCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(CorpGoodIntegrityShareCondition condition) {
		this.condition = condition;
	}

	public CorpGoodIntegrityShareCondition getCondition() {
		CorpGoodIntegrityShareCondition sessionCondition = (CorpGoodIntegrityShareCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	public String queryPage() {
		ICorpGoodIntegrityShareService dao = new CorpGoodIntegrityShareServiceImpl();
		condition.setPersonalID("1");
		// 分页查询
		currentPage = dao.pagedQuery(condition);
		this.set(getActionName(), condition);
		return "queryPage";
	}

	public String queryInfoPage() {
		ICorpGoodIntegrityShareService dao = new CorpGoodIntegrityShareServiceImpl();
		// 分页查询
		currentPage = dao.pagedQuery(condition);
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 跳转添加页面
	 * 
	 * @return
	 */
	public String addPage() {
		ICorpGoodIntegrityService service = new CorpGoodIntegrityServiceImpl();
		// 企业类型(TBAPTITUDEKINDDIC)
		certTypeNums = service.queryCertTypeNums();
		// 查询省
		provinces = service.queryProvince();
		return "addPage";
	}

	/**
	 * 添加企业良好信息
	 * 
	 * @return
	 */
	public String addGoodInfo() {
		ICorpGoodIntegrityService service = new CorpGoodIntegrityServiceImpl();
		corpGoodIntegrity.setDepartName(((Login) this.get("login"))
				.getDepartment());
		corpGoodIntegrity.setDepartId(((Login) this.get("login"))
				.getDepartmentID());
		corpGoodIntegrity.setUserName(((Login) this.get("login")).getName());
		service.addGoodInfo(corpGoodIntegrity);
		return "query";
	}

	/**
	 * 跳转修改页面
	 * 
	 * @return
	 */
	public String modifyPage() {
		ICorpGoodIntegrityService service = new CorpGoodIntegrityServiceImpl();
		// 查询省
		corpGoodIntegrity = service.queryCorpGoodInfo(corpGoodCreditId);
		// 企业类型(TBAPTITUDEKINDDIC)
		certTypeNums = service.queryCertTypeNums();
		provinces = service.queryProvince();
		citys = service.queryCity(corpGoodIntegrity.getProvinceNum());
		areas = service.queryArea(corpGoodIntegrity.getCityNum());
		return "modifyPage";
	}

	/**
	 * 修改企业良好信息
	 * 
	 * @return
	 */
	public String modifyGoodInfo() {
		ICorpGoodIntegrityService service = new CorpGoodIntegrityServiceImpl();
		service.modifyGoodInfo(corpGoodIntegrity);
		return "query";
	}

	/**
	 * 详细界面
	 * 
	 * @return
	 */
	public String detailPage() {
		ICorpGoodIntegrityShareService service = new CorpGoodIntegrityShareServiceImpl();
		// 查询省
		corpGoodIntegrity = service.queryCorpGoodInfo(corpGoodCreditId);
		// 企业类型(TBAPTITUDEKINDDIC)
		certTypeNums = service.queryCertTypeNums();
		provinces = service.queryProvince();
		citys = service.queryCity(corpGoodIntegrity.getProvinceNum());
		areas = service.queryArea(corpGoodIntegrity.getCityNum());
		return "detailPage";
	}

	/**
	 * 删除企业良好信息
	 * 
	 * @return
	 */
	public String deleteGoodInfo() {
		ICorpGoodIntegrityService service = new CorpGoodIntegrityServiceImpl();
		service.deleteGoodInfo(corpGoodCreditId);
		return "query";
	}

	/**
	 * 返回页面
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	/**
	 * 查询市
	 * 
	 * @return
	 */
	public String queryCity() {
		ICorpGoodIntegrityService service = new CorpGoodIntegrityServiceImpl();
		citys = service.queryCity(provinceId);
		JSONArray json = JSONArray.fromObject(citys);// 给result赋值，传递给页面
		result = json.toString();
		return "success";
	}

	/**
	 * 查询区
	 * 
	 * @return
	 */
	public String queryArea() {
		ICorpGoodIntegrityService service = new CorpGoodIntegrityServiceImpl();
		areas = service.queryArea(cityNum);
		JSONArray json = JSONArray.fromObject(areas);// 给result赋值，传递给页面
		result = json.toString();
		return "success";
	}

	public CorpGoodIntegrity getCorpGoodIntegrity() {
		return corpGoodIntegrity;
	}

	public void setCorpGoodIntegrity(CorpGoodIntegrity corpGoodIntegrity) {
		this.corpGoodIntegrity = corpGoodIntegrity;
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

	public List<DictionaryClass> getCertTypeNums() {
		return certTypeNums;
	}

	public void setCertTypeNums(List<DictionaryClass> certTypeNums) {
		this.certTypeNums = certTypeNums;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCorpGoodCreditId() {
		return corpGoodCreditId;
	}

	public void setCorpGoodCreditId(String corpGoodCreditId) {
		this.corpGoodCreditId = corpGoodCreditId;
	}

}
