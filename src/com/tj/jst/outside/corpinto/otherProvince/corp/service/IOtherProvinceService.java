package com.tj.jst.outside.corpinto.otherProvince.corp.service;

import com.tj.jst.login.model.Login;


/**
 * 外省企业备案
 * @author Administrator
 *
 */
public interface IOtherProvinceService {
	
	//根据key Num查询企业信息
	public Login queryCorp(String results);

}
