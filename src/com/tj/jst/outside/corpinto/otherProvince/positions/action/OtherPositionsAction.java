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
 * ��ʡ��λ��Ա
 * @author Administrator
 *
 */
public class OtherPositionsAction extends BaseAction {
	
	//��λ��Ա����
	private String personId;
	//��λ��Ա
	private Positions positions;
	//��λ��Աlist
	private List<Positions> positionsList;
	//��ʾ��Ϣ
	private String message;
	//��λ����
	private List<DictionaryClass> dutys;
	//���֤��
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
	 * ������Ա��Ϣ����ҳ��
	 * 
	 * @return
	 */
	public String addPage() {
		IOtherPositionsService staffService = new OtherPositionsServiceImpl();
		dutys = staffService.queryDuty();
		return "addSuccess";
	}

	/**
	 * ������Ա��Ϣ����
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
	 * ��ת�޸Ľ���
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
	 * ��Ϣ�޸�
	 * 
	 * @return
	 */
	public String modified() {
		IOtherPositionsService staffService = new OtherPositionsServiceImpl();
		message = staffService.modified(positions);
		return "queryPage";
	}

	/**
	 * ɾ��
	 * 
	 * @return
	 */
	public String delete() {
		IOtherPositionsService staffService = new OtherPositionsServiceImpl();
		message = staffService.delete(personId);
		return "queryPage";
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

	/**
     * ������ݿ����Ƿ���ڴ����֤��
     * @return
     */
    public String checkCardId()
    {
    	IOtherPositionsService staffService = new OtherPositionsServiceImpl();
        List list = staffService.checkCardId(cardId);
        //isEmpty���Ϊ�շ���true�����򷵻�false
        JSONArray json = JSONArray.fromObject(list);//��result��ֵ�����ݸ�ҳ��
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
