package com.tj.jst.outside.corpinto.otherProvince.constructor.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.otherProvince.constructor.condition.OtherConstructorCondition;
import com.tj.jst.outside.corpinto.otherProvince.constructor.service.IOtherConstructorService;
import com.tj.jst.outside.corpinto.otherProvince.constructor.service.OtherConstructorServiceImpl;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;
import com.webservice.client.constructor.TJWebService;

/**
 * 外省注册建造师
 * @author Administrator
 *
 */
public class OtherConstructorAction extends BaseAction {
	
	//注册建造师主键
	private String personId;
	//身份证号
	private String idCard;
	//执业印章号
	private String stampNum;
	//所在企业组织机构代码
	private String corpCode;
	//注册建造师
	private Constructor constructor;
	//注册建造师list
	private List<Constructor> constructorList;
	//学历
	private List<DictionaryClass> eduLevelNums;
	//学位
	private List<DictionaryClass> degreeNums;
	//民族
	private List<DictionaryClass> nationAlityNums;
	//提示信息
	private String message;
	//判断是否是外省企业页面提交,1:是
	private String type;
	//ajax返回值
	private String result;
	private List<DictionaryClass> states;//职业资格状态(1-8)(字典表：TBQSTATEDIC)
	private List<DictionaryClass> regTradeTypeNums; //注册专业编号(1-8)(字典表：TBREGTRADETYPEDIC)
	private List<DictionaryClass> callingTypeNums;  //所在企业行业类型(字典表：TBCALLINGTYPEDIC)
	private List<DictionaryClass> sepecialtyTypNums;//注册类型及等级(字典表：TBSPECIALTYTYPEDIC)
	private List<DictionaryClass> idCardTypeNums; 	//证件类型(字典表：TBIDCARDTYPEDIC)
	
	private OtherConstructorCondition condition = new OtherConstructorCondition();
	
	public void setCondition(OtherConstructorCondition condition) {
		this.condition = condition;
	}

	public OtherConstructorCondition getCondition() {
		OtherConstructorCondition sessionCondition = (OtherConstructorCondition) get(getActionName());
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
		String corpCode = (String)this.get("cropCode");
		IOtherConstructorService staffService = new OtherConstructorServiceImpl();
		this.getCondition().setCorpCode(corpCode);
		//分页查询
		currentPage = staffService.pagedQuery(this.getCondition());
		//学历
		eduLevelNums = staffService.eduLevelNums();
		//学位
		degreeNums = staffService.degreeNums();
		
		this.set(getActionName(), condition);
		return "constructorSuccess";
		
	}
	
	/**
	 * 详细
	 * @return
	 */
	public String detailed()
	{
		IOtherConstructorService staffService = new OtherConstructorServiceImpl();
		constructor = staffService.queryDetailed(idCard,corpCode);
		return "detailed";
	}
	
	/**
	 * 通过接口导入国家数据
	 */
	public String leadingIn()
	{
		String corpCode = (String)this.get("cropCode");
		String corpName = (String)this.get("userName");
		//导入数据进中间表
		TJWebService t = new TJWebService();
		String check = t.getTJWebServiceSoap().getSingleCorpRegPerson(corpName, corpCode);
		//如果成功
		if("Success".equals(check))
		{
			IOtherConstructorService staffService = new OtherConstructorServiceImpl();
			//从中间表重新导入新数据
			boolean checked = staffService.importData(corpName,corpCode);
			if(checked==true)
			{
				//导入成功
				result = "1";
			}else
			{
				//导入失败
				result = "-1";
			}
		}else
		{
			//导入失败
			result = "-1";
		}
		return "success";
	}
	
	/**
	 * 跳转添加页面
	 * @return
	 */
	public String addPage()
	{
		this.queryDictionaryClass();
		return "addPage";
	}

	/**
	 * 跳转加载页面
	 * @return
	 */
	public String loadPage()
	{
		return "loadPage";
	}
	
