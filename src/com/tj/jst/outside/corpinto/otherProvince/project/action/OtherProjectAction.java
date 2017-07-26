package com.tj.jst.outside.corpinto.otherProvince.project.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.corpinto.otherProvince.project.condition.OtherProjectCondition;
import com.tj.jst.outside.corpinto.otherProvince.project.service.IOtherProjectService;
import com.tj.jst.outside.corpinto.otherProvince.project.service.OtherProjectServiceImpl;

/**
 * 外省项目备案
 * @author Administrator
 *
 */
public class OtherProjectAction extends BaseAction {
	
	//项目报建实体类
	private Construction construction;
	//主键
	private String otherPrjId;
	//企业组织机构代码
	private String corpCode;
	//企业名称
	private String corpName;
	//企业主键
	private String corpId;
	
	
	
	private OtherProjectCondition condition = new OtherProjectCondition();
	
	public void setCondition(OtherProjectCondition condition) {
		this.condition = condition;
	}

	public OtherProjectCondition getCondition() {
		OtherProjectCondition sessionCondition = (OtherProjectCondition) get(getActionName());
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
		//获取用户主键
		String corpId = (String)this.get("userId");
		IOtherProjectService ocs = new OtherProjectServiceImpl();
		this.getCondition().setCorpId(corpId);
		//分页查询
		currentPage = ocs.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "otherProjectSuccess";
	}
	
	/**
	 * 跳转添加页面
	 * @return
	 */
	public String addPage()
	{
		corpName = (String)this.get("userName");
		corpCode = (String)this.get("cropCode");
		corpId = (String)this.get("userId");
		//this.queryDictionaryClass();
		return "addPage";
	}
	
	/**
	 * 添加
	 * @return
	 */
	public String add()
	{
		IOtherProjectService ocs = new OtherProjectServiceImpl();
		otherPrjId = ocs.add(construction);
		return "queryAdd";
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String modifyPage()
	{
		IOtherProjectService ocs = new OtherProjectServiceImpl();
		construction = ocs.queryById(otherPrjId);
		return "modifyPage";
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String modify()
	{
		IOtherProjectService ocs = new OtherProjectServiceImpl();
		ocs.modify(construction);
		return "queryPage";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete()
	{
		IOtherProjectService ocs = new OtherProjectServiceImpl();
		ocs.delete(otherPrjId);
		return "queryPage";
	}
	
	/**
	 * 返回
	 * @return
	 */
	public String goBack()
	{
		return "goBusiness";
	}

	/**
	 * 返回
	 * @return
	 */
	public String goList()
	{
		return "queryPage";
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 详细
	 * @return
	 */
	public String detailed()
	{
		IOtherProjectService ocs = new OtherProjectServiceImpl();
		//constructor = ocs.queryDetailed(idCard,corpCode);
		return "detailed";
	}

	public Construction getConstruction() {
		return construction;
	}

	public void setConstruction(Construction construction) {
		this.construction = construction;
	}

	public String getOtherPrjId() {
		return otherPrjId;
	}

	public void setOtherPrjId(String otherPrjId) {
		this.otherPrjId = otherPrjId;
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

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}
	
}
