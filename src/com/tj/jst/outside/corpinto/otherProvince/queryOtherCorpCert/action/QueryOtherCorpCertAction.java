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
 * ��ѯ��ʡ������ҵӵ������
 * 
 * @author Administrator
 *
 */
public class QueryOtherCorpCertAction extends BaseAction {

	private String id;
	private Certdetail certdetail;
	private String corpCode;// ��ҵ��֯��������֤
	private String message;// ������Ϣ
	private String result;
	private String qualificationsType;
	private String specialtyType;
	private List<DictionaryClass> qualificationsTypes;//�����ʸ�����(����)
	private List<DictionaryClass> tradeTypeNums;//�����ʸ�����(����)
	private List<DictionaryClass> specialtyTypes;//רҵ���(����)
	private List<DictionaryClass> titleLevelNums;//�����ʸ�ȼ�(����)
	
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
	 * ��ҳ�鿴
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
	 * ��ת���ҳ��
	 * 
	 * @return
	 */
	public String addPage() {
		IQueryOtherCorpCertService service = new QueryOtherCorpCertServiceImpl();
		//�����ʸ�����(����)
		qualificationsTypes = service.qualificationsTypes();
		return "addPage";
	}
	
	/**
	 * ���
	 * 
	 * @return
	 */
	public String add() {
		IQueryOtherCorpCertService service = new QueryOtherCorpCertServiceImpl();
		//��ȡ��ҵ����
		certdetail.setCorpId((String)this.get("userId"));
		//��ȡ��ҵ����
		certdetail.setCorpName((String)this.get("userName"));
		//��ȡ��ҵ��֯��������
		certdetail.setCorpCode((String)this.get("cropCode"));
		service.add(certdetail);
		return "query";
	}
	
	/**
	 * ɾ��
	 * 
	 * @return
	 */
	public String deleteCer() {
		IQueryOtherCorpCertService service = new QueryOtherCorpCertServiceImpl();
		service.deleteCer(id);
		return "query";
	}
	
	/**
	 * �����ʸ�����(�ֵ��TBTRADETYPEDIC)
	 * @return
	 */
	public String queryTradeTypeNum()
    {
		IQueryOtherCorpCertService service = new QueryOtherCorpCertServiceImpl();
		tradeTypeNums = service.queryTradeTypeNum(qualificationsType);
		JSONArray json = JSONArray.fromObject(tradeTypeNums);//��result��ֵ�����ݸ�ҳ�� 
        result = json.toString();
        return "success";
    }
	
	/**
	 * �����ʸ�ȼ�(TBCERTTITLELEVELDIC)
	 * @return
	 */
	public String queryRating()
    {
		IQueryOtherCorpCertService service = new QueryOtherCorpCertServiceImpl();
		titleLevelNums = service.queryRating(qualificationsType);
		JSONArray json = JSONArray.fromObject(titleLevelNums);//��result��ֵ�����ݸ�ҳ�� 
        result = json.toString();
        return "success";
    }
	
	/**
	 * רҵ���(TBTRADETYPEBOUNDDIC)
	 * @return
	 */
	public String specialtyType()
    {
		IQueryOtherCorpCertService service = new QueryOtherCorpCertServiceImpl();
		specialtyTypes = service.specialtyType(specialtyType);
		JSONArray json = JSONArray.fromObject(specialtyTypes);//��result��ֵ�����ݸ�ҳ�� 
        result = json.toString();
        return "success";
    }
	
	/**
	 * ����
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
