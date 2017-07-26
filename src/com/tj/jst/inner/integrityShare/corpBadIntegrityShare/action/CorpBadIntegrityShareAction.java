package com.tj.jst.inner.integrityShare.corpBadIntegrityShare.action;

import java.sql.Date;
import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.corpBadIntegrity.condition.CorpBadIntegrityCondition;
import com.tj.jst.inner.integrity.corpBadIntegrity.model.CorpBadIntegrity;
import com.tj.jst.inner.integrity.corpBadIntegrity.service.CorpBadIntegrityServiceImpl;
import com.tj.jst.inner.integrity.corpBadIntegrity.service.ICorpBadIntegrityService;
import com.tj.jst.inner.integrityShare.corpBadIntegrityShare.condition.CorpBadIntegrityShareCondition;
import com.tj.jst.inner.integrityShare.corpBadIntegrityShare.service.CorpBadIntegrityShareServiceImpl;
import com.tj.jst.inner.integrityShare.corpBadIntegrityShare.service.ICorpBadIntegrityShareService;
import com.tj.jst.login.model.Login;

/**
 * 企业不良行为诚信
 * @author hhc
 *
 */
public class CorpBadIntegrityShareAction extends BaseAction {
	
	//企业不良行为诚信Model
	private CorpBadIntegrity corpBadIntegrity;
	//主键
	private String corpBadCreditId;
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
	
	
	//企业类型(TBAPTITUDEKINDDIC)
	private List<DictionaryClass> certTypeNums;
	//不良行为分类(TBCREDITTYPE)
	private List<DictionaryClass> creditClassNums;
	
	private String departId;//登记部门Id
	private String departName;//登记部门
	private String userName;//登记人姓名
	private Date createDate;//登记时间
	
	private String result;
	private CorpBadIntegrityShareCondition condition = new CorpBadIntegrityShareCondition(((Login)this.get("login")).getDepartmentID());
	
	public void setCondition(CorpBadIntegrityShareCondition condition) {
		this.condition = condition;
	}

	public CorpBadIntegrityShareCondition getCondition() {
		CorpBadIntegrityShareCondition sessionCondition = (CorpBadIntegrityShareCondition) get(getActionName());
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
		ICorpBadIntegrityShareService service = new CorpBadIntegrityShareServiceImpl();
		condition.setPersonalID("1");
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}
	
	public String queryInfoPage(){
		ICorpBadIntegrityShareService service = new CorpBadIntegrityShareServiceImpl();
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
		ICorpBadIntegrityService service = new CorpBadIntegrityServiceImpl();
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
		ICorpBadIntegrityService service = new CorpBadIntegrityServiceImpl();
		service.add(corpBadIntegrity);
		return "query";
	}
	
	/**
	 * 跳修改页面
	 * @return
	 */
	public String modifyPage()
	{
		ICorpBadIntegrityService service = new CorpBadIntegrityServiceImpl();
		corpBadIntegrity = service.queryById(corpBadCreditId);
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
		ICorpBadIntegrityService service = new CorpBadIntegrityServiceImpl();
		service.modify(corpBadIntegrity);
		return "query";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete()
	{
		ICorpBadIntegrityService service = new CorpBadIntegrityServiceImpl();
		service.delete(corpBadCreditId);
		return "query";
	}
	
	/**
	 * 详细
	 * @return
	 */
	public String detail(){
		ICorpBadIntegrityShareService service = new CorpBadIntegrityShareServiceImpl();
		corpBadIntegrity = service.queryById(corpBadCreditId);
		provinces = service.queryProvince();
		this.queryBadIntegrityDictionary();
		return "detailPage";
	}
	
	/**
	 * 查询市
	 * @return
	 */
	public String queryCity()
    {
		ICorpBadIntegrityService service = new CorpBadIntegrityServiceImpl();
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
		ICorpBadIntegrityService service = new CorpBadIntegrityServiceImpl();
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
		ICorpBadIntegrityService service = new CorpBadIntegrityServiceImpl();
		//企业类型(TBAPTITUDEKINDDIC)
		certTypeNums = service.queryCertTypeNums();
		//不良行为分类(TBCREDITTYPE)
		creditClassNums = service.queryCreditClassNums();
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

	public CorpBadIntegrity getCorpBadIntegrity() {
		return corpBadIntegrity;
	}

	public void setCorpBadIntegrity(CorpBadIntegrity corpBadIntegrity) {
		this.corpBadIntegrity = corpBadIntegrity;
	}

	public List<DictionaryClass> getCertTypeNums() {
		return certTypeNums;
	}

	public void setCertTypeNums(List<DictionaryClass> certTypeNums) {
		this.certTypeNums = certTypeNums;
	}

	public List<DictionaryClass> getCreditClassNums() {
		return creditClassNums;
	}

	public void setCreditClassNums(List<DictionaryClass> creditClassNums) {
		this.creditClassNums = creditClassNums;
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

	public String getCorpBadCreditId() {
		return corpBadCreditId;
	}

	public void setCorpBadCreditId(String corpBadCreditId) {
		this.corpBadCreditId = corpBadCreditId;
	}
}
