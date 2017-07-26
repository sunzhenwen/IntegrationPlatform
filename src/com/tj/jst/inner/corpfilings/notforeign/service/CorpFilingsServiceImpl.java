package com.tj.jst.inner.corpfilings.notforeign.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.corpfilings.notforeign.dao.CorpFilingsDaoImpl;
import com.tj.jst.inner.corpfilings.notforeign.dao.ICorpFilingsDao;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * 企业备案
 * 
 * @author Administrator
 *
 */
public class CorpFilingsServiceImpl implements ICorpFilingsService {

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * 新企业添加
	 * 
	 * @return
	 */
	@Override
	public void addCorp(Corp corp) {
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();
		if (corp.getCheckForeign().equals("0")) {
			// 外商企业
			dao.addForeignCorp(corp);
		} else {
			// 非外商企业
			dao.addCorp(corp);
		}

	}

	/**
	 * 跳转修改页面
	 * 
	 * @return
	 */
	public Corp modifyCorpPage(String corpId) {
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();
		return dao.queryCorpForId(corpId);
	}

	/**
	 * 企业修改
	 * 
	 * @return
	 */
	@Override
	public void modifyCorp(Corp corp) {
		// TODO Auto-generated method stub
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();
		dao.modifyCorp(corp);
	}

	/**
	 * 跳转审批页面
	 * 
	 * @return
	 */
	public Corp applyCorpPage(String corpId) {
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();
		// 查询单条数据
		return dao.queryCorpForId(corpId);
	}

	/**
	 * 审批通过
	 * 
	 * @return
	 */
	public void applythrough(Corp corp) {
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();

		dao.applythrough(corp);
	}

	/**
	 * 审批未通过
	 * 
	 * @return
	 */
	public void applyThroughBack(Corp corp) {
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();
		dao.applyThroughBack(corp);
	}

	// 查询省
	@Override
	public List<DictionaryClass> queryProvince() {
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();
		return dao.queryProvince();
	}

	// 查询市
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();
		return dao.queryCity(provinceId);
	}

	// 查询区
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();
		return dao.queryArea(cityId);
	}

	/**
	 * 组织机构代码证重复判断
	 */
	@Override
	public String queryCorpCode(String corpCode) {
		// TODO Auto-generated method stub
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();
		return dao.queryCorpCode(corpCode);
	}

}
