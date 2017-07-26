package com.tj.jst.outside.business.quality.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.PrjCode;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.quality.dao.IQualityDao;
import com.tj.jst.outside.business.quality.dao.QualityDaoImpl;
import com.tj.jst.outside.business.quality.model.Quality;

/**
 * 质量监督
 * @author hhc
 *
 */
public class QualityServiceImpl implements IQualityService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQualityDao dao = new QualityDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * 查询施工图审
	 * @param condition
	 * @return
	 */
	public Page pagedQualityPlans(Condition condition)
	{
		IQualityDao dao = new QualityDaoImpl();
		return dao.pagedQualityPlans(condition);
	}
	
	/**
	 * 质量监督申请
	 * @return
	 */
	public String add(Quality quality)
	{
		IQualityDao dao = new QualityDaoImpl();
		Calendar c = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
		String fDate = simpleDateFormat.format(c.getTime());
		String serNum = PrjCode.querySerNuma(new Date(new java.util.Date().getTime()), 5);
		String qualityNum = quality.getAppDept() + fDate
				+ quality.getPrjNum().substring(12, 16) + "-QU-" + serNum;
		quality.setQualityNum(qualityNum);
		return dao.add(quality);
	}
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Quality queryById(String qualityId)
	{
		IQualityDao dao = new QualityDaoImpl();
		return dao.queryById(qualityId);
	}
	
	/**
	 * 质量监督申请修改
	 * @return
	 */
	public void modify(Quality quality)
	{
		IQualityDao dao = new QualityDaoImpl();
		dao.modify(quality);
	}
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String qualityId)
	{
		IQualityDao dao = new QualityDaoImpl();
		dao.delete(qualityId);
	}

	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IQualityDao dao = new QualityDaoImpl();
		return dao.queryAppDept();
	}
	
	/**
	 * 查询招投标项目
	 * @param condition
	 * @return
	 */
	public Page pagedTbInfoQuery(Condition condition)
	{
		IQualityDao dao = new QualityDaoImpl();
		return dao.pagedTbInfoQuery(condition);
	}
}
