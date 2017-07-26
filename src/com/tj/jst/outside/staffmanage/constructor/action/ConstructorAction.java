package com.tj.jst.outside.staffmanage.constructor.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.staffmanage.constructor.condition.ConstructorCondition;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;
import com.tj.jst.outside.staffmanage.constructor.service.ConstructorServiceImpl;
import com.tj.jst.outside.staffmanage.constructor.service.IConstructorService;

/**
 * 注册建造师
 * @author Administrator
 *
 */
public class ConstructorAction extends BaseAction {
	
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
	//提示信息
	private String message;
	//判断是否是外省企业页面提交,1:是
	private String type;
	
	private ConstructorCondition condition = new ConstructorCondition();
	
	public void setCondition(ConstructorCondition condition) {
		this.condition = condition;
	}

	public ConstructorCondition getCondition() {
		ConstructorCondition sessionCondition = (ConstructorCondition) get(getActionName());
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
		String userName = (String)this.get("userName");
		String corpCode = (String)this.get("corpCode");
		this.getCondition().setCorpCode(corpCode);
		this.getCondition().setCorpName(userName);
		IConstructorService staffService = new ConstructorServiceImpl();
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
		IConstructorService staffService = new ConstructorServiceImpl();
		constructor = staffService.queryDetailed(idCard,corpCode);
		return "detailed";
	}
	
	/**
	 * 返回
	 * @return
	 */
	public String goBack()
	{
		return "goBusiness";
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

}
