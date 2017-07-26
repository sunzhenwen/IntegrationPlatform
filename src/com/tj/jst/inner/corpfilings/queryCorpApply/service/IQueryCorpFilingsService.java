package com.tj.jst.inner.corpfilings.queryCorpApply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * ��ҵ����������ѯ
 * @author Administrator
 *
 */
public interface IQueryCorpFilingsService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	public Corp queryCorpInfo(String corpId);
	
	//��ѯʡ
	public List<DictionaryClass> queryProvince();
	
	//��ѯ��
	public List<DictionaryClass> queryCity(String provinceId);
	
	//��ѯ��
	public List<DictionaryClass> queryArea(String cityId);
	
}
