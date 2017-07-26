package com.tj.jst.outside.corpinto.otherProvince.project.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;

/**
 * 外省项目备案
 * @author Administrator
 *
 */
public interface IOtherProjectDao {
	//分页查询
	public Page pagedQuery(Condition condition);
	/**
	 * 添加
	 * @return
	 */
	public String add(Construction construction);
	/**
	 * 跳转修改页面
	 * @return
	 */
	public Construction queryById(String prjId);
	/**
	 * 修改
	 * @return
	 */
	public void modify(Construction construction);
	/**
	 * 删除
	 * @return
	 */
	public void delete(String otherPrjId);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//查询详细
	public Constructor queryDetailed(String idCard,String corpCode);

}
