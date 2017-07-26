package com.tj.jst.inner.personrecord.constructor.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.personrecord.constructor.dao.ConstructorDaoImpl;
import com.tj.jst.inner.personrecord.constructor.dao.IConstructorDao;
import com.tj.jst.inner.personrecord.constructor.model.Constructor;

public class ConstructorServiceImpl implements IConstructorService {

	/**
	 * 分页查询
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IConstructorDao dao = new ConstructorDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * 学历
	 */
	@Override
	public List<DictionaryClass> eduLevelNums() {
		// TODO Auto-generated method stub
		IConstructorDao dao = new ConstructorDaoImpl();
		return dao.eduLevelNums();
	}

	/**
	 * 学位
	 */
	@Override
	public List<DictionaryClass> degreeNums() {
		// TODO Auto-generated method stub
		IConstructorDao dao = new ConstructorDaoImpl();
		return dao.degreeNums();
	}

	/**
	 * 查询详细
	 */
	@Override
	public Constructor queryDetailed(String personId) {
		// TODO Auto-generated method stub
		IConstructorDao dao = new ConstructorDaoImpl();
		return dao.queryDetailed(personId);
	}

}
