package com.tj.jst.outside.business.queryBusiness.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.permit.dao.IPermitDao;
import com.tj.jst.outside.business.permit.dao.PermitDaoImpl;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.queryBusiness.dao.IQueryPermitDao;
import com.tj.jst.outside.business.queryBusiness.dao.QueryPermitDaoImpl;

/**
 * ʩ�����
 * @author hhc
 *
 */
public class QueryPermitServiceImpl implements IQueryPermitService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQueryPermitDao dao = new QueryPermitDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Permit queryById(String permitId)
	{
		IQueryPermitDao dao = new QueryPermitDaoImpl();
		return dao.queryById(permitId);
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IQueryPermitDao dao = new QueryPermitDaoImpl();
		return dao.queryAppDept();
	}
	
	//֤������
	public List<DictionaryClass> queryCardTypeNums()
	{
		IQueryPermitDao dao = new QueryPermitDaoImpl();
		return dao.queryCardTypeNums();
	}
}
