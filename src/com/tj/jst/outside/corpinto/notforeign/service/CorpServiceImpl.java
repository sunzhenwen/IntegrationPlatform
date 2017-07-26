package com.tj.jst.outside.corpinto.notforeign.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.dao.CorpDaoImpl;
import com.tj.jst.outside.corpinto.notforeign.dao.ICorpDao;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;


public class CorpServiceImpl implements ICorpService {

	//企业组织机构代码查询
	@Override
	public Corp queryCorpCode(String corpCode) {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryCorpCode(corpCode);
	}

	//企业组织机构代码查询
	public Corp queryCorpTypeCode(String corpCode)
	{
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryCorpTypeCode(corpCode);
	}
	
	//查询省
	@Override
	public List<DictionaryClass> queryProvince() {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryProvince();
	}

	//查询市
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryCity(provinceId);
	}

	//保存企业
	@Override
	public String addCorp(Corp corp) {
		ICorpDao corpDao = new CorpDaoImpl();
		if(corp.getCheckForeign().equals("0"))
		{
			//外商企业
			return corpDao.addForeignCorp(corp);
		}else
		{
			//非外商企业
			return corpDao.addCorp(corp);
		}
	}

	//修改企业
	@Override
	public String modifyCorp(Corp corp) {
		// TODO Auto-generated method stub
		ICorpDao corpDao = new CorpDaoImpl();
		
		if(corp.getCheckForeign().equals("0"))
		{
			//外商企业
			return corpDao.modifyForeignCorp(corp);
		}else
		{
			//非外商企业
			return corpDao.modifyCorp(corp);
		}
		
		
	}

	//修改企业类型
	public String modifyCorpType(Corp corp)
	{
		// TODO Auto-generated method stub
		ICorpDao corpDao = new CorpDaoImpl();
		//非外商企业
		return corpDao.modifyCorpType(corp);
	}
	
	//查询区
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryArea(cityId);
	}

	//建设单位跳转修改页面，查询一个企业基本信息
	@Override
	public Corp queryCorpCode1(String corpCode) {
		// TODO Auto-generated method stub
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryCorpCode1(corpCode);
	}
	
}
