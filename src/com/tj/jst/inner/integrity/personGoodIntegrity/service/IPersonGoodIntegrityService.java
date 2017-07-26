package com.tj.jst.inner.integrity.personGoodIntegrity.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.personGoodIntegrity.model.PersonGoodIntegrity;

/**
 * ��Ա������Ϣ�ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public interface IPersonGoodIntegrityService {

	// ��ҳ��ѯ
	public Page pagedQuery(Condition condition);

	// ��ѯʡ
	public List<DictionaryClass> queryProvince();

	// ��ѯ��
	public List<DictionaryClass> queryCity(String provinceId);

	// ��ѯ��
	public List<DictionaryClass> queryArea(String cityId);

	// ֤������
	public List<DictionaryClass> queryCardType();

	// ��Ա����
	public List<DictionaryClass> queryPersonType();

	// ������Ա������Ϣ
	public String addPersonGoodInfo(PersonGoodIntegrity personGoodIntegrity);

	// ��Ա������Ϣ�޸�
	public String modifyPersonGoodInfo(PersonGoodIntegrity personGoodIntegrity);

	// ��Ա������Ϣɾ��
	public String deletePersonGoodInfo(String goodCreditId);

	// ��Ա������Ϣ����
	public PersonGoodIntegrity queryGoodInfo(String goodCreditId);

}
