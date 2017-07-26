package com.tj.jst.inner.integrity.personBadIntegrity.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.personBadIntegrity.model.PersonBadIntegrity;

/**
 * ע����Ա������Ϊ��Ϣ���ݱ�
 * @author hhc
 *
 */
public interface IPersonBadIntegrityDao {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * ���
	 * @return
	 */
	public void add(PersonBadIntegrity personBadIntegrity);
	
	/**
	 * ��ѯ������¼
	 * @param badPersonId
	 * @return
	 */
	public PersonBadIntegrity queryById(String badPersonId);
	
	/**
	 * �޸�
	 * @return
	 */
	public void modify(PersonBadIntegrity personBadIntegrity);
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String badPersonId);
	
	//��ѯʡ
	public List<DictionaryClass> queryProvince();

	//��ѯ��
	public List<DictionaryClass> queryCity(String provinceId);
	
	//��ѯ��
	public List<DictionaryClass> queryArea(String cityId);
	
	
	//��Ա����(TBSPECIALTYTYPEDIC)
	public List<DictionaryClass> querySpecialtyTypNums();
	//������Ϊ����(TBCREDITTYPE)
	public List<DictionaryClass> queryCreditClassNums();
	//������Ϊ���(TBCORPBADDIC)
	public List<DictionaryClass> queryCreditType();
	//������Ϊ����(TBCORPBADDIC)
	public List<DictionaryClass> queryCreditCodes();
	//��������(TBCORPBADDIC)
	public List<DictionaryClass> queryPuishEvidences();
	//֤������(�ֵ��TBIDCARDTYPEDIC)
	public List<DictionaryClass> queryIdCardTypeNums();
}
