package com.tj.jst.inner.personrecord.title.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.personrecord.title.dao.ITitleDao;
import com.tj.jst.inner.personrecord.title.dao.TitleDaoImpl;
import com.tj.jst.inner.personrecord.title.model.Title;

/**
 * ְ����Ա����
 * 
 * @author DarkFlameMaster
 *
 */
public class TitleServiceImpl implements ITitleService {

	/**
	 * ��ҳ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		ITitleDao dao = new TitleDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * ������ϸ
	 */
	@Override
	public Title queryById(String personId) {
		// TODO Auto-generated method stub
		ITitleDao dao = new TitleDaoImpl();
		return dao.queryById(personId);
	}

	/**
	 * �Ա��ֵ���
	 */
	@Override
	public List<DictionaryClass> querySexNums() {
		// TODO Auto-generated method stub
		ITitleDao dao = new TitleDaoImpl();
		return dao.querySexNums();
	}

	/**
	 * ֤�������ֵ���
	 */
	@Override
	public List<DictionaryClass> queryIdCardTypeNums() {
		// TODO Auto-generated method stub
		ITitleDao dao = new TitleDaoImpl();
		return dao.queryIdCardTypeNums();
	}

}
