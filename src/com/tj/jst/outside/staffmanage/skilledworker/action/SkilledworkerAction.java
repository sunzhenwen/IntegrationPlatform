package com.tj.jst.outside.staffmanage.skilledworker.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.staffmanage.skilledworker.condition.SkilledworkerCondition;
import com.tj.jst.outside.staffmanage.skilledworker.model.Skilledworker;
import com.tj.jst.outside.staffmanage.skilledworker.service.ISkilledworkerService;
import com.tj.jst.outside.staffmanage.skilledworker.service.SkilledworkerServiceImpl;

/**
 * 注册技术工种人员
 * 
 * @author DarkFlameMaster
 *
 */
public class SkilledworkerAction extends BaseAction {

	// 注册技术工种
	private Skilledworker skilledworker;
	// 技术工种LIst
	private List<Skilledworker> skilledworkerList;
	// 技术工种种类
	private List<DictionaryClass> typedNums;
	// 技术工种级别
	private List<DictionaryClass> levelNums;
	// 返回提示信息
	private String message;
	// 注册证件类别
	private List<DictionaryClass> idCardTypeName;
	// 性别类别
	private List<DictionaryClass> sexName;
	// 民族类别
	private List<DictionaryClass> nationalName;
	// 学位类别
	private List<DictionaryClass> degreeName;
	// 学历类别
	private List<DictionaryClass> eduLevelName;
	// 人员主键
	private String personId;

	private SkilledworkerCondition condition = new SkilledworkerCondition();

	public void setCondition(SkilledworkerCondition condition) {
		this.condition = condition;
	}

	public SkilledworkerCondition getCondition() {
		SkilledworkerCondition sessionCondition = (SkilledworkerCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 查询所有的技术人员基础信息
	 * 
	 * @return
	 */
	public String queryPage() {

		ISkilledworkerService staffService = new SkilledworkerServiceImpl();
		String corpId = (String)this.get("userId");
		this.getCondition().setCorpId(corpId);
		// 分页查询
		currentPage = staffService.pagedQuery(this.getCondition());
		// 技术类型查询
		typedNums = staffService.skilledTypeNums();
		// 技术级别查询
		//levelNums = staffService.skilledLevelNums();
		this.set(getActionName(), condition);
		return "skillworkerSuccess";

	}

	/**
	 * 跳转到技术人员信息修改界面
	 * 
	 * @return
	 */
	public String modifiedPage() {
		ISkilledworkerService staffService = new SkilledworkerServiceImpl();
		this.queryDictionary();
		skilledworker = staffService.queryById(personId);
		return "modifyPage";
	}

	/**
	 * 技术人员信息修改
	 * 
	 * @return
	 */
	public String modified() {
		ISkilledworkerService staffService = new SkilledworkerServiceImpl();
		message = staffService.modifyPersonInfo(skilledworker);
		this.queryDictionary();
		if(!message.equals("修改成功！")){
			message = "该证件号码已经在" + message + "使用！无法重复添加！请核对！";
			return "modifyPage";
		}else{
			message = "修改成功！";
			return "queryPage";
		}
		
	}

	/**
	 * 技术人员信息增加页面
	 * 
	 * @return
	 */
	public String createdPage() {
		this.queryDictionary();
		return "addPage";
	}

	/**
	 * 技术人员信息增加
	 * 
	 * @return
	 */
	public String created() {
		ISkilledworkerService staffService = new SkilledworkerServiceImpl();
		Login login = (Login) this.get("login");
		this.getSkilledworker().setCorpCode(login.getCorpCode());
		this.getSkilledworker().setUserId(login.getUserId());
		this.getSkilledworker().setCorpName(login.getUserName());
		this.queryDictionary();
		message = staffService.addPersonInfo(skilledworker);
		if(!message.equals("添加人员成功！")){
			message = "该证件号码已经在" + message + "使用！无法重复添加！请核对！";
			return "addPage";
		}else{
			message = "添加成功！";
			return "queryPage";
		}
		
	}

	/**
	 * 返回业务办理界面
	 * 
	 * @return
	 */
	public String goBack() {
		return "goBusiness";
	}

	/**
	 * 返回技术人员列表界面
	 * 
	 * @return
	 */
	public String goList() {
		return "queryPage";
	}

	/**
	 * 技术人员信息删除
	 * 
	 * @return
	 */
	public String delete() {
		ISkilledworkerService staffService = new SkilledworkerServiceImpl();
		message = staffService.delete(personId);
		return "queryPage";
	}

	/**
	 * 查询字典表
	 * 
	 * @return
	 */
	public void queryDictionary() {

		ISkilledworkerService staffService = new SkilledworkerServiceImpl();
		// 证件类型
		//idCardTypeName = staffService.idCardTypeNums();
		// 性别
		//sexName = staffService.sexNums();
		// 技术人员级别
		//levelNums = staffService.skilledLevelNums();
		// 技术人员种类
		typedNums = staffService.skilledTypeNums();
		// 民族
		//nationalName = staffService.nationalNums();
		// 学位
		//degreeName = staffService.degreeNums();
		// 学历
		//eduLevelName = staffService.eduLevelNums();
	}

	public Skilledworker getSkilledworker() {
		return skilledworker;
	}

	public void setSkilledworker(Skilledworker skilledworker) {
		this.skilledworker = skilledworker;
	}

	public List<Skilledworker> getSkilledworkerList() {
		return skilledworkerList;
	}

	public void setSkilledworkerList(List<Skilledworker> skilledworkerList) {
		this.skilledworkerList = skilledworkerList;
	}

	public List<DictionaryClass> getTypedNums() {
		return typedNums;
	}

	public void setTypedNums(List<DictionaryClass> typedNums) {
		this.typedNums = typedNums;
	}

	public List<DictionaryClass> getLevelNums() {
		return levelNums;
	}

	public void setLevelNums(List<DictionaryClass> levelNums) {
		this.levelNums = levelNums;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<DictionaryClass> getIdCardTypeName() {
		return idCardTypeName;
	}

	public void setIdCardTypeName(List<DictionaryClass> idCardTypeName) {
		this.idCardTypeName = idCardTypeName;
	}

	public List<DictionaryClass> getSexName() {
		return sexName;
	}

	public void setSexName(List<DictionaryClass> sexName) {
		this.sexName = sexName;
	}

	public List<DictionaryClass> getNationalName() {
		return nationalName;
	}

	public void setNationalName(List<DictionaryClass> nationalName) {
		this.nationalName = nationalName;
	}

	public List<DictionaryClass> getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(List<DictionaryClass> degreeName) {
		this.degreeName = degreeName;
	}

	public List<DictionaryClass> getEduLevelName() {
		return eduLevelName;
	}

	public void setEduLevelName(List<DictionaryClass> eduLevelName) {
		this.eduLevelName = eduLevelName;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}
}
