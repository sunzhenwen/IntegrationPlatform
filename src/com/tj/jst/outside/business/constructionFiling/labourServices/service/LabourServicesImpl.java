package com.tj.jst.outside.business.constructionFiling.labourServices.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.PrjCode;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.constructionFiling.labourServices.dao.ILabourServicesDao;
import com.tj.jst.outside.business.constructionFiling.labourServices.dao.LabourServicesDaoImpl;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;

/**
 * 施工劳务合同备案
 * @author hhc
 *
 */
public class LabourServicesImpl implements ILabourServices {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ILabourServicesDao dao = new LabourServicesDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * 合同备案申请
	 * @return
	 */
	public String add(ContractFiling contractFiling)
	{
		ILabourServicesDao dao = new LabourServicesDaoImpl();
		String type = contractFiling.getContractTypeNum();
			switch (type) {
			case "100":
				type = "-HB-";
				break;
			case "200":
				type = "-HA-";
				break;
			case "301":
				type = "-HZ-";
				break;
			case "302":
				type = "-HF-";
				break;
			case "303":
				type = "-HL-";
				break;
			case "400":
				type = "-HE-";
				break;
			case "500":
				type = "-HC-";
				break;
			case "600":
				type = "-HG-";
				break;
			case "700":
				type = "-HM-";
				break;

			}
			Calendar c = Calendar.getInstance();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
			String fDate = simpleDateFormat.format(c.getTime());
			String serNum = PrjCode.querySerNuma(new Date(new java.util.Date().getTime()), 3);
			String recordNum = contractFiling.getAppDept() + fDate
					+ contractFiling.getPrjNum().substring(12, 16) + type + serNum;
			contractFiling.setRecordNum(recordNum);
		return dao.add(contractFiling);
	}
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public ContractFiling queryById(String recordId)
	{
		ILabourServicesDao dao = new LabourServicesDaoImpl();
		return dao.queryById(recordId);
	}
	
	/**
	 * 合同备案申请修改
	 * @return
	 */
	public void modify(ContractFiling contractFiling)
	{
		ILabourServicesDao dao = new LabourServicesDaoImpl();
		dao.modify(contractFiling);
	}
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String recordId)
	{
		ILabourServicesDao dao = new LabourServicesDaoImpl();
		dao.delete(recordId);
	}

	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		ILabourServicesDao dao = new LabourServicesDaoImpl();
		return dao.queryAppDept();
	}
	//合同类别
	public List<DictionaryClass> queryContractTypeNums()
	{
		ILabourServicesDao dao = new LabourServicesDaoImpl();
		return dao.queryContractTypeNums();
	}
	/**
	 * 查询项目
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedPrjQuery(Condition condition) {
		ILabourServicesDao dao = new LabourServicesDaoImpl();
		return dao.pagedPrjQuery(condition);
	}
	/**
	 * 查询招投标项目
	 * @param condition
	 * @return
	 */
	public Page pagedTbInfoQuery(Condition condition)
	{
		ILabourServicesDao dao = new LabourServicesDaoImpl();
		return dao.pagedTbInfoQuery(condition);
	}
	
	/**
	 * 查询企业资质
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQuery(Condition condition)
	{
		ILabourServicesDao dao = new LabourServicesDaoImpl();
		return dao.pagedTitleLeveQuery(condition);
	}
	
	/**
	 * 查询施工总包合同
	 * @author Administrator
	 *
	 */
	public Page pagedMainContractor(Condition condition)
	{
		ILabourServicesDao dao = new LabourServicesDaoImpl();
		return dao.pagedMainContractor(condition);
	}
	
	/**
	 * 提交
	 * @return
	 */
	public void sub(String recordId)
	{
		ILabourServicesDao dao = new LabourServicesDaoImpl();
		dao.sub(recordId);
	}
}
