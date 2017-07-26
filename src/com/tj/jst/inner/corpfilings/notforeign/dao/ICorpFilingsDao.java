package com.tj.jst.inner.corpfilings.notforeign.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * 企业备案
 * 
 * @author Administrator
 *
 */
public interface ICorpFilingsDao {

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);

	/**
	 * 新企业添加
	 * 
	 * @return
	 */
	public void addCorp(Corp corp);

	/**
	 * 保存外商企业
	 * 
	 * @param corp
	 * @return
	 */
	public void addForeignCorp(Corp corp);

	/**
	 * 查询单条
	 * 
	 * @return
	 */
	public Corp queryCorpForId(String corpId);

	/**
	 * 企业修改
	 * 
	 * @return
	 */
	public void modifyCorp(Corp corp);

	/**
	 * 审批通过
	 * 
	 * @return
	 */
	public void applythrough(Corp corp);

	/**
	 * 审批未通过
	 * 
	 * @return
	 */
	public void applyThroughBack(Corp corp);

	// 查询省
	public List<DictionaryClass> queryProvince();

	// 查询市
	public List<DictionaryClass> queryCity(String provinceId);

	// 查询区
	public List<DictionaryClass> queryArea(String cityId);

	// 组织机构代码证重复判断
	public String queryCorpCode(String corpCode);
}
