package com.tj.jst.inner.integrityShare.corpGoodIntegrityShare.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.corpGoodIntegrity.model.CorpGoodIntegrity;
import com.tj.jst.inner.integrityShare.corpGoodIntegrityShare.dao.CorpGoodIntegrityShareDaoImpl;
import com.tj.jst.inner.integrityShare.corpGoodIntegrityShare.dao.ICorpGoodIntegrityShareDao;

public class CorpGoodIntegrityShareServiceImpl implements ICorpGoodIntegrityShareService {

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		ICorpGoodIntegrityShareDao dao = new CorpGoodIntegrityShareDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * ��ѯ����ʡ
	 */
	@Override
	public List<DictionaryClass> queryProvince() {
		// TODO Auto-generated method stub
		ICorpGoodIntegrityShareDao dao = new CorpGoodIntegrityShareDaoImpl();
		return dao.queryProvince();
	}

	/**
	 * ��ѯ������
	 */
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		// TODO Auto-generated method stub
		ICorpGoodIntegrityShareDao dao = new CorpGoodIntegrityShareDaoImpl();
		return dao.queryCity(provinceId);
	}

	/**
	 * ��ѯ������
	 */
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
		ICorpGoodIntegrityShareDao dao = new CorpGoodIntegrityShareDaoImpl();
		return dao.queryArea(cityId);
	}

	/**
	 * ��ѯ��ҵ����
	 */
	@Override
	public List<DictionaryClass> queryCertTypeNums() {
		// TODO Auto-generated method stub
		ICorpGoodIntegrityShareDao dao = new CorpGoodIntegrityShareDaoImpl();
		return dao.queryCertTypeNums();
	}

	/**
	 * ������ҵ������Ϊ��Ϣ
	 */
	@Override
	public String addGoodInfo(CorpGoodIntegrity corpGoodIntegrity) {
		// TODO Auto-generated method stub
		ICorpGoodIntegrityShareDao dao = new CorpGoodIntegrityShareDaoImpl();
		return dao.addGoodInfo(corpGoodIntegrity);
	}

	/**
	 * ��ѯ��Ҫ�޸ĵ���Ϣ
	 */
	@Override
	public CorpGoodIntegrity queryCorpGoodInfo(String corpGoodCreditId) {
		// TODO Auto-generated method stub
		ICorpGoodIntegrityShareDao dao = new CorpGoodIntegrityShareDaoImpl();
		return dao.queryCorpGoodInfo(corpGoodCreditId);
	}

	/**
	 * �޸�������Ϣ
	 */
	@Override
	public String modifyGoodInfo(CorpGoodIntegrity corpGoodIntegrity) {
		// TODO Auto-generated method stub
		ICorpGoodIntegrityShareDao dao = new CorpGoodIntegrityShareDaoImpl();
		return dao.modifyGoodInfo(corpGoodIntegrity);
	}

	/**
	 * ɾ����ҵ������Ϣ
	 */
	@Override
	public String deleteGoodInfo(String corpGoodCreditId) {
		// TODO Auto-generated method stub
		ICorpGoodIntegrityShareDao dao = new CorpGoodIntegrityShareDaoImpl();
		return dao.deleteGoodInfo(corpGoodCreditId);
	}

}
