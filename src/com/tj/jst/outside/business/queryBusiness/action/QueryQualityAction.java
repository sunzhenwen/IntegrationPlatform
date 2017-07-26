package com.tj.jst.outside.business.queryBusiness.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.queryBusiness.condition.QueryQualityCondition;
import com.tj.jst.outside.business.queryBusiness.service.IQueryQualityService;
import com.tj.jst.outside.business.queryBusiness.service.QueryQualityServiceImpl;

/**
 * �����ල
 * @author hhc
 *
 */
public class QueryQualityAction extends BaseAction {
	
	//�����ල����
	private String qualityId;
	//��Ŀ���
	private String prjNum;
	//��Ŀ����
	private String prjName;
	//�����ල
	private Quality quality;
	//��������
	private List<Regional> list;
	//������ʾ��Ϣ
	private String message;
	private String result;
	private String treeStr;
	//��ҵ��֯��������
	private String corpCode;
	//��ҵ����
	private String corpName;
	
	private QueryQualityCondition condition = new QueryQualityCondition();
	
	public void setCondition(QueryQualityCondition condition) {
		this.condition = condition;
	}

	public QueryQualityCondition getCondition() {
		QueryQualityCondition sessionCondition = (QueryQualityCondition) get(getActionName());
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
		IQueryQualityService service = new QueryQualityServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ת�����ල�����޸�ҳ��
	 * @return
	 */
	public String modifyPage()
	{
		IQueryQualityService service = new QueryQualityServiceImpl();
		quality = service.queryById(qualityId);
		return "modifyPage";
	}
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public String queryAppDept()
	{
		IQueryQualityService service = new QueryQualityServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	
	public String queryPrjName()
	{
		IQueryQualityService service = new QueryQualityServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
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
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Regional> getList() {
		return list;
	}

	public void setList(List<Regional> list) {
		this.list = list;
	}

	public String getTreeStr() {
		return treeStr;
	}

	public void setTreeStr(String treeStr) {
		this.treeStr = treeStr;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getQualityId() {
		return qualityId;
	}

	public void setQualityId(String qualityId) {
		this.qualityId = qualityId;
	}

	public Quality getQuality() {
		return quality;
	}

	public void setQuality(Quality quality) {
		this.quality = quality;
	}

}
