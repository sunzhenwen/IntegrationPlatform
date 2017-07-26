package com.webServiceCDome;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.webServiceCd package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _GetDepartmentResponse_QNAME = new QName(
			"http://webService.com/", "getDepartmentResponse");
	private final static QName _GetRoleResponse_QNAME = new QName(
			"http://webService.com/", "getRoleResponse");
	private final static QName _GetDepartment_QNAME = new QName(
			"http://webService.com/", "getDepartment");
	private final static QName _GetRole_QNAME = new QName(
			"http://webService.com/", "getRole");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: com.webServiceCd
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link GetRole }
	 * 
	 */
	public GetRole createGetRole() {
		return new GetRole();
	}

	/**
	 * Create an instance of {@link StringArray }
	 * 
	 */
	public StringArray createStringArray() {
		return new StringArray();
	}

	/**
	 * Create an instance of {@link GetRoleResponse }
	 * 
	 */
	public GetRoleResponse createGetRoleResponse() {
		return new GetRoleResponse();
	}

	/**
	 * Create an instance of {@link GetDepartment }
	 * 
	 */
	public GetDepartment createGetDepartment() {
		return new GetDepartment();
	}

	/**
	 * Create an instance of {@link GetDepartmentResponse }
	 * 
	 */
	public GetDepartmentResponse createGetDepartmentResponse() {
		return new GetDepartmentResponse();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetDepartmentResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://webService.com/", name = "getDepartmentResponse")
	public JAXBElement<GetDepartmentResponse> createGetDepartmentResponse(
			GetDepartmentResponse value) {
		return new JAXBElement<GetDepartmentResponse>(
				_GetDepartmentResponse_QNAME, GetDepartmentResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetRoleResponse }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://webService.com/", name = "getRoleResponse")
	public JAXBElement<GetRoleResponse> createGetRoleResponse(
			GetRoleResponse value) {
		return new JAXBElement<GetRoleResponse>(_GetRoleResponse_QNAME,
				GetRoleResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetDepartment }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://webService.com/", name = "getDepartment")
	public JAXBElement<GetDepartment> createGetDepartment(GetDepartment value) {
		return new JAXBElement<GetDepartment>(_GetDepartment_QNAME,
				GetDepartment.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetRole }{@code
	 * >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://webService.com/", name = "getRole")
	public JAXBElement<GetRole> createGetRole(GetRole value) {
		return new JAXBElement<GetRole>(_GetRole_QNAME, GetRole.class, null,
				value);
	}

}
