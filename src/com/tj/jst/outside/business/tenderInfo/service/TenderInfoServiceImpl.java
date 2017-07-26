package com.tj.jst.outside.business.tenderInfo.service;
import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.tenderInfo.dao.ITenderInfoDao;
import com.tj.jst.outside.business.tenderInfo.dao.TenderInfoDaoImpl;
import com.tj.jst.outside.business.tenderInfo.model.TenderInfo;
import com.tj.jst.outside.business.tenderInfo.model.TenderInfoAdd;

/**
 * ’–Õ∂±Í
 * @author hhc
 *
 */
public class TenderInfoServiceImpl implements ITenderInfoService {
	
	/**
	 * ≤È—Ø
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ITenderInfoDao dao = new TenderInfoDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	public List<Construction> queryProjectInfo(String corpCode)
	{
		ITenderInfoDao dao = new TenderInfoDaoImpl();
		return dao.queryProjectInfo(corpCode);
	}
	
	public TenderInfo queryTenderById(String tenderNum)
	{
		ITenderInfoDao dao = new TenderInfoDaoImpl();
		return dao.queryTenderById(tenderNum);
	}
	
	public String add(TenderInfoAdd tenderInfoAdd)
	{
		ITenderInfoDao dao = new TenderInfoDaoImpl();
		return dao.add(tenderInfoAdd);
	}
	
	public List<DictionaryClass> queryTenderClassNum()
	{
		ITenderInfoDao dao = new TenderInfoDaoImpl();
		return dao.queryTenderClassNum();
	}
	public List<DictionaryClass> queryTenderTypeNum()
	{
		ITenderInfoDao dao = new TenderInfoDaoImpl();
		return dao.queryTenderTypeNum();
	}
	public List<DictionaryClass> queryIdCardTypeNum()
	{
		ITenderInfoDao dao = new TenderInfoDaoImpl();
		return dao.queryIdCardTypeNum();
	}
}
