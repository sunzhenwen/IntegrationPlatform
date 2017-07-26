package com.tj.jst.inner.business.surveyapply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.surveyapply.dao.ISurveyApplyDao;
import com.tj.jst.inner.business.surveyapply.dao.SurveyApplyDaoImpl;
import com.tj.jst.inner.business.surveyapply.model.SurveyApply;

public class SurveyApplyServiceImpl implements ISurveyApplyService {

	/**
	 * 分页
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		ISurveyApplyDao dao = new SurveyApplyDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * 按Id查询审批信息
	 */
	@Override
	public SurveyApply queryApproval(String surveyId) {
		// TODO Auto-generated method stub
		ISurveyApplyDao dao = new SurveyApplyDaoImpl();
		return dao.queryApproval(surveyId);
	}

	/**
	 * 审批通过
	 */
	@Override
	public String applySuccess(SurveyApply design) {
		// TODO Auto-generated method stub
		ISurveyApplyDao dao = new SurveyApplyDaoImpl();
		return dao.applySuccess(design);
	}

	/**
	 * 审批不通过
	 */
	@Override
	public String applyFaile(SurveyApply design) {
		// TODO Auto-generated method stub
		ISurveyApplyDao dao = new SurveyApplyDaoImpl();
		return dao.applyFaile(design);
	}

	/**
	 * 查询设计阶段是否完成
	 */
	@Override
	public String querySurvey(String prjNum) {
		// TODO Auto-generated method stub
		ISurveyApplyDao dao = new SurveyApplyDaoImpl();
		return dao.querySurvey(prjNum);
	}

	/**
	 * 修改基本信息表
	 */
	@Override
	public void updateProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		ISurveyApplyDao dao = new SurveyApplyDaoImpl();
		dao.updateProjectInfo(prjNum);

	}

	/**
	 * 审批附页
	 */
	@Override
	public Page sidebyPage(Condition condition) {
		// TODO Auto-generated method stub
		ISurveyApplyDao dao = new SurveyApplyDaoImpl();
		return dao.sidebyPage(condition);
	}

	/**
	 * 查看是否含有附件
	 */
	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		ISurveyApplyDao dao = new SurveyApplyDaoImpl();
		return dao.downloadInfo(prjId);
	}

}
