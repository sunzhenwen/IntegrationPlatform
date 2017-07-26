package com.tj.jst.outside.staffmanage.title.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.staffmanage.title.condition.TitleCondition;
import com.tj.jst.outside.staffmanage.title.model.Title;
import com.tj.jst.outside.staffmanage.title.service.ITitleService;
import com.tj.jst.outside.staffmanage.title.service.TitleServiceImpl;

/**
 * 职称人员
 * @author Administrator
 *
 */
public class TitleAction extends BaseAction {
	
	//职称人员主键
	private String personId;
	//职称人员
	private Title title;
	//职称人员list
	private List<Title> titleList;
	//性别list
	private List<DictionaryClass> sexNums;
	//证件类型
	private List<DictionaryClass> idCardTypeNums;
	
	//提示信息
	private String message;
	
	private TitleCondition condition = new TitleCondition();
	
	public void setCondition(TitleCondition condition) {
		this.condition = condition;
	}

	public TitleCondition getCondition() {
		TitleCondition sessionCondition = (TitleCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * 查询职称人员基础信息
	 * @return
	 */
	public String queryPage()
	{
		ITitleService staffService = new TitleServiceImpl();
		String corpId = (String)this.get("userId");
		this.getCondition().setCorpId(corpId);
		//分页查询
		currentPage = staffService.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "titleSuccess";
	}
	
	/**
	 * 跳转添加职称人员基本信息页面
	 * @return
	 */
	public String addPage()
	{
		this.queryDictionaryClass();
		return "addPage";
	}
	
	/**
	 * 添加职称人员基本信息
	 * @return
	 */
	public String add()
	{
		ITitleService staffService = new TitleServiceImpl();
		Login login = (Login)this.get("login");
		this.getTitle().setCorpId(login.getUserId());
		this.getTitle().setCorpCode(login.getCorpCode());
		this.getTitle().setCorpName(login.getUserName());
		this.queryDictionaryClass();
		message = staffService.add(title);
		if (!message.equals("添加成功！"))
		{
			message = "该证件号码已经在" + message + "使用！无法重复添加！请核对！";
			return "addPage";
		}else{
			message = "添加成功！";
			return "queryPage";
		}
		
	}
	
	/**
	 * 跳转修改职称人员信息页面
	 * @return
	 */
	public String modifyPage()
	{
		ITitleService staffService = new TitleServiceImpl();
		this.queryDictionaryClass();
		title = staffService.queryById(personId);
		return "modifyPage";
	}
	
	/**
	 * 修改职称人员信息
	 * @return
	 */
	public String modify()
	{
		ITitleService staffService = new TitleServiceImpl();
		message = staffService.modify(title);
		this.queryDictionaryClass();
		if(!message.equals("修改成功！")){
			message = "该证件号码已经在" + message + "使用！无法重复添加！请核对！";
			return "modifyPage";
		}else{
			message = "修改成功！";
			return "queryPage";
		}
		
		
	}
	
	/**
	 * 删除职称人员信息
	 * @return
	 */
	public String delete()
	{
		ITitleService staffService = new TitleServiceImpl();
		message = staffService.delete(personId);
		return "queryPage";
	}
	
	/**
	 * 返回职称人员列表目录
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

	public void queryDictionaryClass()
	{
		ITitleService staffService = new TitleServiceImpl();
		sexNums = staffService.querySexNums();
		idCardTypeNums = staffService.queryIdCardTypeNums();
	}
	
	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public List<Title> getTitleList() {
		return titleList;
	}

	public void setTitleList(List<Title> titleList) {
		this.titleList = titleList;
	}

	public List<DictionaryClass> getSexNums() {
		return sexNums;
	}

	public void setSexNums(List<DictionaryClass> sexNums) {
		this.sexNums = sexNums;
	}

	public List<DictionaryClass> getIdCardTypeNums() {
		return idCardTypeNums;
	}

	public void setIdCardTypeNums(List<DictionaryClass> idCardTypeNums) {
		this.idCardTypeNums = idCardTypeNums;
	}

}
