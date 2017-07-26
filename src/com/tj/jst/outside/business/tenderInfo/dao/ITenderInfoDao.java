package com.tj.jst.outside.business.tenderInfo.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.tenderInfo.model.TenderInfo;
import com.tj.jst.outside.business.tenderInfo.model.TenderInfoAdd;

/**
 * ’–Õ∂±Í
 * @author hhc
 *
 */
public interface ITenderInfoDao {
	
	/**
	 * ≤È—Ø
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	public List<Construction> queryProjectInfo(String corpCode);
	
	public TenderInfo queryTenderById(String tenderNum);
	
	public String add(TenderInfoAdd tenderInfoAdd);
	
	public List<DictionaryClass> queryTenderClassNum();
	public List<DictionaryClass> queryTenderTypeNum();
	public List<DictionaryClass> queryIdCardTypeNum();
}
