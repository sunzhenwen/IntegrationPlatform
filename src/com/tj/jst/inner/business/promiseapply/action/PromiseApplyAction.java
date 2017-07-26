package com.tj.jst.inner.business.promiseapply.action;

import java.sql.Date;
import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.promiseapply.condition.PromiseApplyCondition;
import com.tj.jst.inner.business.promiseapply.service.IPromiseApplyService;
import com.tj.jst.inner.business.promiseapply.service.PromiseApplyServiceImpl;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 施工许可方法了类
 * 
 * @author DarkFlameMaster
 *
 */
public class PromiseApplyAction extends BaseAction {

	private String permitId;// 查询主键
	private Permit permit;// Model类
	private String message;// 提示信息
	// 下载列表
	private List<Upload> downloadlist;

	private PromiseApplyCondition condition = new PromiseApplyCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(PromiseApplyCondition condition) {
		this.condition = condition;
	}

	public PromiseApplyCondition getCondition() {
		PromiseApplyCondition sessionCondition = (PromiseApplyCondition) get(getActionName());
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
	public String queryPage() {
		IPromiseApplyService service = new PromiseApplyServiceImpl();
		currentPage = service.pagedQuery(condition);
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 跳转审批页面
	 * 
	 * @return
	 */
	public String queryapproval() {
		IPromiseApplyService service = new PromiseApplyServiceImpl();
		permit = service.queryApproval(permitId);
		downloadlist = service.downloadInfo(permitId);
		return "approvalPage";
	}

	/**
	 * 审批通过
	 * 
	 * @return
	 */
	public String approvalSuccess() {
		IPromiseApplyService service = new PromiseApplyServiceImpl();
		Login login = (Login) this.get("login");
		permit.setAppDate(new Date(new java.util.Date().getTime()));
		permit.setAppSteffId(login.getPersonalID());
		permit.setAppSteffName(login.getName());
		message = service.approvalSuccess(permit);
		if (message.equals("成功")) {
			service.updateProjectInfo(permit.getPrjNum());
			//message = service.changeAuthor(permit.getPrjNum());//更改授权状态
		}
		return "query";
	}

	/**
	 * 审批不通过
	 * 
	 * @return
	 */
	public String approvalFailed() {
		IPromiseApplyService service = new PromiseApplyServiceImpl();
		Login login = (Login) this.get("login");
		permit.setAppDate(new Date(new java.util.Date().getTime()));
		permit.setAppSteffId(login.getPersonalID());
		permit.setAppSteffName(login.getName());
		message = service.approvalFailed(permit);
		return "query";
	}

	/**
	 * 返回
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	public String getPermitId() {
		return permitId;
	}

	public void setPermitId(String permitId) {
		this.permitId = permitId;
	}

	public Permit getPermit() {
		return permit;
	}

	public void setPermit(Permit permit) {
		this.permit = permit;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Upload> getDownloadlist() {
		return downloadlist;
	}

	public void setDownloadlist(List<Upload> downloadlist) {
		this.downloadlist = downloadlist;
	}

}
