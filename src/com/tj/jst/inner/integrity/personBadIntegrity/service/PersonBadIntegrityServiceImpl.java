package com.tj.jst.inner.integrity.personBadIntegrity.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.personBadIntegrity.dao.IPersonBadIntegrityDao;
import com.tj.jst.inner.integrity.personBadIntegrity.dao.PersonBadIntegrityDaoImpl;
import com.tj.jst.inner.integrity.personBadIntegrity.model.PersonBadIntegrity;

/**
 * 注册人员不良行为信息数据表
 * @author hhc
 *
 */
public class PersonBadIntegrityServiceImpl implements IPersonBadIntegrityService {

	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * 添加
	 * @return
	 */
	public void add(PersonBadIntegrity personBadIntegrity)
	{
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		dao.add(personBadIntegrity);
	}
	
	/**
	 * 查询单条记录
	 * @param badPersonId
	 * @return
	 */
	public PersonBadIntegrity queryById(String badPersonId)
	{
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.queryById(badPersonId);
	}
	
	/**
	 * 修改
	 * @return
	 */
	public void modify(PersonBadIntegrity personBadIntegrity)
	{
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		dao.modify(personBadIntegrity);
	}
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String badPersonId)
	{
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		dao.delete(badPersonId);
	}
	
	//查询省
	@Override
	public List<DictionaryClass> queryProvince() {
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.queryProvince();
	}

	//查询市
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.queryCity(provinceId);
	}

	//查询区
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.queryArea(cityId);
	}
	
	
	
	//人员类型(TBSPECIALTYTYPEDIC)
	public List<DictionaryClass> querySpecialtyTypNums() {
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.querySpecialtyTypNums();
	}
	//不良行为分类(TBCREDITTYPE)
	public List<DictionaryClass> queryCreditClassNums() {
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.queryCreditClassNums();
	}
	//不良行为类别(TBCORPBADDIC)
	public List<DictionaryClass> queryCreditType() {
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.queryCreditType();
	}
	//不良行为代码(TBCORPBADDIC)
	public List<DictionaryClass> queryCreditCodes() {
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.queryCreditCodes();
	}
	//处罚依据(TBCORPBADDIC)
	public List<DictionaryClass> queryPuishEvidences() {
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.queryPuishEvidences();
	}
	//证件类型(字典表：TBIDCARDTYPEDIC)
	public List<DictionaryClass> queryIdCardTypeNums()
	{
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.queryIdCardTypeNums();
	}
}
