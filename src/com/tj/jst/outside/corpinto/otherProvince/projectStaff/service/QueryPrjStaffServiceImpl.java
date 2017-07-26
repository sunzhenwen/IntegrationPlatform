package com.tj.jst.outside.corpinto.otherProvince.projectStaff.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.dao.IQueryPrjStaffDao;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.dao.QueryPrjStaffDaoImpl;

/**
 * 查询企业人员
 * @author Administrator
 *
 */
public class QueryPrjStaffServiceImpl implements IQueryPrjStaff {

	//分页查询
	@Override
	public Page pagedQuery(Condition condition) {
		IQueryPrjStaffDao constructorDao = new QueryPrjStaffDaoImpl();
		return constructorDao.pagedQuery(condition);
	}

	//项目人员类型
	public  List<DictionaryClass> queryStaffType()
	{
		IQueryPrjStaffDao constructorDao = new QueryPrjStaffDaoImpl();
		return constructorDao.queryStaffType();
	}
}
