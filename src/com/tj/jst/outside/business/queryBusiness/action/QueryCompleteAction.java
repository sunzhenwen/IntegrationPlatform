package com.tj.jst.outside.business.queryBusiness.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.business.promiseapply.service.IPromiseApplyService;
import com.tj.jst.inner.business.promiseapply.service.PromiseApplyServiceImpl;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;
import com.tj.jst.inner.projectconstruction.service.IProjectConstructionService;
import com.tj.jst.inner.projectconstruction.service.ProjectConstructionServiceImpl;
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.queryBusiness.condition.QueryCompleteCondition;
import com.tj.jst.outside.business.queryBusiness.service.IQueryCompleteService;
import com.tj.jst.outside.business.queryBusiness.service.QueryCompleteServiceImpl;

/**
 * ��������
 * @author hhc
 *
 */
public class QueryCompleteAction extends BaseAction {
	
	//������������
	private String completeId;
	//��Ŀ���
	private String prjNum;
	//��Ŀ����
	private String prjName;
	//��������
	private Complete complete;
	//�ṹ��ϵ
	private List<DictionaryClass> prjStructureTypeNums;
	//��������
	private List<Regional> list;
	//������ʾ��Ϣ
	private String message;
	private String result;
	private String treeStr;
	//��ҵ��֯��������
	private String corpCode;
	//��ҵ����
	private String corpName;
	
	private Permit permit;// Model��
	private ProjectConstruction projectConstruction;
	
	
	//�жϴ�ӡ��
	private String appType;

	
	private QueryCompleteCondition condition = new QueryCompleteCondition();
	
	public void setCondition(QueryCompleteCondition condition) {
		this.condition = condition;
	}

	public QueryCompleteCondition getCondition() {
		QueryCompleteCondition sessionCondition = (QueryCompleteCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		IQueryCompleteService service = new QueryCompleteServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ת�������������޸�ҳ��
	 * @return
	 */
	public String modifyPage()
	{
		IQueryCompleteService service = new QueryCompleteServiceImpl();
		prjStructureTypeNums = service.queryPrjStructureTypeNums();
		complete = service.queryById(completeId);
		
		IPromiseApplyService service1 = new PromiseApplyServiceImpl();
		permit = service1.queryApproval(complete.getPrjNum());
		
		
		IProjectConstructionService projectConstructionService = new ProjectConstructionServiceImpl();
		projectConstruction = projectConstructionService.getProjectInfo(complete.getPrjNum());
		
		
		return "modifyPage";
	}
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public String queryAppDept()
	{
		IQueryCompleteService service = new QueryCompleteServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	
	public String queryPrjName()
	{
		IQueryCompleteService service = new QueryCompleteServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	
	/**
	 * ������Ŀ�����б�Ŀ¼
	 * @return
	 */
	public String goList()
	{
		return "query";
	}
	
	/**
	 * ����ҵ�����Ŀ¼
	 * @return
	 */
	public String goBack()
	{
		return "goBusiness";
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Regional> getList() {
		return list;
	}

	public void setList(List<Regional> list) {
		this.list = list;
	}

	public String getTreeStr() {
		return treeStr;
	}

	public void setTreeStr(String treeStr) {
		this.treeStr = treeStr;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
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

	public List<DictionaryClass> getPrjStructureTypeNums() {
		return prjStructureTypeNums;
	}

	public void setPrjStructureTypeNums(List<DictionaryClass> prjStructureTypeNums) {
		this.prjStructureTypeNums = prjStructureTypeNums;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public Permit getPermit() {
		return permit;
	}

	public void setPermit(Permit permit) {
		this.permit = permit;
	}

	public ProjectConstruction getProjectConstruction() {
		return projectConstruction;
	}

	public void setProjectConstruction(ProjectConstruction projectConstruction) {
		this.projectConstruction = projectConstruction;
	}

}
