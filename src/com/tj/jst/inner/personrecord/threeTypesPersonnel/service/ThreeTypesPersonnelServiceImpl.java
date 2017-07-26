package com.tj.jst.inner.personrecord.threeTypesPersonnel.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.personrecord.threeTypesPersonnel.dao.IThreeTypesPersonnelDao;
import com.tj.jst.inner.personrecord.threeTypesPersonnel.dao.ThreeTypesPersonnelDaoImpl;
import com.tj.jst.inner.personrecord.threeTypesPersonnel.model.ThreeTypesPersonnel;

public class ThreeTypesPersonnelServiceImpl implements IThreeTypesPersonnelService {

	/**
	 * 分页查询
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IThreeTypesPersonnelDao dao = new ThreeTypesPersonnelDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * 查询详细
	 */
	@Override
	public ThreeTypesPersonnel queryById(String threeTypePersonId) {
		// TODO Auto-generated method stub
		IThreeTypesPersonnelDao dao = new ThreeTypesPersonnelDaoImpl();
		return dao.queryById(threeTypePersonId);
	}

	/**
	 * 根据corpId查询企业名称
	 */
	@Override
	public String queryCorpName(String corpId) {
		// TODO Auto-generated method stub
		IThreeTypesPersonnelDao dao = new ThreeTypesPersonnelDaoImpl();
		return dao.queryCorpName(corpId);
	}

}
