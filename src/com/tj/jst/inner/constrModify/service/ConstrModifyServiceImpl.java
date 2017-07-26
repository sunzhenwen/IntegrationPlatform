package com.tj.jst.inner.constrModify.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.constrModify.dao.ConstrModifyDaoImpl;
import com.tj.jst.inner.constrModify.dao.IConstrModifyDao;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;

/**
 * 项目报建修改,主管部门修改
 * 
 * @author hhc
 *
 */
public class ConstrModifyServiceImpl implements IConstrModifyService {

	/**
	 * 分页查询
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IConstrModifyDao dao = new ConstrModifyDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * 跳转修改页面
	 * 
	 * @return
	 */
	@Override
	public ProjectConstruction queryById(String prjId) {
		// TODO Auto-generated method stub
		IConstrModifyDao dao = new ConstrModifyDaoImpl();
		return dao.queryById(prjId);
	}

	/**
	 * 修改
	 */
	public void update(ProjectConstruction project)
	{
		IConstrModifyDao dao = new ConstrModifyDaoImpl();
		dao.update(project);
	}
}
