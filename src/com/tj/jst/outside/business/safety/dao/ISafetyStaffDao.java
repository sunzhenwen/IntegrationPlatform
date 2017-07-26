package com.tj.jst.outside.business.safety.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.safety.model.SafetyStaff;

/**
 * ʩ����ȫ��ҵ��Ա
 * @author hhc
 *
 */
public interface ISafetyStaffDao {
	
	/**
	 * ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	public void add(SafetyStaff quality);
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public SafetyStaff queryById(String qualityId);
	
	/**
	 * ��ȫ�ල�����޸�
	 * @return
	 */
	public void modify(SafetyStaff quality);
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String qualityId);
	
}
