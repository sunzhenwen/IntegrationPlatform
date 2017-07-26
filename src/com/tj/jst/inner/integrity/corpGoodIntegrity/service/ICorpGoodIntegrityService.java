package com.tj.jst.inner.integrity.corpGoodIntegrity.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.corpGoodIntegrity.model.CorpGoodIntegrity;

/**
 * ��ҵ������Ϊ����
 * 
 * @author DarkFlameMaster
 *
 */
public interface ICorpGoodIntegrityService {

	// ��ҳ��ѯ
	public Page pagedQuery(Condition condition);

	// ��ѯʡ
	public List<DictionaryClass> queryProvince();

	// ��ѯ��
	public List<DictionaryClass> queryCity(String provinceId);

	// ��ѯ��
	public List<DictionaryClass> queryArea(String cityId);

	// ��ҵ����(TBAPTITUDEKINDDIC)
	public List<DictionaryClass> queryCertTypeNums();
	
	// ������ҵ������Ϊ��Ϣ
	public String addGoodInfo(CorpGoodIntegrity corpGoodIntegrity);
	
	// ��ҵ������Ϣ�޸�
	public CorpGoodIntegrity queryCorpGoodInfo(String corpGoodCreditId);
	
	// ��ҵ�޸�������Ϣ
	public String modifyGoodInfo(CorpGoodIntegrity corpGoodIntegrity);
	
	// ɾ����ҵ������Ϣ
	public String deleteGoodInfo(String corpGoodCreditId);

}