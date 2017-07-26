package com.tj.jst.inner.personrecord.title.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.personrecord.title.condition.TitleCondition;
import com.tj.jst.inner.personrecord.title.model.Title;
import com.tj.jst.inner.personrecord.title.service.ITitleService;
import com.tj.jst.inner.personrecord.title.service.TitleServiceImpl;

/**
 * ְ����Ա����Action��
 * 
 * @author DarkFlameMaster
 *
 */
public class TitleInfoAction extends BaseAction {

	// ְ����Ա����
	private String personId;
	// ְ����Ա
	private Title title;
	// ְ����Աlist
	private List<Title> titleList;
	// �Ա�list
	private List<DictionaryClass> sexNums;
	// ֤������
	private List<DictionaryClass> idCardTypeNums;
	// ��ʾ��Ϣ
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
	 * ��ҳ��ѯ
	 * 
	 * @return
	 */
	public String queryPage() {
		ITitleService service = new TitleServiceImpl();
		// ��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ѯ��ϸ
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
