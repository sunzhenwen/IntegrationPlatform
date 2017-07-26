package com.tj.jst.outside.corpinto.otherProvince.queryOtherCorpCert.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.contractFiling.model.Certdetail;
import com.tj.jst.outside.corpinto.otherProvince.queryOtherCorpCert.condition.QueryOtherCorpCertCondition;
import com.tj.jst.outside.corpinto.otherProvince.queryOtherCorpCert.service.IQueryOtherCorpCertService;
import com.tj.jst.outside.corpinto.otherProvince.queryOtherCorpCert.service.QueryOtherCorpCertServiceImpl;

/**
 * 查询外省备案企业拥有资质
 * 
 * @author Administrator
 *
 */
public class QueryOtherCorpCertAction extends BaseAction {

	private String id;
	private Certdetail certdetail;
	private String corpCode;// 企业组织机构代码证
	private String message;// 返回信息
	private String result;
	private String qualificationsType;
	private String specialtyType;
	private List<DictionaryClass> qualificationsTypes;//资质资格类型(下拉)
	private List<DictionaryClass> tradeTypeNums;//资质资格序列(下拉)
	private List<DictionaryClass> specialtyTypes;//专业类别(下拉)
	private List<DictionaryClass> titleLevelNums;//资质资格等级(下拉)
	
	private QueryOtherCorpCertCondition condition = new QueryOtherCorpCertCondition();

	public void setCondition(QueryOtherCorpCertCondition condition) {
		this.condition = condition;
	}

	public QueryOtherCorpCertCondition getCondition() {
		QueryOtherCorpCertCondition sessionCondition = (QueryOtherCorpCertCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 分页查看
	 * 
	 * @return
	 */
	public String queryPage() {
		IQueryOtherCorpCertService service = new QueryOtherCorpCertServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		currentPage = service.queryPage(condition);
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 跳转添加页面
	 * 
	 * @return
	 */
	public String addPage() {
		IQueryOtherCorpCertService service = new QueryOtherCorpCertServiceImpl();
		//资质资格类型(下拉)
		qualificationsTypes = service.qualificationsTypes();
		return "addPage";
	}
	
	/**
	 * 添加
	 * 
	 * @return
	 */
	public String add() {
		IQueryOtherCorpCertService service = new QueryOtherCorpCertServiceImpl();
		//获取企业主键
		certdetail.setCorpId((String)this.get("userId"));
		//获取企业名称
		certdetail.setCorpName((String)this.get("userName"));
		//获取企业组织机构代码
		certdetail.setCorpCode((String)this.get("cropCode"));
		service.add(certdetail);
		return "query";
	}
	
	/**
	 * 删除
	 * 
	 * @return
	 */
	public String deleteCer() {
		IQueryOtherCorpCertService service = new QueryOtherCorpCertServiceImpl();
		service.deleteCer(id);
		return "query";
	}
	
	/**
	 * 资质资格序列(字典表：TBTRADETYPEDIC)
	 * @return
	 */
	public String queryTradeTypeNum()
    {
		IQueryOtherCorpCertService service = new QueryOtherCorpCertServiceImpl();
		tradeTypeNums = service.queryTradeTypeNum(qualificationsType);
		JSONArray json = JSONArray.fromObject(tradeTypeNums);//给result赋值，传递给页面 
        result = json.toString();
        return "success";
    }
	
	/**
	 * 资质资格等级(TBCERTTITLELEVELDIC)
	 * @return
	 */
	public String queryRating()
    {
		IQueryOtherCorpCertService service = new QueryOtherCorpCertServiceImpl();
		titleLevelNums = service.queryRating(qualificationsType);
		JSONArray json = JSONArray.fromObject(titleLevelNums);//给result赋值，传递给页面 
        result = json.toString();
        return "success";
    }
	
	/**
	 * 专业类别(TBTRADETYPEBOUNDDIC)
	 * @return
	 */
	public String specialtyType()
    {
		IQueryOtherCorpCertService service = new QueryOtherCorpCertServiceImpl();
		specialtyTypes = service.specialtyType(specialtyType);
		JSONArray json = JSONArray.fromObject(specialtyTypes);//给result赋值，传递给页面 
        result = json.toString();
        return "success";
    }
	
	/**
	 * 返回
	 * 
	 * @return
	 */
	public String goBack() {
		return "goBusiness";
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Certdetail getCertdetail() {
		return certdetail;
	}

	public void setCertdetail(Certdetail certdetail) {
		this.certdetail = certdetail;
	}

	public List<DictionaryClass> getQualificationsTypes() {
		return qualificationsTypes;
	}

	public void setQualificationsTypes(List<DictionaryClass> qualificationsTypes) {
		this.qualificationsTypes = qualificationsTypes;
	}

	public List<DictionaryClass> getTradeTypeNums() {
		return tradeTypeNums;
	}

	public void setTradeTypeNums(List<DictionaryClass> tradeTypeNums) {
		this.tradeTypeNums = tradeTypeNums;
	}

	public List<DictionaryClass> getSpecialtyTypes() {
		return specialtyTypes;
	}

	public void setSpecialtyTypes(List<DictionaryClass> specialtyTypes) {
		this.specialtyTypes = specialtyTypes;
	}

	public List<DictionaryClass> getTitleLevelNums() {
		return titleLevelNums;
	}

	public void setTitleLevelNums(List<DictionaryClass> titleLevelNums) {
		this.titleLevelNums = titleLevelNums;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getQualificationsType() {
		return qualificationsType;
	}

	public void setQualificationsType(String qualificationsType) {
		this.qualificationsType = qualificationsType;
	}

	public String getSpecialtyType() {
		return specialtyType;
	}

	public void setSpecialtyType(String specialtyType) {
		this.specialtyType = specialtyType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
