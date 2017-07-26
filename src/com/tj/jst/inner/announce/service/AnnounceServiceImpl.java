package com.tj.jst.inner.announce.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.announce.dao.AnnounceDaoImpl;
import com.tj.jst.inner.announce.dao.IAnnounceDao;
import com.tj.jst.inner.announce.model.Announce;

/**
 * ������Ϣ������
 * 
 * @author DarkFlameMaster
 *
 */
public class AnnounceServiceImpl implements IAnnounceService {

	/**
	 * ��ҳ
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IAnnounceDao dao = new AnnounceDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * ��ѯ������Ϣ
	 */
	@Override
	public Announce queryById(String announceId) {
		// TODO Auto-generated method stub
		IAnnounceDao dao = new AnnounceDaoImpl();
		return dao.queryById(announceId);
	}

	/**
	 * ���ӷ�����Ϣ
	 */
	@Override
	public String addAnnounce(Announce annouce) {
		// TODO Auto-generated method stub
		IAnnounceDao dao = new AnnounceDaoImpl();
		return dao.addAnnounce(annouce);
	}

	/**
	 * �޸ķ�����Ϣ
	 */
	@Override
	public String modifyAnnounce(Announce announce) {
		// TODO Auto-generated method stub
		IAnnounceDao dao = new AnnounceDaoImpl();
		return dao.modifyAnnounce(announce);
	}

}
