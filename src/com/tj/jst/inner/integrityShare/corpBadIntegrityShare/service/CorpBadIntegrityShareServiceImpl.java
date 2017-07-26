package com.tj.jst.inner.integrityShare.corpBadIntegrityShare.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.corpBadIntegrity.model.CorpBadIntegrity;
import com.tj.jst.inner.integrityShare.corpBadIntegrityShare.dao.CorpBadIntegrityShareDaoImpl;
import com.tj.jst.inner.integrityShare.corpBadIntegrityShare.dao.ICorpBadIntegrityShareDao;

/**
 * ��ҵ������Ϊ����
 * @author hhc
 *
 */
public class CorpBadIntegrityShareServiceImpl implements ICorpBadIntegrityShareService {

	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ICorpBadIntegrityShareDao dao = new CorpBadIntegrityShareDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * ���
	 * @return
	 */
	public void add(CorpBadIntegrity corpBadIntegrity)
	{
		ICorpBadIntegrityShareDao dao = new CorpBadIntegrityShareDaoImpl();
		dao.add(corpBadIntegrity);
	}
	
	/**
	 * ��ѯ������¼
	 * @param corpBadCreditId
	 * @return
	 */
	public CorpBadIntegrity queryById(String corpBadCreditId)
	{
		ICorpBadIntegrityShareDao dao = new CorpBadIntegrityShareDaoImpl();
		return dao.queryById(corpBadCreditId);
	}
	
	/**
	 * �޸�
	 * @return
	 */
	public void modify(CorpBadIntegrity corpBadIntegrity)
	{
		ICorpBadIntegrityShareDao dao = new CorpBadIntegrityShareDaoImpl();
		dao.modify(corpBadIntegrity);
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String corpBadCreditId)
	{
		ICorpBadIntegrityShareDao dao = new CorpBadIntegrityShareDaoImpl();
		dao.delete(corpBadCreditId);
	}
	
	//��ѯʡ
	@Override
	public List<DictionaryClass> queryProvince() {
		ICorpBadIntegrityShareDao dao = new CorpBadIntegrityShareDaoImpl();
		return dao.queryProvince();
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		ICorpBadIntegrityShareDao dao = new CorpBadIntegrityShareDaoImpl();
		return dao.queryCity(provinceId);
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		ICorpBadIntegrityShareDao dao = new CorpBadIntegrityShareDaoImpl();
		return dao.queryArea(cityId);
	}
	
	
	
	//��ҵ����(TBAPTITUDEKINDDIC)
	public List<DictionaryClass> queryCertTypeNums() {
		ICorpBadIntegrityShareDao dao = new CorpBadIntegrityShareDaoImpl();
		return dao.queryCertTypeNums();
	}
	//������Ϊ����(TBCREDITTYPE)
	public List<DictionaryClass> queryCreditClassNums() {
		ICorpBadIntegrityShareDao dao = new CorpBadIntegrityShareDaoImpl();
		return dao.queryCreditClassNums();
	}
	
}
