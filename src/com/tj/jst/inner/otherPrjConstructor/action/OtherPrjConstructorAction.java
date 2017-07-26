package com.tj.jst.inner.otherPrjConstructor.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.otherPrjConstructor.condition.OtherPrjConstructorCondition;
import com.tj.jst.inner.otherPrjConstructor.service.IOtherPrjConstructorService;
import com.tj.jst.inner.otherPrjConstructor.service.OtherPrjConstructorServiceImpl;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.model.ProjectPerson;

/**
 * ��ʡ��Ŀ���������鿴
 * @author Administrator
 *
 */
public class OtherPrjConstructorAction extends BaseAction {
	
	//��Ŀ����ʵ����
	private Construction construction;
	//����
	private String otherPrjId;
	//��ҵ��֯��������
	private String corpCode;
	//��ҵ����
	private String corpName;
	//��ҵ����
	private String corpId;
	private ProjectPerson projectPerson;
	private String personId;
	
	
	
	private OtherPrjConstructorCondition condition = new OtherPrjConstructorCondition();
	
	public void setCondition(OtherPrjConstructorCondition condition) {
		this.condition = condition;
	}

	public OtherPrjConstructorCondition getCondition() {
		OtherPrjConstructorCondition sessionCondition = (OtherPrjConstructorCondition) get(getActionName());
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
		IOtherPrjConstructorService ocs = new OtherPrjConstructorServiceImpl();
		//��ҳ��ѯ
		currentPage = ocs.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "otherProject";
	}
	
	/**
	 * ��Ŀ��ϸ
	 * @return
	 */
	public String projectById()
	{
		IOtherPrjConstructorService ocs = new OtherPrjConstructorServiceImpl();
		construction = ocs.projectById(otherPrjId);
		return "projectById";
	}
	
	/**
	 * ��Ա��ϸ
	 * @return
	 */
	public String personDetailed()
	{
		IOtherPrjConstructorService ocs = new OtherPrjConstructorServiceImpl();
		projectPerson = ocs.personDetailed(personId);
		return "personDetailed";
	}
	
	public Construction getConstruction() {
		return construction;
	}

	public void setConstruction(Construction construction) {
		this.construction = construction;
	}

	public String getOtherPrjId() {
		return otherPrjId;
	}

	public void setOtherPrjId(String otherPrjId) {
		this.otherPrjId = otherPrjId;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public ProjectPerson getProjectPerson() {
		return projectPerson;
	}

	public void setProjectPerson(ProjectPerson projectPerson) {
		this.projectPerson = projectPerson;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}
	
}
