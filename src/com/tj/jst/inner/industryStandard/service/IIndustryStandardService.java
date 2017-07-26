package com.tj.jst.inner.industryStandard.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.industryStandard.model.IndustryStandard;

/**
 * 行业标准
 * 
 * @author DarkFlameMaster
 *
 */
public interface IIndustryStandardService {

	/**
	 * 分页类
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * 查询发布信息
	 * 
	 * @param announceId
	 * @return
	 */
	public IndustryStandard queryById(String isId);

	/**
	 * 增加发布信息
	 * 
	 * @param annouce
	 * @return
	 */
	public void add(IndustryStandard industryStandard);

	/**
	 * 修改发布信息
	 * 
	 * @param announce
	 * @return
	 */
	public void modify(IndustryStandard industryStandard);

	/**
	 * 删除
	 * 
	 * @param announceId
	 * @return
	 */
	public void delete(String isId);
	
	public List<DictionaryClass> queryIsTypes();
	public List<DictionaryClass> queryIsPublishs();
}
