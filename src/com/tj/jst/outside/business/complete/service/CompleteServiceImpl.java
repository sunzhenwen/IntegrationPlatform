package com.tj.jst.outside.business.complete.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.PrjCode;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.complete.dao.CompleteDaoImpl;
import com.tj.jst.outside.business.complete.dao.ICompleteDao;
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.construction.model.Regional;

/**
 * 竣工验收
 * @author hhc
 *
 */
public class CompleteServiceImpl implements ICompleteService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ICompleteDao dao = new CompleteDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * 竣工验收申请
	 * @return
	 */
	public String add(Complete complete)
	{
		ICompleteDao dao = new CompleteDaoImpl();
		Calendar c = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
		String fDate = simpleDateFormat.format(c.getTime());
		String serNum = PrjCode.querySerNuma(new Date(new java.util.Date().getTime()), 8);
		String prjFinishNum = complete.getAppDept() + fDate
				+ complete.getPrjNum().substring(12, 16) + "-JX-" + serNum;
		complete.setPrjFinishNum(prjFinishNum);
		return dao.add(complete);
	}
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Complete queryById(String completeId)
	{
		ICompleteDao dao = new CompleteDaoImpl();
		return dao.queryById(completeId);
	}
	
	/**
	 * 竣工验收申请修改
	 * @return
	 */
	public void modify(Complete complete)
	{
		ICompleteDao dao = new CompleteDaoImpl();
		dao.modify(complete);
	}
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String completeId)
	{
		ICompleteDao dao = new CompleteDaoImpl();
		dao.delete(completeId);
	}

	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		ICompleteDao dao = new CompleteDaoImpl();
		return dao.queryAppDept();
	}
	
	//结构体系
	public List<DictionaryClass> queryPrjStructureTypeNums()
	{
		ICompleteDao dao = new CompleteDaoImpl();
		return dao.queryPrjStructureTypeNums();
	}
	
	/**
	 * 竣工验收,施工许可信息查询
	 * @author Administrator
	 *
	 */
	public Page pagedTbInfoQuery(Condition condition)
	{
		ICompleteDao dao = new CompleteDaoImpl();
		return dao.pagedTbInfoQuery(condition);
	}
}
