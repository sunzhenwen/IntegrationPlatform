package com.tj.jst.outside.business.singleProject.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.PrjNum;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.singleProject.condition.SingleProjectCondition;
import com.tj.jst.outside.business.singleProject.model.SingleProject;
import com.tj.jst.outside.business.singleProject.service.ISingleProjectService;
import com.tj.jst.outside.business.singleProject.service.SingleProjectServiceImpl;

/**
 * ���幤��
 * @author hhc
 *
 */
public class SingleProjectAction extends BaseAction {
	
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
	
	private SingleProjectCondition condition = new SingleProjectCondition();
	
	public void setCondition(SingleProjectCondition condition) {
		this.condition = condition;
	}

	public SingleProjectCondition getCondition() {
		SingleProjectCondition sessionCondition = (SingleProjectCondition) get(getActionName());
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
		ISingleProjectService service = new SingleProjectServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ת���ҳ��
	 * @return
	 */
	public String addPage()
	{
		int num = PrjNum.querySerNum(prjNum);
		if(num != 0)
		{
			if(num<10)
			{
				spNum = prjNum+"-00"+Integer.toString(num);
			}else if(num<100)
			{
				spNum = prjNum+"-0"+Integer.toString(num);
			}else
			{
				spNum = prjNum+"-"+Integer.toString(num);
			}
			ISingleProjectService service = new SingleProjectServiceImpl();
			//�ṹ��ϵ(�ֵ��TBPRJSTRUCTURETYPEDIC)
			prjStructureTypeNums = service.queryPrjStructureTypeNums();
			return "addPage";
		}else
		{
			message = "1";
			System.out.println("message= "+message);
			return "query";
		}
		
	}
	
	/**
	 * ���
	 * @return
	 */
	public String add()
	{
		ISingleProjectService service = new SingleProjectServiceImpl();
		singleProject.setPrjNum(prjNum);
		singleProject.setLinkName(linkName);
		singleProject.setPrjId(prjId);
		service.add(singleProject);
		return "query";
	}
	
	/**
	 * ��ת�޸�ҳ��
	 * @return
	 */
	public String modifyPage()
	{
		ISingleProjectService service = new SingleProjectServiceImpl();
		//�ṹ��ϵ(�ֵ��TBPRJSTRUCTURETYPEDIC)
		prjStructureTypeNums = service.queryPrjStructureTypeNums();
		singleProject = service.queryById(spId);
		return "modifyPage";
	}
	
	/**
	 * �޸�
	 * @return
	 */
	public String modify()
	{
		ISingleProjectService service = new SingleProjectServiceImpl();
		service.modify(singleProject);
		return "query";
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String delete()
	{
		ISingleProjectService service = new SingleProjectServiceImpl();
		service.delete(spId);
		return "query";
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
