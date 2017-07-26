package com.tj.jst.inner.business.scenesafe.action;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.promiseapply.condition.PromiseHistoryCondition;
import com.tj.jst.inner.business.promiseapply.service.IPromiseApplyService;
import com.tj.jst.inner.business.promiseapply.service.PromiseApplyServiceImpl;
import com.tj.jst.inner.business.scenesafe.condition.querscenesafecondition;
import com.tj.jst.inner.business.scenesafe.condition.scenesafeCondition;
import com.tj.jst.inner.business.scenesafe.model.SceneSafe;
import com.tj.jst.inner.business.scenesafe.service.ScenesafeService;
import com.tj.jst.inner.business.scenesafe.service.ScenesafeServiceImpl;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;
import com.tj.jst.inner.projectconstruction.service.IProjectConstructionService;
import com.tj.jst.inner.projectconstruction.service.ProjectConstructionServiceImpl;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.quality.condition.QualityTenderInfoCondition;

public class querscenesafeAction extends BaseAction {
				private String permitid;
				private String prjnamee;
				private String prjnumm;
				private SceneSafe scenesafe;
 private querscenesafecondition condition = new querscenesafecondition(
		((Login) this.get("login")).getDepartmentID());

	public void setCondition(querscenesafecondition condition) {
		this.condition = condition;
	}

	public querscenesafecondition getCondition() {
		querscenesafecondition sessionCondition = (querscenesafecondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 审批查询页面
	 * 
	 * @return
	 */
	public String querypage() {
		ScenesafeService service = new ScenesafeServiceImpl();
		currentPage = service.pagedQuerypage(condition);
		this.set(getActionName(), condition);
		return "querypage";
	}
	/**
	 * 审批查询页面
	 * 
	 * @return
	 */
	public String querypagey() {
		ScenesafeService service = new ScenesafeServiceImpl();
		currentPage = service.pagedQuerypage(condition);
		this.set(getActionName(), condition);
		return "querypagey";
	}
	/**
	 * 条件模糊查询
	 * 
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String querypagetj() throws UnsupportedEncodingException {
		String context = new String(prjnamee.getBytes("iso-8859-1"),"UTF-8");
		this.getCondition().setPrjnumm(prjnumm);
		this.getCondition().setPrjnamee(context);
		ScenesafeService service = new ScenesafeServiceImpl();
		currentPage = service.pagedQuerypage(condition);
		System.out.println(prjnumm);
		System.out.println(context);
		this.set(getActionName(), condition);
		return "querypage";
	}
	/**
	 * 详细
	 * 
	 * @return
	 */
	public String querypagexx() {
		 
		ScenesafeService service = new ScenesafeServiceImpl();
		this.getCondition().setPermitid(permitid);
		currentPage = service.pagedQuerypage(condition);
		this.set(getActionName(), condition);
		scenesafe=(SceneSafe)currentPage.getData().get(0);
		return "querypagexx";
	}
	public String getPermitid() {
		return permitid;
	}

	public void setPermitid(String permitid) {
		this.permitid = permitid;
	}

	public String getPrjnamee() {
		return prjnamee;
	}

	public void setPrjnamee(String prjnamee) {
		this.prjnamee = prjnamee;
	}

	public String getPrjnumm() {
		return prjnumm;
	}

	public void setPrjnumm(String prjnumm) {
		this.prjnumm = prjnumm;
	}

	public SceneSafe getScenesafe() {
		return scenesafe;
	}

	public void setScenesafe(SceneSafe scenesafe) {
		this.scenesafe = scenesafe;
	}


}
