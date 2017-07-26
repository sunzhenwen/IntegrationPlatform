package com.tj.jst.inner.announce.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.announce.model.Announce;

/**
 * 发布信息数据库接口
 * 
 * @author DarkFlameMaster
 *
 */
public interface IAnnounceDao {

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
	public Announce queryById(String announceId);

	/**
	 * 增加发布信息
	 * 
	 * @param annouce
	 * @return
	 */
	public String addAnnounce(Announce annouce);

	/**
	 * 修改发布信息
	 * 
	 * @param announce
	 * @return
	 */
	public String modifyAnnounce(Announce announce);

}
