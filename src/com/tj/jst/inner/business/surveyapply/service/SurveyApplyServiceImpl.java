package com.tj.jst.inner.business.surveyapply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.surveyapply.dao.ISurveyApplyDao;
import com.tj.jst.inner.business.surveyapply.dao.SurveyApplyDaoImpl;
import com.tj.jst.inner.business.surveyapply.model.SurveyApply;

public class SurveyApplyServiceImpl implements ISurveyApplyService {

	/**
	 * ��ҳ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		ISurveyApplyDao dao = new SurveyApplyDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * ��Id��ѯ������Ϣ
	 */
	@Override
	public SurveyApply queryApproval(String surveyId) {
		// TODO Auto-generated method stub
		ISurveyApplyDao dao = new SurveyApplyDaoImpl();
		return dao.queryApproval(surveyId);
	}

	/**
	 * ����ͨ��
	 */
	@Override
	public String applySuccess(SurveyApply design) {
		// TODO Auto-generated method stub
		ISurveyApplyDao dao = new SurveyApplyDaoImpl();
		return dao.applySuccess(design);
	}

	/**
	 * ������ͨ��
	 */
	@Override
	public String applyFaile(SurveyApply design) {
		// TODO Auto-generated method stub
		ISurveyApplyDao dao = new SurveyApplyDaoImpl();
		return dao.applyFaile(design);
	}

	/**
	 * ��ѯ��ƽ׶��Ƿ����
	 */
	@Override
	public String querySurvey(String prjNum) {
		// TODO Auto-generated method stub
		ISurveyApplyDao dao = new SurveyApplyDaoImpl();
		return dao.querySurvey(prjNum);
	}

	/**
	 * �޸Ļ�����Ϣ��
	 */
	@Override
	public void updateProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		ISurveyApplyDao dao = new SurveyApplyDaoImpl();
		dao.updateProjectInfo(prjNum);

	}

	/**
	 * ������ҳ
	 */
	@Override
	public Page sidebyPage(Condition condition) {
		// TODO Auto-generated method stub
		ISurveyApplyDao dao = new SurveyApplyDaoImpl();
		return dao.sidebyPage(condition);
	}

	/**
	 * �鿴�Ƿ��и���
	 */
	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		ISurveyApplyDao dao = new SurveyApplyDaoImpl();
		return dao.downloadInfo(prjId);
	}

}
