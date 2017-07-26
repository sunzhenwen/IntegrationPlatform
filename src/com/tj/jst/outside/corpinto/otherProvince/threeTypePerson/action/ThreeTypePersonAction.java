package com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.condition.ThreeTypePersonCondition;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.model.ThreeTypePerson;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.service.IThreeTypePersonService;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.service.ThreeTypePersonServiceImpl;

/**
 * 外省三类人员
 * @author Administrator
 *
 */
public class ThreeTypePersonAction extends BaseAction {
	
	//主键
	private String threeTypePersonId;
	//外省三类人员
	private ThreeTypePerson threeTypePerson;
	//提示信息
	private String message;
	
	private ThreeTypePersonCondition condition = new ThreeTypePersonCondition();
	
	public void setCondition(ThreeTypePersonCondition condition) {
		this.condition = condition;
	}

	public ThreeTypePersonCondition getCondition() {
		ThreeTypePersonCondition sessionCondition = (ThreeTypePersonCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * 查询外省三类人员
	 * @return
	 */
	public String queryPage()
	{
		IThreeTypePersonService staffService = new ThreeTypePersonServiceImpl();
		String corpId = (String)this.get("userId");
		this.getCondition().setCorpId(corpId);
		//分页查询
		currentPage = staffService.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "threeTypePersonSuccess";
	}
	
	/**
	 * 跳转添加页面
	 * @return
	 */
	public String addPage()
	{
		return "addPage";
	}
	
	/**
	 * 添加
	 * @return
	 */
	public String add()
	{
		IThreeTypePersonService staffService = new ThreeTypePersonServiceImpl();
		this.getThreeTypePerson().setCorpId((String)this.get("userId"));
		String userName = (String)this.get("userName");
		this.getThreeTypePerson().setFEntName(userName);
		this.getThreeTypePerson().setFEntName1(userName);
		message = staffService.add(threeTypePerson);
		return "queryPage";
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String modifyPage()
	{
		IThreeTypePersonService staffService = new ThreeTypePersonServiceImpl();
		threeTypePerson = staffService.queryById(threeTypePersonId);
		return "modifyPage";
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String modify()
	{
		IThreeTypePersonService staffService = new ThreeTypePersonServiceImpl();
		message = staffService.modify(threeTypePerson);
		return "queryPage";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete()
	{
		IThreeTypePersonService staffService = new ThreeTypePersonServiceImpl();
		message = staffService.delete(threeTypePersonId);
		return "queryPage";
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
	 * 返回业务办理目录
	 * @return
	 */
	public String goBack()
	{
		return "goBusiness";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ThreeTypePerson getThreeTypePerson() {
		return threeTypePerson;
	}

	public void setThreeTypePerson(ThreeTypePerson threeTypePerson) {
		this.threeTypePerson = threeTypePerson;
	}

	public String getThreeTypePersonId() {
		return threeTypePersonId;
	}

	public void setThreeTypePersonId(String threeTypePersonId) {
		this.threeTypePersonId = threeTypePersonId;
	}

}
