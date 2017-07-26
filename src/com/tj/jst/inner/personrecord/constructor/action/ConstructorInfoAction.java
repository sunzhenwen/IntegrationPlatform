package com.tj.jst.inner.personrecord.constructor.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.personrecord.constructor.condition.ConstructorCondition;
import com.tj.jst.inner.personrecord.constructor.model.Constructor;
import com.tj.jst.inner.personrecord.constructor.service.ConstructorServiceImpl;
import com.tj.jst.inner.personrecord.constructor.service.IConstructorService;

public class ConstructorInfoAction extends BaseAction {

	// ��Ὠ��ʦ����
	private String personId;
	// ע�Ὠ��ʦ
	private Constructor constructor;
	// ע�Ὠ��ʦlist
	private List<Constructor> constructorList;
	// ѧ��
	private List<DictionaryClass> eduLevelNums;
	// ѧλ
	private List<DictionaryClass> degreeNums;
	// ��ʾ��Ϣ
	private String message;

	private ConstructorCondition condition = new ConstructorCondition();

	public void setCondition(ConstructorCondition condition) {
		this.condition = condition;
	}

	public ConstructorCondition getCondition() {
		ConstructorCondition sessionCondition = (ConstructorCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * ��ҳ��ѯ
	 * 
	 * @return
	 */
	public String queryPage() {
		IConstructorService service = new ConstructorServiceImpl();
		// ��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		// ѧ��
		eduLevelNums = service.eduLevelNums();
		// ѧλ
		degreeNums = service.degreeNums();
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ѯ��ϸ��Ϣ
	 * 
	 * @param personId
	 * @return
	 */
	public String detail() {
		IConstructorService service = new ConstructorServiceImpl();
		constructor = service.queryDetailed(personId);
		return "detailPage";
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
