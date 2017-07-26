package com.tj.jst.inner.integrityShare.personBadIntegrityShare.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.personBadIntegrity.model.PersonBadIntegrity;
import com.tj.jst.inner.integrityShare.personBadIntegrityShare.dao.IPersonBadIntegrityShareDao;
import com.tj.jst.inner.integrityShare.personBadIntegrityShare.dao.PersonBadIntegrityShareDaoImpl;

/**
 * 注册人员不良行为信息数据表
 * @author hhc
 *
 */
public class PersonBadIntegrityShareServiceImpl implements IPersonBadIntegrityShareService {

	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * 添加
	 * @return
	 */
	public void add(PersonBadIntegrity personBadIntegrity)
	{
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		dao.add(personBadIntegrity);
	}
	
	/**
	 * 查询单条记录
	 * @param badPersonId
	 * @return
	 */
	public PersonBadIntegrity queryById(String badPersonId)
	{
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.queryById(badPersonId);
	}
	
	/**
	 * 修改
	 * @return
	 */
	public void modify(PersonBadIntegrity personBadIntegrity)
	{
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		dao.modify(personBadIntegrity);
	}
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String badPersonId)
	{
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		dao.delete(badPersonId);
	}
	
	//查询省
	@Override
	public List<DictionaryClass> queryProvince() {
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.queryProvince();
	}

	//查询市
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.queryCity(provinceId);
	}

	//查询区
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.queryArea(cityId);
	}
	
	
	
	//人员类型(TBSPECIALTYTYPEDIC)
	public List<DictionaryClass> querySpecialtyTypNums() {
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.querySpecialtyTypNums();
	}
	//不良行为分类(TBCREDITTYPE)
	public List<DictionaryClass> queryCreditClassNums() {
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.queryCreditClassNums();
	}
	//不良行为类别(TBCORPBADDIC)
	public List<DictionaryClass> queryCreditType() {
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.queryCreditType();
	}
	//不良行为代码(TBCORPBADDIC)
	public List<DictionaryClass> queryCreditCodes() {
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.queryCreditCodes();
	}
	//处罚依据(TBCORPBADDIC)
	public List<DictionaryClass> queryPuishEvidences() {
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.queryPuishEvidences();
	}
	//证件类型(字典表：TBIDCARDTYPEDIC)
	public List<DictionaryClass> queryIdCardTypeNums()
	{
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.queryIdCardTypeNums();
	}
}
