package com.tj.jst.outside.business.queryBusiness.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.complete.dao.CompleteDaoImpl;
import com.tj.jst.outside.business.complete.dao.ICompleteDao;
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.queryBusiness.dao.IQueryCompleteDao;
import com.tj.jst.outside.business.queryBusiness.dao.QueryCompleteDaoImpl;

/**
 * ��������
 * @author hhc
 *
 */
public class QueryCompleteServiceImpl implements IQueryCompleteService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQueryCompleteDao dao = new QueryCompleteDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Complete queryById(String completeId)
	{
		IQueryCompleteDao dao = new QueryCompleteDaoImpl();
		return dao.queryById(completeId);
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IQueryCompleteDao dao = new QueryCompleteDaoImpl();
		return dao.queryAppDept();
	}
	
	//�ṹ��ϵ
	public List<DictionaryClass> queryPrjStructureTypeNums()
	{
		IQueryCompleteDao dao = new QueryCompleteDaoImpl();
		return dao.queryPrjStructureTypeNums();
	}
}
