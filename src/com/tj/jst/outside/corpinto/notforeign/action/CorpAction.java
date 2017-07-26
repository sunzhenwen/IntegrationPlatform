package com.tj.jst.outside.corpinto.notforeign.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;
import com.tj.jst.outside.corpinto.notforeign.service.CorpServiceImpl;
import com.tj.jst.outside.corpinto.notforeign.service.ICorpService;

/**
 * 企业
 * @author Administrator
 *
 */
public class CorpAction extends BaseAction {
	
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

	private String builderLicenceNum;
	
	private String typeNum;// 来源 1:建设单位 2:行业企业 3:主管部门
	
	//请求来源,值为oaeas,说明是行政审批系统请求
	private String method;
	//返回连接地址
	private String fromurl;
	
	//返回提示信息
	private String message;
	private String result;
	private int num;
	
	/**
	 * 新企业添加
	 * @return
	 */
	public String addCorp()
	{
		ICorpService corpService = new CorpServiceImpl();
		message = corpService.addCorp(corp);
		
		String returnPage = "";
		//判断是否跳转行政审批系统登录页面
		if(!"".equals(this.get("oaeas")))
		{
			//返回连接地址
			fromurl = (String) this.get("fromurl");
			this.remove("oaeas");
			this.remove("fromurl");
			returnPage = "oaeasPage";
		}else
		{
			returnPage = "addCorp";
		}

		return returnPage;
	}
	
	public String showCodeCertificate()
	{

		return "showCodeCertificate";
	}
	
	
	/**
	 * 建设单位
	 * 企业修改
	 * @return
	 */
	public String modifyCorp()
	{
		ICorpService corpService = new CorpServiceImpl();
		message = corpService.modifyCorp(corp);
		corpCode = corp.getCorpCode();
		typeNum = "1" ;
		return "backToBusiness";
	} 
	
	/**
	 * 未发key企业修改
	 * 企业基本信息修改
	 * @return
	 */
	public String corpModify()
	{
		ICorpService corpService = new CorpServiceImpl();
		message = corpService.modifyCorp(corp);
		
		String returnPage = "";
		//判断是否跳转行政审批系统登录页面
		if(!"".equals(this.get("oaeas")))
		{
			//返回连接地址
			fromurl = (String) this.get("fromurl");
			this.remove("oaeas");
			this.remove("fromurl");
			returnPage = "oaeasPage";
		}else
		{
			returnPage = "outLogin";
		}
		
		return returnPage;
	} 
	
	/**
	 * 建设单位
	 * 跳转至修改页面
	 * @return
	 */
	public String queryCorp(){
		ICorpService corpService = new CorpServiceImpl();
		corp = corpService.queryCorpCode1(corpCode);
		typeNum = "1" ;
		if(corp==null) {
			message = "企业已拥有资质或资质正在审批，无法修改基本信息！" ;
			return "backToBusiness" ;
		}
		provinces = corpService.queryProvince();//查询省
		this.queryDictionary();
		return "modifyCorp";
	}
	
	/**
	 * 企业类型修改
	 * @return
	 */
	public String modifyCorpType()
	{
		ICorpService corpService = new CorpServiceImpl();
		message = corpService.modifyCorpType(corp);
		return "outLogin";
	}
	
//	/**
//	 * 跳转企业注册流程图页面
//	 * @return
//	 */
//	public String flowChart()
//	{
//		return "flowchart";
//	}
	
	/**
	 * 跳转组织机构代码证查询页面
	 * @return
	 */
	public String queryCorpNamePage()
	{
		//判断是否由行政审批系统请求
		if(!"".equals(this.getMethod()))
		{
			//请求来源,值为oaeas,说明是行政审批系统请求
			this.set("oaeas", this.getMethod());
			//返回连接地址
			this.set("fromurl", this.getFromurl());
		}
		
		return "queryCorpNamePage";
	}
	
	/**
	 * 跳转企业类型组织机构代码查询页面
	 * @return
	 */
	public String queryCorpCodePage()
	{
		
		return "queryCorpCodePage";
	}
	
	/**
	 * 跳转外网登陆页面
	 * @return
	 */
	public String queryOutLoginPage()
	{
		String oaeas = (String)this.get("oaeas");
		if(oaeas != null)
		{
			//返回连接地址
			fromurl = (String) this.get("fromurl");
			this.remove("oaeas");
			this.remove("fromurl");
			return "oaeasPage";
		}else
		{
			return "outLogin";
		}
		
	}
	
	/**
	 * 组织机构代码查询
	 * @return
	 */
	public String queryCorpCode()
	{
		String oaeas = (String)this.get("oaeas");
		ICorpService corpService = new CorpServiceImpl();
		//根据组织机构代码查询企业信息
		corp = corpService.queryCorpCode(corpCode);
		String returnPage = "";
		//返回登陆页面
		if(corp.getCheckType() == 0)
		{
			returnPage = "outLogin";
		}
		//跳转修改页面
		if(corp.getCheckType() == 1)
		{
			//查询省
			provinces = corpService.queryProvince();
			this.queryDictionary();
			returnPage = "corpModify";
		}
		//跳转注册添加页面
		if(corp.getCheckType() == 2)
		{
			//查询省
			provinces = corpService.queryProvince();
			this.queryDictionary();
			returnPage = "corpAdd";
		}
		return returnPage;
		
	}
	
	/**
	 * 组织机构代码查询
	 * @return
	 */
	public String queryCorpTypeCode()
	{
		ICorpService corpService = new CorpServiceImpl();
		//根据组织机构代码查询企业信息
		corp = corpService.queryCorpTypeCode(corpCode);
		String returnPage = "";
		if(corp.getCheckType()==2)
		{
			returnPage = "outLogin";
		}else
		{
			returnPage = "queryCorpTypeCode";
		}
		return returnPage;
	}

	/**
	 * 查询市
	 * @return
	 */
	public String queryCity()
    {
		ICorpService corpService = new CorpServiceImpl();
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
		ICorpService corpService = new CorpServiceImpl();
		areas = corpService.queryArea(cityNum);
		JSONArray json = JSONArray.fromObject(areas);//给result赋值，传递给页面 
        result = json.toString();
        return "success";
    }
	
	//无锁企业修改页面返回
	public String goBack(){
		
		String oaeas = (String)this.get("oaeas");
		if(oaeas != null)
		{
			//返回连接地址
			fromurl = (String) this.get("fromurl");
			this.remove("oaeas");
			this.remove("fromurl");
			return "oaeasPage";
		}else
		{
			return "outLogin";
		}
	}
	
	//建设单位基本信息修改页面返回
	public String goBack1(){
		typeNum = "1" ;
		return "goBusiness";
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getBuilderLicenceNum() {
		return builderLicenceNum;
	}

	public void setBuilderLicenceNum(String builderLicenceNum) {
		this.builderLicenceNum = builderLicenceNum;
	}

	public String getTypeNum() {
		return typeNum;
	}

	public void setTypeNum(String typeNum) {
		this.typeNum = typeNum;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getFromurl() {
		return fromurl;
	}

	public void setFromurl(String fromurl) {
		this.fromurl = fromurl;
	}

}
