package com.tj.jst.inner.business.readyapply.action;

import java.sql.Date;
import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.readyapply.condition.ReadyApplyCondition;
import com.tj.jst.inner.business.readyapply.service.IReadyApplyService;
import com.tj.jst.inner.business.readyapply.service.ReadyApplyServiceImpl;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 竣工验收方法类
 * 
 * @author DarkFlameMaster
 *
 */
public class ReadyApplyAction extends BaseAction {

	private String completeId;// 查询主键
	private Complete complete;// Model类
	private String message;// 返回消息
	// 下载列表
	private List<Upload> downloadlist;

	private ReadyApplyCondition condition = new ReadyApplyCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(ReadyApplyCondition condition) {
		this.condition = condition;
	}

	public ReadyApplyCondition getCondition() {
		ReadyApplyCondition sessionCondition = (ReadyApplyCondition) get(getActionName());
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
		IReadyApplyService service = new ReadyApplyServiceImpl();
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
		IReadyApplyService service = new ReadyApplyServiceImpl();
		complete = service.queryApproval(completeId);
		downloadlist = service.downloadInfo(completeId);
		return "approvalPage";
	}

	/**
	 * 审批通过
	 * 
	 * @return
	 */
	public String approvalSuccess() {
		IReadyApplyService service = new ReadyApplyServiceImpl();
		Login login = (Login) this.get("login");
		complete.setAppDate(new Date(new java.util.Date().getTime()));
		complete.setAppSteffId(login.getPersonalID());
		complete.setAppSteffName(login.getName());
		message = service.approvalSuccess(complete);
		if (message.equals("成功")) {
			service.updateProjectInfo(complete.getPrjNum());
			// message = service.changeAuthor(complete.getPrjNum());//更改授权状态
		}
		return "query";
	}

	/**
	 * 审批不通过
	 * 
	 * @return
	 */
	public String approvalFailed() {
		IReadyApplyService service = new ReadyApplyServiceImpl();
		Login login = (Login) this.get("login");
		complete.setAppDate(new Date(new java.util.Date().getTime()));
		complete.setAppSteffId(login.getPersonalID());
		complete.setAppSteffName(login.getName());
		message = service.approvalFailed(complete);
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

	public String getCompleteId() {
		return completeId;
	}

	public void setCompleteId(String completeId) {
		this.completeId = completeId;
	}

	public Complete getComplete() {
		return complete;
	}

	public void setComplete(Complete complete) {
		this.complete = complete;
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
