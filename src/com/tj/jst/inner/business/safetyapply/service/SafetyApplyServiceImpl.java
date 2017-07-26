package com.tj.jst.inner.business.safetyapply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.safetyapply.dao.ISafetyApplyDao;
import com.tj.jst.inner.business.safetyapply.dao.SafetyApplyDaoImpl;
import com.tj.jst.outside.business.safety.model.Safety;

/**
 * ��ȫ���������
 * 
 * @author DarkFlameMaster
 *
 */
public class SafetyApplyServiceImpl implements ISafetyApplyService {

	/**
	 * ��ҳ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		ISafetyApplyDao dao = new SafetyApplyDaoImpl();
		return dao.pagedQuery(condition);
	}

	@Override
	public Safety queryApproval(String safetyId) {
		// TODO Auto-generated method stub
		ISafetyApplyDao dao = new SafetyApplyDaoImpl();
		return dao.queryApproval(safetyId);
	}

	@Override
	public String applySuccess(Safety safe) {
		// TODO Auto-generated method stub
		ISafetyApplyDao dao = new SafetyApplyDaoImpl();
		return dao.applySuccess(safe);
	}

	@Override
	public String applyFaile(Safety safe) {
		// TODO Auto-generated method stub
		ISafetyApplyDao dao = new SafetyApplyDaoImpl();
		return dao.applyFaile(safe);
	}

	@Override
	public String queryQuality(String prjNum) {
		// TODO Auto-generated method stub
		ISafetyApplyDao dao = new SafetyApplyDaoImpl();
		return dao.queryQuality(prjNum);
	}

	@Override
	public void updateProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		ISafetyApplyDao dao = new SafetyApplyDaoImpl();
		dao.updateProjectInfo(prjNum);
	}

	/**
	 * �鿴�Ƿ��и�ҳ
	 */
	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		ISafetyApplyDao dao = new SafetyApplyDaoImpl();
		return dao.downloadInfo(prjId);
	}

	/**
	 * ������������
	 */
	@Override
	public String queryTypeName(String typeNum) {
		// TODO Auto-generated method stub
		ISafetyApplyDao dao = new SafetyApplyDaoImpl();
		return dao.queryTypeName(typeNum);
	}

	/**
	 * ͨ������״̬
	 */
	@Override
	public String changeAuthor(String prjId) {
		// TODO Auto-generated method stub
		ISafetyApplyDao dao = new SafetyApplyDaoImpl();
		return dao.changeAuthor(prjId);
	}

}
