package com.tj.jst.outside.business.design.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.design.condition.DesignCondition;
import com.tj.jst.outside.business.design.model.Design;
import com.tj.jst.outside.business.design.model.DesignQualification;
import com.tj.jst.outside.business.design.service.DesignServiceImpl;
import com.tj.jst.outside.business.design.service.IDesignService;

/**
 * ���
 * @author hhc
 *
 */
public class DesignAction extends BaseAction {
	
	//�������
	private String designId;
	//��Ŀ���
	private String prjNum;
	//��Ŀ����
	private String prjName;
	//��Ʊ���
	private String designCode;
	//���ʵ����
	private Design design;
	//��Ƶ�λ����
	private List<DesignQualification> designQualifications;
	//��������
	private List<Regional> list;
	//��Ŀ����ʵ������
	private String prjId;
	
	
	
	

	//������ʾ��Ϣ
	private String message;
	private String result;
	private String treeStr;
	//��ҵ��֯��������
	private String corpCode;
	//��ҵ����
	private String corpName;
	//�ӱ�����
	private String id;
	
	private DesignCondition condition = new DesignCondition(((Login)this.get("login")).getCorpCode());
	
	public void setCondition(DesignCondition condition) {
		this.condition = condition;
	}

	public DesignCondition getCondition() {
		DesignCondition sessionCondition = (DesignCondition) get(getActionName());
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
		IDesignService service = new DesignServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ת�������ҳ��
	 * @return
	 */
	public String addPage()
	{
		Login login = (Login)this.get("login");
		//��ҵ��֯��������
		corpCode = login.getCorpCode();
		//��ҵ����
		corpName = login.getUserName();
		//������Ʊ��
//		Calendar c = Calendar.getInstance();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmssSSS");
//        designCode = simpleDateFormat.format(c.getTime());
		
		return "addPage";
	}
	
	/**
	 * �������
	 * @return
	 */
	public String add()
	{
		IDesignService service = new DesignServiceImpl();
		Login login = (Login)this.get("login");
		design.setApplyCorpCode(login.getCorpCode());
		designId = service.add(design,designQualifications);
		return "queryAdd";
	}
	
	/**
	 * ��ת��������޸�ҳ��
	 * @return
	 */
	public String modifyPage()
	{
		IDesignService service = new DesignServiceImpl();
		design = service.queryById(designId);
		return "modifyPage";
	}
	
	/**
	 * ��������޸�
	 * @return
	 */
	public String modify()
	{
		IDesignService service = new DesignServiceImpl();
		service.modify(design,designQualifications);
		return "query";
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String delete()
	{
		IDesignService service = new DesignServiceImpl();
		service.delete(designId);
		return "query";
	}
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public String queryAppDept()
	{
		IDesignService service = new DesignServiceImpl();
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

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getDesignCode() {
		return designCode;
	}

	public void setDesignCode(String designCode) {
		this.designCode = designCode;
	}

	public Design getDesign() {
		return design;
	}

	public void setDesign(Design design) {
		this.design = design;
	}

	public List<DesignQualification> getDesignQualifications() {
		return designQualifications;
	}

	public void setDesignQualifications(
			List<DesignQualification> designQualifications) {
		this.designQualifications = designQualifications;
	}

	public String getDesignId() {
		return designId;
	}

	public void setDesignId(String designId) {
		this.designId = designId;
	}

}
