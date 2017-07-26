package com.tj.jst.inner.integrityShare.corpBadIntegrityShare.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * 查询项目基本信息数据库接口
 * 
 * @author DarkFlameMaster
 *
 */
public interface IQueryProjectInfoDao {

	/**
	 * 查询分页
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

}
