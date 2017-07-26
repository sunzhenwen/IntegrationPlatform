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
 * ��ȫ���췽��
 * 
 * @author DarkFlameMaster
 *
 */
public class SafetyApplyAction extends BaseAction {

	private String safetyId;// ����
	private Safety safety;// Model��
	private String message;// ������Ϣ
	private String typeName;// ������������
	private List<Upload> list;
	private String oversightNum;// ��ȫ�ල�ǼǱ��

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
	 * ��ҳ��ѯ
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
	 * ��ת����ҳ��
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
	 * ����ͨ��
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
		if (message.equals("�ɹ�")) {
			message = service.queryQuality(safety.getPrjNum());
			if (message.equals("�ɹ�")) {
				// ��ȫ�������Ҳ��ɣ��������Ŀ��������Ϣ
				service.updateProjectInfo(safety.getPrjNum());
				// message = service.changeAuthor(safety.getPrjNum());//������Ȩ״̬
			}
		}
		return "query";
	}

	/**
	 * ����δͨ��
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
	 * ����
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
