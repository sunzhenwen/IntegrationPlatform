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
 * 登陆
 * 
 * @author Administrator
 *
 */
public class LoginAction extends BaseAction {

	private String results;
	private String typeNum;// 来源 1:建设单位 2:行业企业 3:主管部门
	private String message;// 提示信息
	private String corpCode ;//组织结构代码
	private String corpName;//企业名称

	// 系统启动欢迎页面自动进入此方法
	public String login() throws Exception {
		return "login";
	}

	public String deptLogin() throws Exception {
		return "deptLogin";
	}

	/**
	 * 跳转认证页面
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
	 * 判断查询页面
	 * 
	 * @return
	 */
	public String businessPage() {
		
		String page = "";
		//如果不是企业名称登陆
		if(corpName == null)
		{
			//企业登陆
			page = this.loginCorp();
			if("".equals(page))
			{
				//主管部门登陆
				page = this.chargeDeptLogin();
			}
		}else
		{
			page = this.loginCorp(corpName);
		}
		
		return page;
	}

	/**
	 * 企业登录
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
		//获取企业类型
		String type = login.getEnterPriseType();
		
		if(type == null){
			type = "9";
		}
		
		if (typeNum == null) {
			typeNum = "9";
		}
		
		// 如果为企业用户
		if (login.getUserId() != null) {
			corpCode = login.getCorpCode();
			String userName = login.getUserName();
			String userId = login.getUserId();
			//省名称
			String provinceName =login.getProvinceName();
			//省编码
			String provinceNum = login.getProvincenum();
			// 企业所在市名称
			String cityName = login.getCityName();
			// 企业所在区名称
			String countyName = login.getCountyName();
			
			if (typeNum.equals("3")) {
				// 判断是否有权限登陆到这里
				message = "对不起，您没有权限登陆主管部门系统！";
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
						message = "对不起，您没有权限登陆建设单位系统！";
						page = "login";
					}
				}

				if (typeNum.equals("2")) {
					if (type.equals("1")) {
						message = "对不起，您没有权限登陆行业企业单位系统！";
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
	 * 企业名称登录
	 */
	public String loginCorp(String corpName)
	{
		Login login = null;
		String page = "";
		ILoginService loginService = new LoginServiceImpl();
		login = loginService.query(corpName,"1");
		//获取企业类型
		String type = login.getEnterPriseType();
		
		
		if(type==null)
		{
			message = "您所输入的企业不存在,或企业尚未领取key,或尚未选择企业类型,请核实信息后重新登陆！";
			page = "nameLogin";
		}else
		{
			//用于企业名称登录页面返回按钮,判断企业类型
			if(type.contains("1"))
			{
				//移除企业类型
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
			//省名称
			String provinceName =login.getProvinceName();
			//省编码
			String provinceNum = login.getProvincenum();
			// 企业所在市名称
			String cityName = login.getCityName();
			// 企业所在区名称
			String countyName = login.getCountyName();
			
			//如果企业类型包含建设单位类型
			if(type.indexOf("1")!=-1){
				this.set("login", login);
				this.set("cropCode", corpCode);
				this.getMessage();
				page = "businessPage";
			} else {
				//如果企业单位不包含建设单位类型
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
	 * 主管部门登陆
	 * @return
	 */
	public String chargeDeptLogin()
	{
		String page = "";
		if (typeNum.equals("1") || typeNum.equals("2")) {
			// 判断是否有权限登陆到这里
			message = "请登陆主管部门系统！";
			page = "login";
		}
		// 否则为部门用户
		RoleServiceImplService role = new RoleServiceImplService();
		// 获得人员信息
		List<String> list = new ArrayList<String>();
		list = role.getRoleServiceImplPort().getRole(results, "2");
		Login login = new Login();
		login.setLoginType("1");
		if (list.get(0) != null && !list.get(0).equals("")) {
			// 主键
			login.setLoginuserid(list.get(0));
			// 人名
			login.setName(list.get(1));
			// 角色Id
			login.setRoleID(list.get(2));
			// 部门Id
			login.setDepartmentID(list.get(3));
			// 权限集合
			login.setPopedomid(list.get(4));
			// 部门名称
			login.setDepartment(list.get(5));
			// 人员id
			login.setPersonalID(list.get(6));
			// 角色名称(值为 -99 跳转按照企业名称登录)
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
	 * 跳转安装驱动说明页面
	 * 
	 * @return
	 */
	public String driveInstructions() {
		return "driveInstructions";
	}

	/**
	 * 退出系统
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
