package com.tj.jst.inner.integrity.corpGoodIntegrity.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.corpGoodIntegrity.model.CorpGoodIntegrity;

/**
 * 企业良好行为诚信
 * 
 * @author DarkFlameMaster
 *
 */
public interface ICorpGoodIntegrityDao {

	// 分页查询
	public Page pagedQuery(Condition condition);

	// 查询省
	public List<DictionaryClass> queryProvince();

	// 查询市
	public List<DictionaryClass> queryCity(String provinceId);

	// 查询区
	public List<DictionaryClass> queryArea(String cityId);

	// 企业类型(TBAPTITUDEKINDDIC)
	public List<DictionaryClass> queryCertTypeNums();
	
	// 增加企业良好行为信息
	public String addGoodInfo(CorpGoodIntegrity corpGoodIntegrity);
	
	// 企业良好信息修改
	public CorpGoodIntegrity queryCorpGoodInfo(String corpGoodCreditId);
	
	// 企业修改良好信息
	public String modifyGoodInfo(CorpGoodIntegrity corpGoodIntegrity);
	
	// 删除企业良好信息
	public String deleteGoodInfo(String corpGoodCreditId);

}
