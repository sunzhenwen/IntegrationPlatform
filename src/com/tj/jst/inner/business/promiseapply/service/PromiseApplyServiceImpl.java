package com.tj.jst.inner.business.promiseapply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.promiseapply.dao.IPromiseApplyDao;
import com.tj.jst.inner.business.promiseapply.dao.PromiseApplyDaoImpl;
import com.tj.jst.outside.business.permit.model.Permit;

/**
 * ʩ����ɷ�����
 * 
 * @author DarkFlameMaster
 *
 */
public class PromiseApplyServiceImpl implements IPromiseApplyService {

	/**
	 * ��ҳ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IPromiseApplyDao dao = new PromiseApplyDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * ��ѯ������ϸ
	 */
	@Override
	public Permit queryApproval(String permitId) {
		// TODO Auto-generated method stub
		IPromiseApplyDao dao = new PromiseApplyDaoImpl();
		return dao.queryApproval(permitId);
	}

	/**
	 * ������ͨ��
	 */
	@Override
	public String approvalSuccess(Permit permit) {
		// TODO Auto-generated method stub
		IPromiseApplyDao dao = new PromiseApplyDaoImpl();
		return dao.approvalSuccess(permit);
	}

	/**
	 * ������ͬ��
	 */
	@Override
	public String approvalFailed(Permit permit) {
		// TODO Auto-generated method stub
		IPromiseApplyDao dao = new PromiseApplyDaoImpl();
		return dao.approvalFailed(permit);
	}

	/**
	 * ��ɺ󣬸��Ļ�����Ϣ
	 */
	@Override
	public void updateProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		IPromiseApplyDao dao = new PromiseApplyDaoImpl();
		dao.updateProjectInfo(prjNum);

	}

	/**
	 * �鿴�Ƿ��и���
	 */
	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		IPromiseApplyDao dao = new PromiseApplyDaoImpl();
		return dao.downloadInfo(prjId);
	}

	/**
	 * ������Ȩ״̬
	 */
	@Override
	public String changeAuthor(String prjId) {
		// TODO Auto-generated method stub
		IPromiseApplyDao dao = new PromiseApplyDaoImpl();
		return dao.changeAuthor(prjId);
	}

}
