
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
 *         &lt;element name="SetBidPersonStateResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "setBidPersonStateResult"
})
@XmlRootElement(name = "SetBidPersonStateResponse")
public class SetBidPersonStateResponse {

    @XmlElement(name = "SetBidPersonStateResult")
    protected int setBidPersonStateResult;

    /**
     * Gets the value of the setBidPersonStateResult property.
     * 
     */
    public int getSetBidPersonStateResult() {
        return setBidPersonStateResult;
    }

    /**
     * Sets the value of the setBidPersonStateResult property.
     * 
     */
    public void setSetBidPersonStateResult(int value) {
        this.setBidPersonStateResult = value;
    }

}
