package com.tj.jst.inner.projectShare.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.projectShare.condition.FilingShareCondition;
import com.tj.jst.inner.projectShare.service.IProjectShareService;
import com.tj.jst.inner.projectShare.service.ProjectShareServiceImpl;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;

/**
 * ��ͬ���������ѯ
 * @author Administrator
 *
 */
public class FilingShareAction extends BaseAction {
	
	private String recordId;// ����
	private ContractFiling filing;// Model��
	//��ѯ��������Ȩ�����б�
	private List<DictionaryClass> approvalCityList;
	private String approvalCityId;
	private List<DictionaryClass> approvalAreaList;
	private String result;
	
	private FilingShareCondition condition = new FilingShareCondition();

	public void setCondition(FilingShareCondition condition) {
		this.condition = condition;
	}

	public FilingShareCondition getCondition() {
		FilingShareCondition sessionCondition = (FilingShareCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * ��Ʒ�ҳ��ѯ
	 * 
	 * @return
	 */
	public String queryPage() {
		IProjectShareService service = new ProjectShareServiceImpl();
		currentPage = service.queryFilingSharePage(this.getCondition());
		approvalCityList = service.queryApprovalCity();
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ƹ�����ϸ
	 * @return
	 */
	public String queryInfo() {
		IProjectShareService service = new ProjectShareServiceImpl();
		filing = service.queryFilingShareInfo(recordId);
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

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public ContractFiling getFiling() {
		return filing;
	}

	public void setFiling(ContractFiling filing) {
		this.filing = filing;
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
