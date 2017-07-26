
package ws.client.tenderinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FIdCertNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FEntName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="s" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "fIdCertNo",
    "fEntName",
    "s"
})
@XmlRootElement(name = "GetSLRYList")
public class GetSLRYList {

    @XmlElement(name = "FIdCertNo")
    protected String fIdCertNo;
    @XmlElement(name = "FEntName")
    protected String fEntName;
    protected String s;

    /**
     * Gets the value of the fIdCertNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIdCertNo() {
        return fIdCertNo;
    }

    /**
     * Sets the value of the fIdCertNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIdCertNo(String value) {
        this.fIdCertNo = value;
    }

    /**
     * Gets the value of the fEntName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFEntName() {
        return fEntName;
    }

    /**
     * Sets the value of the fEntName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFEntName(String value) {
        this.fEntName = value;
    }

    /**
     * Gets the value of the s property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getS() {
        return s;
    }

    /**
     * Sets the value of the s property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setS(String value) {
        this.s = value;
    }

}
