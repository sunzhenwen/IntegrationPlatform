package com.tj.jst.outside.business.queryprojection.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.complete.service.CompleteServiceImpl;
import com.tj.jst.outside.business.complete.service.ICompleteService;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.permit.service.IPermitService;
import com.tj.jst.outside.business.permit.service.PermitServiceImpl;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.queryprojection.condition.QueryProjectionCondition;
import com.tj.jst.outside.business.queryprojection.model.Filing;
import com.tj.jst.outside.business.queryprojection.model.Permit;
import com.tj.jst.outside.business.queryprojection.model.Plan;
import com.tj.jst.outside.business.queryprojection.model.ProjectModel;
import com.tj.jst.outside.business.queryprojection.model.Ready;
import com.tj.jst.outside.business.queryprojection.model.Tender;
import com.tj.jst.outside.business.queryprojection.service.IQueryProjectService;
import com.tj.jst.outside.business.queryprojection.service.QueryProjectServiceImpl;
import com.tj.jst.outside.business.safety.model.Safety;
import com.tj.jst.outside.business.tenderInfo.model.TenderInfo;

/**
 * 业务查询
 * 
 * @author Administrator
 *
 */
public class QueryProjectAction extends BaseAction {

	//招投标
	private TenderInfo tenderInfo;
	//合同备案
	private ContractFiling contractFiling;
	private String recordId;
	private String tenderNum;//中标通知书编号
	private String corpCode;// 企业组织机构代码证
	private String result;// 返回结果
	private ProjectModel project;// 项目Modle类
	private String prjName;// 项目名称
	private String prjID;// 项目Id
	private String prjNum;// 项目编号
	private List<Filing> filingList;
	private Filing filing;
	private String filingId;
	private List<Permit> permitList;
	private Permit permit;
	private String permitId;
	private List<Plan> planList;
	private Plan plan;
	private String planId;
	private List<Ready> readyList;
	private Ready ready;
	private String readyId;
	private List<Tender> tenderList;
	private Tender tender;
	private String tenderId;
	private List<Quality> qualityList;
	private Quality quality;
	private String qualityId;
	private List<Safety> safetyList;
	private Safety safety;
	private String safetyId;
	//证件类型
	private List<DictionaryClass> cardTypeNums;
	//工程类型
	private List<DictionaryClass> projectTypes;
	public List<DictionaryClass> getProjectTypes() {
		return projectTypes;
	}

	public void setProjectTypes(List<DictionaryClass> projectTypes) {
		this.projectTypes = projectTypes;
	}

	private Complete complete;
	private String completeId;
	//结构体系
	private List<DictionaryClass> prjStructureTypeNums;

	private QueryProjectionCondition condition = new QueryProjectionCondition(
			((Login) this.get("login")).getCorpCode());

	public void setCondition(QueryProjectionCondition condition) {
		this.condition = condition;
	}

