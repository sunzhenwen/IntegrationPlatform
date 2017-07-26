package com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.dao.IThreeTypePersonDao;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.dao.ThreeTypePersonDaoImpl;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.model.ThreeTypePerson;

/**
 * 外省三类人员
 * @author Administrator
 *
 */
public class ThreeTypePersonServiceImpl implements IThreeTypePersonService {

	//分页查询
	@Override
	public Page pagedQuery(Condition condition) {
		IThreeTypePersonDao titleDao = new ThreeTypePersonDaoImpl();
		return titleDao.pagedQuery(condition);
	}

	/**
	 * 增加职称人员基础信息
	 */
	@Override
	public String add(ThreeTypePerson threeTypePerson) {
		// TODO Auto-generated method stub
		IThreeTypePersonDao titleDao = new ThreeTypePersonDaoImpl();
		return titleDao.add(threeTypePerson);
	}
	
	/**
	 * 修改职称人员信息
	 */
	@Override
	public String modify(ThreeTypePerson threeTypePerson) {
		IThreeTypePersonDao titleDao = new ThreeTypePersonDaoImpl();
		return titleDao.modify(threeTypePerson);
	}

	/**
	 * 通过PersonId来判断进行删除操作的职称人员信息
	 */
	@Override
	public String delete(String threeTypePersonId) {
		IThreeTypePersonDao titleDao = new ThreeTypePersonDaoImpl();
		return titleDao.delete(threeTypePersonId);
	}

	/**
	 * 根据personId来寻找进行删除或者修改操作的人员信息
	 */
	@Override
	public ThreeTypePerson queryById(String threeTypePersonId) {
		IThreeTypePersonDao titleDao = new ThreeTypePersonDaoImpl();
		return titleDao.queryById(threeTypePersonId);
	}

	
}
