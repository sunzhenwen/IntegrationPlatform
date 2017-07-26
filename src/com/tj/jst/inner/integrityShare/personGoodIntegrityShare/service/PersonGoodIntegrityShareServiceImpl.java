package com.tj.jst.inner.integrityShare.personGoodIntegrityShare.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.personGoodIntegrity.model.PersonGoodIntegrity;
import com.tj.jst.inner.integrityShare.personGoodIntegrityShare.dao.IPersonGoodIntegrityShareDao;
import com.tj.jst.inner.integrityShare.personGoodIntegrityShare.dao.PersonGoodIntegrityShareDaoImpl;

/**
 * 人员良好信息Service
 * 
 * @author DarkFlameMaster
 *
 */
public class PersonGoodIntegrityShareServiceImpl implements
		IPersonGoodIntegrityShareService {

	/**
	 * 分页查询
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityShareDao dao = new PersonGoodIntegrityShareDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * 查询省
	 */
	@Override
	public List<DictionaryClass> queryProvince() {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityShareDao dao = new PersonGoodIntegrityShareDaoImpl();
		return dao.queryProvince();
	}

	/**
	 * 查询市
	 */
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityShareDao dao = new PersonGoodIntegrityShareDaoImpl();
		return dao.queryCity(provinceId);
	}

	/**
	 * 查询区
	 */
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityShareDao dao = new PersonGoodIntegrityShareDaoImpl();
		return dao.queryArea(cityId);
	}

	/**
	 * 查询证件类型
	 */
	@Override
	public List<DictionaryClass> queryCardType() {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityShareDao dao = new PersonGoodIntegrityShareDaoImpl();
		return dao.queryCardType();
	}

	/**
	 * 查询人员类型
	 */
	@Override
	public List<DictionaryClass> queryPersonType() {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityShareDao dao = new PersonGoodIntegrityShareDaoImpl();
		return dao.queryPersonType();
	}

	/**
	 * 增加人员良好信息
	 */
	@Override
	public String addPersonGoodInfo(PersonGoodIntegrity personGoodIntegrity) {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityShareDao dao = new PersonGoodIntegrityShareDaoImpl();
		return dao.addPersonGoodInfo(personGoodIntegrity);
	}

	/**
	 * 修改人员良好信息
	 */
	@Override
	public String modifyPersonGoodInfo(PersonGoodIntegrity personGoodIntegrity) {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityShareDao dao = new PersonGoodIntegrityShareDaoImpl();
		return dao.modifyPersonGoodInfo(personGoodIntegrity);
	}

	/**
	 * 删除人员良好信息
	 */
	@Override
	public String deletePersonGoodInfo(String goodCreditId) {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityShareDao dao = new PersonGoodIntegrityShareDaoImpl();
		return dao.deletePersonGoodInfo(goodCreditId);
	}

	/**
	 * 人员良好信息查找
	 */
	@Override
	public PersonGoodIntegrity queryGoodInfo(String goodCreditId) {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityShareDao dao = new PersonGoodIntegrityShareDaoImpl();
		return dao.queryGoodInfo(goodCreditId);
	}

}
