package com.tj.jst.inner.business.innerSingleProject.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.PrjNum;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.business.innerSingleProject.condition.InnerSingleProjectCondition;
import com.tj.jst.inner.business.innerSingleProject.model.InnerSingleProject;
import com.tj.jst.inner.business.innerSingleProject.service.IInnerSingleProjectService;
import com.tj.jst.inner.business.innerSingleProject.service.InnerSingleProjectServiceImpl;



/**
 * 单体工程
 * @author hhc
 *
 */
public class InnerSingleProjectAction extends BaseAction {
	
	//单体工程实体主键
	private Long spId;
	//项目编号
	private String prjNum;
	//主体项目主键
	private String prjId;
	//单位编码
	private String spNum;
	//环节名称
	private String linkName;
	//单体工程实体类
	private InnerSingleProject singleProject;
	//结构体系(字典表：TBPRJSTRUCTURETYPEDIC)
	private List<DictionaryClass> prjStructureTypeNums; 
	//提示消息
	private String message;
	//判断是否是查询操作
	private String type;
	
	private InnerSingleProjectCondition condition = new InnerSingleProjectCondition();
	
	public void setCondition(InnerSingleProjectCondition condition) {
		this.condition = condition;
	}

	public InnerSingleProjectCondition getCondition() {
		InnerSingleProjectCondition sessionCondition = (InnerSingleProjectCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		IInnerSingleProjectService service = new InnerSingleProjectServiceImpl();
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 跳转添加页面
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
			IInnerSingleProjectService service = new InnerSingleProjectServiceImpl();
			//结构体系(字典表：TBPRJSTRUCTURETYPEDIC)
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
	 * 添加
	 * @return
	 */
	public String add()
	{
		IInnerSingleProjectService service = new InnerSingleProjectServiceImpl();
		singleProject.setPrjNum(prjNum);
		singleProject.setLinkName(linkName);
		singleProject.setPrjId(prjId);
		service.add(singleProject);
		return "query";
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String modifyPage()
	{
		IInnerSingleProjectService service = new InnerSingleProjectServiceImpl();
		//结构体系(字典表：TBPRJSTRUCTURETYPEDIC)
		prjStructureTypeNums = service.queryPrjStructureTypeNums();
		singleProject = service.queryById(spId);
		return "modifyPage";
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String modify()
	{
		IInnerSingleProjectService service = new InnerSingleProjectServiceImpl();
		service.modify(singleProject);
		return "query";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete()
	{
		IInnerSingleProjectService service = new InnerSingleProjectServiceImpl();
		service.delete(spId);
		return "query";
	}
	
	/**
	 * 返回项目报建列表目录
	 * @return
	 */
	public String goList()
	{
		return "query";
	}
	
	/**
	 * 返回业务办理目录
	 * @return
	 */
	public String goBack()
	{
		return "goBusiness";
	}

	public Long getSpId() {
		return spId;
	}

	public void setSpId(Long spId) {
		this.spId = spId;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}


	public InnerSingleProject getSingleProject() {
		return singleProject;
	}

	public void setSingleProject(InnerSingleProject singleProject) {
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
	
}
