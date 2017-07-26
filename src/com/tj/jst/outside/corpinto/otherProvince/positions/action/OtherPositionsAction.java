package com.tj.jst.outside.corpinto.otherProvince.positions.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.otherProvince.positions.condition.OtherPositionsCondition;
import com.tj.jst.outside.corpinto.otherProvince.positions.service.IOtherPositionsService;
import com.tj.jst.outside.corpinto.otherProvince.positions.service.OtherPositionsServiceImpl;
import com.tj.jst.outside.staffmanage.positions.model.Positions;

/**
 * 外省岗位人员
 * @author Administrator
 *
 */
public class OtherPositionsAction extends BaseAction {
	
	//岗位人员主键
	private String personId;
	//岗位人员
	private Positions positions;
	//岗位人员list
	private List<Positions> positionsList;
	//提示信息
	private String message;
	//岗位名称
	private List<DictionaryClass> dutys;
	//身份证号
	private String cardId;
	private String result;
	
	private OtherPositionsCondition condition = new OtherPositionsCondition();
	
	public void setCondition(OtherPositionsCondition condition) {
		this.condition = condition;
	}

	public OtherPositionsCondition getCondition() {
		OtherPositionsCondition sessionCondition = (OtherPositionsCondition) get(getActionName());
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
	 * 技术人员信息增加页面
	 * 
	 * @return
	 */
	public String addPage() {
		IOtherPositionsService staffService = new OtherPositionsServiceImpl();
		dutys = staffService.queryDuty();
		return "addSuccess";
	}

	/**
	 * 技术人员信息增加
	 * 
	 * @return
	 */
	public String add() {
		IOtherPositionsService staffService = new OtherPositionsServiceImpl();
		String userName = (String)this.get("userName");
		String cropCode = (String)this.get("cropCode");
		String corpId = (String)this.get("userId");
		String provinceName = (String)this.get("provinceName");
		String cityName = (String)this.get("cityName");
		String countyName = (String)this.get("countyName");
		
		positions.setEntName(userName);
		positions.setCorpCode(cropCode);
		positions.setCorpId(corpId);
		positions.setProvinceName(provinceName);
		positions.setCityName(cityName);
		positions.setCountyName(countyName);
		message = staffService.add(positions);
		return "queryPage";
	}
	
	/**
	 * 跳转修改界面
	 * 
	 * @return
	 */
	public String modifiedPage() {
		IOtherPositionsService staffService = new OtherPositionsServiceImpl();
		dutys = staffService.queryDuty();
		positions = staffService.queryById(personId);
		return "modifySuccess";
	}

	/**
	 * 信息修改
	 * 
	 * @return
	 */
	public String modified() {
		IOtherPositionsService staffService = new OtherPositionsServiceImpl();
		message = staffService.modified(positions);
		return "queryPage";
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String delete() {
		IOtherPositionsService staffService = new OtherPositionsServiceImpl();
		message = staffService.delete(personId);
		return "queryPage";
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

	/**
     * 检测数据库中是否存在此身份证号
     * @return
     */
    public String checkCardId()
    {
    	IOtherPositionsService staffService = new OtherPositionsServiceImpl();
        List list = staffService.checkCardId(cardId);
        //isEmpty如果为空返回true，否则返回false
        JSONArray json = JSONArray.fromObject(list);//给result赋值，传递给页面
        result = json.toString();
        System.out.println("result= "+result);
        return "success";
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

	public List<DictionaryClass> getDutys() {
		return dutys;
	}

	public void setDutys(List<DictionaryClass> dutys) {
		this.dutys = dutys;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

}
