package com.tj.jst.inner.integrityShare.corpBadIntegrityShare.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * ��ѯ��Ŀ������Ϣ���ݿ�ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public interface IQueryProjectInfoDao {

	/**
	 * ��ѯ��ҳ
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

}
