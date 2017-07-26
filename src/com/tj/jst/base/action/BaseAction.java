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
 * 基础action类
 * 
 * @author hhc
 *
 */

public class BaseAction extends ActionSupport implements Preparable,
		ServletRequestAware, ServletResponseAware 
{

	private static final long serialVersionUID = 1L;
	// 获取request对象
	protected HttpServletRequest request;
	// 获取response对象
	HttpServletResponse response;

	protected Page currentPage;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	// 法定代表人证件类型
	private List<DictionaryClass> idCardType;
	// 企业登记注册类型
	private List<DictionaryClass> economicNum;
	// 注册资本币种
	private List<DictionaryClass> principalUnit;
	// 国籍或地区
	private List<DictionaryClass> nations;
	// 外商投资者类型
	private List<DictionaryClass> ivestors;
	// 企业类型
	private List<DictionaryClass> enterpriseTypes;

	public String execute() throws Exception {

		throw new BaseException("您所请求的资源不存在!!");
	}

	/**
	 * 获取session中对象,map形式传入key
	 * 
	 * @param name
	 * @return
	 */
	protected Object get(String name) {
		return ActionContext.getContext().getSession().get(name);
	}

	/**
	 * 将对象存入session,map形式key、value
	 * 
	 * @param name
	 * @param value
	 */
	protected void set(String name, Object value) {
		ActionContext.getContext().getSession().put(name, value);
	}

	// 获取action完整路径名
	public String getActionName() {
		return this.getClass().getName();
	}

	// 移除session中的对象
	protected void remove(Object key) {
		ActionContext.getContext().getSession().remove(key);
	}

	// 清理session
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
	 * 查询字典表
	 */
	public void queryDictionary() {
		BaseDao dao = new BaseDao();
		// 证件类型
		idCardType = dao.queryIdCardType();
		// 企业登记注册类型
		economicNum = dao.queryEconomicNum();
		// 注册资本币种
		principalUnit = dao.queryPrincipalUnit();
		// 查询国籍或地区
		nations = dao.queryNation();
		// 外商投资这类型
		ivestors = dao.queryIvestor();
		// 查询企业类型
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
