package com.tj.jst.inner.projectconstruction.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.projectconstruction.dao.IProjectConstructionDao;
import com.tj.jst.inner.projectconstruction.dao.ProjectConstructionDaoImpl;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;

/**
 * ��Ŀ��������ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public class ProjectConstructionServiceImpl implements
		IProjectConstructionService {

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IProjectConstructionDao dao = new ProjectConstructionDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * ��ѯ������Ϣ
	 */
	@Override
	public ProjectConstruction queryApproval(String prjId) {
		// TODO Auto-generated method stub
		IProjectConstructionDao dao = new ProjectConstructionDaoImpl();
		return dao.queryApproval(prjId);
	}

	/**
	 * ����ͨ��
	 */
	@Override
	public String applySuccess(ProjectConstruction project) {
		// TODO Auto-generated method stub
		IProjectConstructionDao dao = new ProjectConstructionDaoImpl();
		return dao.applySuccess(project);
	}

	/**
	 * ������ͨ��
	 */
	@Override
	public String applyFaile(ProjectConstruction project) {
		// TODO Auto-generated method stub
		IProjectConstructionDao dao = new ProjectConstructionDaoImpl();
		return dao.applyFaile(project);
	}

	/**
	 * ��������
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
	 * ������Ŀ��Ų�����Ŀ
	 */
	@Override
	public ProjectConstruction getProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		IProjectConstructionDao dao = new ProjectConstructionDaoImpl();
		return dao.getProjectInfo(prjNum);
	}

	// /**
	// * ��������
	// */
	// @Override
	// public Page projectPage(Condition condition) {
	// // TODO Auto-generated method stub
	// IProjectConstructionDao dao = new ProjectConstructionDaoImpl();
	// return dao.projectPage(condition);
	// }

	/**
	 * ��ʷ������ѯ
	 */
	@Override
	public Page historyPagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IProjectConstructionDao dao = new ProjectConstructionDaoImpl();
		return dao.historyPagedQuery(condition);
	}

	/**
	 * �鿴�Ƿ����ϴ�����Ϣ
	 */
	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		IProjectConstructionDao dao = new ProjectConstructionDaoImpl();
		return dao.downloadInfo(prjId);
	}

	/**
	 * �ϴ�����Ȩ��
	 */
	@Override
	public String updateAuthor(ProjectConstruction project) {
		// TODO Auto-generated method stub
		IProjectConstructionDao dao = new ProjectConstructionDaoImpl();
		return dao.updateAuthor(project);
	}

}
