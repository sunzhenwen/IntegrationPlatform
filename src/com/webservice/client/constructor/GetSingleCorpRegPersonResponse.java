
package com.webservice.client.constructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡgetSingleCorpRegPersonResult���Ե�ֵ��
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
     * ����getSingleCorpRegPersonResult���Ե�ֵ��
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
