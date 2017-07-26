package com.tj.jst.inner.announce.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.announce.dao.AnnounceDaoImpl;
import com.tj.jst.inner.announce.dao.IAnnounceDao;
import com.tj.jst.inner.announce.model.Announce;

/**
 * 发布信息服务类
 * 
 * @author DarkFlameMaster
 *
 */
public class AnnounceServiceImpl implements IAnnounceService {

	/**
	 * 分页
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IAnnounceDao dao = new AnnounceDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * 查询发布信息
	 */
	@Override
	public Announce queryById(String announceId) {
		// TODO Auto-generated method stub
		IAnnounceDao dao = new AnnounceDaoImpl();
		return dao.queryById(announceId);
	}

	/**
	 * 增加发布信息
	 */
	@Override
	public String addAnnounce(Announce annouce) {
		// TODO Auto-generated method stub
		IAnnounceDao dao = new AnnounceDaoImpl();
		return dao.addAnnounce(annouce);
	}

	/**
	 * 修改发布信息
	 */
	@Override
	public String modifyAnnounce(Announce announce) {
		// TODO Auto-generated method stub
		IAnnounceDao dao = new AnnounceDaoImpl();
		return dao.modifyAnnounce(announce);
	}

}
