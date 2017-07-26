package com.tj.jst.outside.staffmanage.positions.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.staffmanage.positions.condition.PositionsCondition;
import com.tj.jst.outside.staffmanage.positions.model.Positions;
import com.tj.jst.outside.staffmanage.positions.service.IPositionsService;
import com.tj.jst.outside.staffmanage.positions.service.PositionsServiceImpl;

/**
 * 岗位人员
 * @author Administrator
 *
 */
public class PositionsAction extends BaseAction {
	
	//岗位人员主键
	private String personId;
	//岗位人员
	private Positions positions;
	//岗位人员list
	private List<Positions> positionsList;
	//提示信息
	private String message;
	
	private PositionsCondition condition = new PositionsCondition();
	
	public void setCondition(PositionsCondition condition) {
		this.condition = condition;
	}

	public PositionsCondition getCondition() {
		PositionsCondition sessionCondition = (PositionsCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		IPositionsService staffService = new PositionsServiceImpl();
		String userName = (String)this.get("userName");
		this.getCondition().setCorpName(userName);
		//分页查询
		currentPage = staffService.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "positionsSuccess";
	}
	
	/**
	 * 返回
	 * @return
	 */
	public String goBack()
	{
		return "goBusiness";
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

	public List<Positions> getPositionsList() {
		return positionsList;
	}

	public void setPositionsList(List<Positions> positionsList) {
		this.positionsList = positionsList;
	}

	public Positions getPositions() {
		return positions;
	}

	public void setPositions(Positions positions) {
		this.positions = positions;
	}

}
