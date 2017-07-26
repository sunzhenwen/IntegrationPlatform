package com.tj.jst.outside.staffmanage.positions.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.corpinto.otherProvince.positions.service.IOtherPositionsService;
import com.tj.jst.outside.corpinto.otherProvince.positions.service.OtherPositionsServiceImpl;
import com.tj.jst.outside.staffmanage.positions.condition.QueryOtherPositionsCondition;
import com.tj.jst.outside.staffmanage.positions.model.Positions;

/**
 * 查询外省岗位人员
 * @author Administrator
 *
 */
public class QueryOtherPositionsAction extends BaseAction {
	
	//岗位人员主键
	private String personId;
	//岗位人员
	private Positions positions;
	//岗位人员list
	private List<Positions> positionsList;
	//提示信息
	private String message;
	
	private QueryOtherPositionsCondition condition = new QueryOtherPositionsCondition();
	
	public void setCondition(QueryOtherPositionsCondition condition) {
		this.condition = condition;
	}

	public QueryOtherPositionsCondition getCondition() {
		QueryOtherPositionsCondition sessionCondition = (QueryOtherPositionsCondition) get(getActionName());
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
		IOtherPositionsService staffService = new OtherPositionsServiceImpl();
		String corpId = (String)this.get("userId");
		this.getCondition().setCorpId(corpId);
		//分页查询
		currentPage = staffService.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "querySuccess";
	}
	
	/**
	 * 取消
	 * @return
	 */
	public String goList()
	{
		return "queryPage";
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
