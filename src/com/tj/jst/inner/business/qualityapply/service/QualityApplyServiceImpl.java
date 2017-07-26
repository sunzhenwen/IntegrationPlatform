package com.tj.jst.inner.business.qualityapply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.qualityapply.dao.IQualityApplyDao;
import com.tj.jst.inner.business.qualityapply.dao.QualityApplyDaoImpl;
import com.tj.jst.outside.business.quality.model.Quality;

/**
 * 质量勘察服务类
 * 
 * @author DarkFlameMaster
 *
 */
public class QualityApplyServiceImpl implements IQualityApplyService {

	/**
	 * 分页查询
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IQualityApplyDao dao = new QualityApplyDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * 查询审批记录
	 */
	@Override
	public Quality queryApproval(String qualityId) {
		// TODO Auto-generated method stub
		IQualityApplyDao dao = new QualityApplyDaoImpl();
		return dao.queryApproval(qualityId);
	}

	/**
	 * 审批通过
	 */
	@Override
	public String applySuccess(Quality qu) {
		// TODO Auto-generated method stub
		IQualityApplyDao dao = new QualityApplyDaoImpl();
		return dao.applySuccess(qu);
	}

	/**
	 * 审批不通过
	 */
	@Override
	public String applyFaile(Quality qu) {
		// TODO Auto-generated method stub
		IQualityApplyDao dao = new QualityApplyDaoImpl();
		return dao.applyFaile(qu);
	}

	/**
	 * 查询安全勘察是否完成
	 */
	@Override
	public String querySafety(String prjNum) {
		// TODO Auto-generated method stub
		IQualityApplyDao dao = new QualityApplyDaoImpl();
		return dao.querySafety(prjNum);
	}

	/**
	 * 完成更改基本信息
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
	 * 更改授权状态
	 */
	@Override
	public String changeAuthor(String prjId) {
		// TODO Auto-generated method stub
		IQualityApplyDao dao = new QualityApplyDaoImpl();
		return dao.changeAuthor(prjId);
	}

}
