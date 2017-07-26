package com.tj.jst.inner.personrecord.position.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.personrecord.position.dao.IPositionDao;
import com.tj.jst.inner.personrecord.position.dao.PositionDaoImpl;

public class PositionServiceImpl implements IPositionService {

	/**
	 * ∑÷“≥≤È—Ø
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IPositionDao dao = new PositionDaoImpl();
		return dao.pagedQuery(condition);
	}

}
