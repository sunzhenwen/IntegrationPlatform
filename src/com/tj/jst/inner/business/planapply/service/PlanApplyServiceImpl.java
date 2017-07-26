package com.tj.jst.inner.business.planapply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.planapply.dao.IPlanApplyDao;
import com.tj.jst.inner.business.planapply.dao.PlanApplyDaoImpl;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;

/**
 * ��ͬ����������
 * 
 * @author DarkFlameMaster
 *
 */
public class PlanApplyServiceImpl implements IPlanApplyService {

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IPlanApplyDao dao = new PlanApplyDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * ��ѯ������Ŀ
	 */
	@Override
	public ConstructionPlans queryApproval(String censorId) {
		// TODO Auto-generated method stub
		IPlanApplyDao dao = new PlanApplyDaoImpl();
		return dao.queryApproval(censorId);
	}

	/**
	 * ����ͨ��
	 */
	@Override
	public String approvalSuccess(ConstructionPlans plan) {
		// TODO Auto-generated method stub
		IPlanApplyDao dao = new PlanApplyDaoImpl();
		return dao.approvalSuccess(plan);
	}

	/**
	 * ������ͨ��
	 */
	@Override
	public String approvalFailed(ConstructionPlans plan) {
		// TODO Auto-generated method stub
		IPlanApplyDao dao = new PlanApplyDaoImpl();
		return dao.approvalFailed(plan);
	}

	/**
	 * ��ѯʩ��ͼ�Ƿ����
	 */
	@Override
	public String queryFiling(String prjNum) {
		// TODO Auto-generated method stub
		IPlanApplyDao dao = new PlanApplyDaoImpl();
		return dao.queryFiling(prjNum);
	}

	/**
	 * ����ɸ��Ļ�����Ϣ
	 */
	@Override
	public void updateProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		IPlanApplyDao dao = new PlanApplyDaoImpl();
		dao.updateProjectInfo(prjNum);

	}

	/**
	 * �鿴�Ƿ��и���
	 */
	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		IPlanApplyDao dao = new PlanApplyDaoImpl();
		return dao.downloadInfo(prjId);
	}

	/**
	 * ��ɸ�����Ȩ״̬
	 */
	@Override
	public String changeAuthor(String prjId) {
		// TODO Auto-generated method stub
		IPlanApplyDao dao = new PlanApplyDaoImpl();
		return dao.changeAuthor(prjId);
	}

}
