package com.tj.jst.inner.integrity.personBadIntegrity.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.personBadIntegrity.dao.IPersonBadIntegrityDao;
import com.tj.jst.inner.integrity.personBadIntegrity.dao.PersonBadIntegrityDaoImpl;
import com.tj.jst.inner.integrity.personBadIntegrity.model.PersonBadIntegrity;

/**
 * ע����Ա������Ϊ��Ϣ���ݱ�
 * @author hhc
 *
 */
public class PersonBadIntegrityServiceImpl implements IPersonBadIntegrityService {

	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * ���
	 * @return
	 */
	public void add(PersonBadIntegrity personBadIntegrity)
	{
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		dao.add(personBadIntegrity);
	}
	
	/**
	 * ��ѯ������¼
	 * @param badPersonId
	 * @return
	 */
	public PersonBadIntegrity queryById(String badPersonId)
	{
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.queryById(badPersonId);
	}
	
	/**
	 * �޸�
	 * @return
	 */
	public void modify(PersonBadIntegrity personBadIntegrity)
	{
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		dao.modify(personBadIntegrity);
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String badPersonId)
	{
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		dao.delete(badPersonId);
	}
	
	//��ѯʡ
	@Override
	public List<DictionaryClass> queryProvince() {
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.queryProvince();
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.queryCity(provinceId);
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.queryArea(cityId);
	}
	
	
	
	//��Ա����(TBSPECIALTYTYPEDIC)
	public List<DictionaryClass> querySpecialtyTypNums() {
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.querySpecialtyTypNums();
	}
	//������Ϊ����(TBCREDITTYPE)
	public List<DictionaryClass> queryCreditClassNums() {
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.queryCreditClassNums();
	}
	//������Ϊ���(TBCORPBADDIC)
	public List<DictionaryClass> queryCreditType() {
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.queryCreditType();
	}
	//������Ϊ����(TBCORPBADDIC)
	public List<DictionaryClass> queryCreditCodes() {
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.queryCreditCodes();
	}
	//��������(TBCORPBADDIC)
	public List<DictionaryClass> queryPuishEvidences() {
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.queryPuishEvidences();
	}
	//֤������(�ֵ��TBIDCARDTYPEDIC)
	public List<DictionaryClass> queryIdCardTypeNums()
	{
		IPersonBadIntegrityDao dao = new PersonBadIntegrityDaoImpl();
		return dao.queryIdCardTypeNums();
	}
}
