package com.tj.jst.outside.business.constructionFiling.subPackage.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.PrjCode;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.constructionFiling.mainContractor.dao.ConstructionContractDaoImpl;
import com.tj.jst.outside.business.constructionFiling.mainContractor.dao.IConstructionContractDao;
import com.tj.jst.outside.business.constructionFiling.subPackage.dao.ISubPackageDao;
import com.tj.jst.outside.business.constructionFiling.subPackage.dao.SubPackageDaoImpl;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;

/**
 * �ְ���ͬ����
 * @author hhc
 *
 */
public class SubPackageServiceImpl implements ISubPackageService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ISubPackageDao dao = new SubPackageDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * ��ͬ��������
	 * @return
	 */
	public String add(ContractFiling contractFiling)
	{
		ISubPackageDao dao = new SubPackageDaoImpl();
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
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public ContractFiling queryById(String recordId)
	{
		ISubPackageDao dao = new SubPackageDaoImpl();
		return dao.queryById(recordId);
	}
	
	/**
	 * ��ͬ���������޸�
	 * @return
	 */
	public void modify(ContractFiling contractFiling)
	{
		ISubPackageDao dao = new SubPackageDaoImpl();
		dao.modify(contractFiling);
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String recordId)
	{
		ISubPackageDao dao = new SubPackageDaoImpl();
		dao.delete(recordId);
	}

	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		ISubPackageDao dao = new SubPackageDaoImpl();
		return dao.queryAppDept();
	}
	//��ͬ���
	public List<DictionaryClass> queryContractTypeNums()
	{
		ISubPackageDao dao = new SubPackageDaoImpl();
		return dao.queryContractTypeNums();
	}
	/**
	 * ��ѯ��Ŀ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedPrjQuery(Condition condition) {
		ISubPackageDao dao = new SubPackageDaoImpl();
		return dao.pagedPrjQuery(condition);
	}
	/**
	 * ��ѯ��Ͷ����Ŀ
	 * @param condition
	 * @return
	 */
	public Page pagedTbInfoQuery(Condition condition)
	{
		ISubPackageDao dao = new SubPackageDaoImpl();
		return dao.pagedTbInfoQuery(condition);
	}
	
	/**
	 * ��ѯ��ҵ����
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQuery(Condition condition)
	{
		ISubPackageDao dao = new SubPackageDaoImpl();
		return dao.pagedTitleLeveQuery(condition);
	}
	
	/**
	 * ��ѯʩ���ܰ���ͬ
	 * @author Administrator
	 *
	 */
	public Page pagedMainContractor(Condition condition)
	{
		ISubPackageDao dao = new SubPackageDaoImpl();
		return dao.pagedMainContractor(condition);
	}
	
	/**
	 * �ύ
	 * @return
	 */
	public void sub(String recordId)
	{
		ISubPackageDao dao = new SubPackageDaoImpl();
		dao.sub(recordId);
	}
}
