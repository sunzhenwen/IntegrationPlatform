package com.tj.jst.outside.business.queryBusiness.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.dao.ConstructionDaoImpl;
import com.tj.jst.outside.business.construction.dao.IConstructionDao;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.queryBusiness.dao.IQueryConstructionDao;
import com.tj.jst.outside.business.queryBusiness.dao.QueryConstructionDaoImpl;

/**
 * ��Ŀ����
 * @author hhc
 *
 */
public class QueryConstructionServiceImpl implements IQueryConstructionService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQueryConstructionDao dao = new QueryConstructionDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Construction queryById(String prjId)
	{
		IQueryConstructionDao dao = new QueryConstructionDaoImpl();
		return dao.queryById(prjId);
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IQueryConstructionDao dao = new QueryConstructionDaoImpl();
		return dao.queryAppDept();
	}
	
	//��Ŀ����(�ֵ��TBPRJTYPEDIC)
	public List<DictionaryClass> queryPrjTypeNums()
	{
		IQueryConstructionDao corpDao = new QueryConstructionDaoImpl();
		return corpDao.queryPrjTypeNums();
	}
	
	//��������(�ֵ��TBPRJPROPERTYDIC)
	public List<DictionaryClass> queryPrjPropertyNums()
	{
		IQueryConstructionDao corpDao = new QueryConstructionDaoImpl();
		return corpDao.queryPrjPropertyNums();
	}
	//������;(�ֵ��TBPRJFUNCTIONDIC)
	public List<DictionaryClass> queryPrjFuncitonNums()
	{
		IQueryConstructionDao corpDao = new QueryConstructionDaoImpl();
		return corpDao.queryPrjFuncitonNums();
	}
	//�����
	public List<DictionaryClass> queryPrjApprovalLevelNums()
	{
		IQueryConstructionDao corpDao = new QueryConstructionDaoImpl();
		return corpDao.queryPrjApprovalLevelNums();
	}
	//��ѯʡ
	@Override
	public List<DictionaryClass> queryProvince() {
		IQueryConstructionDao corpDao = new QueryConstructionDaoImpl();
		return corpDao.queryProvince();
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		IQueryConstructionDao corpDao = new QueryConstructionDaoImpl();
		return corpDao.queryCity(provinceId);
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		IQueryConstructionDao corpDao = new QueryConstructionDaoImpl();
		return corpDao.queryArea(cityId);
	}
	
}
