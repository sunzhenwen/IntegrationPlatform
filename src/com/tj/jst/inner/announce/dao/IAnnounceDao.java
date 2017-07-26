package com.tj.jst.inner.announce.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.announce.model.Announce;

/**
 * ������Ϣ���ݿ�ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public interface IAnnounceDao {

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
	public Announce queryById(String announceId);

	/**
	 * ���ӷ�����Ϣ
	 * 
	 * @param annouce
	 * @return
	 */
	public String addAnnounce(Announce annouce);

	/**
	 * �޸ķ�����Ϣ
	 * 
	 * @param announce
	 * @return
	 */
	public String modifyAnnounce(Announce announce);

}
