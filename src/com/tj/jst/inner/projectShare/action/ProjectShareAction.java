package com.tj.jst.inner.projectShare.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.projectShare.condition.ProConCondition;
import com.tj.jst.inner.projectShare.service.IProjectShareService;
import com.tj.jst.inner.projectShare.service.ProjectShareServiceImpl;
import com.tj.jst.outside.business.construction.model.Construction;

/**
 * ��Ŀ����
 * @author Administrator
 *
 */
public class ProjectShareAction extends BaseAction {

	//��Ŀ��������
	private String prjId;
	//��Ŀ����ʵ����
	private Construction construction;
	
	//��ѯ��������Ȩ�����б�
	private List<DictionaryClass> approvalCityList;
	private String approvalCityId;
	private List<DictionaryClass> approvalAreaList;
	private String result;
	
	/**
	 * ��Ŀ����
	 */


	private ProConCondition condition = new ProConCondition();

	public void setCondition(ProConCondition condition) {
		this.condition = condition;
	}

	public ProConCondition getCondition() {
		ProConCondition sessionCondition = (ProConCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}
	
	
	/**
	 * ��Ŀ����
	 */
	public String queryPage() {
		IProjectShareService service = new ProjectShareServiceImpl();
		currentPage = service.queryConstructionPage(this.getCondition());
		approvalCityList = service.queryApprovalCity();
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��Ŀ������ϸ
	 * @return
	 */
	public String queryInfo() {
		IProjectShareService service = new ProjectShareServiceImpl();
		construction = service.queryConstructionInfo(prjId);
		return "queryInfo";
	}
	
	/**
	 * ����
	 * 
	 * @return
	 */
	public String goPage() {
		return "goPage";
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
	
	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}

	public Construction getConstruction() {
		return construction;
	}

	public void setConstruction(Construction construction) {
		this.construction = construction;
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
