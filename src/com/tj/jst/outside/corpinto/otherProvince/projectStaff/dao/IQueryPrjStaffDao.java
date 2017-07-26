package com.tj.jst.outside.corpinto.otherProvince.projectStaff.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;

/**
 * 查询企业人员
 * @author Administrator
 *
 */
public interface IQueryPrjStaffDao {
	//分页查询
	public Page pagedQuery(Condition condition);
	
	//项目人员类型
	public  List<DictionaryClass> queryStaffType();
	
}
