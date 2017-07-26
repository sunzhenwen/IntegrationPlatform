package com.tj.jst.inner.business.planapply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.planapply.dao.IPlanApplyDao;
import com.tj.jst.inner.business.planapply.dao.PlanApplyDaoImpl;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;

/**
 * 合同备案服务类
 * 
 * @author DarkFlameMaster
 *
 */
public class PlanApplyServiceImpl implements IPlanApplyService {

	/**
	 * 分页查询
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IPlanApplyDao dao = new PlanApplyDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * 查询审批条目
	 */
	@Override
	public ConstructionPlans queryApproval(String censorId) {
		// TODO Auto-generated method stub
		IPlanApplyDao dao = new PlanApplyDaoImpl();
		return dao.queryApproval(censorId);
	}

	/**
	 * 审批通过
	 */
	@Override
	public String approvalSuccess(ConstructionPlans plan) {
		// TODO Auto-generated method stub
		IPlanApplyDao dao = new PlanApplyDaoImpl();
		return dao.approvalSuccess(plan);
	}

	/**
	 * 审批不通过
	 */
	@Override
	public String approvalFailed(ConstructionPlans plan) {
		// TODO Auto-generated method stub
		IPlanApplyDao dao = new PlanApplyDaoImpl();
		return dao.approvalFailed(plan);
	}

	/**
	 * 查询施工图是否完成
	 */
	@Override
	public String queryFiling(String prjNum) {
		// TODO Auto-generated method stub
		IPlanApplyDao dao = new PlanApplyDaoImpl();
		return dao.queryFiling(prjNum);
	}

	/**
	 * 均完成更改基本信息
	 */
	@Override
	public void updateProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		IPlanApplyDao dao = new PlanApplyDaoImpl();
		dao.updateProjectInfo(prjNum);

	}

	/**
	 * 查看是否含有附件
	 */
	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		IPlanApplyDao dao = new PlanApplyDaoImpl();
		return dao.downloadInfo(prjId);
	}

	/**
	 * 完成更改授权状态
	 */
	@Override
	public String changeAuthor(String prjId) {
		// TODO Auto-generated method stub
		IPlanApplyDao dao = new PlanApplyDaoImpl();
		return dao.changeAuthor(prjId);
	}

}
