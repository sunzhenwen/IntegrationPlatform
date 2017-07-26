package com.tj.jst.inner.business.designapply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.designapply.dao.DesignApplyDaoImpl;
import com.tj.jst.inner.business.designapply.dao.IDesignApplyDao;
import com.tj.jst.inner.business.designapply.model.DesignApply;

public class DesignApplyServiceImpl implements IDesignApplyService {

	/**
	 * ��ҳ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IDesignApplyDao dao = new DesignApplyDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * ����Id��ѯ��ѡ��Ŀ
	 */
	@Override
	public DesignApply queryApproval(String surveyId) {
		// TODO Auto-generated method stub
		IDesignApplyDao dao = new DesignApplyDaoImpl();
		return dao.queryApproval(surveyId);
	}

	/**
	 * ����ͨ��
	 */
	@Override
	public String applySuccess(DesignApply project) {
		// TODO Auto-generated method stub
		IDesignApplyDao dao = new DesignApplyDaoImpl();
		return dao.applySuccess(project);
	}

	/**
	 * ������ͨ��
	 */
	@Override
	public String applyFaile(DesignApply project) {
		// TODO Auto-generated method stub
		IDesignApplyDao dao = new DesignApplyDaoImpl();
		return dao.applyFaile(project);
	}

	/**
	 * ��ѯ���칤���Ƿ����
	 */
	@Override
	public String querySurvey(String prjNum) {
		// TODO Auto-generated method stub
		IDesignApplyDao dao = new DesignApplyDaoImpl();
		return dao.querySurvey(prjNum);
	}

	/**
	 * ������Ŀ������Ϣ��
	 */
	@Override
	public void updateProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		IDesignApplyDao dao = new DesignApplyDaoImpl();
		dao.updateProjectInfo(prjNum);
	}

	/**
	 * ������ҳ
	 */
	@Override
	public Page sidebyPage(Condition condition) {
		// TODO Auto-generated method stub
		IDesignApplyDao dao = new DesignApplyDaoImpl();
		return dao.sidebyPage(condition);
	}

	/**
	 * �鿴�Ƿ��и���
	 */
	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		IDesignApplyDao dao = new DesignApplyDaoImpl();
		return dao.downloadInfo(prjId);
	}

}
