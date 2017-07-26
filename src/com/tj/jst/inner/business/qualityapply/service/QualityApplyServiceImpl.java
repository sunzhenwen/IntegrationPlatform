package com.tj.jst.inner.business.qualityapply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.qualityapply.dao.IQualityApplyDao;
import com.tj.jst.inner.business.qualityapply.dao.QualityApplyDaoImpl;
import com.tj.jst.outside.business.quality.model.Quality;

/**
 * �������������
 * 
 * @author DarkFlameMaster
 *
 */
public class QualityApplyServiceImpl implements IQualityApplyService {

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IQualityApplyDao dao = new QualityApplyDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * ��ѯ������¼
	 */
	@Override
	public Quality queryApproval(String qualityId) {
		// TODO Auto-generated method stub
		IQualityApplyDao dao = new QualityApplyDaoImpl();
		return dao.queryApproval(qualityId);
	}

	/**
	 * ����ͨ��
	 */
	@Override
	public String applySuccess(Quality qu) {
		// TODO Auto-generated method stub
		IQualityApplyDao dao = new QualityApplyDaoImpl();
		return dao.applySuccess(qu);
	}

	/**
	 * ������ͨ��
	 */
	@Override
	public String applyFaile(Quality qu) {
		// TODO Auto-generated method stub
		IQualityApplyDao dao = new QualityApplyDaoImpl();
		return dao.applyFaile(qu);
	}

	/**
	 * ��ѯ��ȫ�����Ƿ����
	 */
	@Override
	public String querySafety(String prjNum) {
		// TODO Auto-generated method stub
		IQualityApplyDao dao = new QualityApplyDaoImpl();
		return dao.querySafety(prjNum);
	}

	/**
	 * ��ɸ��Ļ�����Ϣ
	 */
	@Override
	public void updateProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		IQualityApplyDao dao = new QualityApplyDaoImpl();
		dao.updateProjectInfo(prjNum);
	}

	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		IQualityApplyDao dao = new QualityApplyDaoImpl();
		return dao.downloadInfo(prjId);
	}

	/**
	 * ������Ȩ״̬
	 */
	@Override
	public String changeAuthor(String prjId) {
		// TODO Auto-generated method stub
		IQualityApplyDao dao = new QualityApplyDaoImpl();
		return dao.changeAuthor(prjId);
	}

}
