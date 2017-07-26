package com.tj.jst.outside.business.design.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.design.model.Design;
import com.tj.jst.outside.business.design.model.DesignQualification;

/**
 * 设计
 * @author hhc
 *
 */
public interface IDesignService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 设计申请
	 * @return
	 */
	public String add(Design design,List<DesignQualification> designQualifications);
	
	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept();
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Design queryById(String designId);
	
	/**
	 * 设计申请修改
	 * @return
	 */
	public void modify(Design design,List<DesignQualification> designQualifications);
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String designId);

	
}
