package com.tj.jst.outside.business.queryBusiness.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.singleProject.model.SingleProject;

/**
 * 单体工程
 * @author hhc
 *
 */
public interface IQuerySingleProjectDao {
	
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public SingleProject queryById(long spId);
	
	
	//结构体系(字典表：TBPRJSTRUCTURETYPEDIC)
	public List<DictionaryClass> queryPrjStructureTypeNums();

}
