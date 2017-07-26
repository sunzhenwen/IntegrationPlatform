package com.tj.jst.inner.integrity.personBadIntegrity.action;

import java.sql.Date;
import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.personBadIntegrity.condition.PersonBadIntegrityCondition;
import com.tj.jst.inner.integrity.personBadIntegrity.model.PersonBadIntegrity;
import com.tj.jst.inner.integrity.personBadIntegrity.service.IPersonBadIntegrityService;
import com.tj.jst.inner.integrity.personBadIntegrity.service.PersonBadIntegrityServiceImpl;
import com.tj.jst.login.model.Login;

/**
 * 注册人员不良行为信息数据表
 * @author hhc
 *
 */
public class PersonBadIntegrityAction extends BaseAction {
	
	//注册人员不良行为信息Model
	private PersonBadIntegrity personBadIntegrity;
	//主键
	private String badPersonId;
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
	
	
	//人员类型(TBSPECIALTYTYPEDIC)
	private List<DictionaryClass> specialtyTypNums;
	//不良行为分类(TBCREDITTYPE)
	private List<DictionaryClass> creditClassNums;
	//不良行为类别(TBCORPBADDIC)
	private List<DictionaryClass> creditType;
	//不良行为代码(TBCORPBADDIC)
	private List<DictionaryClass> creditCodes;
	//处罚依据(TBCORPBADDIC)
	private List<DictionaryClass> puishEvidences;
	//证件类型(字典表：TBIDCARDTYPEDIC)
	private List<DictionaryClass> idCardTypeNums;
	
	private String departId;//登记部门Id
	private String departName;//登记部门
	private String userName;//登记人姓名
	private Date createDate;//登记时间
	
	private String result;
	private PersonBadIntegrityCondition condition = new PersonBadIntegrityCondition(((Login)this.get("login")).getDepartmentID());
	
	public void setCondition(PersonBadIntegrityCondition condition) {
		this.condition = condition;
	}

	public PersonBadIntegrityCondition getCondition() {
		PersonBadIntegrityCondition sessionCondition = (PersonBadIntegrityCondition) get(getActionName());
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
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
		condition.setPersonalID("1");
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}
	
	public String queryInfoPage(){
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 添加页面
	 * @return
	 */
	public String addPage()
	{
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
		Login login = (Login)this.get("login");
		departId = login.getDepartmentID();//登记部门Id
		departName= login.getDepartment();//登记部门
		userName = login.getName();//登记人姓名
		createDate = new Date(new java.util.Date().getTime());
		this.queryBadIntegrityDictionary();
		provinces = service.queryProvince();
		return "addPage";
	}
	
	/**
	 * 添加
	 * @return
	 */
	public String add()
	{
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
		service.add(personBadIntegrity);
		return "query";
	}
	
	/**
	 * 跳修改页面
	 * @return
	 */
	public String modifyPage()
	{
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
		personBadIntegrity = service.queryById(badPersonId);
		provinces = service.queryProvince();
		this.queryBadIntegrityDictionary();
		return "modifyPage";
	}

	/**
	 * 修改
	 * @return
	 */
	public String modify()
	{
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
		service.modify(personBadIntegrity);
		return "query";
	}
	
	public String detail(){
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
		personBadIntegrity = service.queryById(badPersonId);
		provinces = service.queryProvince();
		this.queryBadIntegrityDictionary();
		return "detailPage";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete()
	{
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
		service.delete(badPersonId);
		return "query";
	}
	
	/**
	 * 查询市
	 * @return
	 */
	public String queryCity()
    {
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
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
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
		areas = service.queryArea(cityNum);
		JSONArray json = JSONArray.fromObject(areas);//给result赋值，传递给页面 
        result = json.toString();
        return "success";
    }
	
	/**
	 * 查询字典表
	 */
	public void queryBadIntegrityDictionary()
	{
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
		//人员类型(TBSPECIALTYTYPEDIC)
		specialtyTypNums = service.querySpecialtyTypNums();
		//不良行为分类(TBCREDITTYPE)
		creditClassNums = service.queryCreditClassNums();
		//不良行为类别(TBCORPBADDIC)
		creditType = service.queryCreditType();
		//不良行为代码(TBCORPBADDIC)
		creditCodes = service.queryCreditCodes();
		//处罚依据(TBCORPBADDIC)
		puishEvidences = service.queryPuishEvidences();
		//证件类型(字典表：TBIDCARDTYPEDIC)
		idCardTypeNums = service.queryIdCardTypeNums();
	}

	/**
	 * 取消
	 * @return
	 */
	public String goBack()
	{
		return "query";
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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

	public PersonBadIntegrity getPersonBadIntegrity() {
		return personBadIntegrity;
	}

	public void setPersonBadIntegrity(PersonBadIntegrity personBadIntegrity) {
		this.personBadIntegrity = personBadIntegrity;
	}

	public List<DictionaryClass> getSpecialtyTypNums() {
		return specialtyTypNums;
	}

	public void setSpecialtyTypNums(List<DictionaryClass> specialtyTypNums) {
		this.specialtyTypNums = specialtyTypNums;
	}

	public List<DictionaryClass> getCreditClassNums() {
		return creditClassNums;
	}

	public void setCreditClassNums(List<DictionaryClass> creditClassNums) {
		this.creditClassNums = creditClassNums;
	}

	public List<DictionaryClass> getCreditType() {
		return creditType;
	}

	public void setCreditType(List<DictionaryClass> creditType) {
		this.creditType = creditType;
	}

	public List<DictionaryClass> getCreditCodes() {
		return creditCodes;
	}

	public void setCreditCodes(List<DictionaryClass> creditCodes) {
		this.creditCodes = creditCodes;
	}

	public List<DictionaryClass> getPuishEvidences() {
		return puishEvidences;
	}

	public void setPuishEvidences(List<DictionaryClass> puishEvidences) {
		this.puishEvidences = puishEvidences;
	}

	public String getDepartId() {
		return departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getBadPersonId() {
		return badPersonId;
	}

	public void setBadPersonId(String badPersonId) {
		this.badPersonId = badPersonId;
	}

	public List<DictionaryClass> getIdCardTypeNums() {
		return idCardTypeNums;
	}

	public void setIdCardTypeNums(List<DictionaryClass> idCardTypeNums) {
		this.idCardTypeNums = idCardTypeNums;
	}

}
