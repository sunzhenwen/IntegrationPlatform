package com.tj.jst.inner.business.qualityapply.action;

import java.sql.Date;
import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.qualityapply.condition.QualityApplyCondition;
import com.tj.jst.inner.business.qualityapply.service.IQualityApplyService;
import com.tj.jst.inner.business.qualityapply.service.QualityApplyServiceImpl;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ����������������
 * 
 * @author DarkFlameMaster
 *
 */
public class QualityApplyAction extends BaseAction {

	private String qualityId;// ����
	private Quality quality;// Model��
	private String message;// ��ʾ��Ϣ
	// �����б�
	private List<Upload> downloadlist;

	private QualityApplyCondition condition = new QualityApplyCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(QualityApplyCondition condition) {
		this.condition = condition;
	}

	public QualityApplyCondition getCondition() {
		QualityApplyCondition sessionCondition = (QualityApplyCondition) get(getActionName());
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
		IQualityApplyService service = new QualityApplyServiceImpl();
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
		IQualityApplyService service = new QualityApplyServiceImpl();
		quality = service.queryApproval(qualityId);
		downloadlist = service.downloadInfo(qualityId);
		return "approvalPage";
	}

	/**
	 * ����ͨ��
	 * 
	 * @return
	 */
	public String applySuccess() {
		IQualityApplyService service = new QualityApplyServiceImpl();
		Login login = (Login) this.get("login");
		quality.setAppSteffId(login.getDepartmentID());
		quality.setAppSteffName(login.getDepartment());
		quality.setAppDate(new Date(new java.util.Date().getTime()));
		message = service.applySuccess(quality);
		if (message.equals("�ɹ�")) {
			message = service.querySafety(quality.getPrjNum());
			if (message.equals("�ɹ�")) {
				// ��ȫ�������Ҳ��ɣ��������Ŀ��������Ϣ
				service.updateProjectInfo(quality.getPrjNum());
				//message = service.changeAuthor(quality.getPrjNum());//������Ȩ״̬
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
		IQualityApplyService service = new QualityApplyServiceImpl();
		Login login = (Login) this.get("login");
		quality.setAppSteffId(login.getDepartmentID());
		quality.setAppSteffName(login.getDepartment());
		quality.setAppDate(new Date(new java.util.Date().getTime()));
		message = service.applyFaile(quality);
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

	public List<Upload> getDownloadlist() {
		return downloadlist;
	}

	public void setDownloadlist(List<Upload> downloadlist) {
		this.downloadlist = downloadlist;
	}

}
