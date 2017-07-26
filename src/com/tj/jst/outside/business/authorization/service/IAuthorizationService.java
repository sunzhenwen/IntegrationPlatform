package com.tj.jst.outside.business.authorization.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.authorization.model.Authorization;

/**
 * 授权
 * @author hhc
 *
 */
public interface IAuthorizationService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 授权
	 * @param construction
	 * @return
	 */
	public void add(Authorization authorization);
	
	/**
	 * 取消授权
	 * @return
	 */
	public void delete(String id);
	/**
	 * 企业项目
	 * @param condition
	 * @return
	 */
	public Page pagedCorpQuery(Condition condition);
	
	/**
	 * 查询项目
	 * @param condition
	 * @return
	 */
	public Page pagedPrjQuery(Condition condition);
	
	public List<DictionaryClass>  queryEnterpriseTypes();
}
