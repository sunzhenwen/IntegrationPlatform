package com.tj.jst.outside.business.safety.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.safety.model.SafetyStaff;

/**
 * ʩ����ȫ��ҵ��Ա
 * @author hhc
 *
 */
public interface ISafetyStaffService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * ʩ����ȫ��ҵ��Ա���
	 * @return
	 */
	public void add(SafetyStaff quality);
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public SafetyStaff queryById(String qualityId);
	
	/**
	 * ʩ����ȫ��ҵ��Ա�޸�
	 * @return
	 */
	public void modify(SafetyStaff quality);
	
	/**
	 * ʩ����ȫ��ҵ��Աɾ��
	 * @return
	 */
	public void delete(String qualityId);
	
	//֤������
	public List<DictionaryClass> queryCardTypeNums();
}
