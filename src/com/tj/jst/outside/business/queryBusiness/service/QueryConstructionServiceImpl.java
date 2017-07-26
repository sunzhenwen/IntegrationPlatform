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
 * 项目报建
 * @author hhc
 *
 */
public class QueryConstructionServiceImpl implements IQueryConstructionService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQueryConstructionDao dao = new QueryConstructionDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Construction queryById(String prjId)
	{
		IQueryConstructionDao dao = new QueryConstructionDaoImpl();
		return dao.queryById(prjId);
	}
	
	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IQueryConstructionDao dao = new QueryConstructionDaoImpl();
		return dao.queryAppDept();
	}
	
	//项目分类(字典表：TBPRJTYPEDIC)
	public List<DictionaryClass> queryPrjTypeNums()
	{
		IQueryConstructionDao corpDao = new QueryConstructionDaoImpl();
		return corpDao.queryPrjTypeNums();
	}
	
	//建设性质(字典表：TBPRJPROPERTYDIC)
	public List<DictionaryClass> queryPrjPropertyNums()
	{
		IQueryConstructionDao corpDao = new QueryConstructionDaoImpl();
		return corpDao.queryPrjPropertyNums();
	}
	//工程用途(字典表：TBPRJFUNCTIONDIC)
	public List<DictionaryClass> queryPrjFuncitonNums()
	{
		IQueryConstructionDao corpDao = new QueryConstructionDaoImpl();
		return corpDao.queryPrjFuncitonNums();
	}
	//立项级别
	public List<DictionaryClass> queryPrjApprovalLevelNums()
	{
		IQueryConstructionDao corpDao = new QueryConstructionDaoImpl();
		return corpDao.queryPrjApprovalLevelNums();
	}
	//查询省
	@Override
	public List<DictionaryClass> queryProvince() {
		IQueryConstructionDao corpDao = new QueryConstructionDaoImpl();
		return corpDao.queryProvince();
	}

	//查询市
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		IQueryConstructionDao corpDao = new QueryConstructionDaoImpl();
		return corpDao.queryCity(provinceId);
	}

	//查询区
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		IQueryConstructionDao corpDao = new QueryConstructionDaoImpl();
		return corpDao.queryArea(cityId);
	}
	
}
