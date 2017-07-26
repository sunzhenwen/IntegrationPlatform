package com.tj.jst.inner.personrecord.title.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.personrecord.title.dao.ITitleDao;
import com.tj.jst.inner.personrecord.title.dao.TitleDaoImpl;
import com.tj.jst.inner.personrecord.title.model.Title;

/**
 * 职称人员备案
 * 
 * @author DarkFlameMaster
 *
 */
public class TitleServiceImpl implements ITitleService {

	/**
	 * 分页
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		ITitleDao dao = new TitleDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * 查找详细
	 */
	@Override
	public Title queryById(String personId) {
		// TODO Auto-generated method stub
		ITitleDao dao = new TitleDaoImpl();
		return dao.queryById(personId);
	}

	/**
	 * 性别字典类
	 */
	@Override
	public List<DictionaryClass> querySexNums() {
		// TODO Auto-generated method stub
		ITitleDao dao = new TitleDaoImpl();
		return dao.querySexNums();
	}

	/**
	 * 证件类型字典类
	 */
	@Override
	public List<DictionaryClass> queryIdCardTypeNums() {
		// TODO Auto-generated method stub
		ITitleDao dao = new TitleDaoImpl();
		return dao.queryIdCardTypeNums();
	}

}
