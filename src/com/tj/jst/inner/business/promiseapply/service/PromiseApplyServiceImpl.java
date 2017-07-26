package com.tj.jst.inner.business.promiseapply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.promiseapply.dao.IPromiseApplyDao;
import com.tj.jst.inner.business.promiseapply.dao.PromiseApplyDaoImpl;
import com.tj.jst.outside.business.permit.model.Permit;

/**
 * 施工许可服务类
 * 
 * @author DarkFlameMaster
 *
 */
public class PromiseApplyServiceImpl implements IPromiseApplyService {

	/**
	 * 分页
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IPromiseApplyDao dao = new PromiseApplyDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * 查询审批详细
	 */
	@Override
	public Permit queryApproval(String permitId) {
		// TODO Auto-generated method stub
		IPromiseApplyDao dao = new PromiseApplyDaoImpl();
		return dao.queryApproval(permitId);
	}

	/**
	 * 审批沟通过
	 */
	@Override
	public String approvalSuccess(Permit permit) {
		// TODO Auto-generated method stub
		IPromiseApplyDao dao = new PromiseApplyDaoImpl();
		return dao.approvalSuccess(permit);
	}

	/**
	 * 审批不同故
	 */
	@Override
	public String approvalFailed(Permit permit) {
		// TODO Auto-generated method stub
		IPromiseApplyDao dao = new PromiseApplyDaoImpl();
		return dao.approvalFailed(permit);
	}

	/**
	 * 完成后，更改基础信息
	 */
	@Override
	public void updateProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		IPromiseApplyDao dao = new PromiseApplyDaoImpl();
		dao.updateProjectInfo(prjNum);

	}

	/**
	 * 查看是否含有附件
	 */
	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		IPromiseApplyDao dao = new PromiseApplyDaoImpl();
		return dao.downloadInfo(prjId);
	}

	/**
	 * 更改授权状态
	 */
	@Override
	public String changeAuthor(String prjId) {
		// TODO Auto-generated method stub
		IPromiseApplyDao dao = new PromiseApplyDaoImpl();
		return dao.changeAuthor(prjId);
	}

}
