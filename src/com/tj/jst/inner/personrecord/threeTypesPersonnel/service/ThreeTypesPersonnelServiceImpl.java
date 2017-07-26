package com.tj.jst.inner.personrecord.threeTypesPersonnel.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.personrecord.threeTypesPersonnel.dao.IThreeTypesPersonnelDao;
import com.tj.jst.inner.personrecord.threeTypesPersonnel.dao.ThreeTypesPersonnelDaoImpl;
import com.tj.jst.inner.personrecord.threeTypesPersonnel.model.ThreeTypesPersonnel;

public class ThreeTypesPersonnelServiceImpl implements IThreeTypesPersonnelService {

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IThreeTypesPersonnelDao dao = new ThreeTypesPersonnelDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * ��ѯ��ϸ
	 */
	@Override
	public ThreeTypesPersonnel queryById(String threeTypePersonId) {
		// TODO Auto-generated method stub
		IThreeTypesPersonnelDao dao = new ThreeTypesPersonnelDaoImpl();
		return dao.queryById(threeTypePersonId);
	}

	/**
	 * ����corpId��ѯ��ҵ����
	 */
	@Override
	public String queryCorpName(String corpId) {
		// TODO Auto-generated method stub
		IThreeTypesPersonnelDao dao = new ThreeTypesPersonnelDaoImpl();
		return dao.queryCorpName(corpId);
	}

}
