package com.tj.jst.inner.business.readyapply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.readyapply.dao.IReadyApplyDao;
import com.tj.jst.inner.business.readyapply.dao.ReadyApplyDaoImpl;
import com.tj.jst.outside.business.complete.model.Complete;

/**
 * �������շ�����
 * 
 * @author DarkFlameMaster
 *
 */
public class ReadyApplyServiceImpl implements IReadyApplyService {

	/**
	 * ��ҳ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IReadyApplyDao dao = new ReadyApplyDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * ��ѯ������ϸ
	 */
	@Override
	public Complete queryApproval(String completeId) {
		// TODO Auto-generated method stub
		IReadyApplyDao dao = new ReadyApplyDaoImpl();
		return dao.queryApproval(completeId);
	}

	/**
	 * ����ͨ��
	 */
	@Override
	public String approvalSuccess(Complete complete) {
		// TODO Auto-generated method stub
		IReadyApplyDao dao = new ReadyApplyDaoImpl();
		return dao.approvalSuccess(complete);
	}

	/**
	 * ������ͨ��
	 */
	@Override
	public String approvalFailed(Complete complete) {
		// TODO Auto-generated method stub
		IReadyApplyDao dao = new ReadyApplyDaoImpl();
		return dao.approvalFailed(complete);
	}

	/**
	 * ������� ����״̬
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
	 * ������Ȩ״̬
	 */
	@Override
	public String changeAuthor(String prjId) {
		// TODO Auto-generated method stub
		IReadyApplyDao dao = new ReadyApplyDaoImpl();
		return dao.changeAuthor(prjId);
	}

}
