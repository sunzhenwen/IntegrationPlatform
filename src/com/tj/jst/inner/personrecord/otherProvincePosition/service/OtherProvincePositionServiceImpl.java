package com.tj.jst.inner.personrecord.otherProvincePosition.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.personrecord.otherProvincePosition.dao.IOtherProvincePositionDao;
import com.tj.jst.inner.personrecord.otherProvincePosition.dao.OtherProvincePositionDaoImpl;

public class OtherProvincePositionServiceImpl implements IOtherProvincePositionService {

	/**
	 * ∑÷“≥≤È—Ø
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IOtherProvincePositionDao dao = new OtherProvincePositionDaoImpl();
		return dao.pagedQuery(condition);
	}

}
