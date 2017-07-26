package com.tj.jst.outside.business.design.service;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.PrjCode;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.design.dao.DesignDaoImpl;
import com.tj.jst.outside.business.design.dao.IDesignDao;
import com.tj.jst.outside.business.design.model.Design;
import com.tj.jst.outside.business.design.model.DesignQualification;

/**
 * 设计
 * @author hhc
 *
 */
public class DesignServiceImpl implements IDesignService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IDesignDao dao = new DesignDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * 设计申请
	 * @return
	 */
	public String add(Design design,List<DesignQualification> designQualifications)
	{
		IDesignDao dao = new DesignDaoImpl();
		Calendar c = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
		String fDate = simpleDateFormat.format(c.getTime());
		String serNum = PrjCode.querySerNuma(new Date(new java.util.Date().getTime()), 1);
		String designNum = design.getAppDept() + fDate
				+ design.getPrjNum().substring(12, 16) + "-HA-" + serNum;
		design.setDesignNum(designNum);
		return dao.add(design,designQualifications);
	}
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Design queryById(String designId)
	{
		IDesignDao dao = new DesignDaoImpl();
		return dao.queryById(designId);
	}
	
	/**
	 * 设计申请修改
	 * @return
	 */
	public void modify(Design design,List<DesignQualification> designQualifications)
	{
		IDesignDao dao = new DesignDaoImpl();
		dao.modify(design,designQualifications);
	}
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String designId)
	{
		IDesignDao dao = new DesignDaoImpl();
		dao.delete(designId);
	}

	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IDesignDao dao = new DesignDaoImpl();
		return dao.queryAppDept();
	}
	
}
