package com.tj.jst.outside.business.corpReport.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.corpReport.condition.CorpReportCondition;
import com.tj.jst.outside.business.corpReport.model.CorpReport;
import com.tj.jst.outside.business.corpReport.service.CorpReportServiceImpl;
import com.tj.jst.outside.business.corpReport.service.ICorpReportService;

/**
 * ������ҵͳ�Ʊ���
 * @author hhc
 *
 */
public class CorpReportAction extends BaseAction {
	
	private String id;
	//������ҵͳ�Ʊ���
	private CorpReport corpReport;
	private String corpName; 		//��ҵ����
	private String corpCode; 		//��֯��������
	private String provinceNum; 	//ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
	private String cityNum; 		//ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
	private String countyNum; 		//ע��������(�����С���)(�ֵ��TBXZQDMDIC)
	private String legalMan; 		//��������������
	
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
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		ICorpReportService service = new CorpReportServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ת��ӱ���ҳ��
	 * @return
	 */
	public String addPage()
	{
		Login login = (Login)this.get("login");
		//��ҵ��֯��������
		corpCode = login.getCorpCode();
		//��ҵ����
		corpName = login.getUserName();
		provinceNum = login.getProvincenum(); 	//ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
		cityNum = login.getCitynum(); 		//ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
		countyNum = login.getCountynum(); 		//ע��������(�����С���)(�ֵ��TBXZQDMDIC)
		legalMan = login.getLegalMan(); 		//��������������
		return "addPage";
	}
	
	/**
	 * ��ӱ���
	 * @return
	 */
	public String add()
	{
		ICorpReportService service = new CorpReportServiceImpl();
		service.add(corpReport);
		return "query";
	}
	
	/**
	 * ��ת�����޸�ҳ��
	 * @return
	 */
	public String modifyPage()
	{
		Login login = (Login)this.get("login");
		//��ҵ��֯��������
		corpCode = login.getCorpCode();
		//��ҵ����
		corpName = login.getUserName();
		provinceNum = login.getProvincenum(); 	//ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
		cityNum = login.getCitynum(); 		//ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
		countyNum = login.getCountynum(); 		//ע��������(�����С���)(�ֵ��TBXZQDMDIC)
		legalMan = login.getLegalMan(); 		//��������������
		ICorpReportService service = new CorpReportServiceImpl();
		corpReport = service.queryById(id);
		return "modifyPage";
	}
	
	/**
	 * �����޸�
	 * @return
	 */
	public String modify()
	{
		ICorpReportService service = new CorpReportServiceImpl();
		service.modify(corpReport);
		return "query";
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String delete()
	{
		ICorpReportService service = new CorpReportServiceImpl();
		service.delete(id);
		return "query";
	}
	
	/**
	 * ������Ŀ�����б�Ŀ¼
	 * @return
	 */
	public String goList()
	{
		return "query";
	}
	
	/**
	 * ����ҵ�����Ŀ¼
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
