package com.tj.jst.inner.business.readyapply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.readyapply.dao.IReadyApplyDao;
import com.tj.jst.inner.business.readyapply.dao.ReadyApplyDaoImpl;
import com.tj.jst.outside.business.complete.model.Complete;

/**
 * 竣工验收服务类
 * 
 * @author DarkFlameMaster
 *
 */
public class ReadyApplyServiceImpl implements IReadyApplyService {

	/**
	 * 分页
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IReadyApplyDao dao = new ReadyApplyDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * 查询审批详细
	 */
	@Override
	public Complete queryApproval(String completeId) {
		// TODO Auto-generated method stub
		IReadyApplyDao dao = new ReadyApplyDaoImpl();
		return dao.queryApproval(completeId);
	}

	/**
	 * 审批通过
	 */
	@Override
	public String approvalSuccess(Complete complete) {
		// TODO Auto-generated method stub
		IReadyApplyDao dao = new ReadyApplyDaoImpl();
		return dao.approvalSuccess(complete);
	}

	/**
	 * 审批不通过
	 */
	@Override
	public String approvalFailed(Complete complete) {
		// TODO Auto-generated method stub
		IReadyApplyDao dao = new ReadyApplyDaoImpl();
		return dao.approvalFailed(complete);
	}

	/**
	 * 审批完成 更改状态
	 */
	@Override
	public void updateProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		IReadyApplyDao dao = new ReadyApplyDaoImpl();
		dao.updateProjectInfo(prjNum);

	}

	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		IReadyApplyDao dao = new ReadyApplyDaoImpl();
		return dao.downloadInfo(prjId);
	}

	/**
	 * 更改授权状态
	 */
	@Override
	public String changeAuthor(String prjId) {
		// TODO Auto-generated method stub
		IReadyApplyDao dao = new ReadyApplyDaoImpl();
		return dao.changeAuthor(prjId);
	}

}
