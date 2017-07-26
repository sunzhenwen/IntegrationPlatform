package com.tj.jst.inner.business.qualityapply.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.qualityapply.condition.QualityHistoryCondition;
import com.tj.jst.inner.business.qualityapply.service.IQualityApplyService;
import com.tj.jst.inner.business.qualityapply.service.QualityApplyServiceImpl;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.quality.model.Quality;

public class QualityHistoryAction extends BaseAction {
	private String qualityId;// 主键
	private Quality quality;// Model类
	private String message;// 提示信息

	private QualityHistoryCondition condition = new QualityHistoryCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(QualityHistoryCondition condition) {
		this.condition = condition;
	}

	public QualityHistoryCondition getCondition() {
		QualityHistoryCondition sessionCondition = (QualityHistoryCondition) get(getActionName());
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
	public String queryHistoryPage() {
		IQualityApplyService service = new QualityApplyServiceImpl();
		currentPage = service.pagedQuery(condition);
		this.set(getActionName(), condition);
		return "queryHistoryPage";
	}

	/**
	 * 跳转审批页面
	 * 
	 * @return
	 */
	public String queryHistory() {
		IQualityApplyService service = new QualityApplyServiceImpl();
		quality = service.queryApproval(qualityId);
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

	public String getQualityId() {
		return qualityId;
	}

	public void setQualityId(String qualityId) {
		this.qualityId = qualityId;
	}

	public Quality getQuality() {
		return quality;
	}

	public void setQuality(Quality quality) {
		this.quality = quality;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
