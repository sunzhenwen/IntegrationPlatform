package com.tj.jst.outside.business.queryBusiness.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.queryBusiness.condition.QuerySingleProjectCondition;
import com.tj.jst.outside.business.queryBusiness.service.IQuerySingleProjectService;
import com.tj.jst.outside.business.queryBusiness.service.QuerySingleProjectServiceImpl;
import com.tj.jst.outside.business.singleProject.model.SingleProject;

/**
 * 单体工程
 * @author hhc
 *
 */
public class QuerySingleProjectAction extends BaseAction {
	
	//单体工程实体主键
	private long spId;
	//项目编号
	private String prjNum;
	//主体项目主键
	private String prjId;
	//单位编码
	private String spNum;
	//环节名称
	private String linkName;
	//单体工程实体类
	private SingleProject singleProject;
	//结构体系(字典表：TBPRJSTRUCTURETYPEDIC)
	private List<DictionaryClass> prjStructureTypeNums; 
	//提示消息
	private String message;
	//判断是否是查询操作
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
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		IQuerySingleProjectService service = new QuerySingleProjectServiceImpl();
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 跳转修改页面
	 * @return
	 */
	public String modifyPage()
	{
		IQuerySingleProjectService service = new QuerySingleProjectServiceImpl();
		//结构体系(字典表：TBPRJSTRUCTURETYPEDIC)
		prjStructureTypeNums = service.queryPrjStructureTypeNums();
		singleProject = service.queryById(spId);
		return "modifyPage";
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
