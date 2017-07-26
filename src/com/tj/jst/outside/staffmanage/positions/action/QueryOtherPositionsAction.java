package com.tj.jst.outside.staffmanage.positions.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.corpinto.otherProvince.positions.service.IOtherPositionsService;
import com.tj.jst.outside.corpinto.otherProvince.positions.service.OtherPositionsServiceImpl;
import com.tj.jst.outside.staffmanage.positions.condition.QueryOtherPositionsCondition;
import com.tj.jst.outside.staffmanage.positions.model.Positions;

/**
 * ��ѯ��ʡ��λ��Ա
 * @author Administrator
 *
 */
public class QueryOtherPositionsAction extends BaseAction {
	
	//��λ��Ա����
	private String personId;
	//��λ��Ա
	private Positions positions;
	//��λ��Աlist
	private List<Positions> positionsList;
	//��ʾ��Ϣ
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
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		IOtherPositionsService staffService = new OtherPositionsServiceImpl();
		String corpId = (String)this.get("userId");
		this.getCondition().setCorpId(corpId);
		//��ҳ��ѯ
		currentPage = staffService.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "querySuccess";
	}
	
	/**
	 * ȡ��
	 * @return
	 */
	public String goList()
	{
		return "queryPage";
	}
	
	/**
	 * ����
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
