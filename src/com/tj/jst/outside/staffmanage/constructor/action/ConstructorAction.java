package com.tj.jst.outside.staffmanage.constructor.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.staffmanage.constructor.condition.ConstructorCondition;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;
import com.tj.jst.outside.staffmanage.constructor.service.ConstructorServiceImpl;
import com.tj.jst.outside.staffmanage.constructor.service.IConstructorService;

/**
 * ע�Ὠ��ʦ
 * @author Administrator
 *
 */
public class ConstructorAction extends BaseAction {
	
	//ע�Ὠ��ʦ����
	private String personId;
	//���֤��
	private String idCard;
	//ִҵӡ�º�
	private String stampNum;
	//������ҵ��֯��������
	private String corpCode;
	//ע�Ὠ��ʦ
	private Constructor constructor;
	//ע�Ὠ��ʦlist
	private List<Constructor> constructorList;
	//ѧ��
	private List<DictionaryClass> eduLevelNums;
	//ѧλ
	private List<DictionaryClass> degreeNums;
	//��ʾ��Ϣ
	private String message;
	//�ж��Ƿ�����ʡ��ҵҳ���ύ,1:��
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
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		String userName = (String)this.get("userName");
		String corpCode = (String)this.get("corpCode");
		this.getCondition().setCorpCode(corpCode);
		this.getCondition().setCorpName(userName);
		IConstructorService staffService = new ConstructorServiceImpl();
		//��ҳ��ѯ
		currentPage = staffService.pagedQuery(this.getCondition());
		//ѧ��
		eduLevelNums = staffService.eduLevelNums();
		//ѧλ
		degreeNums = staffService.degreeNums();
		
		this.set(getActionName(), condition);
		return "constructorSuccess";
		
	}
	
	/**
	 * ��ϸ
	 * @return
	 */
	public String detailed()
	{
		IConstructorService staffService = new ConstructorServiceImpl();
		constructor = staffService.queryDetailed(idCard,corpCode);
		return "detailed";
	}
	
	/**
	 * ����
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
