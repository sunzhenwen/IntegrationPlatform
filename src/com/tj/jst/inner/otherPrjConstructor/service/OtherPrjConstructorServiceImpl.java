package com.tj.jst.inner.otherPrjConstructor.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.otherPrjConstructor.dao.IOtherPrjConstructorDao;
import com.tj.jst.inner.otherPrjConstructor.dao.OtherPrjConstructorDaoImpl;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.model.ProjectPerson;

/**
 * 外省项目备案内网查看
 * @author Administrator
 *
 */
public class OtherPrjConstructorServiceImpl implements IOtherPrjConstructorService {

	//分页查询
	@Override
	public Page pagedQuery(Condition condition) {
		IOtherPrjConstructorDao opd = new OtherPrjConstructorDaoImpl();
		return opd.pagedQuery(condition);
	}

	public Construction projectById(String otherPrjId)
	{
		IOtherPrjConstructorDao opd = new OtherPrjConstructorDaoImpl();
		return opd.projectById(otherPrjId);
	}
	
	/**
	 * 人员编辑
	 * @return
	 */
	public ProjectPerson personDetailed(String personId)
	{
		IOtherPrjConstructorDao opd = new OtherPrjConstructorDaoImpl();
		return opd.personDetailed(personId);
	}
}
