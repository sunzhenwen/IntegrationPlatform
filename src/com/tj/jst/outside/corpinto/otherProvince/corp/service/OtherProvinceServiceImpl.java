package com.tj.jst.outside.corpinto.otherProvince.corp.service;

import com.tj.jst.login.model.Login;
import com.tj.jst.outside.corpinto.otherProvince.corp.dao.IOtherProvinceDao;
import com.tj.jst.outside.corpinto.otherProvince.corp.dao.OtherProvinceDaoImpl;

/**
 * ��ʡ��ҵ����
 * @author Administrator
 *
 */
public class OtherProvinceServiceImpl implements IOtherProvinceService {

	//����key Num��ѯ��ҵ��Ϣ
	public Login queryCorp(String results)
	{
		IOtherProvinceDao corpDao = new OtherProvinceDaoImpl();
		return corpDao.queryCorp(results);
	}
}
