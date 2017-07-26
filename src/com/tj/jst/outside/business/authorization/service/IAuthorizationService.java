package com.tj.jst.outside.business.authorization.service;

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
public interface IAuthorizationService {
	
	/**
	 * ��ѯ
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
	 * ��ҵ��Ŀ
	 * @param condition
	 * @return
	 */
	public Page pagedCorpQuery(Condition condition);
	
	/**
	 * ��ѯ��Ŀ
	 * @param condition
	 * @return
	 */
	public Page pagedPrjQuery(Condition condition);
	
	public List<DictionaryClass>  queryEnterpriseTypes();
}
