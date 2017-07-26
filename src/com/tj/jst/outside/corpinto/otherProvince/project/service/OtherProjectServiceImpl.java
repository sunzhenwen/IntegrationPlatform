package com.tj.jst.outside.corpinto.otherProvince.project.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.corpinto.otherProvince.project.dao.IOtherProjectDao;
import com.tj.jst.outside.corpinto.otherProvince.project.dao.OtherProjectDaoImpl;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;

/**
 * 外省项目备案
 * @author Administrator
 *
 */
public class OtherProjectServiceImpl implements IOtherProjectService {

	//分页查询
	@Override
	public Page pagedQuery(Condition condition) {
		IOtherProjectDao opd = new OtherProjectDaoImpl();
		return opd.pagedQuery(condition);
	}

	/**
	 * 添加
	 * @return
	 */
	public String add(Construction construction)
	{
		IOtherProjectDao opd = new OtherProjectDaoImpl();
		return opd.add(construction);
	}
	/**
	 * 跳转修改页面
	 * @return
	 */
	public Construction queryById(String prjId)
	{
		IOtherProjectDao constructionDao = new OtherProjectDaoImpl();
		return constructionDao.queryById(prjId);
	}
	/**
	 * 修改
	 * @return
	 */
	public void modify(Construction construction)
	{
		IOtherProjectDao constructorDao = new OtherProjectDaoImpl();
		constructorDao.modify(construction);
	}
	/**
	 * 删除
	 * @return
	 */
	public void delete(String otherPrjId)
	{
		IOtherProjectDao constructorDao = new OtherProjectDaoImpl();
		constructorDao.delete(otherPrjId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//查询详细
	@Override
	public Constructor queryDetailed(String idCard,String corpCode) {
		IOtherProjectDao constructorDao = new OtherProjectDaoImpl();
		return constructorDao.queryDetailed(idCard,corpCode);
	}

}
