package com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.dao.IThreeTypePersonDao;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.dao.ThreeTypePersonDaoImpl;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.model.ThreeTypePerson;

/**
 * ��ʡ������Ա
 * @author Administrator
 *
 */
public class ThreeTypePersonServiceImpl implements IThreeTypePersonService {

	//��ҳ��ѯ
	@Override
	public Page pagedQuery(Condition condition) {
		IThreeTypePersonDao titleDao = new ThreeTypePersonDaoImpl();
		return titleDao.pagedQuery(condition);
	}

	/**
	 * ����ְ����Ա������Ϣ
	 */
	@Override
	public String add(ThreeTypePerson threeTypePerson) {
		// TODO Auto-generated method stub
		IThreeTypePersonDao titleDao = new ThreeTypePersonDaoImpl();
		return titleDao.add(threeTypePerson);
	}
	
	/**
	 * �޸�ְ����Ա��Ϣ
	 */
	@Override
	public String modify(ThreeTypePerson threeTypePerson) {
		IThreeTypePersonDao titleDao = new ThreeTypePersonDaoImpl();
		return titleDao.modify(threeTypePerson);
	}

	/**
	 * ͨ��PersonId���жϽ���ɾ��������ְ����Ա��Ϣ
	 */
	@Override
	public String delete(String threeTypePersonId) {
		IThreeTypePersonDao titleDao = new ThreeTypePersonDaoImpl();
		return titleDao.delete(threeTypePersonId);
	}

	/**
	 * ����personId��Ѱ�ҽ���ɾ�������޸Ĳ�������Ա��Ϣ
	 */
	@Override
	public ThreeTypePerson queryById(String threeTypePersonId) {
		IThreeTypePersonDao titleDao = new ThreeTypePersonDaoImpl();
		return titleDao.queryById(threeTypePersonId);
	}

	
}
