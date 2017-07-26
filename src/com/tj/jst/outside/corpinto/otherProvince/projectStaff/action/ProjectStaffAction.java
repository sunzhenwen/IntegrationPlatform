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
 * 外省项目,人员备案
 * @author Administrator
 *
 */
public class ProjectStaffAction extends BaseAction {
	
	//已经备案的项目列表
	private List<Construction> projectList;
	//外省备案项目主键
	private String otherPrjId;
	//人员主键
	private String personId;
	//项目报建实体类
	private Construction construction;
	private ProjectPerson projectPerson;
	private String projectPersons;
	//项目人员类型
	private List<DictionaryClass> staffTypeList;
	
	/**
	 * 项目添加人员
	 * @return
	 */
	public String add()
	{
		IProjectStaffService staffService = new ProjectStaffServiceImpl();
		otherPrjId = staffService.add(projectPersons,(String)this.get("userId"),otherPrjId);
		return "queryAdd";
	}
	
	/**
	 * 查询项目、人员详细
	 * @return
	 */
	public String queryById()
	{
		//查询项目
		IOtherProjectService ocs = new OtherProjectServiceImpl();
		construction = ocs.queryById(otherPrjId);
		
		//已经备案的项目列表
		IProjectStaffService projectService = new ProjectStaffServiceImpl();
		projectList = projectService.queryProject((String)this.get("userId"));
		
		//查询项目下的人员
		construction = projectService.queryById(construction);

		return "queryProjectDetailed";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String deletePerson()
	{
		IProjectStaffService staffService = new ProjectStaffServiceImpl();
		staffService.deletePerson(personId);
		return "queryAdd";
	}
	
	/**
	 * 人员编辑
	 * @return
	 */
	public String personDetailed()
	{
		IProjectStaffService staffService = new ProjectStaffServiceImpl();
		projectPerson = staffService.personDetailed(personId);
		
		//查询人员类型
		IQueryPrjStaff service = new QueryPrjStaffServiceImpl();
		staffTypeList = service.queryStaffType();
		return "personDetailed";
	}
	
	/**
	 * 人员修改
	 * @return
	 */
	public String modify()
	{
		IProjectStaffService staffService = new ProjectStaffServiceImpl();
		staffService.modify(projectPerson);
		return "queryAdd";
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
	 * 查询项目详细页面
	 * @return
	 */
	public String queryProject()
	{
		IProjectStaffService staffService = new ProjectStaffServiceImpl();
		//已经备案的项目列表
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
