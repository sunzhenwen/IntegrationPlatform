package com.tj.jst.inner.business.innerSingleProject.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.business.innerSingleProject.model.InnerSingleProject;

/**
 * 单体工程
 * @author sunzw
 *
 */
public interface IInnerSingleProjectDao {
	
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 添加
	 * @param construction
	 * @return
	 */
	public void add(InnerSingleProject singleProject);
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public InnerSingleProject queryById(Long spId);
	
	/**
	 * 修改
	 * @param construction
	 * @return
	 */
	public void modify(InnerSingleProject singleProject);
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(Long id);
	
	//结构体系(字典表：TBPRJSTRUCTURETYPEDIC)
	public List<DictionaryClass> queryPrjStructureTypeNums();

}
