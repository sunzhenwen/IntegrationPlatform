package com.tj.jst.inner.integrity.personGoodIntegrity.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.personGoodIntegrity.dao.IPersonGoodIntegrityDao;
import com.tj.jst.inner.integrity.personGoodIntegrity.dao.PersonGoodIntegrityDaoImpl;
import com.tj.jst.inner.integrity.personGoodIntegrity.model.PersonGoodIntegrity;

/**
 * 人员良好信息Service
 * 
 * @author DarkFlameMaster
 *
 */
public class PersonGoodIntegrityServiceImpl implements
		IPersonGoodIntegrityService {

	/**
	 * 分页查询
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityDao dao = new PersonGoodIntegrityDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * 查询省
	 */
	@Override
	public List<DictionaryClass> queryProvince() {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityDao dao = new PersonGoodIntegrityDaoImpl();
		return dao.queryProvince();
	}

	/**
	 * 查询市
	 */
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityDao dao = new PersonGoodIntegrityDaoImpl();
		return dao.queryCity(provinceId);
	}

	/**
	 * 查询区
	 */
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityDao dao = new PersonGoodIntegrityDaoImpl();
		return dao.queryArea(cityId);
	}

	/**
	 * 查询证件类型
	 */
	@Override
	public List<DictionaryClass> queryCardType() {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityDao dao = new PersonGoodIntegrityDaoImpl();
		return dao.queryCardType();
	}

	/**
	 * 查询人员类型
	 */
	@Override
	public List<DictionaryClass> queryPersonType() {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityDao dao = new PersonGoodIntegrityDaoImpl();
		return dao.queryPersonType();
	}

	/**
	 * 增加人员良好信息
	 */
	@Override
	public String addPersonGoodInfo(PersonGoodIntegrity personGoodIntegrity) {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityDao dao = new PersonGoodIntegrityDaoImpl();
		return dao.addPersonGoodInfo(personGoodIntegrity);
	}

	/**
	 * 修改人员良好信息
	 */
	@Override
	public String modifyPersonGoodInfo(PersonGoodIntegrity personGoodIntegrity) {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityDao dao = new PersonGoodIntegrityDaoImpl();
		return dao.modifyPersonGoodInfo(personGoodIntegrity);
	}

	/**
	 * 删除人员良好信息
	 */
	@Override
	public String deletePersonGoodInfo(String goodCreditId) {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityDao dao = new PersonGoodIntegrityDaoImpl();
		return dao.deletePersonGoodInfo(goodCreditId);
	}

	/**
	 * 人员良好信息查找
	 */
	@Override
	public PersonGoodIntegrity queryGoodInfo(String goodCreditId) {
		// TODO Auto-generated method stub
		IPersonGoodIntegrityDao dao = new PersonGoodIntegrityDaoImpl();
		return dao.queryGoodInfo(goodCreditId);
	}

}
