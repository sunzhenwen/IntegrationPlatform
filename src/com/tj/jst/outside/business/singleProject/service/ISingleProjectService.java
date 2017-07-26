package com.tj.jst.outside.business.singleProject.service;

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
public interface ISingleProjectService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 添加
	 * @param construction
	 * @return
	 */
	public void add(SingleProject singleProject);
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public SingleProject queryById(long spId);
	
	/**
	 * 修改
	 * @param construction
	 * @return
	 */
	public void modify(SingleProject singleProject);
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(long id);

	//结构体系(字典表：TBPRJSTRUCTURETYPEDIC)
	public List<DictionaryClass> queryPrjStructureTypeNums();

}
