package com.tj.jst.outside.staffmanage.constructor.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.staffmanage.constructor.dao.ConstructorDaoImpl;
import com.tj.jst.outside.staffmanage.constructor.dao.IConstructorDao;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;

public class ConstructorServiceImpl implements IConstructorService {

	//分页查询
	@Override
	public Page pagedQuery(Condition condition) {
		IConstructorDao constructorDao = new ConstructorDaoImpl();
		return constructorDao.pagedQuery(condition);
	}

	//学历
	@Override
	public List<DictionaryClass> eduLevelNums() {
		IConstructorDao constructorDao = new ConstructorDaoImpl();
		return constructorDao.eduLevelNums();
	}

	//学位
	@Override
	public List<DictionaryClass> degreeNums() {
		IConstructorDao constructorDao = new ConstructorDaoImpl();
		return constructorDao.degreeNums();
	}

	//查询详细
	@Override
	public Constructor queryDetailed(String idCard,String corpCode) {
		IConstructorDao constructorDao = new ConstructorDaoImpl();
		return constructorDao.queryDetailed(idCard,corpCode);
	}

}
