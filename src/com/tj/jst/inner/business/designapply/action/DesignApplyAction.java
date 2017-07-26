package com.tj.jst.inner.business.designapply.action;

import java.sql.Date;
import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.designapply.condition.DesignApplyCondition;
import com.tj.jst.inner.business.designapply.condition.DesignQualificationCondition;
import com.tj.jst.inner.business.designapply.model.DesignApply;
import com.tj.jst.inner.business.designapply.service.DesignApplyServiceImpl;
import com.tj.jst.inner.business.designapply.service.IDesignApplyService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.upload.model.Upload;

public class DesignApplyAction extends BaseAction {

	// Model类
	private DesignApply project;
	// 项目名称
	private String prjName;
	// 立项文号
	private String prjApprovalNum;
	// 建设单位名称
	private String buildCorpName;
	// 建设单位组织机构代码证
	private String buildCorpCode;
	// 主键
	private String designId;
	// 返回提示信息
	private String message;
	// 下载列表
	private List<Upload> downloadlist;

	private DesignApplyCondition condition = new DesignApplyCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(DesignApplyCondition condition) {
		this.condition = condition;
	}

	public DesignApplyCondition getCondition() {
		DesignApplyCondition sessionCondition = (DesignApplyCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	public String queryPage() {
		IDesignApplyService service = new DesignApplyServiceImpl();
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
		IDesignApplyService service = new DesignApplyServiceImpl();
		project = service.queryApproval(designId);
		DesignQualificationCondition qcondition = new DesignQualificationCondition(
				designId);
		downloadlist = service.downloadInfo(designId);
		currentPage = service.sidebyPage(qcondition);
		// 判断是否有单位工程
		if (currentPage.getTotalCount() > 0) {
			project.setUnitMark("1");
		}
		return "approvalPage";
	}

	/**
	 * 审批通过
	 * 
	 * @return
	 */
	public String applySuccess() {
		IDesignApplyService service = new DesignApplyServiceImpl();
		Login login = (Login) this.get("login");
		project.setAppSteffId(login.getDepartmentID());
		project.setAppSteffName(login.getDepartment());
		project.setAppDate(new Date(new java.util.Date().getTime()));
		message = service.applySuccess(project);
		if (message.equals("成功")) {
			service.updateProjectInfo(project.getPrjNum());
		}
		return "query";
	}

	/**
	 * 审批未通过
	 * 
	 * @return
	 */
	public String applyFaile() {
		IDesignApplyService service = new DesignApplyServiceImpl();
		Login login = (Login) this.get("login");
		project.setAppSteffId(login.getDepartmentID());
		project.setAppSteffName(login.getDepartment());
		project.setAppDate(new Date(new java.util.Date().getTime()));
		message = service.applyFaile(project);
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

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getPrjApprovalNum() {
		return prjApprovalNum;
	}

	public void setPrjApprovalNum(String prjApprovalNum) {
		this.prjApprovalNum = prjApprovalNum;
	}

	public String getBuildCorpName() {
		return buildCorpName;
	}

	public void setBuildCorpName(String buildCorpName) {
		this.buildCorpName = buildCorpName;
	}

	public String getBuildCorpCode() {
		return buildCorpCode;
	}

	public void setBuildCorpCode(String buildCorpCode) {
		this.buildCorpCode = buildCorpCode;
	}

	public String getDesignId() {
		return designId;
	}

	public void setDesignId(String designId) {
		this.designId = designId;
	}

	public DesignApply getProject() {
		return project;
	}

	public void setProject(DesignApply project) {
		this.project = project;
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
