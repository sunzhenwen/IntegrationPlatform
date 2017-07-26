package com.tj.jst.outside.corpinto.otherProvince.queryOtherCorpCert.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.contractFiling.model.Certdetail;
import com.tj.jst.outside.corpinto.otherProvince.queryOtherCorpCert.dao.IQueryOtherCorpCertDao;
import com.tj.jst.outside.corpinto.otherProvince.queryOtherCorpCert.dao.QueryOtherCorpCertDaoImpl;

/**
 * 查询外省备案企业拥有资质
 * 
 * @author Administrator
 *
 */
public class QueryOtherCorpCertServiceImpl implements IQueryOtherCorpCertService {

	/**
	 * 分页查询
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IQueryOtherCorpCertDao dao = new QueryOtherCorpCertDaoImpl();
		return dao.queryPage(condition);
	}

	//资质资格类型(TBAPTITUDEKINDDIC)
	public List<DictionaryClass> qualificationsTypes()
	{
		IQueryOtherCorpCertDao dao = new QueryOtherCorpCertDaoImpl();
		return dao.qualificationsTypes();
	}
	
	//资质资格序列
	public List<DictionaryClass> queryTradeTypeNum(String qualificationsType)
	{
		String requirement = "";
		if("1".equals(qualificationsType))
		{
			//工程勘察
			requirement = "101";
		}else if("2".equals(qualificationsType))
		{
			//工程设计
			requirement = "102";
		}else if("3".equals(qualificationsType))
		{
			//建筑业
			requirement = "104";
		}else if("4".equals(qualificationsType))
		{
			//工程监理
			requirement = "105";
		}else if("5".equals(qualificationsType))
		{
			//工程招标代理
			requirement = "103";
		}else if("6".equals(qualificationsType))
		{
			//设计施工一体化
			requirement = "113";
		}else
		{
			requirement = "sdfgsdfgsdf";
		}
		IQueryOtherCorpCertDao dao = new QueryOtherCorpCertDaoImpl();
		return dao.queryTradeTypeNum(requirement);
	}
	
	//资质资格等级(TBCERTTITLELEVELDIC)
	public List<DictionaryClass> queryRating(String qualificationsType)
	{
		String requirement = "";
		if("1".equals(qualificationsType))
		{
			//工程勘察
			requirement = "工程勘察";
		}else if("2".equals(qualificationsType))
		{
			//工程设计
			requirement = "工程设计";
		}else if("3".equals(qualificationsType))
		{
			//建筑业
			requirement = "建筑业";
		}else if("4".equals(qualificationsType))
		{
			//工程监理
			requirement = "工程监理";
		}else if("5".equals(qualificationsType))
		{
			//工程招标代理
			requirement = "工程招标代理";
		}else if("6".equals(qualificationsType))
		{
			//设计施工一体化
			requirement = "设计施工一体化";
		}else if("7".equals(qualificationsType))
		{
			requirement = "工程造价咨询";
		}else if("8".equals(qualificationsType))
		{
			requirement = "安全生产许可";
		}else if("9".equals(qualificationsType))
		{
			requirement = "施工图审查";
		}else if("10".equals(qualificationsType))
		{
			requirement = "质量检测";
		}else if("11".equals(qualificationsType))
		{
			requirement = "城乡规划";
		}else if("12".equals(qualificationsType))
		{
			requirement = "园林绿化";
		}else
		{
			requirement = "aaasgasdfgsdfgd";
		}
		
		
		IQueryOtherCorpCertDao dao = new QueryOtherCorpCertDaoImpl();
		return dao.queryRating(requirement);
	}
	
	/**
	 * 专业类别(TBTRADETYPEBOUNDDIC)
	 * @return
	 */
	public List<DictionaryClass> specialtyType(String specialtyType)
	{
		IQueryOtherCorpCertDao dao = new QueryOtherCorpCertDaoImpl();
		return dao.specialtyType(specialtyType);
	}
	
	//添加
	public void add(Certdetail certdetail)
	{
		IQueryOtherCorpCertDao dao = new QueryOtherCorpCertDaoImpl();
		dao.add(certdetail);
	}
	
	//删除
	public void deleteCer(String id)
	{
		IQueryOtherCorpCertDao dao = new QueryOtherCorpCertDaoImpl();
		dao.deleteCer(id);
	}
}
