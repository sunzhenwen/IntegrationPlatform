package com.tj.jst.inner.business.safetyapply.action;

import java.sql.Date;
import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.safetyapply.condition.SafetyApplyCondition;
import com.tj.jst.inner.business.safetyapply.service.ISafetyApplyService;
import com.tj.jst.inner.business.safetyapply.service.SafetyApplyServiceImpl;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.safety.model.Safety;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 安全勘察方法
 * 
 * @author DarkFlameMaster
 *
 */
public class SafetyApplyAction extends BaseAction {

	private String safetyId;// 主键
	private Safety safety;// Model类
	private String message;// 提心信息
	private String typeName;// 工程类型名称
	private List<Upload> list;
	private String oversightNum;// 安全监督登记编号

	private SafetyApplyCondition condition = new SafetyApplyCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(SafetyApplyCondition condition) {
		this.condition = condition;
	}

	public SafetyApplyCondition getCondition() {
		SafetyApplyCondition sessionCondition = (SafetyApplyCondition) get(getActionName());
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
		ISafetyApplyService service = new SafetyApplyServiceImpl();
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
		ISafetyApplyService service = new SafetyApplyServiceImpl();
		safety = service.queryApproval(safetyId);
		typeName = service.queryTypeName(safety.getProjectType());
		list = service.downloadInfo(safetyId);
		return "approvalPage";
	}

	/**
	 * 审批通过
	 * 
	 * @return
	 */
	public String applySuccess() {
		ISafetyApplyService service = new SafetyApplyServiceImpl();
		Login login = (Login) this.get("login");
		safety.setAppSteffId(login.getDepartmentID());
		safety.setAppSteffName(login.getDepartment());
		safety.setAppDate(new Date(new java.util.Date().getTime()));
		message = service.applySuccess(safety);
		if (message.equals("成功")) {
			message = service.queryQuality(safety.getPrjNum());
			if (message.equals("成功")) {
				// 安全勘察如果也完成，则更改项目基本表信息
				service.updateProjectInfo(safety.getPrjNum());
				// message = service.changeAuthor(safety.getPrjNum());//更改授权状态
			}
		}
		return "query";
	}

	/**
	 * 审批未通过
	 * 
	 * @return
	 */
	public String applyFaile() {
		ISafetyApplyService service = new SafetyApplyServiceImpl();
		Login login = (Login) this.get("login");
		safety.setAppSteffId(login.getDepartmentID());
		safety.setAppSteffName(login.getDepartment());
		safety.setAppDate(new Date(new java.util.Date().getTime()));
		message = service.applyFaile(safety);
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

	public String getSafetyId() {
		return safetyId;
	}

	public void setSafetyId(String safetyId) {
		this.safetyId = safetyId;
	}

	public Safety getSafety() {
		return safety;
	}

	public void setSafety(Safety safety) {
		this.safety = safety;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Upload> getList() {
		return list;
	}

	public void setList(List<Upload> list) {
		this.list = list;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getOversightNum() {
		return oversightNum;
	}

	public void setOversightNum(String oversightNum) {
		this.oversightNum = oversightNum;
	}

}
