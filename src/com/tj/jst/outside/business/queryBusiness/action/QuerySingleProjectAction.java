package com.tj.jst.outside.business.queryBusiness.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.queryBusiness.condition.QuerySingleProjectCondition;
import com.tj.jst.outside.business.queryBusiness.service.IQuerySingleProjectService;
import com.tj.jst.outside.business.queryBusiness.service.QuerySingleProjectServiceImpl;
import com.tj.jst.outside.business.singleProject.model.SingleProject;

/**
 * ���幤��
 * @author hhc
 *
 */
public class QuerySingleProjectAction extends BaseAction {
	
	//���幤��ʵ������
	private long spId;
	//��Ŀ���
	private String prjNum;
	//������Ŀ����
	private String prjId;
	//��λ����
	private String spNum;
	//��������
	private String linkName;
	//���幤��ʵ����
	private SingleProject singleProject;
	//�ṹ��ϵ(�ֵ��TBPRJSTRUCTURETYPEDIC)
	private List<DictionaryClass> prjStructureTypeNums; 
	//��ʾ��Ϣ
	private String message;
	//�ж��Ƿ��ǲ�ѯ����
	private String type;
	
	private QuerySingleProjectCondition condition = new QuerySingleProjectCondition();
	
	public void setCondition(QuerySingleProjectCondition condition) {
		this.condition = condition;
	}

	public QuerySingleProjectCondition getCondition() {
		QuerySingleProjectCondition sessionCondition = (QuerySingleProjectCondition) get(getActionName());
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
		IQuerySingleProjectService service = new QuerySingleProjectServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ת�޸�ҳ��
	 * @return
	 */
	public String modifyPage()
	{
		IQuerySingleProjectService service = new QuerySingleProjectServiceImpl();
		//�ṹ��ϵ(�ֵ��TBPRJSTRUCTURETYPEDIC)
		prjStructureTypeNums = service.queryPrjStructureTypeNums();
		singleProject = service.queryById(spId);
		return "modifyPage";
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


	public long getSpId() {
		return spId;
	}

	public void setSpId(long spId) {
		this.spId = spId;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public SingleProject getSingleProject() {
		return singleProject;
	}

	public void setSingleProject(SingleProject singleProject) {
		this.singleProject = singleProject;
	}

	public List<DictionaryClass> getPrjStructureTypeNums() {
		return prjStructureTypeNums;
	}

	public void setPrjStructureTypeNums(List<DictionaryClass> prjStructureTypeNums) {
		this.prjStructureTypeNums = prjStructureTypeNums;
	}

	public String getSpNum() {
		return spNum;
	}

	public void setSpNum(String spNum) {
		this.spNum = spNum;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}
	
}
