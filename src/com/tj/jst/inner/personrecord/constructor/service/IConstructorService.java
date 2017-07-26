package com.tj.jst.inner.personrecord.constructor.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.personrecord.constructor.model.Constructor;

public interface IConstructorService {

	// 分页查询
	public Page pagedQuery(Condition condition);

	// 学历
	public List<DictionaryClass> eduLevelNums();

	// 学位
	public List<DictionaryClass> degreeNums();

	// 查询详细
	public Constructor queryDetailed(String personId);
}
