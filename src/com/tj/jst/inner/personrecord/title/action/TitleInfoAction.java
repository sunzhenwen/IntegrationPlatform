package com.tj.jst.inner.personrecord.title.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.personrecord.title.condition.TitleCondition;
import com.tj.jst.inner.personrecord.title.model.Title;
import com.tj.jst.inner.personrecord.title.service.ITitleService;
import com.tj.jst.inner.personrecord.title.service.TitleServiceImpl;

/**
 * 职称人员备案Action类
 * 
 * @author DarkFlameMaster
 *
 */
public class TitleInfoAction extends BaseAction {

	// 职称人员主键
	private String personId;
	// 职称人员
	private Title title;
	// 职称人员list
	private List<Title> titleList;
	// 性别list
	private List<DictionaryClass> sexNums;
	// 证件类型
	private List<DictionaryClass> idCardTypeNums;
	// 提示信息
	private String message;

	private TitleCondition condition = new TitleCondition();

	public void setCondition(TitleCondition condition) {
		this.condition = condition;
	}

	public TitleCondition getCondition() {
		TitleCondition sessionCondition = (TitleCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	public String queryPage() {
		ITitleService service = new TitleServiceImpl();
		// 分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 查询详细
	 * 
	 * @return
	 */
	public String queryById() {
		ITitleService service = new TitleServiceImpl();
		title = service.queryById(personId);
		return "detailPage";
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
