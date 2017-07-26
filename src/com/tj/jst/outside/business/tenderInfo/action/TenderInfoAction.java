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
 * 招投标
 * @author hhc
 *
 */
public class TenderInfoAction extends BaseAction {
	
	private TenderInfo tenderInfo;
	private TenderInfoAdd tenderInfoAdd;
	private String tenderId;
	private String tenderNum;
	private List<Construction> list;
	private List<DictionaryClass> tenderClassNums;//招标类型(TBTENDERCLASSDIC)
	private List<DictionaryClass> tenderTypeNums;//招标方式(TBTENDERTYPEDIC)
	private List<DictionaryClass> idCardTypeNums;//安全生产管理证件类型(TBIDCARDTYPEDIC)
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
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		ITenderInfoService service = new TenderInfoServiceImpl();
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		Login login = (Login)this.get("login");
		list = service.queryProjectInfo(login.getCorpCode());
		return "queryPage";
	}

	/**
	 * 跳转添加页面
	 * @return
	 */
	public String addPage()
	{
		ITenderInfoService service = new TenderInfoServiceImpl();
		tenderClassNums = service.queryTenderClassNum();//招标类型(TBTENDERCLASSDIC)
		tenderTypeNums = service.queryTenderTypeNum();//招标方式(TBTENDERTYPEDIC)
		idCardTypeNums = service.queryIdCardTypeNum();//安全生产管理证件类型(TBIDCARDTYPEDIC)
		return "addPage";
	}

	/**
	 * 跳转添加页面
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
	 * 返回项目报建列表目录
	 * @return
	 */
	public String goList()
	{
		return "query";
	}
	
	/**
	 * 返回业务办理目录
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
