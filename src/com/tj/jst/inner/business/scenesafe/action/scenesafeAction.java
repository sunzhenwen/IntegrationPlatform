package com.tj.jst.inner.business.scenesafe.action;
import java.sql.Date;
import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.promiseapply.condition.PromiseApplyCondition;
import com.tj.jst.inner.business.promiseapply.service.IPromiseApplyService;
import com.tj.jst.inner.business.promiseapply.service.PromiseApplyServiceImpl;
import com.tj.jst.inner.business.qualityapply.condition.QualityApplyCondition;
import com.tj.jst.inner.business.scenesafe.condition.scenesafeCondition;
import com.tj.jst.inner.business.scenesafe.model.ConstruScenesafe;
import com.tj.jst.inner.business.scenesafe.model.SceneSafe;
import com.tj.jst.inner.business.scenesafe.service.ScenesafeService;
import com.tj.jst.inner.business.scenesafe.service.ScenesafeServiceImpl;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.safety.model.ConstructionSafety;
import com.tj.jst.outside.business.safety.service.ISafetyService;
import com.tj.jst.outside.business.safety.service.SafetyServiceImpl;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ʩ����ɷ�������
 * 
 * @author DarkFlameMaster
 *
 */
public class scenesafeAction extends BaseAction {

	 private String permitid;//����
	private SceneSafe scenesafe;// Model��
	private String appDept;
	private List<ConstruScenesafe> construscenesafe; 
	private scenesafeCondition condition = new scenesafeCondition(
			((Login) this.get("login")).getDepartmentID());
	public void setCondition(scenesafeCondition condition) {
		this.condition = condition;
	}
	public scenesafeCondition getCondition() {
		scenesafeCondition sessionCondition = (scenesafeCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * ʩ�������Ŀ��ѯ ��ת
	 * 
	 * @return
	 */
	public String queryPage() {
//		ScenesafeService service = new ScenesafeServiceImpl();
//		currentPage = service.pagedQuery(condition);
//		this.set(getActionName(), condition);
		return "queryPage";
	}
	
	/**
	 * ʩ�������Ŀ��ѯ
	 * 
	 * @return
	 */
	public String queryPagee() {
		ScenesafeService service = new ScenesafeServiceImpl();
		currentPage = service.pagedQuery(condition);
		this.set(getActionName(), condition);
		return "queryPagee";
	}

	/**
	 * ���
	 * 
	 * @return
	 */
	public String addpage() {
		ScenesafeService service = new ScenesafeServiceImpl();
		scenesafe.setAppDept(condition.getAppDept());
		System.out.println(condition.getAppDept());
		permitid=service.add(scenesafe,construscenesafe);
		return "queryfj";
	}
	/**
	 * ɾ��
	 * @return
	 */
	public String delete()
	{
		ScenesafeService service = new ScenesafeServiceImpl();
		service.delete(permitid);
		return "querydel";
	}
	/**
	 * ��ת�ֳ���ȫ�ල�����޸�ҳ��
	 * @return
	 */
	public String modifyPage()
	{
		ScenesafeService service = new ScenesafeServiceImpl();
		scenesafe = service.queryById(permitid);
		return "modifyPage";
	}
	/**
	 * ��ת�ֳ���ȫ�ල�����޸�ҳ��
	 * @return
	 */
	public String modifyPag()
	{
		ScenesafeService service = new ScenesafeServiceImpl();
		scenesafe = service.queryById(permitid);
		return "modifyPag";
	}
	/**
	 * ��Ӹ���
	 * @return
	 */
	public String modifyPagee()
	{
		ScenesafeService service = new ScenesafeServiceImpl();
		scenesafe = service.queryById(permitid);
		return "modifyPagee";
	}
	
	/**
	 * �޸�
	 * @return
	 */
	public String modify()
	{
		ScenesafeService service = new ScenesafeServiceImpl();
		  service.modify(scenesafe,construscenesafe);
		return "query";
	}

	
	/**
	 * ����
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	public String getPermitid() {
		return permitid;
	}

	public void setPermitid(String permitid) {
		this.permitid = permitid;
	}

	public SceneSafe getScenesafe() {
		return scenesafe;
	}

	public void setScenesafe(SceneSafe scenesafe) {
		this.scenesafe = scenesafe;
	}

	public List<ConstruScenesafe> getConstruscenesafe() {
		return construscenesafe;
	}

	public void setConstruscenesafe(List<ConstruScenesafe> construscenesafe) {
		this.construscenesafe = construscenesafe;
	}
	public String getAppDept() {
		return appDept;
	}
	public void setAppDept(String appDept) {
		this.appDept = appDept;
	}

	
	 

}
