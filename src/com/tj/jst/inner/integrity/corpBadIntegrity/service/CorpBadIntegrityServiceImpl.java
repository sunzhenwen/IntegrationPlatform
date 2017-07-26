package com.tj.jst.inner.integrity.corpBadIntegrity.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.corpBadIntegrity.dao.CorpBadIntegrityDaoImpl;
import com.tj.jst.inner.integrity.corpBadIntegrity.dao.ICorpBadIntegrityDao;
import com.tj.jst.inner.integrity.corpBadIntegrity.model.CorpBadIntegrity;

/**
 * 企业不良行为诚信
 * @author hhc
 *
 */
public class CorpBadIntegrityServiceImpl implements ICorpBadIntegrityService {

	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ICorpBadIntegrityDao dao = new CorpBadIntegrityDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * 添加
	 * @return
	 */
	public void add(CorpBadIntegrity corpBadIntegrity)
	{
		ICorpBadIntegrityDao dao = new CorpBadIntegrityDaoImpl();
		dao.add(corpBadIntegrity);
	}
	
	/**
	 * 查询单条记录
	 * @param corpBadCreditId
	 * @return
	 */
	public CorpBadIntegrity queryById(String corpBadCreditId)
	{
		ICorpBadIntegrityDao dao = new CorpBadIntegrityDaoImpl();
		return dao.queryById(corpBadCreditId);
	}
	
	/**
	 * 修改
	 * @return
	 */
	public void modify(CorpBadIntegrity corpBadIntegrity)
	{
		ICorpBadIntegrityDao dao = new CorpBadIntegrityDaoImpl();
		dao.modify(corpBadIntegrity);
	}
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String corpBadCreditId)
	{
		ICorpBadIntegrityDao dao = new CorpBadIntegrityDaoImpl();
		dao.delete(corpBadCreditId);
	}
	
	//查询省
	@Override
	public List<DictionaryClass> queryProvince() {
		ICorpBadIntegrityDao dao = new CorpBadIntegrityDaoImpl();
		return dao.queryProvince();
	}

	//查询市
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		ICorpBadIntegrityDao dao = new CorpBadIntegrityDaoImpl();
		return dao.queryCity(provinceId);
	}

	//查询区
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		ICorpBadIntegrityDao dao = new CorpBadIntegrityDaoImpl();
		return dao.queryArea(cityId);
	}
	
	
	
	//企业类型(TBAPTITUDEKINDDIC)
	public List<DictionaryClass> queryCertTypeNums() {
		ICorpBadIntegrityDao dao = new CorpBadIntegrityDaoImpl();
		return dao.queryCertTypeNums();
	}
	//不良行为分类(TBCREDITTYPE)
	public List<DictionaryClass> queryCreditClassNums() {
		ICorpBadIntegrityDao dao = new CorpBadIntegrityDaoImpl();
		return dao.queryCreditClassNums();
	}
	
}
