package com.tj.jst.outside.business.complete.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.construction.model.Regional;

/**
 * 竣工验收
 * @author hhc
 *
 */
public interface ICompleteDao {
	
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 竣工验收申请
	 * @return
	 */
	public String add(Complete complete);
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Complete queryById(String completeId);
	
	/**
	 * 竣工验收申请修改
	 * @return
	 */
	public void modify(Complete complete);
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String completeId);
	
	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept();
	/**
	 * 根据树形排序id查询区域编码
	 * @param appDept
	 * @return
	 */
	public String queryAppDeptId(String appDept);
	
	//结构体系
	public List<DictionaryClass> queryPrjStructureTypeNums();
	
	/**
	 * 竣工验收,施工许可信息查询
	 * @author Administrator
	 *
	 */
	public Page pagedTbInfoQuery(Condition condition);
}
