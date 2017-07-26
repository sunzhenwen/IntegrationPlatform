package com.tj.jst.inner.integrityShare.personBadIntegrityShare.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.personBadIntegrity.model.PersonBadIntegrity;
import com.tj.jst.inner.integrityShare.personBadIntegrityShare.dao.IPersonBadIntegrityShareDao;
import com.tj.jst.inner.integrityShare.personBadIntegrityShare.dao.PersonBadIntegrityShareDaoImpl;

/**
 * ע����Ա������Ϊ��Ϣ���ݱ�
 * @author hhc
 *
 */
public class PersonBadIntegrityShareServiceImpl implements IPersonBadIntegrityShareService {

	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * ���
	 * @return
	 */
	public void add(PersonBadIntegrity personBadIntegrity)
	{
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		dao.add(personBadIntegrity);
	}
	
	/**
	 * ��ѯ������¼
	 * @param badPersonId
	 * @return
	 */
	public PersonBadIntegrity queryById(String badPersonId)
	{
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.queryById(badPersonId);
	}
	
	/**
	 * �޸�
	 * @return
	 */
	public void modify(PersonBadIntegrity personBadIntegrity)
	{
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		dao.modify(personBadIntegrity);
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String badPersonId)
	{
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		dao.delete(badPersonId);
	}
	
	//��ѯʡ
	@Override
	public List<DictionaryClass> queryProvince() {
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.queryProvince();
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.queryCity(provinceId);
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.queryArea(cityId);
	}
	
	
	
	//��Ա����(TBSPECIALTYTYPEDIC)
	public List<DictionaryClass> querySpecialtyTypNums() {
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.querySpecialtyTypNums();
	}
	//������Ϊ����(TBCREDITTYPE)
	public List<DictionaryClass> queryCreditClassNums() {
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.queryCreditClassNums();
	}
	//������Ϊ���(TBCORPBADDIC)
	public List<DictionaryClass> queryCreditType() {
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.queryCreditType();
	}
	//������Ϊ����(TBCORPBADDIC)
	public List<DictionaryClass> queryCreditCodes() {
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.queryCreditCodes();
	}
	//��������(TBCORPBADDIC)
	public List<DictionaryClass> queryPuishEvidences() {
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.queryPuishEvidences();
	}
	//֤������(�ֵ��TBIDCARDTYPEDIC)
	public List<DictionaryClass> queryIdCardTypeNums()
	{
		IPersonBadIntegrityShareDao dao = new PersonBadIntegrityShareDaoImpl();
		return dao.queryIdCardTypeNums();
	}
}
