package com.tj.jst.inner.corpfilings.queryCorpApply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * 企业备案审批查询
 * @author Administrator
 *
 */
public interface IQueryCorpFilingsService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	public Corp queryCorpInfo(String corpId);
	
	//查询省
	public List<DictionaryClass> queryProvince();
	
	//查询市
	public List<DictionaryClass> queryCity(String provinceId);
	
	//查询区
	public List<DictionaryClass> queryArea(String cityId);
	
}
