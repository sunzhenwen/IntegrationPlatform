package com.tj.jst.outside.business.authorization.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.authorization.dao.AuthorizationDaoImpl;
import com.tj.jst.outside.business.authorization.dao.IAuthorizationDao;
import com.tj.jst.outside.business.authorization.model.Authorization;

/**
 * 授权
 * @author hhc
 *
 */
public class AuthorizationServiceImpl implements IAuthorizationService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IAuthorizationDao dao = new AuthorizationDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * 授权
	 * @param construction
	 * @return
	 */
	public void add(Authorization authorization)
	{
		IAuthorizationDao dao = new AuthorizationDaoImpl();
		dao.add(authorization);
	}
	
	/**
	 * 取消授权
	 * @return
	 */
	public void delete(String id)
	{
		IAuthorizationDao dao = new AuthorizationDaoImpl();
		dao.delete(id);
	}
	
	/**
	 * 查询项目
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedPrjQuery(Condition condition) {
		IAuthorizationDao dao = new AuthorizationDaoImpl();
		return dao.pagedPrjQuery(condition);
	}
	
	/**
	 * 企业项目
	 * @param condition
	 * @return
	 */
	public Page pagedCorpQuery(Condition condition)
	{
		IAuthorizationDao dao = new AuthorizationDaoImpl();
		return dao.pagedCorpQuery(condition);
	}
	
	public List<DictionaryClass>  queryEnterpriseTypes()
	{
		IAuthorizationDao dao = new AuthorizationDaoImpl();
		return dao.queryEnterpriseTypes();
	}
}
