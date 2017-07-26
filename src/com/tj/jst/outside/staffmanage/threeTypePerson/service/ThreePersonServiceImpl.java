package com.tj.jst.outside.staffmanage.threeTypePerson.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.dao.IThreeTypePersonDao;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.dao.ThreeTypePersonDaoImpl;

/**
 * 外省三类人员
 * @author Administrator
 *
 */
public class ThreePersonServiceImpl implements IThreePersonService {

	//分页查询
	@Override
	public Page pagedQuery(Condition condition) {
		IThreeTypePersonDao titleDao = new ThreeTypePersonDaoImpl();
		return titleDao.pagedQuery(condition);
	}

}
