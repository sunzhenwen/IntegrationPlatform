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
 * ʩ��ͼ���
 * @author hhc
 *
 */
public class ConstructionPlansServiceImpl implements IConstructionPlansService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IConstructionPlansDao dao = new ConstructionPlansDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * ʩ��ͼ�������
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
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public ConstructionPlans queryById(String censorId)
	{
		IConstructionPlansDao dao = new ConstructionPlansDaoImpl();
		return dao.queryById(censorId);
	}
	
	/**
	 * ��ͬ���������޸�
	 * @return
	 */
	public void modify(ConstructionPlans constructionPlans)
	{
		IConstructionPlansDao dao = new ConstructionPlansDaoImpl();
		dao.modify(constructionPlans);
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String censorId)
	{
		IConstructionPlansDao dao = new ConstructionPlansDaoImpl();
		dao.delete(censorId);
	}

	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IConstructionPlansDao dao = new ConstructionPlansDaoImpl();
		return dao.queryAppDept();
	}
}
