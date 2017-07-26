package com.tj.jst.outside.business.tenderInfo.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.tenderInfo.condition.TenderInfoCondition;
import com.tj.jst.outside.business.tenderInfo.model.TenderInfo;
import com.tj.jst.outside.business.tenderInfo.model.TenderInfoAdd;
import com.tj.jst.outside.business.tenderInfo.service.ITenderInfoService;
import com.tj.jst.outside.business.tenderInfo.service.TenderInfoServiceImpl;

/**
 * ��Ͷ��
 * @author hhc
 *
 */
public class TenderInfoAction extends BaseAction {
	
	private TenderInfo tenderInfo;
	private TenderInfoAdd tenderInfoAdd;
	private String tenderId;
	private String tenderNum;
	private List<Construction> list;
	private List<DictionaryClass> tenderClassNums;//�б�����(TBTENDERCLASSDIC)
	private List<DictionaryClass> tenderTypeNums;//�б귽ʽ(TBTENDERTYPEDIC)
	private List<DictionaryClass> idCardTypeNums;//��ȫ��������֤������(TBIDCARDTYPEDIC)
	private String message;
		
	private TenderInfoCondition condition = new TenderInfoCondition();
	
	public void setCondition(TenderInfoCondition condition) {
		this.condition = condition;
	}

	public TenderInfoCondition getCondition() {
		TenderInfoCondition sessionCondition = (TenderInfoCondition) get(getActionName());
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
		ITenderInfoService service = new TenderInfoServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		Login login = (Login)this.get("login");
		list = service.queryProjectInfo(login.getCorpCode());
		return "queryPage";
	}

	/**
	 * ��ת���ҳ��
	 * @return
	 */
	public String addPage()
	{
		ITenderInfoService service = new TenderInfoServiceImpl();
		tenderClassNums = service.queryTenderClassNum();//�б�����(TBTENDERCLASSDIC)
		tenderTypeNums = service.queryTenderTypeNum();//�б귽ʽ(TBTENDERTYPEDIC)
		idCardTypeNums = service.queryIdCardTypeNum();//��ȫ��������֤������(TBIDCARDTYPEDIC)
		return "addPage";
	}

	/**
	 * ��ת���ҳ��
	 * @return
	 */
	public String add()
	{
		ITenderInfoService service = new TenderInfoServiceImpl();
		message = service.add(tenderInfoAdd);
		return "add";
	}
	
	public String queryTenderById()
	{
		ITenderInfoService service = new TenderInfoServiceImpl();
		tenderInfo = service.queryTenderById(tenderNum);
		return "queryById";
	}
	
	
	/**
	 * ������Ŀ�����б�Ŀ¼
	 * @return
	 */
	public String goList()
	{
		return "query";
	}
	
	/**
	 * ����ҵ�����Ŀ¼
	 * @return
	 */
	public String goBack()
	{
		return "goBusiness";
	}

	public List<Construction> getList() {
		return list;
	}

	public void setList(List<Construction> list) {
		this.list = list;
	}

	public String getTenderId() {
		return tenderId;
	}

	public void setTenderId(String tenderId) {
		this.tenderId = tenderId;
	}

	public TenderInfo getTenderInfo() {
		return tenderInfo;
	}

	public void setTenderInfo(TenderInfo tenderInfo) {
		this.tenderInfo = tenderInfo;
	}

	public String getTenderNum() {
		return tenderNum;
	}

	public void setTenderNum(String tenderNum) {
		this.tenderNum = tenderNum;
	}

	public TenderInfoAdd getTenderInfoAdd() {
		return tenderInfoAdd;
	}

	public void setTenderInfoAdd(TenderInfoAdd tenderInfoAdd) {
		this.tenderInfoAdd = tenderInfoAdd;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<DictionaryClass> getTenderClassNums() {
		return tenderClassNums;
	}

	public void setTenderClassNums(List<DictionaryClass> tenderClassNums) {
		this.tenderClassNums = tenderClassNums;
	}

	public List<DictionaryClass> getTenderTypeNums() {
		return tenderTypeNums;
	}

	public void setTenderTypeNums(List<DictionaryClass> tenderTypeNums) {
		this.tenderTypeNums = tenderTypeNums;
	}

	public List<DictionaryClass> getIdCardTypeNums() {
		return idCardTypeNums;
	}

	public void setIdCardTypeNums(List<DictionaryClass> idCardTypeNums) {
		this.idCardTypeNums = idCardTypeNums;
	}
	
}
