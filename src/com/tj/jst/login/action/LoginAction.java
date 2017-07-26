package com.tj.jst.login.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.login.model.Login;
import com.tj.jst.login.service.ILoginService;
import com.tj.jst.login.service.LoginServiceImpl;
import com.webServiceCDome.RoleServiceImplService;

/**
 * ��½
 * 
 * @author Administrator
 *
 */
public class LoginAction extends BaseAction {

	private String results;
	private String typeNum;// ��Դ 1:���赥λ 2:��ҵ��ҵ 3:���ܲ���
	private String message;// ��ʾ��Ϣ
	private String corpCode ;//��֯�ṹ����
	private String corpName;//��ҵ����

	// ϵͳ������ӭҳ���Զ�����˷���
	public String login() throws Exception {
		return "login";
	}

	public String deptLogin() throws Exception {
		return "deptLogin";
	}

	/**
	 * ��ת��֤ҳ��
	 * 
	 * @return
	 */
	public String checkOne() {
		HttpSession session = request.getSession();
		session.setAttribute("typeNum", typeNum);
		//typeNum = typeNum;
		return "checkOne";
	}

	/**
	 * �жϲ�ѯҳ��
	 * 
	 * @return
	 */
	public String businessPage() {
		
		String page = "";
		//���������ҵ���Ƶ�½
		if(corpName == null)
		{
			//��ҵ��½
			page = this.loginCorp();
			if("".equals(page))
			{
				//���ܲ��ŵ�½
				page = this.chargeDeptLogin();
			}
		}else
		{
			page = this.loginCorp(corpName);
		}
		
		return page;
	}

	/**
	 * ��ҵ��¼
	 */
	public String loginCorp()
	{
		HttpSession session = request.getSession();
		Login login = null;
		String page = "";
		ILoginService loginService = new LoginServiceImpl();
		typeNum = (String) session.getAttribute("typeNum");
		if (results == null) {
			login = (Login) this.get("login");
		} else {
			login = loginService.query(results,"");
		}
		//��ȡ��ҵ����
		String type = login.getEnterPriseType();
		
		if(type == null){
			type = "9";
		}
		
		if (typeNum == null) {
			typeNum = "9";
		}
		
		// ���Ϊ��ҵ�û�
		if (login.getUserId() != null) {
			corpCode = login.getCorpCode();
			String userName = login.getUserName();
			String userId = login.getUserId();
			//ʡ����
			String provinceName =login.getProvinceName();
			//ʡ����
			String provinceNum = login.getProvincenum();
			// ��ҵ����������
			String cityName = login.getCityName();
			// ��ҵ����������
			String countyName = login.getCountyName();
			
			if (typeNum.equals("3")) {
				// �ж��Ƿ���Ȩ�޵�½������
				message = "�Բ�����û��Ȩ�޵�½���ܲ���ϵͳ��";
				page = "login";
			} else {

				if (typeNum.equals("1")) {
					if (type.contains("1")) {
						this.set("login", login);
						this.set("cropCode", corpCode);
						this.set("userName", userName);
						this.getMessage();
						typeNum = type; 
						page = "businessPage";
					} else {
						message = "�Բ�����û��Ȩ�޵�½���赥λϵͳ��";
						page = "login";
					}
				}

				if (typeNum.equals("2")) {
					if (type.equals("1")) {
						message = "�Բ�����û��Ȩ�޵�½��ҵ��ҵ��λϵͳ��";
						page = "login";
					} else {
						this.set("login", login);
						this.set("cropCode", corpCode);
						this.set("userName", userName);
						this.set("userId", userId);
						this.set("provinceNum", provinceNum);
						this.set("provinceName", provinceName);
						this.set("cityName", cityName);
						this.set("countyName", countyName);
						typeNum = type;
						page = "businessPage2";
					}
				}
			}
		}
		return page;
	}
	
