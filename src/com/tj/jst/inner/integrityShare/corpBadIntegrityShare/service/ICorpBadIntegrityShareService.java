package com.tj.jst.inner.integrityShare.corpBadIntegrityShare.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.corpBadIntegrity.model.CorpBadIntegrity;
import com.tj.jst.login.model.Login;

/**
 * ��ҵ������Ϊ����
 * @author hhc
 *
 */
public interface ICorpBadIntegrityShareService {
	
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
	public void add(CorpBadIntegrity corpBadIntegrity);
	
	/**
	 * ��ѯ������¼
	 * @param corpBadCreditId
	 * @return
	 */
	public CorpBadIntegrity queryById(String corpBadCreditId);
	
	/**
	 * �޸�
	 * @return
	 */
	public void modify(CorpBadIntegrity corpBadIntegrity);
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String corpBadCreditId);
	
	//��ѯʡ
	public List<DictionaryClass> queryProvince();
	
	//��ѯ��
	public List<DictionaryClass> queryCity(String provinceId);
	
	//��ѯ��
	public List<DictionaryClass> queryArea(String cityId);
	
	
	//��ҵ����(TBAPTITUDEKINDDIC)
	public List<DictionaryClass> queryCertTypeNums();
	//������Ϊ����(TBCREDITTYPE)
	public List<DictionaryClass> queryCreditClassNums();
	
}
