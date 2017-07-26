package com.tj.jst.inner.integrityShare.personGoodIntegrityShare.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.personGoodIntegrity.condition.PersonGoodIntegrityCondition;
import com.tj.jst.inner.integrity.personGoodIntegrity.model.PersonGoodIntegrity;
import com.tj.jst.inner.integrity.personGoodIntegrity.service.IPersonGoodIntegrityService;
import com.tj.jst.inner.integrity.personGoodIntegrity.service.PersonGoodIntegrityServiceImpl;
import com.tj.jst.inner.integrityShare.personGoodIntegrityShare.condition.PersonGoodIntegrityShareCondition;
import com.tj.jst.inner.integrityShare.personGoodIntegrityShare.service.IPersonGoodIntegrityShareService;
import com.tj.jst.inner.integrityShare.personGoodIntegrityShare.service.PersonGoodIntegrityShareServiceImpl;
import com.tj.jst.login.model.Login;

public class PersonGoodIntegrityShareAction extends BaseAction {

	// 人员良好行为信息Model
	private PersonGoodIntegrity personGoodIntegrity;
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
	// 证件类型
	private List<DictionaryClass> idCardTypeNums;
	// 人员类型
	private List<DictionaryClass> specialtyTypeNums;
	// 结果
	private String result;
	// 主键
	private String goodCreditId;

	private PersonGoodIntegrityShareCondition condition = new PersonGoodIntegrityShareCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(PersonGoodIntegrityShareCondition condition) {
		this.condition = condition;
	}

	public PersonGoodIntegrityShareCondition getCondition() {
		PersonGoodIntegrityShareCondition sessionCondition = (PersonGoodIntegrityShareCondition) get(getActionName());
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
		IPersonGoodIntegrityShareService service = new PersonGoodIntegrityShareServiceImpl();
		condition.setPersonalID("1");
		currentPage = service.pagedQuery(condition);
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 全部查询
	 * 
	 * @return
	 */
	public String queryInfoPage() {
		IPersonGoodIntegrityShareService service = new PersonGoodIntegrityShareServiceImpl();
		currentPage = service.pagedQuery(condition);
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 跳转增加页面
	 * 
	 * @return
	 */
	public String addPage() {
		IPersonGoodIntegrityService service = new PersonGoodIntegrityServiceImpl();
		// 查询省
		provinces = service.queryProvince();
		this.queryDictionary();
		return "addPage";
	}

	/**
	 * 增加人员良好信息
	 * 
	 * @return
	 */
	public String addGoodInfo() {
		IPersonGoodIntegrityService service = new PersonGoodIntegrityServiceImpl();
		personGoodIntegrity.setDepartName(((Login) this.get("login"))
				.getDepartment());
		personGoodIntegrity.setDepartId(((Login) this.get("login"))
				.getDepartmentID());
		personGoodIntegrity.setUserName(((Login) this.get("login")).getName());
		service.addPersonGoodInfo(personGoodIntegrity);
		return "query";
	}

	/**
	 * 跳转修改页面
	 * 
	 * @return
	 */
	public String modifyPage() {
		IPersonGoodIntegrityService service = new PersonGoodIntegrityServiceImpl();
		personGoodIntegrity = service.queryGoodInfo(goodCreditId);
		provinces = service.queryProvince();
		citys = service.queryCity(personGoodIntegrity.getProvinceNum());
		areas = service.queryArea(personGoodIntegrity.getCityNum());
		this.queryDictionary();
		return "modifyPage";
	}

	/**
	 * 修改人员良好信息
	 * 
	 * @return
	 */
	public String modifyGoodInfo() {
		IPersonGoodIntegrityService service = new PersonGoodIntegrityServiceImpl();
		service.modifyPersonGoodInfo(personGoodIntegrity);
		return "query";
	}

	/**
	 * 删除人员良好信息
	 * 
	 * @return
	 */
	public String deleteGoodInfo() {
		IPersonGoodIntegrityService service = new PersonGoodIntegrityServiceImpl();
		service.deletePersonGoodInfo(goodCreditId);
		return "query";
	}

	/**
	 * 人员信息详细
	 * 
	 * @return
	 */
	public String detailPage() {
		IPersonGoodIntegrityShareService service = new PersonGoodIntegrityShareServiceImpl();
		personGoodIntegrity = service.queryGoodInfo(goodCreditId);
		provinces = service.queryProvince();
		citys = service.queryCity(personGoodIntegrity.getProvinceNum());
		areas = service.queryArea(personGoodIntegrity.getCityNum());
		this.queryDictionary();
		return "detailPage";
	}

	/**
	 * 返回方法
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	/**
	 * 字典类
	 */
	public void queryDictionary() {
		IPersonGoodIntegrityService service = new PersonGoodIntegrityServiceImpl();
		// 证件类型
		idCardTypeNums = service.queryCardType();
		// 人员类型
		specialtyTypeNums = service.queryPersonType();
	}

	public PersonGoodIntegrity getPersonGoodIntegrity() {
		return personGoodIntegrity;
	}

	public void setPersonGoodIntegrity(PersonGoodIntegrity personGoodIntegrity) {
		this.personGoodIntegrity = personGoodIntegrity;
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

	public List<DictionaryClass> getIdCardTypeNums() {
		return idCardTypeNums;
	}

	public void setIdCardTypeNums(List<DictionaryClass> idCardTypeNums) {
		this.idCardTypeNums = idCardTypeNums;
	}

	public List<DictionaryClass> getSpecialtyTypeNums() {
		return specialtyTypeNums;
	}

	public void setSpecialtyTypeNums(List<DictionaryClass> specialtyTypeNums) {
		this.specialtyTypeNums = specialtyTypeNums;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getGoodCreditId() {
		return goodCreditId;
	}

	public void setGoodCreditId(String goodCreditId) {
		this.goodCreditId = goodCreditId;
	}

}
