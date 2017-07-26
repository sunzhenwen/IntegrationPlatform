package com.tj.jst.inner.projectShare.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.projectShare.condition.ReadyShareCondition;
import com.tj.jst.inner.projectShare.service.IProjectShareService;
import com.tj.jst.inner.projectShare.service.ProjectShareServiceImpl;
import com.tj.jst.outside.business.complete.model.Complete;

/**
 * ��������
 * @author hhc
 *
 */
public class ReadyShareAction extends BaseAction {
	
	private String completeId;// ��ѯ����
	private Complete complete;// Model��
	//��ѯ��������Ȩ�����б�
	private List<DictionaryClass> approvalCityList;
	private String approvalCityId;
	private List<DictionaryClass> approvalAreaList;
	private String result;
	
	private ReadyShareCondition condition = new ReadyShareCondition();

	public void setCondition(ReadyShareCondition condition) {
		this.condition = condition;
	}

	public ReadyShareCondition getCondition() {
		ReadyShareCondition sessionCondition = (ReadyShareCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	public String queryPage() {
		IProjectShareService service = new ProjectShareServiceImpl();
		currentPage = service.queryReadySharePage(condition);
		approvalCityList = service.queryApprovalCity();
		this.set(getActionName(), condition);
		return "queryPage";
	}


	public String queryInfo() {
		IProjectShareService service = new ProjectShareServiceImpl();
		complete = service.queryReadyShareInfo(completeId);
		return "queryInfo";
	}

	/**
	 * ��ѯ��
	 * @return
	 */
	public String queryApprovaArea()
    {
		IProjectShareService service = new ProjectShareServiceImpl();
		approvalAreaList = service.queryApprovaArea(approvalCityId);
		JSONArray json = JSONArray.fromObject(approvalAreaList);//��result��ֵ�����ݸ�ҳ�� 
        result = json.toString();
        return "success";
    }
	
	/**
	 * ����
	 * 
	 * @return
	 */
	public String goBack() {
		return "goPage";
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

	public List<DictionaryClass> getApprovalCityList() {
		return approvalCityList;
	}

	public void setApprovalCityList(List<DictionaryClass> approvalCityList) {
		this.approvalCityList = approvalCityList;
	}

	public String getApprovalCityId() {
		return approvalCityId;
	}

	public void setApprovalCityId(String approvalCityId) {
		this.approvalCityId = approvalCityId;
	}

	public List<DictionaryClass> getApprovalAreaList() {
		return approvalAreaList;
	}

	public void setApprovalAreaList(List<DictionaryClass> approvalAreaList) {
		this.approvalAreaList = approvalAreaList;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