	/**
	 * ��ҵ���Ƶ�¼
	 */
	public String loginCorp(String corpName)
	{
		Login login = null;
		String page = "";
		ILoginService loginService = new LoginServiceImpl();
		login = loginService.query(corpName,"1");
		//��ȡ��ҵ����
		String type = login.getEnterPriseType();
		
		
		if(type==null)
		{
			message = "�����������ҵ������,����ҵ��δ��ȡkey,����δѡ����ҵ����,���ʵ��Ϣ�����µ�½��";
			page = "nameLogin";
		}else
		{
			//������ҵ���Ƶ�¼ҳ�淵�ذ�ť,�ж���ҵ����
			if(type.contains("1"))
			{
				//�Ƴ���ҵ����
				this.getRequest().getSession().removeAttribute("typeNum");
				this.getRequest().getSession().setAttribute("typeNum", "1");
			}else
			{
				this.getRequest().getSession().removeAttribute("typeNum");
				this.getRequest().getSession().setAttribute("typeNum", "2");
			}
			
			corpCode = login.getCorpCode();
			String userName = login.getUserName();
			String userId = login.getUserId();
			//ʡ����
			String provinceName =login.getProvinceName();
			//ʡ����
			String provinceNum = login.getProvincenum();
			// ��ҵ����������
			String cityName = login.getCityName();
			// ��ҵ����������
			String countyName = login.getCountyName();
			
			//�����ҵ���Ͱ������赥λ����
			if(type.indexOf("1")!=-1){
				this.set("login", login);
				this.set("cropCode", corpCode);
				this.getMessage();
				page = "businessPage";
			} else {
				//�����ҵ��λ���������赥λ����
				this.set("login", login);
				this.set("cropCode", corpCode);
				this.set("userName", userName);
				this.set("userId", userId);
				this.set("provinceNum", provinceNum);
				this.set("provinceName", provinceName);
				this.set("cityName", cityName);
				this.set("countyName", countyName);
				page = "businessPage2";
			}
			
		}

		return page;
	}
	
	/**
	 * ���ܲ��ŵ�½
	 * @return
	 */
	public String chargeDeptLogin()
	{
		String page = "";
		if (typeNum.equals("1") || typeNum.equals("2")) {
			// �ж��Ƿ���Ȩ�޵�½������
			message = "���½���ܲ���ϵͳ��";
			page = "login";
		}
		// ����Ϊ�����û�
		RoleServiceImplService role = new RoleServiceImplService();
		// �����Ա��Ϣ
		List<String> list = new ArrayList<String>();
		list = role.getRoleServiceImplPort().getRole(results, "2");
		Login login = new Login();
		login.setLoginType("1");
		if (list.get(0) != null && !list.get(0).equals("")) {
			// ����
			login.setLoginuserid(list.get(0));
			// ����
			login.setName(list.get(1));
			// ��ɫId
			login.setRoleID(list.get(2));
			// ����Id
			login.setDepartmentID(list.get(3));
			// Ȩ�޼���
			login.setPopedomid(list.get(4));
			// ��������
			login.setDepartment(list.get(5));
			// ��Աid
			login.setPersonalID(list.get(6));
			// ��ɫ����(ֵΪ -99 ��ת������ҵ���Ƶ�¼)
			login.setRolename(list.get(7));
			this.set("login", login);
			if(login.getRolename().equals("-99"))
			{
				page = "nameLogin";
			}else
			{
				page = "deptPage";
			}
			//page = "deptPage";
		} else {
			page = "login";
		}
		return page;
	}
	
	/**
	 * ��ת��װ����˵��ҳ��
	 * 
	 * @return
	 */
	public String driveInstructions() {
		return "driveInstructions";
	}

	/**
	 * �˳�ϵͳ
	 */
	public String exitSystem() {
		this.clearSession();
		return "login";
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getTypeNum() {
		return typeNum;
	}

	public void setTypeNum(String typeNum) {
		this.typeNum = typeNum;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

}
