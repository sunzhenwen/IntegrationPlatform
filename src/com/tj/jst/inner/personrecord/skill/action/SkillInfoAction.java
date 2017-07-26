package com.tj.jst.inner.personrecord.skill.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.personrecord.skill.condition.SkillCondition;
import com.tj.jst.inner.personrecord.skill.model.Skill;
import com.tj.jst.inner.personrecord.skill.service.ISkillService;
import com.tj.jst.inner.personrecord.skill.service.SkillServiceImpl;

public class SkillInfoAction extends BaseAction {

	// 技术人员
	private Skill skillworker;
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

	private SkillCondition condition = new SkillCondition();

	public void setCondition(SkillCondition condition) {
		this.condition = condition;
	}

	public SkillCondition getCondition() {
		SkillCondition sessionCondition = (SkillCondition) get(getActionName());
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
		ISkillService service = new SkillServiceImpl();
		// 分页查询
		currentPage = service.pagedQuery(this.getCondition());
		// 技术类型查询
		typedNums = service.skilledTypeNums();
		// 技术级别查询
		levelNums = service.skilledLevelNums();
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 查询详细
	 * 
	 * @return
	 */
	public String queryById() {
		ISkillService service = new SkillServiceImpl();
		skillworker = service.queryById(personId);
		return "detailPage";
	}

	public Skill getSkillworker() {
		return skillworker;
	}

	public void setSkillworker(Skill skillworker) {
		this.skillworker = skillworker;
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
