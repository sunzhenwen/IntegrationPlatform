package com.tj.jst.base.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.exception.BaseException;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;

/**
 * ����action��
 * 
 * @author hhc
 *
 */

public class BaseAction extends ActionSupport implements Preparable,
		ServletRequestAware, ServletResponseAware 
{

	private static final long serialVersionUID = 1L;
	// ��ȡrequest����
	protected HttpServletRequest request;
	// ��ȡresponse����
	HttpServletResponse response;

	protected Page currentPage;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	// ����������֤������
	private List<DictionaryClass> idCardType;
	// ��ҵ�Ǽ�ע������
	private List<DictionaryClass> economicNum;
	// ע���ʱ�����
	private List<DictionaryClass> principalUnit;
	// ���������
	private List<DictionaryClass> nations;
	// ����Ͷ��������
	private List<DictionaryClass> ivestors;
	// ��ҵ����
	private List<DictionaryClass> enterpriseTypes;

	public String execute() throws Exception {

		throw new BaseException("�����������Դ������!!");
	}

	/**
	 * ��ȡsession�ж���,map��ʽ����key
	 * 
	 * @param name
	 * @return
	 */
	protected Object get(String name) {
		return ActionContext.getContext().getSession().get(name);
	}

	/**
	 * ���������session,map��ʽkey��value
	 * 
	 * @param name
	 * @param value
	 */
	protected void set(String name, Object value) {
		ActionContext.getContext().getSession().put(name, value);
	}

	// ��ȡaction����·����
	public String getActionName() {
		return this.getClass().getName();
	}

	// �Ƴ�session�еĶ���
	protected void remove(Object key) {
		ActionContext.getContext().getSession().remove(key);
	}

	// ����session
	public void clearSession() {
		ServletActionContext.getRequest().getSession().invalidate();
	}

	public Page getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Page currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		this.clearErrorsAndMessages();
	}

	/**
	 * ��ѯ�ֵ��
	 */
	public void queryDictionary() {
		BaseDao dao = new BaseDao();
		// ֤������
		idCardType = dao.queryIdCardType();
		// ��ҵ�Ǽ�ע������
		economicNum = dao.queryEconomicNum();
		// ע���ʱ�����
		principalUnit = dao.queryPrincipalUnit();
		// ��ѯ���������
		nations = dao.queryNation();
		// ����Ͷ��������
		ivestors = dao.queryIvestor();
		// ��ѯ��ҵ����
		enterpriseTypes = dao.queryEnterpriseTypes();
	}

	public List<DictionaryClass> getIdCardType() {
		return idCardType;
	}

	public void setIdCardType(List<DictionaryClass> idCardType) {
		this.idCardType = idCardType;
	}

	public List<DictionaryClass> getEconomicNum() {
		return economicNum;
	}

	public void setEconomicNum(List<DictionaryClass> economicNum) {
		this.economicNum = economicNum;
	}

	public List<DictionaryClass> getPrincipalUnit() {
		return principalUnit;
	}

	public void setPrincipalUnit(List<DictionaryClass> principalUnit) {
		this.principalUnit = principalUnit;
	}

	public List<DictionaryClass> getNations() {
		return nations;
	}

	public void setNations(List<DictionaryClass> nations) {
		this.nations = nations;
	}

	public List<DictionaryClass> getIvestors() {
		return ivestors;
	}

	public void setIvestors(List<DictionaryClass> ivestors) {
		this.ivestors = ivestors;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public List<DictionaryClass> getEnterpriseTypes() {
		return enterpriseTypes;
	}

	public void setEnterpriseTypes(List<DictionaryClass> enterpriseTypes) {
		this.enterpriseTypes = enterpriseTypes;
	}

}
