package com.tj.jst.inner.personrecord.otherProvincePosition.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.personrecord.otherProvincePosition.condition.OtherProvincePositionCondition;
import com.tj.jst.inner.personrecord.otherProvincePosition.model.OtherProvincePosition;
import com.tj.jst.inner.personrecord.otherProvincePosition.service.IOtherProvincePositionService;
import com.tj.jst.inner.personrecord.otherProvincePosition.service.OtherProvincePositionServiceImpl;

public class OtherProvincePositionInfoAction extends BaseAction {

	// 岗位人员主键
	private String personId;
	// 岗位人员
	private OtherProvincePosition position;
	// 岗位人员list
	private List<OtherProvincePosition> positionList;
	// 提示信息
	private String message;

	private OtherProvincePositionCondition condition = new OtherProvincePositionCondition();

	public void setCondition(OtherProvincePositionCondition condition) {
		this.condition = condition;
	}

	public OtherProvincePositionCondition getCondition() {
		OtherProvincePositionCondition sessionCondition = (OtherProvincePositionCondition) get(getActionName());
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
		IOtherProvincePositionService service = new OtherProvincePositionServiceImpl();
		// 分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
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

	public OtherProvincePosition getPosition() {
		return position;
	}

	public void setPosition(OtherProvincePosition position) {
		this.position = position;
	}

	public List<OtherProvincePosition> getPositionList() {
		return positionList;
	}

	public void setPositionList(List<OtherProvincePosition> positionList) {
		this.positionList = positionList;
	}


}
