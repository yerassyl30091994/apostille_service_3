//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.09.30 at 11:49:10 AM ALMT 
//


package kz.itig.egov.pep.p117;

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
 *         &lt;element name="spp_apostilled_document_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="apostille_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "sppApostilledDocumentId",
    "apostilleCode"
})
@XmlRootElement(name = "GetConfirmation")
public class GetConfirmation {

    @XmlElement(name = "spp_apostilled_document_id", required = true)
    protected String sppApostilledDocumentId;
    @XmlElement(name = "apostille_code", required = true)
    protected String apostilleCode;

    /**
     * Gets the value of the sppApostilledDocumentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSppApostilledDocumentId() {
        return sppApostilledDocumentId;
    }

    /**
     * Sets the value of the sppApostilledDocumentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSppApostilledDocumentId(String value) {
        this.sppApostilledDocumentId = value;
    }

    /**
     * Gets the value of the apostilleCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApostilleCode() {
        return apostilleCode;
    }

    /**
     * Sets the value of the apostilleCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApostilleCode(String value) {
        this.apostilleCode = value;
    }

}
