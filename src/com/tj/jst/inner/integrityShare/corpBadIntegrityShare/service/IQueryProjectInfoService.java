package com.tj.jst.inner.integrityShare.corpBadIntegrityShare.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * 查询项目进本信息服务接口
 * 
 * @author DarkFlameMaster
 *
 */
public interface IQueryProjectInfoService {

	/**
	 * 查询分页
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

}
