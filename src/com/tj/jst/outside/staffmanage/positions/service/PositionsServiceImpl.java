package com.tj.jst.outside.staffmanage.positions.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.staffmanage.positions.dao.IPositionsDao;
import com.tj.jst.outside.staffmanage.positions.dao.PositionsDaoImpl;

public class PositionsServiceImpl implements IPositionsService {

	//∑÷“≥≤È—Ø
	@Override
	public Page pagedQuery(Condition condition) {
		IPositionsDao constructorDao = new PositionsDaoImpl();
		return constructorDao.pagedQuery(condition);
	}
}
