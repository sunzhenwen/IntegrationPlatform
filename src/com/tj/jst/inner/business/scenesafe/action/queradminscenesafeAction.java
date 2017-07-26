package com.tj.jst.inner.business.scenesafe.action;
import java.io.UnsupportedEncodingException;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.scenesafe.condition.querscenesafeadmincondition;
import com.tj.jst.inner.business.scenesafe.model.SceneSafe;
import com.tj.jst.inner.business.scenesafe.service.ScenesafeService;
import com.tj.jst.inner.business.scenesafe.service.ScenesafeServiceImpl;

public class queradminscenesafeAction extends BaseAction {
				private String permitid;
				private String prjnamee;
				private String prjnumm;
				private SceneSafe scenesafe;
	private querscenesafeadmincondition condition = new querscenesafeadmincondition();

	public void setCondition(querscenesafeadmincondition condition) {
		this.condition = condition;
	}

	public querscenesafeadmincondition getCondition() {
		querscenesafeadmincondition sessionCondition = (querscenesafeadmincondition) get(getActionName());
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
	public String querypageytj() throws UnsupportedEncodingException {
		ScenesafeService service = new ScenesafeServiceImpl();
		String context = new String(prjnamee.getBytes("iso-8859-1"),"UTF-8");
		this.getCondition().setPrjnumm(prjnumm);
		this.getCondition().setPrjnamee(context);
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
	public String querypageback() {
		 
		ScenesafeService service = new ScenesafeServiceImpl();
		scenesafe = service.queryById(permitid);
		return "querypageback";
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