	/**
	 * 添加
	 * @return
	 */
	public String add()
	{
		IOtherConstructorService staffService = new OtherConstructorServiceImpl();
		//获取企业主键
		constructor.setCorpId((String)this.get("userId"));
		//获取企业名称
		constructor.setCorpName((String)this.get("userName"));
		//获取企业组织机构代码
		constructor.setCorpCode((String)this.get("cropCode"));
		staffService.add(constructor);
		return "queryPage";
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String queryById()
	{
		this.queryDictionaryClass();
		IOtherConstructorService staffService = new OtherConstructorServiceImpl();
		constructor = staffService.queryById(personId);
		return "modifyPage";
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String modify()
	{
		IOtherConstructorService staffService = new OtherConstructorServiceImpl();
		staffService.modify(constructor);
		return "queryPage";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String deletePerson()
	{
		IOtherConstructorService staffService = new OtherConstructorServiceImpl();
		staffService.deletePerson(personId);
		return "queryPage";
	}
	
	/**
	 * 返回
	 * @return
	 */
	public String goBack()
	{
		return "goBusiness";
	}

	/**
	 * 查询字典表数据
	 */
	public void queryDictionaryClass()
	{
		IOtherConstructorService staffService = new OtherConstructorServiceImpl();
		states = staffService.queryStates();//职业资格状态(1-8)(字典表：TBQSTATEDIC)
		regTradeTypeNums = staffService.queryRegTradeTypeNums(); //注册专业编号(1-8)(字典表：TBREGTRADETYPEDIC)
		callingTypeNums = staffService.queryCallingTypeNums();  //所在企业行业类型(字典表：TBCALLINGTYPEDIC)
		sepecialtyTypNums =staffService.querySepecialtyTypNums();//注册类型及等级(字典表：TBSPECIALTYTYPEDIC)
		idCardTypeNums =staffService.queryIdCardTypeNums(); 	//证件类型(字典表：TBIDCARDTYPEDIC)
		//学历
		eduLevelNums = staffService.eduLevelNums();
		//学位
		degreeNums = staffService.degreeNums();
		//民族
		nationAlityNums = staffService.nationAlityNums();
	}
	
	public Constructor getConstructor() {
		return constructor;
	}

	public void setConstructor(Constructor constructor) {
		this.constructor = constructor;
	}

	public List<Constructor> getConstructorList() {
		return constructorList;
	}

	public void setConstructorList(List<Constructor> constructorList) {
		this.constructorList = constructorList;
	}

	public List<DictionaryClass> getEduLevelNums() {
		return eduLevelNums;
	}

	public void setEduLevelNums(List<DictionaryClass> eduLevelNums) {
		this.eduLevelNums = eduLevelNums;
	}

	public List<DictionaryClass> getDegreeNums() {
		return degreeNums;
	}

	public void setDegreeNums(List<DictionaryClass> degreeNums) {
		this.degreeNums = degreeNums;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getStampNum() {
		return stampNum;
	}

	public void setStampNum(String stampNum) {
		this.stampNum = stampNum;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<DictionaryClass> getStates() {
		return states;
	}

	public void setStates(List<DictionaryClass> states) {
		this.states = states;
	}

	public List<DictionaryClass> getRegTradeTypeNums() {
		return regTradeTypeNums;
	}

	public void setRegTradeTypeNums(List<DictionaryClass> regTradeTypeNums) {
		this.regTradeTypeNums = regTradeTypeNums;
	}

	public List<DictionaryClass> getCallingTypeNums() {
		return callingTypeNums;
	}

	public void setCallingTypeNums(List<DictionaryClass> callingTypeNums) {
		this.callingTypeNums = callingTypeNums;
	}

	public List<DictionaryClass> getSepecialtyTypNums() {
		return sepecialtyTypNums;
	}

	public void setSepecialtyTypNums(List<DictionaryClass> sepecialtyTypNums) {
		this.sepecialtyTypNums = sepecialtyTypNums;
	}

	public List<DictionaryClass> getIdCardTypeNums() {
		return idCardTypeNums;
	}

	public void setIdCardTypeNums(List<DictionaryClass> idCardTypeNums) {
		this.idCardTypeNums = idCardTypeNums;
	}

	public List<DictionaryClass> getNationAlityNums() {
		return nationAlityNums;
	}

	public void setNationAlityNums(List<DictionaryClass> nationAlityNums) {
		this.nationAlityNums = nationAlityNums;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
