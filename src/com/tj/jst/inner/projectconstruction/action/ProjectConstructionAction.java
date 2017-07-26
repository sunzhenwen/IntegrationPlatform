package com.tj.jst.inner.projectconstruction.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.projectconstruction.condition.ProjectConstructionCondition;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;
import com.tj.jst.inner.projectconstruction.service.IProjectConstructionService;
import com.tj.jst.inner.projectconstruction.service.ProjectConstructionServiceImpl;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.upload.model.Upload;

public class ProjectConstructionAction extends BaseAction {

	// Model类
	private ProjectConstruction project;
	// 项目名称
	private String prjName;
	// 立项文号
	private String prjApprovalNum;
	// 建设单位名称
	private String buildCorpName;
	// 建设单位组织机构代码证
	private String buildCorpCode;
	// 主键
	private String prjId;
	// 返回提示信息
	private String message;
	// 批量审批
	private String[] ids;
	// 项目编码
	private String prjNum;
	// 下载列表
	private List<Upload> downloadlist;

	private ProjectConstructionCondition condition = new ProjectConstructionCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(ProjectConstructionCondition condition) {
		this.condition = condition;
	}

	public ProjectConstructionCondition getCondition() {
		ProjectConstructionCondition sessionCondition = (ProjectConstructionCondition) get(getActionName());
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
		IProjectConstructionService service = new ProjectConstructionServiceImpl();
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 跳转审批页面
	 * 
	 * @return
	 */
	public String queryapproval() {
		IProjectConstructionService service = new ProjectConstructionServiceImpl();
		project = service.queryApproval(prjId);
		// ProjectPageCondition procondition = new ProjectPageCondition(prjId);
		downloadlist = service.downloadInfo(prjId);
		// currentPage = service.projectPage(procondition);
		// 用于判断是否含有单位工程
		// if (currentPage.getTotalCount() > 0) {
		// project.setUnitMark("1");
		// }

		return "approvalPage";
	}

	/**
	 * 审批通过
	 * 
	 * @return
	 */
	public String applySuccess() {
		IProjectConstructionService service = new ProjectConstructionServiceImpl();
		message = service.applySuccess(project);
		if(message.equals("成功")){
			message = service.updateAuthor(project);
		}
		return "query";
	}

	/**
	 * 审批未通过
	 * 
	 * @return
	 */
	public String applyFaile() {
		IProjectConstructionService service = new ProjectConstructionServiceImpl();
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

	/**
	 * 查看项目记录
	 * 
	 * @return
	 */
	public String getProjectInfo() {
		IProjectConstructionService service = new ProjectConstructionServiceImpl();
		project = service.getProjectInfo(prjNum);
		return "getProjectInfo";
	}

	public ProjectConstruction getProject() {
		return project;
	}

	public void setProject(ProjectConstruction project) {
		this.project = project;
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

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

	public List<Upload> getDownloadlist() {
		return downloadlist;
	}

	public void setDownloadlist(List<Upload> downloadlist) {
		this.downloadlist = downloadlist;
	}

}
