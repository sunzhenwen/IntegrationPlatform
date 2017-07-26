package com.tj.jst.outside.corpinto.otherProvince.projectStaff.service;

import java.util.List;

import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.dao.IProjectStaffDao;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.dao.ProjectStaffDaoImpl;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.model.ProjectPerson;

/**
 * 外省项目,人员备案
 * @author Administrator
 *
 */
public class ProjectStaffServiceImpl implements IProjectStaffService {

	//已经备案的项目列表
	public List<Construction> queryProject(String corpId)
	{
		IProjectStaffDao constructorDao = new ProjectStaffDaoImpl();
		return constructorDao.queryProject(corpId);
	}

	/**
	 * 项目添加人员
	 * @return
	 */
	public String add(String projectPersons,String corpId,String otherPrjId)
	{
		IProjectStaffDao constructorDao = new ProjectStaffDaoImpl();
		return constructorDao.add(projectPersons,corpId,otherPrjId);
	}
	
	/**
	 * 查询项目下的人员
	 * @return
	 */
	public Construction queryById(Construction construction)
	{
		IProjectStaffDao constructorDao = new ProjectStaffDaoImpl();
		return constructorDao.queryById(construction);
	}
	
	/**
	 * 删除
	 * @return
	 */
	public void deletePerson(String personId)
	{
		IProjectStaffDao constructorDao = new ProjectStaffDaoImpl();
		constructorDao.deletePerson(personId);
	}
	
	/**
	 * 人员编辑
	 * @return
	 */
	public ProjectPerson personDetailed(String personId)
	{
		IProjectStaffDao constructorDao = new ProjectStaffDaoImpl();
		return constructorDao.personDetailed(personId);
	}
	
	/**
	 * 人员修改
	 * @return
	 */
	public void modify(ProjectPerson projectPerson)
	{
		IProjectStaffDao constructorDao = new ProjectStaffDaoImpl();
		constructorDao.modify(projectPerson);
	}
}
