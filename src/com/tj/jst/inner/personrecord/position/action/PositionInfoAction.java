package com.tj.jst.inner.personrecord.position.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.personrecord.position.condition.PositionCondition;
import com.tj.jst.inner.personrecord.position.model.Position;
import com.tj.jst.inner.personrecord.position.service.IPositionService;
import com.tj.jst.inner.personrecord.position.service.PositionServiceImpl;

public class PositionInfoAction extends BaseAction {

	// 岗位人员主键
	private String personId;
	// 岗位人员
	private Position position;
	// 岗位人员list
	private List<Position> positionList;
	// 提示信息
	private String message;

	private PositionCondition condition = new PositionCondition();

	public void setCondition(PositionCondition condition) {
		this.condition = condition;
	}

	public PositionCondition getCondition() {
		PositionCondition sessionCondition = (PositionCondition) get(getActionName());
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
		IPositionService service = new PositionServiceImpl();
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

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public List<Position> getPositionList() {
		return positionList;
	}

	public void setPositionList(List<Position> positionList) {
		this.positionList = positionList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
