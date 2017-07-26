package com.tj.jst.inner.integrity.corpBadIntegrity.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.corpBadIntegrity.dao.CorpBadIntegrityDaoImpl;
import com.tj.jst.inner.integrity.corpBadIntegrity.dao.ICorpBadIntegrityDao;
import com.tj.jst.inner.integrity.corpBadIntegrity.model.CorpBadIntegrity;

/**
 * ��ҵ������Ϊ����
 * @author hhc
 *
 */
public class CorpBadIntegrityServiceImpl implements ICorpBadIntegrityService {

	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ICorpBadIntegrityDao dao = new CorpBadIntegrityDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * ���
	 * @return
	 */
	public void add(CorpBadIntegrity corpBadIntegrity)
	{
		ICorpBadIntegrityDao dao = new CorpBadIntegrityDaoImpl();
		dao.add(corpBadIntegrity);
	}
	
	/**
	 * ��ѯ������¼
	 * @param corpBadCreditId
	 * @return
	 */
	public CorpBadIntegrity queryById(String corpBadCreditId)
	{
		ICorpBadIntegrityDao dao = new CorpBadIntegrityDaoImpl();
		return dao.queryById(corpBadCreditId);
	}
	
	/**
	 * �޸�
	 * @return
	 */
	public void modify(CorpBadIntegrity corpBadIntegrity)
	{
		ICorpBadIntegrityDao dao = new CorpBadIntegrityDaoImpl();
		dao.modify(corpBadIntegrity);
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String corpBadCreditId)
	{
		ICorpBadIntegrityDao dao = new CorpBadIntegrityDaoImpl();
		dao.delete(corpBadCreditId);
	}
	
	//��ѯʡ
	@Override
	public List<DictionaryClass> queryProvince() {
		ICorpBadIntegrityDao dao = new CorpBadIntegrityDaoImpl();
		return dao.queryProvince();
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		ICorpBadIntegrityDao dao = new CorpBadIntegrityDaoImpl();
		return dao.queryCity(provinceId);
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		ICorpBadIntegrityDao dao = new CorpBadIntegrityDaoImpl();
		return dao.queryArea(cityId);
	}
	
	
	
	//��ҵ����(TBAPTITUDEKINDDIC)
	public List<DictionaryClass> queryCertTypeNums() {
		ICorpBadIntegrityDao dao = new CorpBadIntegrityDaoImpl();
		return dao.queryCertTypeNums();
	}
	//������Ϊ����(TBCREDITTYPE)
	public List<DictionaryClass> queryCreditClassNums() {
		ICorpBadIntegrityDao dao = new CorpBadIntegrityDaoImpl();
		return dao.queryCreditClassNums();
	}
	
}
