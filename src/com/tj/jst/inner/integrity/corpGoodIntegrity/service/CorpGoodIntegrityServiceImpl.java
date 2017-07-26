package com.tj.jst.inner.integrity.corpGoodIntegrity.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.corpGoodIntegrity.dao.CorpGoodIntegrityDaoImpl;
import com.tj.jst.inner.integrity.corpGoodIntegrity.dao.ICorpGoodIntegrityDao;
import com.tj.jst.inner.integrity.corpGoodIntegrity.model.CorpGoodIntegrity;

public class CorpGoodIntegrityServiceImpl implements ICorpGoodIntegrityService {

	/**
	 * 分页查询
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		ICorpGoodIntegrityDao dao = new CorpGoodIntegrityDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * 查询所在省
	 */
	@Override
	public List<DictionaryClass> queryProvince() {
		// TODO Auto-generated method stub
		ICorpGoodIntegrityDao dao = new CorpGoodIntegrityDaoImpl();
		return dao.queryProvince();
	}

	/**
	 * 查询所在市
	 */
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		// TODO Auto-generated method stub
		ICorpGoodIntegrityDao dao = new CorpGoodIntegrityDaoImpl();
		return dao.queryCity(provinceId);
	}

	/**
	 * 查询所在区
	 */
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
		ICorpGoodIntegrityDao dao = new CorpGoodIntegrityDaoImpl();
		return dao.queryArea(cityId);
	}

	/**
	 * 查询企业类型
	 */
	@Override
	public List<DictionaryClass> queryCertTypeNums() {
		// TODO Auto-generated method stub
		ICorpGoodIntegrityDao dao = new CorpGoodIntegrityDaoImpl();
		return dao.queryCertTypeNums();
	}

	/**
	 * 增加企业良好行为信息
	 */
	@Override
	public String addGoodInfo(CorpGoodIntegrity corpGoodIntegrity) {
		// TODO Auto-generated method stub
		ICorpGoodIntegrityDao dao = new CorpGoodIntegrityDaoImpl();
		return dao.addGoodInfo(corpGoodIntegrity);
	}

	/**
	 * 查询所要修改的信息
	 */
	@Override
	public CorpGoodIntegrity queryCorpGoodInfo(String corpGoodCreditId) {
		// TODO Auto-generated method stub
		ICorpGoodIntegrityDao dao = new CorpGoodIntegrityDaoImpl();
		return dao.queryCorpGoodInfo(corpGoodCreditId);
	}

	/**
	 * 修改良好信息
	 */
	@Override
	public String modifyGoodInfo(CorpGoodIntegrity corpGoodIntegrity) {
		// TODO Auto-generated method stub
		ICorpGoodIntegrityDao dao = new CorpGoodIntegrityDaoImpl();
		return dao.modifyGoodInfo(corpGoodIntegrity);
	}

	/**
	 * 删除企业良好信息
	 */
	@Override
	public String deleteGoodInfo(String corpGoodCreditId) {
		// TODO Auto-generated method stub
		ICorpGoodIntegrityDao dao = new CorpGoodIntegrityDaoImpl();
		return dao.deleteGoodInfo(corpGoodCreditId);
	}

}
