package com.tj.jst.inner.business.designapply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.designapply.dao.DesignApplyDaoImpl;
import com.tj.jst.inner.business.designapply.dao.IDesignApplyDao;
import com.tj.jst.inner.business.designapply.model.DesignApply;

public class DesignApplyServiceImpl implements IDesignApplyService {

	/**
	 * 分页
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IDesignApplyDao dao = new DesignApplyDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * 根据Id查询所选条目
	 */
	@Override
	public DesignApply queryApproval(String surveyId) {
		// TODO Auto-generated method stub
		IDesignApplyDao dao = new DesignApplyDaoImpl();
		return dao.queryApproval(surveyId);
	}

	/**
	 * 审批通过
	 */
	@Override
	public String applySuccess(DesignApply project) {
		// TODO Auto-generated method stub
		IDesignApplyDao dao = new DesignApplyDaoImpl();
		return dao.applySuccess(project);
	}

	/**
	 * 审批不通过
	 */
	@Override
	public String applyFaile(DesignApply project) {
		// TODO Auto-generated method stub
		IDesignApplyDao dao = new DesignApplyDaoImpl();
		return dao.applyFaile(project);
	}

	/**
	 * 查询勘察工作是否结束
	 */
	@Override
	public String querySurvey(String prjNum) {
		// TODO Auto-generated method stub
		IDesignApplyDao dao = new DesignApplyDaoImpl();
		return dao.querySurvey(prjNum);
	}

	/**
	 * 更改项目基本信息表
	 */
	@Override
	public void updateProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		IDesignApplyDao dao = new DesignApplyDaoImpl();
		dao.updateProjectInfo(prjNum);
	}

	/**
	 * 审批附页
	 */
	@Override
	public Page sidebyPage(Condition condition) {
		// TODO Auto-generated method stub
		IDesignApplyDao dao = new DesignApplyDaoImpl();
		return dao.sidebyPage(condition);
	}

	/**
	 * 查看是否有附件
	 */
	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		IDesignApplyDao dao = new DesignApplyDaoImpl();
		return dao.downloadInfo(prjId);
	}

}