	public QueryProjectionCondition getCondition() {
		QueryProjectionCondition sessionCondition = (QueryProjectionCondition) get(getActionName());
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
		IQueryProjectService service = new QueryProjectServiceImpl();
		currentPage = service.queryPage(condition);
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 查询项目详细
	 * 
	 * @return
	 */
	public String queryProjectInfo() {
		IQueryProjectService service = new QueryProjectServiceImpl();
		project = service.queryProjectInfo(prjNum);
		filingList = service.queryFilingList(prjNum);
		planList = service.queryPlanList(prjID);
		readyList = service.queryReadyList(prjNum);
		permitList = service.queryPermitList(prjNum);
		tenderList = service.queryTenderList(prjNum);
		qualityList = service.queryQualityList(prjNum);
		safetyList = service.querySafetyList(prjNum);
		return "queryInfo";
	}

	/**
	 * 查询招投标详细页面
	 * @return
	 */
	public String queryTenderById()
	{
		IQueryProjectService service = new QueryProjectServiceImpl();
		tenderInfo = service.queryTenderById(tenderNum);
		return "queryTenderById";
	}
	
	/**
	 * 查询合同备案详细页面
	 * @return
	 */
	public String queryFilingById()
	{
		IQueryProjectService service = new QueryProjectServiceImpl();
		contractFiling = service.queryFilingById(recordId);
		return "queryFilingById";
	}

	/**
	 * 查询质量详细页面
	 * @return
	 */
	public String queryQualityById()
	{
		IQueryProjectService service = new QueryProjectServiceImpl();
		quality = service.queryQualityById(qualityId);
		return "queryQualityById";
	}
	
	/**
	 * 查询安全详细页面
	 * @return
	 */
	public String querySafetyById()
	{
		IQueryProjectService service = new QueryProjectServiceImpl();
		projectTypes = service.queryProjectTypes();
		safety = service.querySafetyById(safetyId);
		return "querySafetyById";
	}

	/**
	 * 查询竣工验收详细页面
	 * @return
	 */
	public String queryCompleteById()
	{
		IQueryProjectService service = new QueryProjectServiceImpl();
		complete = service.queryCompleteById(completeId);
		ICompleteService st = new CompleteServiceImpl();
		prjStructureTypeNums = st.queryPrjStructureTypeNums();
		return "queryCompleteById";
	}
	
	/**
	 * 查询施工许可详细页面
	 * @return
	 */
	public String queryPermitById()
	{
		IQueryProjectService service = new QueryProjectServiceImpl();
		permit = service.queryPermitById(permitId);
		IPermitService sr = new PermitServiceImpl();
		cardTypeNums = sr.queryCardTypeNums();
		return "queryPermitById";
	}
	
	public String goBack() {
		return "goBusiness";
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public ProjectModel getProject() {
		return project;
	}

	public void setProject(ProjectModel project) {
		this.project = project;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getPrjID() {
		return prjID;
	}

	public void setPrjID(String prjID) {
		this.prjID = prjID;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

	public List<Filing> getFilingList() {
		return filingList;
	}

	public void setFilingList(List<Filing> filingList) {
		this.filingList = filingList;
	}

	public Filing getFiling() {
		return filing;
	}

	public void setFiling(Filing filing) {
		this.filing = filing;
	}

	public String getFilingId() {
		return filingId;
	}

	public void setFilingId(String filingId) {
		this.filingId = filingId;
	}

	public List<Permit> getPermitList() {
		return permitList;
	}

	public void setPermitList(List<Permit> permitList) {
		this.permitList = permitList;
	}

	public Permit getPermit() {
		return permit;
	}

	public void setPermit(Permit permit) {
		this.permit = permit;
	}

	public String getPermitId() {
		return permitId;
	}

	public void setPermitId(String permitId) {
		this.permitId = permitId;
	}

	public List<Plan> getPlanList() {
		return planList;
	}

	public void setPlanList(List<Plan> planList) {
		this.planList = planList;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public List<Ready> getReadyList() {
		return readyList;
	}

	public void setReadyList(List<Ready> readyList) {
		this.readyList = readyList;
	}

	public Ready getReady() {
		return ready;
	}

	public void setReady(Ready ready) {
		this.ready = ready;
	}

	public String getReadyId() {
		return readyId;
	}

	public void setReadyId(String readyId) {
		this.readyId = readyId;
	}

	public List<Tender> getTenderList() {
		return tenderList;
	}

	public void setTenderList(List<Tender> tenderList) {
		this.tenderList = tenderList;
	}

	public Tender getTender() {
		return tender;
	}

	public void setTender(Tender tender) {
		this.tender = tender;
	}

	public String getTenderId() {
		return tenderId;
	}

	public void setTenderId(String tenderId) {
		this.tenderId = tenderId;
	}

	public List<Quality> getQualityList() {
		return qualityList;
	}

	public void setQualityList(List<Quality> qualityList) {
		this.qualityList = qualityList;
	}

	public Quality getQuality() {
		return quality;
	}

	public void setQuality(Quality quality) {
		this.quality = quality;
	}

	public String getQualityId() {
		return qualityId;
	}

	public void setQualityId(String qualityId) {
		this.qualityId = qualityId;
	}

	public List<Safety> getSafetyList() {
		return safetyList;
	}

	public void setSafetyList(List<Safety> safetyList) {
		this.safetyList = safetyList;
	}

	public Safety getSafety() {
		return safety;
	}

	public void setSafety(Safety safety) {
		this.safety = safety;
	}

	public String getSafetyId() {
		return safetyId;
	}

	public void setSafetyId(String safetyId) {
		this.safetyId = safetyId;
	}

	public String getTenderNum() {
		return tenderNum;
	}

	public void setTenderNum(String tenderNum) {
		this.tenderNum = tenderNum;
	}

	public TenderInfo getTenderInfo() {
		return tenderInfo;
	}

	public void setTenderInfo(TenderInfo tenderInfo) {
		this.tenderInfo = tenderInfo;
	}

	public ContractFiling getContractFiling() {
		return contractFiling;
	}

	public void setContractFiling(ContractFiling contractFiling) {
		this.contractFiling = contractFiling;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public List<DictionaryClass> getCardTypeNums() {
		return cardTypeNums;
	}

	public void setCardTypeNums(List<DictionaryClass> cardTypeNums) {
		this.cardTypeNums = cardTypeNums;
	}

	public Complete getComplete() {
		return complete;
	}

	public void setComplete(Complete complete) {
		this.complete = complete;
	}

	public String getCompleteId() {
		return completeId;
	}

	public void setCompleteId(String completeId) {
		this.completeId = completeId;
	}

	public List<DictionaryClass> getPrjStructureTypeNums() {
		return prjStructureTypeNums;
	}

	public void setPrjStructureTypeNums(List<DictionaryClass> prjStructureTypeNums) {
		this.prjStructureTypeNums = prjStructureTypeNums;
	}

}
