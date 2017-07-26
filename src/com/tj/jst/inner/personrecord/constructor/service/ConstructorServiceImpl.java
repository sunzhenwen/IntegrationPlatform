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
	 * ��ҳ��ѯ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IConstructorDao dao = new ConstructorDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * ѧ��
	 */
	@Override
	public List<DictionaryClass> eduLevelNums() {
		// TODO Auto-generated method stub
		IConstructorDao dao = new ConstructorDaoImpl();
		return dao.eduLevelNums();
	}

	/**
	 * ѧλ
	 */
	@Override
	public List<DictionaryClass> degreeNums() {
		// TODO Auto-generated method stub
		IConstructorDao dao = new ConstructorDaoImpl();
		return dao.degreeNums();
	}

	/**
	 * ��ѯ��ϸ
	 */
	@Override
	public Constructor queryDetailed(String personId) {
		// TODO Auto-generated method stub
		IConstructorDao dao = new ConstructorDaoImpl();
		return dao.queryDetailed(personId);
	}

}
