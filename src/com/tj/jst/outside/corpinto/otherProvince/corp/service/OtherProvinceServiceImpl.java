package com.tj.jst.outside.corpinto.otherProvince.corp.service;

import com.tj.jst.login.model.Login;
import com.tj.jst.outside.corpinto.otherProvince.corp.dao.IOtherProvinceDao;
import com.tj.jst.outside.corpinto.otherProvince.corp.dao.OtherProvinceDaoImpl;

/**
 * 外省企业备案
 * @author Administrator
 *
 */
public class OtherProvinceServiceImpl implements IOtherProvinceService {

	//根据key Num查询企业信息
	public Login queryCorp(String results)
	{
		IOtherProvinceDao corpDao = new OtherProvinceDaoImpl();
		return corpDao.queryCorp(results);
	}
}
