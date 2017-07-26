package com.tj.jst.inner.personrecord.threeTypesPersonnel.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.personrecord.threeTypesPersonnel.condition.ThreeTypesPersonnelCondition;
import com.tj.jst.inner.personrecord.threeTypesPersonnel.model.ThreeTypesPersonnel;
import com.tj.jst.inner.personrecord.threeTypesPersonnel.service.IThreeTypesPersonnelService;
import com.tj.jst.inner.personrecord.threeTypesPersonnel.service.ThreeTypesPersonnelServiceImpl;
import com.tj.jst.inner.personrecord.title.service.ITitleService;
import com.tj.jst.inner.personrecord.title.service.TitleServiceImpl;

public class ThreeTypesPersonnelAction extends BaseAction {

	// 岗位人员主键
	private String threeTypePersonId;
	// 提示信息
	private String message;
	//三类人员
	private ThreeTypesPersonnel threeTypesPersonnel ;
	//三类人员集合
	private List<ThreeTypesPersonnel> threeTypesPersonnelList ;
	
	//企业名称（根据corpId查询）
	private String corpName ;

	private ThreeTypesPersonnelCondition condition = new ThreeTypesPersonnelCondition();

	public void setCondition(ThreeTypesPersonnelCondition condition) {
		this.condition = condition;
	}

	public ThreeTypesPersonnelCondition getCondition() {
		ThreeTypesPersonnelCondition sessionCondition = (ThreeTypesPersonnelCondition) get(getActionName());
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
		IThreeTypesPersonnelService service = new ThreeTypesPersonnelServiceImpl();
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
		IThreeTypesPersonnelService service = new ThreeTypesPersonnelServiceImpl();
		threeTypesPersonnel = service.queryById(threeTypePersonId);
		corpName = service.queryCorpName(threeTypesPersonnel.getCorpId());//根据corpId查询企业名称
		return "detailPage";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ThreeTypesPersonnel getThreeTypesPersonnel() {
		return threeTypesPersonnel;
	}

	public void setThreeTypesPersonnel(ThreeTypesPersonnel threeTypesPersonnel) {
		this.threeTypesPersonnel = threeTypesPersonnel;
	}

	public List<ThreeTypesPersonnel> getThreeTypesPersonnelList() {
		return threeTypesPersonnelList;
	}

	public void setThreeTypesPersonnelList(
			List<ThreeTypesPersonnel> threeTypesPersonnelList) {
		this.threeTypesPersonnelList = threeTypesPersonnelList;
	}

	public String getThreeTypePersonId() {
		return threeTypePersonId;
	}

	public void setThreeTypePersonId(String threeTypePersonId) {
		this.threeTypePersonId = threeTypePersonId;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

}
