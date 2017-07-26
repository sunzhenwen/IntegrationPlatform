package com.tj.jst.outside.corpinto.otherProvince.corp.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.corpinto.otherProvince.corp.service.IOtherProvinceService;
import com.tj.jst.outside.corpinto.otherProvince.corp.service.OtherProvinceServiceImpl;

/**
 * 外省企业备案
 * @author Administrator
 *
 */
public class OtherProvinceAction extends BaseAction {
	
	//key Num
	private String results;
	//返回提示信息
	private String message;
	
	public String otherProvinceLogin()
	{
		return "otherProvinceLogin";
	}
	
	/**
	 * 跳转认证页面
	 * 
	 * @return
	 */
	public String check() {
		return "otherProvinceCheck";
	}
	
	/**
	 * 登陆检测,验证
	 * @return
	 */
	public String loginCheck()
	{
		Login login = null;
		if (results == null) {
			login = (Login) this.get("login");
		} else {
			IOtherProvinceService corpService = new OtherProvinceServiceImpl();
			//根据key Num查询企业信息
			login = corpService.queryCorp(results);
		}
		
		if(login.equals(null))
		{
			message = "请注册企业并申请企业锁后在进行备案!";
			return "loginCheck";
		}else if("230000".equals(login.getProvincenum()))
		{
			message = "所使用的key非外省企业!";
			return "loginCheck";
		}else
		{
			String corpCode = login.getCorpCode();
			String userName = login.getUserName();
			String userId = login.getUserId();
			//省名称
			String provinceName =login.getProvinceName();
			//省编码
			String provinceNum = login.getProvincenum();
			//企业所在市名称
			String cityName = login.getCityName();
			//企业所在区名称
			String countyName = login.getCountyName();
			this.set("login", login);
			this.set("cropCode", corpCode);
			this.set("userName", userName);
			this.set("userId", userId);
			this.set("provinceNum", provinceNum);
			this.set("provinceName", provinceName);
			this.set("cityName", cityName);
			this.set("countyName", countyName);
			return "businessPage3";
		}
		
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
