package com.tj.jst.outside.business.permit.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import pojo.CORP_AQSCXKZ;
import ws.client.tenderinfo.InfoClient;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.PrjCode;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.permit.dao.IPermitDao;
import com.tj.jst.outside.business.permit.dao.PermitDaoImpl;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.quality.model.Quality;

/**
 * 施工许可
 * @author hhc
 *
 */
public class PermitServiceImpl implements IPermitService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IPermitDao dao = new PermitDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * 施工许可申请
	 * @return
	 */
	public String add(Permit permit)
	{
		IPermitDao dao = new PermitDaoImpl();
		Calendar c = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
		String fDate = simpleDateFormat.format(c.getTime());
		String serNum = PrjCode.querySerNuma(new Date(new java.util.Date().getTime()), 7);
		String builderLicenceNum = permit.getAppDept() + fDate
				+ permit.getPrjNum().substring(12, 16) + "-SX-" + serNum;
		permit.setBuilderLicenceNum(builderLicenceNum);
		return dao.add(permit);
	}
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Permit queryById(String permitId)
	{
		IPermitDao dao = new PermitDaoImpl();
		return dao.queryById(permitId);
	}
	
	/**
	 * 施工许可申请修改
	 * @return
	 */
	public void modify(Permit permit)
	{
		IPermitDao dao = new PermitDaoImpl();
		dao.modify(permit);
	}
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String permitId)
	{
		IPermitDao dao = new PermitDaoImpl();
		dao.delete(permitId);
	}

	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IPermitDao dao = new PermitDaoImpl();
		return dao.queryAppDept();
	}
	
	//证件类型
	public List<DictionaryClass> queryCardTypeNums()
	{
		IPermitDao dao = new PermitDaoImpl();
		return dao.queryCardTypeNums();
	}
	
	/**
	 * 施工许可,质量信息查询
	 * @author Administrator
	 *
	 */
	public Page pagedQueryQuality(Condition condition)
	{
		IPermitDao dao = new PermitDaoImpl();
		Page page = dao.pagedQueryQuality(condition);
		InfoClient ic = new InfoClient();
		for(int i=0;i<page.getData().size();i++)
		{
			//施工单位名称
			String corpName = ((Quality)page.getData().get(i)).getConstructionUnit();
			//施工单位组织机构代码
			String corpCode = ((Quality)page.getData().get(i)).getConstructionCode();
			//通过接口获取安全生产许可证
			List<CORP_AQSCXKZ> cas = ic.getCORP_AQSCXKZList(corpCode, corpName, "1RGQywA@AtMTEjwADAADYEwAA2BMAAA==");
			
			//循环返回的安全生产许可证信息
			for(int j=0;j<cas.size();j++)
			{
				//如果安全生产许可证有效
				if(cas.get(j).getFState().equals("有效"))
				{
					((Quality)page.getData().get(i)).setSafetyCerId(cas.get(0).getFCertNumber());
				}
			}
			
		}
		return page;
	}

	/**
	 * 施工许可,安全信息查询
	 * @author Administrator
	 *
	 */
	public Page pagedQueryPermSafety(Condition condition)
	{
		IPermitDao dao = new PermitDaoImpl();
		return dao.pagedQueryPermSafety(condition);
	}
	
	/**
	 * 施工许可,施工图审查合格书编号
	 * @param condition
	 * @return
	 */
	public Page pagedQueryPlanNum(Condition condition)
	{
		IPermitDao dao = new PermitDaoImpl();
		return dao.pagedQueryPlanNum(condition);
	}
}
