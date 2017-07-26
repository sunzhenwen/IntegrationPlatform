package com.tj.jst.inner.integrityShare.corpBadIntegrityShare.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.integrity.corpBadIntegrity.dao.IQueryProjectInfoDao;
import com.tj.jst.inner.integrity.corpBadIntegrity.dao.QueryProjectInfoDaoImpl;

/**
 * 查询项目信息类
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryProjectInfoServiceImpl implements IQueryProjectInfoService {

	/**
	 * 分页方法
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IQueryProjectInfoDao dao = new QueryProjectInfoDaoImpl();
		return dao.queryPage(condition);
	}

}
