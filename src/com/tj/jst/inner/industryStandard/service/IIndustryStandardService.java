package com.tj.jst.inner.industryStandard.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.industryStandard.model.IndustryStandard;

/**
 * ��ҵ��׼
 * 
 * @author DarkFlameMaster
 *
 */
public interface IIndustryStandardService {

	/**
	 * ��ҳ��
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * ��ѯ������Ϣ
	 * 
	 * @param announceId
	 * @return
	 */
	public IndustryStandard queryById(String isId);

	/**
	 * ���ӷ�����Ϣ
	 * 
	 * @param annouce
	 * @return
	 */
	public void add(IndustryStandard industryStandard);

	/**
	 * �޸ķ�����Ϣ
	 * 
	 * @param announce
	 * @return
	 */
	public void modify(IndustryStandard industryStandard);

	/**
	 * ɾ��
	 * 
	 * @param announceId
	 * @return
	 */
	public void delete(String isId);
	
	public List<DictionaryClass> queryIsTypes();
	public List<DictionaryClass> queryIsPublishs();
}
