package com.tj.jst.inner.integrityShare.corpBadIntegrityShare.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.corpBadIntegrity.model.CorpBadIntegrity;
import com.tj.jst.login.model.Login;

/**
 * 企业不良行为诚信
 * @author hhc
 *
 */
public interface ICorpBadIntegrityShareService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 添加
	 * @return
	 */
	public void add(CorpBadIntegrity corpBadIntegrity);
	
	/**
	 * 查询单条记录
	 * @param corpBadCreditId
	 * @return
	 */
	public CorpBadIntegrity queryById(String corpBadCreditId);
	
	/**
	 * 修改
	 * @return
	 */
	public void modify(CorpBadIntegrity corpBadIntegrity);
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String corpBadCreditId);
	
	//查询省
	public List<DictionaryClass> queryProvince();
	
	//查询市
	public List<DictionaryClass> queryCity(String provinceId);
	
	//查询区
	public List<DictionaryClass> queryArea(String cityId);
	
	
	//企业类型(TBAPTITUDEKINDDIC)
	public List<DictionaryClass> queryCertTypeNums();
	//不良行为分类(TBCREDITTYPE)
	public List<DictionaryClass> queryCreditClassNums();
	
}
