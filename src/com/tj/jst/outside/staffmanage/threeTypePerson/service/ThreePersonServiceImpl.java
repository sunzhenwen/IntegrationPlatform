package com.tj.jst.outside.staffmanage.threeTypePerson.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.dao.IThreeTypePersonDao;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.dao.ThreeTypePersonDaoImpl;

/**
 * ��ʡ������Ա
 * @author Administrator
 *
 */
public class ThreePersonServiceImpl implements IThreePersonService {

	//��ҳ��ѯ
	@Override
	public Page pagedQuery(Condition condition) {
		IThreeTypePersonDao titleDao = new ThreeTypePersonDaoImpl();
		return titleDao.pagedQuery(condition);
	}

}
