package com.tj.jst.inner.integrityShare.personGoodIntegrityShare.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.personGoodIntegrity.model.PersonGoodIntegrity;
import com.tj.jst.inner.integrityShare.personGoodIntegrityShare.dao.IPersonGoodIntegrityShareDao;
import com.tj.jst.inner.integrityShare.personGoodIntegrityShare.dao.PersonGoodIntegrityShareDaoImpl;

/**
 * ��Ա������ϢService
 * 
 * @author DarkFlameMaster
 *
 */
public class PersonGoodIntegrityShareServiceImpl implements
		IPersonGoodIntegrityShareService {

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityShareDao dao = new PersonGoodIntegrityShareDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * ��ѯʡ
	 */
	@Override
	public List<DictionaryClass> queryProvince() {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityShareDao dao = new PersonGoodIntegrityShareDaoImpl();
		return dao.queryProvince();
	}

	/**
	 * ��ѯ��
	 */
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityShareDao dao = new PersonGoodIntegrityShareDaoImpl();
		return dao.queryCity(provinceId);
	}

	/**
	 * ��ѯ��
	 */
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityShareDao dao = new PersonGoodIntegrityShareDaoImpl();
		return dao.queryArea(cityId);
	}

	/**
	 * ��ѯ֤������
	 */
	@Override
	public List<DictionaryClass> queryCardType() {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityShareDao dao = new PersonGoodIntegrityShareDaoImpl();
		return dao.queryCardType();
	}

	/**
	 * ��ѯ��Ա����
	 */
	@Override
	public List<DictionaryClass> queryPersonType() {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityShareDao dao = new PersonGoodIntegrityShareDaoImpl();
		return dao.queryPersonType();
	}

	/**
	 * ������Ա������Ϣ
	 */
	@Override
	public String addPersonGoodInfo(PersonGoodIntegrity personGoodIntegrity) {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityShareDao dao = new PersonGoodIntegrityShareDaoImpl();
		return dao.addPersonGoodInfo(personGoodIntegrity);
	}

	/**
	 * �޸���Ա������Ϣ
	 */
	@Override
	public String modifyPersonGoodInfo(PersonGoodIntegrity personGoodIntegrity) {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityShareDao dao = new PersonGoodIntegrityShareDaoImpl();
		return dao.modifyPersonGoodInfo(personGoodIntegrity);
	}

	/**
	 * ɾ����Ա������Ϣ
	 */
	@Override
	public String deletePersonGoodInfo(String goodCreditId) {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityShareDao dao = new PersonGoodIntegrityShareDaoImpl();
		return dao.deletePersonGoodInfo(goodCreditId);
	}

	/**
	 * ��Ա������Ϣ����
	 */
	@Override
	public PersonGoodIntegrity queryGoodInfo(String goodCreditId) {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityShareDao dao = new PersonGoodIntegrityShareDaoImpl();
		return dao.queryGoodInfo(goodCreditId);
	}

}
