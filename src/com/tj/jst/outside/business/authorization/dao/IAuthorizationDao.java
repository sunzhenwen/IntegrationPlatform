package com.tj.jst.outside.business.authorization.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.authorization.model.Authorization;

/**
 * ��Ȩ
 * @author hhc
 *
 */
public interface IAuthorizationDao {
	
	/**
	 * ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * ��Ȩ
	 * @param construction
	 * @return
	 */
	public void add(Authorization authorization);
	
	/**
	 * ȡ����Ȩ
	 * @return
	 */
	public void delete(String id);

	/**
	 * ��ѯ��Ŀ
	 * @param condition
	 * @return
	 */
	public Page pagedPrjQuery(Condition condition);
	
	/**
	 * ��ҵ��Ŀ
	 * @param condition
	 * @return
	 */
	public Page pagedCorpQuery(Condition condition);
	
	public List<DictionaryClass>  queryEnterpriseTypes();
}
