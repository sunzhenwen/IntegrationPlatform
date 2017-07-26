package com.tj.jst.inner.integrity.personBadIntegrity.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.personBadIntegrity.model.PersonBadIntegrity;

/**
 * 注册人员不良行为信息数据表
 * @author hhc
 *
 */
public interface IPersonBadIntegrityDao {
	
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
	public void add(PersonBadIntegrity personBadIntegrity);
	
	/**
	 * 查询单条记录
	 * @param badPersonId
	 * @return
	 */
	public PersonBadIntegrity queryById(String badPersonId);
	
	/**
	 * 修改
	 * @return
	 */
	public void modify(PersonBadIntegrity personBadIntegrity);
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String badPersonId);
	
	//查询省
	public List<DictionaryClass> queryProvince();

	//查询市
	public List<DictionaryClass> queryCity(String provinceId);
	
	//查询区
	public List<DictionaryClass> queryArea(String cityId);
	
	
	//人员类型(TBSPECIALTYTYPEDIC)
	public List<DictionaryClass> querySpecialtyTypNums();
	//不良行为分类(TBCREDITTYPE)
	public List<DictionaryClass> queryCreditClassNums();
	//不良行为类别(TBCORPBADDIC)
	public List<DictionaryClass> queryCreditType();
	//不良行为代码(TBCORPBADDIC)
	public List<DictionaryClass> queryCreditCodes();
	//处罚依据(TBCORPBADDIC)
	public List<DictionaryClass> queryPuishEvidences();
	//证件类型(字典表：TBIDCARDTYPEDIC)
	public List<DictionaryClass> queryIdCardTypeNums();
}
