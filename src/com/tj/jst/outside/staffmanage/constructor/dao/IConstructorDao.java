package com.tj.jst.outside.staffmanage.constructor.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;

public interface IConstructorDao {
	//分页查询
	public Page pagedQuery(Condition condition);
	//学历
	public List<DictionaryClass> eduLevelNums();
	//学位
	public List<DictionaryClass> degreeNums();
	//查询详细
	public Constructor queryDetailed(String idCard,String corpCode);
}
