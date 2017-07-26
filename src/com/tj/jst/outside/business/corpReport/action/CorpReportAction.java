package com.tj.jst.outside.business.corpReport.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.corpReport.condition.CorpReportCondition;
import com.tj.jst.outside.business.corpReport.model.CorpReport;
import com.tj.jst.outside.business.corpReport.service.CorpReportServiceImpl;
import com.tj.jst.outside.business.corpReport.service.ICorpReportService;

/**
 * 建筑企业统计报表
 * @author hhc
 *
 */
public class CorpReportAction extends BaseAction {
	
	private String id;
	//建筑企业统计报表
	private CorpReport corpReport;
	private String corpName; 		//企业名称
	private String corpCode; 		//组织机构代码
	private String provinceNum; 	//注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
	private String cityNum; 		//注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
	private String countyNum; 		//注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
	private String legalMan; 		//法定代表人姓名
	
	private CorpReportCondition condition = new CorpReportCondition();
	
	public void setCondition(CorpReportCondition condition) {
		this.condition = condition;
	}

	public CorpReportCondition getCondition() {
		CorpReportCondition sessionCondition = (CorpReportCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		ICorpReportService service = new CorpReportServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 跳转添加报建页面
	 * @return
	 */
	public String addPage()
	{
		Login login = (Login)this.get("login");
		//企业组织机构代码
		corpCode = login.getCorpCode();
		//企业名称
		corpName = login.getUserName();
		provinceNum = login.getProvincenum(); 	//注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
		cityNum = login.getCitynum(); 		//注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
		countyNum = login.getCountynum(); 		//注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
		legalMan = login.getLegalMan(); 		//法定代表人姓名
		return "addPage";
	}
	
	/**
	 * 添加报建
	 * @return
	 */
	public String add()
	{
		ICorpReportService service = new CorpReportServiceImpl();
		service.add(corpReport);
		return "query";
	}
	
	/**
	 * 跳转报建修改页面
	 * @return
	 */
	public String modifyPage()
	{
		Login login = (Login)this.get("login");
		//企业组织机构代码
		corpCode = login.getCorpCode();
		//企业名称
		corpName = login.getUserName();
		provinceNum = login.getProvincenum(); 	//注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
		cityNum = login.getCitynum(); 		//注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
		countyNum = login.getCountynum(); 		//注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
		legalMan = login.getLegalMan(); 		//法定代表人姓名
		ICorpReportService service = new CorpReportServiceImpl();
		corpReport = service.queryById(id);
		return "modifyPage";
	}
	
	/**
	 * 报建修改
	 * @return
	 */
	public String modify()
	{
		ICorpReportService service = new CorpReportServiceImpl();
		service.modify(corpReport);
		return "query";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete()
	{
		ICorpReportService service = new CorpReportServiceImpl();
		service.delete(id);
		return "query";
	}
	
	/**
	 * 返回项目报建列表目录
	 * @return
	 */
	public String goList()
	{
		return "query";
	}
	
	/**
	 * 返回业务办理目录
	 * @return
	 */
	public String goBack()
	{
		return "goBusiness";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CorpReport getCorpReport() {
		return corpReport;
	}

	public void setCorpReport(CorpReport corpReport) {
		this.corpReport = corpReport;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getProvinceNum() {
		return provinceNum;
	}

	public void setProvinceNum(String provinceNum) {
		this.provinceNum = provinceNum;
	}

	public String getCityNum() {
		return cityNum;
	}

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}

	public String getCountyNum() {
		return countyNum;
	}

	public void setCountyNum(String countyNum) {
		this.countyNum = countyNum;
	}

	public String getLegalMan() {
		return legalMan;
	}

	public void setLegalMan(String legalMan) {
		this.legalMan = legalMan;
	}
	
}
