package com.tj.jst.inner.projectconstruction.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.projectconstruction.dao.IProjectConstructionDao;
import com.tj.jst.inner.projectconstruction.dao.ProjectConstructionDaoImpl;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;

/**
 * 项目报建服务接口
 * 
 * @author DarkFlameMaster
 *
 */
public class ProjectConstructionServiceImpl implements
		IProjectConstructionService {

	/**
	 * 分页查询
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IProjectConstructionDao dao = new ProjectConstructionDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * 查询审批信息
	 */
	@Override
	public ProjectConstruction queryApproval(String prjId) {
		// TODO Auto-generated method stub
		IProjectConstructionDao dao = new ProjectConstructionDaoImpl();
		return dao.queryApproval(prjId);
	}

	/**
	 * 审批通过
	 */
	@Override
	public String applySuccess(ProjectConstruction project) {
		// TODO Auto-generated method stub
		IProjectConstructionDao dao = new ProjectConstructionDaoImpl();
		return dao.applySuccess(project);
	}

	/**
	 * 审批不通过
	 */
	@Override
	public String applyFaile(ProjectConstruction project) {
		// TODO Auto-generated method stub
		IProjectConstructionDao dao = new ProjectConstructionDaoImpl();
		return dao.applyFaile(project);
	}

	/**
	 * 批量审批
	 */
	@Override
	public void batchApplythrough(String[] ids) {
		// TODO Auto-generated method stub
		IProjectConstructionDao dao = new ProjectConstructionDaoImpl();
		List<ProjectConstruction> list = dao.batchApplythrough(ids);
		for (int i = 0; i < list.size(); i++) {
			this.applySuccess(list.get(i));
		}
	}

	/**
	 * 根据项目编号查找项目
	 */
	@Override
	public ProjectConstruction getProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		IProjectConstructionDao dao = new ProjectConstructionDaoImpl();
		return dao.getProjectInfo(prjNum);
	}

	// /**
	// * 审批分项
	// */
	// @Override
	// public Page projectPage(Condition condition) {
	// // TODO Auto-generated method stub
	// IProjectConstructionDao dao = new ProjectConstructionDaoImpl();
	// return dao.projectPage(condition);
	// }

	/**
	 * 历史审批查询
	 */
	@Override
	public Page historyPagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IProjectConstructionDao dao = new ProjectConstructionDaoImpl();
		return dao.historyPagedQuery(condition);
	}

	/**
	 * 查看是否有上传的信息
	 */
	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		IProjectConstructionDao dao = new ProjectConstructionDaoImpl();
		return dao.downloadInfo(prjId);
	}

	/**
	 * 上传到授权库
	 */
	@Override
	public String updateAuthor(ProjectConstruction project) {
		// TODO Auto-generated method stub
		IProjectConstructionDao dao = new ProjectConstructionDaoImpl();
		return dao.updateAuthor(project);
	}

}
