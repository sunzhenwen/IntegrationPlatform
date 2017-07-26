package com.tj.jst.outside.corpinto.otherProvince.corp.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.corpinto.otherProvince.corp.service.IOtherProvinceService;
import com.tj.jst.outside.corpinto.otherProvince.corp.service.OtherProvinceServiceImpl;

/**
 * ��ʡ��ҵ����
 * @author Administrator
 *
 */
public class OtherProvinceAction extends BaseAction {
	
	//key Num
	private String results;
	//������ʾ��Ϣ
	private String message;
	
	public String otherProvinceLogin()
	{
		return "otherProvinceLogin";
	}
	
	/**
	 * ��ת��֤ҳ��
	 * 
	 * @return
	 */
	public String check() {
		return "otherProvinceCheck";
	}
	
	/**
	 * ��½���,��֤
	 * @return
	 */
	public String loginCheck()
	{
		Login login = null;
		if (results == null) {
			login = (Login) this.get("login");
		} else {
			IOtherProvinceService corpService = new OtherProvinceServiceImpl();
			//����key Num��ѯ��ҵ��Ϣ
			login = corpService.queryCorp(results);
		}
		
		if(login.equals(null))
		{
			message = "��ע����ҵ��������ҵ�����ڽ��б���!";
			return "loginCheck";
		}else if("230000".equals(login.getProvincenum()))
		{
			message = "��ʹ�õ�key����ʡ��ҵ!";
			return "loginCheck";
		}else
		{
			String corpCode = login.getCorpCode();
			String userName = login.getUserName();
			String userId = login.getUserId();
			//ʡ����
			String provinceName =login.getProvinceName();
			//ʡ����
			String provinceNum = login.getProvincenum();
			//��ҵ����������
			String cityName = login.getCityName();
			//��ҵ����������
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
