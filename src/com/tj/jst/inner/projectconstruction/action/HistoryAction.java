package com.tj.jst.inner.projectconstruction.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.projectconstruction.condition.HistoryCondition;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;
import com.tj.jst.inner.projectconstruction.service.IProjectConstructionService;
import com.tj.jst.inner.projectconstruction.service.ProjectConstructionServiceImpl;
import com.tj.jst.login.model.Login;

/**
 * 查询审批历史方法
 * 
 * @author DarkFlameMaster
 *
 */
public class HistoryAction extends BaseAction {
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

	private HistoryCondition condition = new HistoryCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(HistoryCondition condition) {
		this.condition = condition;
	}

	public HistoryCondition getCondition() {
		HistoryCondition sessionCondition = (HistoryCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 查询审批历史
	 * 
	 * @return
	 */
	public String queryHistoryPage() {
		IProjectConstructionService service = new ProjectConstructionServiceImpl();
		currentPage = service.historyPagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryHistoryPage";
	}

	/**
	 * 审批历史详细
	 * 
	 * @return
	 */
	public String queryHistory() {
		IProjectConstructionService service = new ProjectConstructionServiceImpl();
		project = service.queryApproval(prjId);
//		ProjectPageCondition procondition = new ProjectPageCondition(prjId);
//		currentPage = service.projectPage(procondition);
//		// 用于判断是否含有单位工程
//		if (currentPage.getTotalCount() > 0) {
//			project.setUnitMark("1");
//		}
		return "info";
	}
	
	/**
	 * 返回
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
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

}
