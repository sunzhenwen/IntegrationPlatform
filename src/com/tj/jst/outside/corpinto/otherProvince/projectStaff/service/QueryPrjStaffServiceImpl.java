package com.tj.jst.outside.corpinto.otherProvince.projectStaff.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.dao.IQueryPrjStaffDao;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.dao.QueryPrjStaffDaoImpl;

/**
 * ��ѯ��ҵ��Ա
 * @author Administrator
 *
 */
public class QueryPrjStaffServiceImpl implements IQueryPrjStaff {

	//��ҳ��ѯ
	@Override
	public Page pagedQuery(Condition condition) {
		IQueryPrjStaffDao constructorDao = new QueryPrjStaffDaoImpl();
		return constructorDao.pagedQuery(condition);
	}

	//��Ŀ��Ա����
	public  List<DictionaryClass> queryStaffType()
	{
		IQueryPrjStaffDao constructorDao = new QueryPrjStaffDaoImpl();
		return constructorDao.queryStaffType();
	}
}
