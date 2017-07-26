package com.tj.jst.inner.personrecord.position.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.personrecord.position.condition.PositionCondition;
import com.tj.jst.inner.personrecord.position.model.Position;
import com.tj.jst.inner.personrecord.position.service.IPositionService;
import com.tj.jst.inner.personrecord.position.service.PositionServiceImpl;

public class PositionInfoAction extends BaseAction {

	// ��λ��Ա����
	private String personId;
	// ��λ��Ա
	private Position position;
	// ��λ��Աlist
	private List<Position> positionList;
	// ��ʾ��Ϣ
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
	 * ��ҳ��ѯ
	 * 
	 * @return
	 */
	public String queryPage() {
		IPositionService service = new PositionServiceImpl();
		// ��ҳ��ѯ
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
