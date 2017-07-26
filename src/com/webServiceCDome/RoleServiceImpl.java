package com.webServiceCDome;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * 
 */
@WebService(name = "RoleServiceImpl", targetNamespace = "http://webService.com/")
public interface RoleServiceImpl {

	/**
	 * 
	 * @return returns java.util.List<com.webServiceCd.StringArray>
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getDepartment", targetNamespace = "http://webService.com/", className = "com.webServiceCd.GetDepartment")
	@ResponseWrapper(localName = "getDepartmentResponse", targetNamespace = "http://webService.com/", className = "com.webServiceCd.GetDepartmentResponse")
	public List<StringArray> getDepartment();

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 * @return returns java.util.List<java.lang.String>
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getRole", targetNamespace = "http://webService.com/", className = "com.webServiceCd.GetRole")
	@ResponseWrapper(localName = "getRoleResponse", targetNamespace = "http://webService.com/", className = "com.webServiceCd.GetRoleResponse")
	public List<String> getRole(
			@WebParam(name = "arg0", targetNamespace = "") String arg0,
			@WebParam(name = "arg1", targetNamespace = "") String arg1);

}