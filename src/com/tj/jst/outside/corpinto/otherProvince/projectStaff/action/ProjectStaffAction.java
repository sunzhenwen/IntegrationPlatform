package com.tj.jst.outside.corpinto.otherProvince.projectStaff.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.corpinto.otherProvince.project.service.IOtherProjectService;
import com.tj.jst.outside.corpinto.otherProvince.project.service.OtherProjectServiceImpl;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.model.ProjectPerson;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.service.IProjectStaffService;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.service.IQueryPrjStaff;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.service.ProjectStaffServiceImpl;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.service.QueryPrjStaffServiceImpl;

/**
 * ��ʡ��Ŀ,��Ա����
 * @author Administrator
 *
 */
public class ProjectStaffAction extends BaseAction {
	
	//�Ѿ���������Ŀ�б�
	private List<Construction> projectList;
	//��ʡ������Ŀ����
	private String otherPrjId;
	//��Ա����
	private String personId;
	//��Ŀ����ʵ����
	private Construction construction;
	private ProjectPerson projectPerson;
	private String projectPersons;
	//��Ŀ��Ա����
	private List<DictionaryClass> staffTypeList;
	
	/**
	 * ��Ŀ�����Ա
	 * @return
	 */
	public String add()
	{
		IProjectStaffService staffService = new ProjectStaffServiceImpl();
		otherPrjId = staffService.add(projectPersons,(String)this.get("userId"),otherPrjId);
		return "queryAdd";
	}
	
	/**
	 * ��ѯ��Ŀ����Ա��ϸ
	 * @return
	 */
	public String queryById()
	{
		//��ѯ��Ŀ
		IOtherProjectService ocs = new OtherProjectServiceImpl();
		construction = ocs.queryById(otherPrjId);
		
		//�Ѿ���������Ŀ�б�
		IProjectStaffService projectService = new ProjectStaffServiceImpl();
		projectList = projectService.queryProject((String)this.get("userId"));
		
		//��ѯ��Ŀ�µ���Ա
		construction = projectService.queryById(construction);

		return "queryProjectDetailed";
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String deletePerson()
	{
		IProjectStaffService staffService = new ProjectStaffServiceImpl();
		staffService.deletePerson(personId);
		return "queryAdd";
	}
	
	/**
	 * ��Ա�༭
	 * @return
	 */
	public String personDetailed()
	{
		IProjectStaffService staffService = new ProjectStaffServiceImpl();
		projectPerson = staffService.personDetailed(personId);
		
		//��ѯ��Ա����
		IQueryPrjStaff service = new QueryPrjStaffServiceImpl();
		staffTypeList = service.queryStaffType();
		return "personDetailed";
	}
	
	/**
	 * ��Ա�޸�
	 * @return
	 */
	public String modify()
	{
		IProjectStaffService staffService = new ProjectStaffServiceImpl();
		staffService.modify(projectPerson);
		return "queryAdd";
	}
	
	/**
	 * ����
	 * @return
	 */
	public String goBack()
	{
		return "goBusiness";
	}

	/**
	 * ��ѯ��Ŀ��ϸҳ��
	 * @return
	 */
	public String queryProject()
	{
		IProjectStaffService staffService = new ProjectStaffServiceImpl();
		//�Ѿ���������Ŀ�б�
		projectList = staffService.queryProject((String)this.get("userId"));
		return "queryProjectDetailed";
	}
	
	
	public List<Construction> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Construction> projectList) {
		this.projectList = projectList;
	}

	public String getOtherPrjId() {
		return otherPrjId;
	}

	public void setOtherPrjId(String otherPrjId) {
		this.otherPrjId = otherPrjId;
	}

	public Construction getConstruction() {
		return construction;
	}

	public void setConstruction(Construction construction) {
		this.construction = construction;
	}

	public ProjectPerson getProjectPerson() {
		return projectPerson;
	}

	public void setProjectPerson(ProjectPerson projectPerson) {
		this.projectPerson = projectPerson;
	}

	public String getProjectPersons() {
		return projectPersons;
	}

	public void setProjectPersons(String projectPersons) {
		this.projectPersons = projectPersons;
	}

	public List<DictionaryClass> getStaffTypeList() {
		return staffTypeList;
	}

	public void setStaffTypeList(List<DictionaryClass> staffTypeList) {
		this.staffTypeList = staffTypeList;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

}
