package com.tj.jst.outside.business.constructionPlans.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.PrjCode;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.constructionPlans.dao.ConstructionPlansDaoImpl;
import com.tj.jst.outside.business.constructionPlans.dao.IConstructionPlansDao;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;

/**
 * 施工图审查
 * @author hhc
 *
 */
public class ConstructionPlansServiceImpl implements IConstructionPlansService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IConstructionPlansDao dao = new ConstructionPlansDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * 施工图审查申请
	 * @return
	 */
	public String add(ConstructionPlans constructionPlans)
	{
		IConstructionPlansDao dao = new ConstructionPlansDaoImpl();
		Calendar c = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
		String fDate = simpleDateFormat.format(c.getTime());
		String serNum = PrjCode.querySerNuma(new Date(new java.util.Date().getTime()), 4);
		String censorNum = constructionPlans.getAppDept() + fDate
				+ constructionPlans.getPrjNum().substring(12, 16) + "-TX-" + serNum;
		constructionPlans.setCensorNum(censorNum);
		return dao.add(constructionPlans);
	}
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public ConstructionPlans queryById(String censorId)
	{
		IConstructionPlansDao dao = new ConstructionPlansDaoImpl();
		return dao.queryById(censorId);
	}
	
	/**
	 * 合同备案申请修改
	 * @return
	 */
	public void modify(ConstructionPlans constructionPlans)
	{
		IConstructionPlansDao dao = new ConstructionPlansDaoImpl();
		dao.modify(constructionPlans);
	}
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String censorId)
	{
		IConstructionPlansDao dao = new ConstructionPlansDaoImpl();
		dao.delete(censorId);
	}

	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IConstructionPlansDao dao = new ConstructionPlansDaoImpl();
		return dao.queryAppDept();
	}
}
