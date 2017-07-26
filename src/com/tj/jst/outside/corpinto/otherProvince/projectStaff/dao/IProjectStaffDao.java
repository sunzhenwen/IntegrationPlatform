package com.tj.jst.outside.corpinto.otherProvince.projectStaff.dao;

import java.util.List;

import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.model.ProjectPerson;

/**
 * 外省项目,人员备案
 * @author Administrator
 *
 */
public interface IProjectStaffDao {

	//已经备案的项目列表
	public List<Construction> queryProject(String corpId);

	/**
	 * 项目添加人员
	 * @return
	 */
	public String add(String projectPersons,String corpId,String otherPrjId);

	/**
	 * 查询项目下的人员
	 * @return
	 */
	public Construction queryById(Construction construction);
	
	/**
	 * 删除
	 * @return
	 */
	public void deletePerson(String personId);
	
	/**
	 * 人员编辑
	 * @return
	 */
	public ProjectPerson personDetailed(String personId);
	
	/**
	 * 人员修改
	 * @return
	 */
	public void modify(ProjectPerson projectPerson);
}
