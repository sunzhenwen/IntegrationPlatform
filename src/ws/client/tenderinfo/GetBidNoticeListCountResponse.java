
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
 *         &lt;element name="GetBidNoticeListCountResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "getBidNoticeListCountResult"
})
@XmlRootElement(name = "GetBidNoticeListCountResponse")
public class GetBidNoticeListCountResponse {

    @XmlElement(name = "GetBidNoticeListCountResult")
    protected int getBidNoticeListCountResult;

    /**
     * Gets the value of the getBidNoticeListCountResult property.
     * 
     */
    public int getGetBidNoticeListCountResult() {
        return getBidNoticeListCountResult;
    }

    /**
     * Sets the value of the getBidNoticeListCountResult property.
     * 
     */
    public void setGetBidNoticeListCountResult(int value) {
        this.getBidNoticeListCountResult = value;
    }

}
