package com.tj.jst.outside.corpinto.otherProvince.queryOtherCorpCert.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.contractFiling.model.Certdetail;

/**
 * 查询外省备案企业拥有资质
 * 
 * @author Administrator
 *
 */
public interface IQueryOtherCorpCertDao {

	/**
	 * 分页查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);
	
	//资质资格类型(TBAPTITUDEKINDDIC)
	public List<DictionaryClass> qualificationsTypes();
	//资质资格序列
	public List<DictionaryClass> queryTradeTypeNum(String requirement);
	//资质资格等级(TBCERTTITLELEVELDIC)
	public List<DictionaryClass> queryRating(String requirement);
	/**
	 * 专业类别(TBTRADETYPEBOUNDDIC)
	 * @return
	 */
	public List<DictionaryClass> specialtyType(String specialtyType);
	
	//添加
	public void add(Certdetail certdetail);
	
	//删除
	public void deleteCer(String id);
}
