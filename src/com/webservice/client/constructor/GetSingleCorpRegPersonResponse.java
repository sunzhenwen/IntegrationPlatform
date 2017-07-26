
package com.webservice.client.constructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetSingleCorpRegPersonResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getSingleCorpRegPersonResult"
})
@XmlRootElement(name = "GetSingleCorpRegPersonResponse")
public class GetSingleCorpRegPersonResponse {

    @XmlElement(name = "GetSingleCorpRegPersonResult")
    protected String getSingleCorpRegPersonResult;

    /**
     * 获取getSingleCorpRegPersonResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetSingleCorpRegPersonResult() {
        return getSingleCorpRegPersonResult;
    }

    /**
     * 设置getSingleCorpRegPersonResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetSingleCorpRegPersonResult(String value) {
        this.getSingleCorpRegPersonResult = value;
    }

}
