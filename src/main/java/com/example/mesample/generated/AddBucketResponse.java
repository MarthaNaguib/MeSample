
package com.example.mesample.generated;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="serviceStatus" type="{http://www.concretepage.com/bucket-ws}serviceStatus"/&gt;
 *         &lt;element name="bucketInfo" type="{http://www.concretepage.com/bucket-ws}bucketInfo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "serviceStatus",
    "bucketInfo"
})
@XmlRootElement(name = "addBucketResponse")
public class AddBucketResponse {

    @XmlElement(required = true)
    protected ServiceStatus serviceStatus;
    @XmlElement(required = true)
    protected BucketInfo bucketInfo;

    /**
     * Gets the value of the serviceStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceStatus }
     *     
     */
    public ServiceStatus getServiceStatus() {
        return serviceStatus;
    }

    /**
     * Sets the value of the serviceStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceStatus }
     *     
     */
    public void setServiceStatus(ServiceStatus value) {
        this.serviceStatus = value;
    }

    /**
     * Gets the value of the bucketInfo property.
     * 
     * @return
     *     possible object is
     *     {@link BucketInfo }
     *     
     */
    public BucketInfo getBucketInfo() {
        return bucketInfo;
    }

    /**
     * Sets the value of the bucketInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BucketInfo }
     *     
     */
    public void setBucketInfo(BucketInfo value) {
        this.bucketInfo = value;
    }

}
