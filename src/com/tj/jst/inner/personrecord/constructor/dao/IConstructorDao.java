package com.tj.jst.inner.personrecord.constructor.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.personrecord.constructor.model.Constructor;

public interface IConstructorDao {
	// ��ҳ��ѯ
	public Page pagedQuery(Condition condition);

	// ѧ��
	public List<DictionaryClass> eduLevelNums();

	// ѧλ
	public List<DictionaryClass> degreeNums();

	// ��ѯ��ϸ
	public Constructor queryDetailed(String personId);

}
