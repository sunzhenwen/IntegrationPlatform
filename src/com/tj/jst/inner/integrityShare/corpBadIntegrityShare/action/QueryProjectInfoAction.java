package com.tj.jst.inner.integrityShare.corpBadIntegrityShare.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.integrity.corpBadIntegrity.condition.QueryProjectInfoCondition;
import com.tj.jst.inner.integrity.corpBadIntegrity.service.IQueryProjectInfoService;
import com.tj.jst.inner.integrity.corpBadIntegrity.service.QueryProjectInfoServiceImpl;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;

/**
 * 查询项目基本信息
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryProjectInfoAction extends BaseAction {

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

	private QueryProjectInfoCondition condition = new QueryProjectInfoCondition();

	public void setCondition(QueryProjectInfoCondition condition) {
		this.condition = condition;
	}

	public QueryProjectInfoCondition getCondition() {
		QueryProjectInfoCondition sessionCondition = (QueryProjectInfoCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 分页类
	 * 
	 * @return
	 */
	public String queryPage() {
		IQueryProjectInfoService service = new QueryProjectInfoServiceImpl();
		currentPage = service.queryPage(condition);
		this.set(getActionName(), condition);
		return "queryprojectinfo";
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

}
