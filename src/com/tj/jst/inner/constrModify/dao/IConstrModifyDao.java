package com.tj.jst.inner.constrModify.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;

/**
 * 项目报建修改,主管部门修改
 * 
 * @author hhc
 *
 */
public interface IConstrModifyDao {

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);


	/**
	 * 跳转修改页面
	 * 
	 * @return
	 */
	public ProjectConstruction queryById(String prjId);

	/**
	 * 修改
	 */
	public void update(ProjectConstruction project);
}
