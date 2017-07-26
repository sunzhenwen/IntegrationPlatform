package com.tj.jst.inner.integrityShare.corpBadIntegrityShare.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.corpBadIntegrity.model.CorpBadIntegrity;
import com.tj.jst.inner.integrityShare.corpBadIntegrityShare.dao.CorpBadIntegrityShareDaoImpl;
import com.tj.jst.inner.integrityShare.corpBadIntegrityShare.dao.ICorpBadIntegrityShareDao;

/**
 * 企业不良行为诚信
 * @author hhc
 *
 */
public class CorpBadIntegrityShareServiceImpl implements ICorpBadIntegrityShareService {

	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ICorpBadIntegrityShareDao dao = new CorpBadIntegrityShareDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * 添加
	 * @return
	 */
	public void add(CorpBadIntegrity corpBadIntegrity)
	{
		ICorpBadIntegrityShareDao dao = new CorpBadIntegrityShareDaoImpl();
		dao.add(corpBadIntegrity);
	}
	
	/**
	 * 查询单条记录
	 * @param corpBadCreditId
	 * @return
	 */
	public CorpBadIntegrity queryById(String corpBadCreditId)
	{
		ICorpBadIntegrityShareDao dao = new CorpBadIntegrityShareDaoImpl();
		return dao.queryById(corpBadCreditId);
	}
	
	/**
	 * 修改
	 * @return
	 */
	public void modify(CorpBadIntegrity corpBadIntegrity)
	{
		ICorpBadIntegrityShareDao dao = new CorpBadIntegrityShareDaoImpl();
		dao.modify(corpBadIntegrity);
	}
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String corpBadCreditId)
	{
		ICorpBadIntegrityShareDao dao = new CorpBadIntegrityShareDaoImpl();
		dao.delete(corpBadCreditId);
	}
	
	//查询省
	@Override
	public List<DictionaryClass> queryProvince() {
		ICorpBadIntegrityShareDao dao = new CorpBadIntegrityShareDaoImpl();
		return dao.queryProvince();
	}

	//查询市
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		ICorpBadIntegrityShareDao dao = new CorpBadIntegrityShareDaoImpl();
		return dao.queryCity(provinceId);
	}

	//查询区
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		ICorpBadIntegrityShareDao dao = new CorpBadIntegrityShareDaoImpl();
		return dao.queryArea(cityId);
	}
	
	
	
	//企业类型(TBAPTITUDEKINDDIC)
	public List<DictionaryClass> queryCertTypeNums() {
		ICorpBadIntegrityShareDao dao = new CorpBadIntegrityShareDaoImpl();
		return dao.queryCertTypeNums();
	}
	//不良行为分类(TBCREDITTYPE)
	public List<DictionaryClass> queryCreditClassNums() {
		ICorpBadIntegrityShareDao dao = new CorpBadIntegrityShareDaoImpl();
		return dao.queryCreditClassNums();
	}
	
}
