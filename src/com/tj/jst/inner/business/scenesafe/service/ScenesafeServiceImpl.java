package com.tj.jst.inner.business.scenesafe.service;
 
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.PrjCode;
import com.tj.jst.inner.business.promiseapply.dao.IPromiseApplyDao;
import com.tj.jst.inner.business.promiseapply.dao.PromiseApplyDaoImpl;
import com.tj.jst.inner.business.scenesafe.dao.ScenesafeDao;
import com.tj.jst.inner.business.scenesafe.dao.ScenesafeDaoImpl;
import com.tj.jst.inner.business.scenesafe.model.ConstruScenesafe;
import com.tj.jst.inner.business.scenesafe.model.SceneSafe;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.quality.dao.IQualityDao;
import com.tj.jst.outside.business.quality.dao.QualityDaoImpl;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.safety.dao.ISafetyDao;
import com.tj.jst.outside.business.safety.dao.SafetyDaoImpl;

/**
 * ʩ����ɷ�����
 * 
 * @author DarkFlameMaster
 *
 */
public class ScenesafeServiceImpl implements ScenesafeService {

	/**
	 * ��ҳ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		ScenesafeDao dao = new ScenesafeDaoImpl();
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

	@Override
	public String add(SceneSafe scenesafe,List<ConstruScenesafe> construscenesafe) {
		ScenesafeDao dao = new ScenesafeDaoImpl();
		Calendar c = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
//		String fDate = simpleDateFormat.format(c.getTime());
//		String serNum = PrjCode.querySerNuma(new Date(new java.util.Date().getTime()), 5);
//		String qualityNum = quality.getAppDept() + fDate
//				+ quality.getPrjNum().substring(12, 16) + "-QU-" + serNum;
//		quality.setQualityNum(qualityNum);
		return dao.add(scenesafe,construscenesafe);
	}

	@Override
	public Page pagedQuerypage(Condition condition) {
		// TODO Auto-generated method stub
		ScenesafeDao dao = new ScenesafeDaoImpl();
		return dao.pagedQuerypage(condition);
	}

	@Override
	public SceneSafe queryById(String permitid) {
		ScenesafeDao dao = new ScenesafeDaoImpl();
		return dao.queryById(permitid);
	}

	@Override
	public void delete(String permitid) {
		ScenesafeDao dao = new ScenesafeDaoImpl();
		 dao.delete(permitid);
	}

	@Override
	public void modify(SceneSafe scenesafe,
			List<ConstruScenesafe> construscenesafe) {
		ScenesafeDao dao = new ScenesafeDaoImpl();
		 dao.modify(scenesafe,construscenesafe);
	}

}
