package com.tj.jst.outside.corpinto.otherProvince.projectStaff.service;

import java.util.List;

import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.dao.IProjectStaffDao;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.dao.ProjectStaffDaoImpl;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.model.ProjectPerson;

/**
 * ��ʡ��Ŀ,��Ա����
 * @author Administrator
 *
 */
public class ProjectStaffServiceImpl implements IProjectStaffService {

	//�Ѿ���������Ŀ�б�
	public List<Construction> queryProject(String corpId)
	{
		IProjectStaffDao constructorDao = new ProjectStaffDaoImpl();
		return constructorDao.queryProject(corpId);
	}

	/**
	 * ��Ŀ�����Ա
	 * @return
	 */
	public String add(String projectPersons,String corpId,String otherPrjId)
	{
		IProjectStaffDao constructorDao = new ProjectStaffDaoImpl();
		return constructorDao.add(projectPersons,corpId,otherPrjId);
	}
	
	/**
	 * ��ѯ��Ŀ�µ���Ա
	 * @return
	 */
	public Construction queryById(Construction construction)
	{
		IProjectStaffDao constructorDao = new ProjectStaffDaoImpl();
		return constructorDao.queryById(construction);
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void deletePerson(String personId)
	{
		IProjectStaffDao constructorDao = new ProjectStaffDaoImpl();
		constructorDao.deletePerson(personId);
	}
	
	/**
	 * ��Ա�༭
	 * @return
	 */
	public ProjectPerson personDetailed(String personId)
	{
		IProjectStaffDao constructorDao = new ProjectStaffDaoImpl();
		return constructorDao.personDetailed(personId);
	}
	
	/**
	 * ��Ա�޸�
	 * @return
	 */
	public void modify(ProjectPerson projectPerson)
	{
		IProjectStaffDao constructorDao = new ProjectStaffDaoImpl();
		constructorDao.modify(projectPerson);
	}
}
