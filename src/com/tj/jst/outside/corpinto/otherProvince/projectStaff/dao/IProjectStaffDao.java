package com.tj.jst.outside.corpinto.otherProvince.projectStaff.dao;

import java.util.List;

import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.model.ProjectPerson;

/**
 * ��ʡ��Ŀ,��Ա����
 * @author Administrator
 *
 */
public interface IProjectStaffDao {

	//�Ѿ���������Ŀ�б�
	public List<Construction> queryProject(String corpId);

	/**
	 * ��Ŀ�����Ա
	 * @return
	 */
	public String add(String projectPersons,String corpId,String otherPrjId);

	/**
	 * ��ѯ��Ŀ�µ���Ա
	 * @return
	 */
	public Construction queryById(Construction construction);
	
	/**
	 * ɾ��
	 * @return
	 */
	public void deletePerson(String personId);
	
	/**
	 * ��Ա�༭
	 * @return
	 */
	public ProjectPerson personDetailed(String personId);
	
	/**
	 * ��Ա�޸�
	 * @return
	 */
	public void modify(ProjectPerson projectPerson);
}
