package com.tj.jst.inner.corpfilings.queryCorpApply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.corpfilings.queryCorpApply.dao.IQueryCorpFilingsDao;
import com.tj.jst.inner.corpfilings.queryCorpApply.dao.QueryCorpFilingsDaoImpl;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * ��ҵ����������ѯ
 * @author Administrator
 *
 */
public class QueryCorpFilingsServiceImpl implements IQueryCorpFilingsService {

	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQueryCorpFilingsDao dao = new QueryCorpFilingsDaoImpl();
		return dao.pagedQuery(condition);
	}
	
	public Corp queryCorpInfo(String corpId)
	{
		IQueryCorpFilingsDao dao = new QueryCorpFilingsDaoImpl();
		return dao.queryCorpInfo(corpId);
	}
	
	//��ѯʡ
	@Override
	public List<DictionaryClass> queryProvince() {
		IQueryCorpFilingsDao dao = new QueryCorpFilingsDaoImpl();
		return dao.queryProvince();
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		IQueryCorpFilingsDao dao = new QueryCorpFilingsDaoImpl();
		return dao.queryCity(provinceId);
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		IQueryCorpFilingsDao dao = new QueryCorpFilingsDaoImpl();
		return dao.queryArea(cityId);
	}
	
}
