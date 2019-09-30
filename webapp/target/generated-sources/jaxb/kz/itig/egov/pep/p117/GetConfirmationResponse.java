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
 *         &lt;element name="pep_application_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="spp_application_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="spp_apostilled_document_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applicant">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="surname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="patronymic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="iin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="apostilled_document">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="extension" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="base64" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="apostille_stamp">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="extension" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="base64" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "pepApplicationId",
    "sppApplicationId",
    "sppApostilledDocumentId",
    "status",
    "applicant",
    "apostilledDocument",
    "apostilleStamp",
    "apostilleCode"
})
@XmlRootElement(name = "GetConfirmationResponse")
public class GetConfirmationResponse {

    @XmlElement(name = "pep_application_id", required = true)
    protected String pepApplicationId;
    @XmlElement(name = "spp_application_id", required = true)
    protected String sppApplicationId;
    @XmlElement(name = "spp_apostilled_document_id", required = true)
    protected String sppApostilledDocumentId;
    @XmlElement(required = true)
    protected String status;
    @XmlElement(required = true)
    protected GetConfirmationResponse.Applicant applicant;
    @XmlElement(name = "apostilled_document", required = true)
    protected GetConfirmationResponse.ApostilledDocument apostilledDocument;
    @XmlElement(name = "apostille_stamp", required = true)
    protected GetConfirmationResponse.ApostilleStamp apostilleStamp;
    @XmlElement(name = "apostille_code", required = true)
    protected String apostilleCode;

    /**
     * Gets the value of the pepApplicationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPepApplicationId() {
        return pepApplicationId;
    }

    /**
     * Sets the value of the pepApplicationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPepApplicationId(String value) {
        this.pepApplicationId = value;
    }

    /**
     * Gets the value of the sppApplicationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSppApplicationId() {
        return sppApplicationId;
    }

    /**
     * Sets the value of the sppApplicationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSppApplicationId(String value) {
        this.sppApplicationId = value;
    }

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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the applicant property.
     * 
     * @return
     *     possible object is
     *     {@link GetConfirmationResponse.Applicant }
     *     
     */
    public GetConfirmationResponse.Applicant getApplicant() {
        return applicant;
    }

    /**
     * Sets the value of the applicant property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetConfirmationResponse.Applicant }
     *     
     */
    public void setApplicant(GetConfirmationResponse.Applicant value) {
        this.applicant = value;
    }

    /**
     * Gets the value of the apostilledDocument property.
     * 
     * @return
     *     possible object is
     *     {@link GetConfirmationResponse.ApostilledDocument }
     *     
     */
    public GetConfirmationResponse.ApostilledDocument getApostilledDocument() {
        return apostilledDocument;
    }

    /**
     * Sets the value of the apostilledDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetConfirmationResponse.ApostilledDocument }
     *     
     */
    public void setApostilledDocument(GetConfirmationResponse.ApostilledDocument value) {
        this.apostilledDocument = value;
    }

    /**
     * Gets the value of the apostilleStamp property.
     * 
     * @return
     *     possible object is
     *     {@link GetConfirmationResponse.ApostilleStamp }
     *     
     */
    public GetConfirmationResponse.ApostilleStamp getApostilleStamp() {
        return apostilleStamp;
    }

    /**
     * Sets the value of the apostilleStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetConfirmationResponse.ApostilleStamp }
     *     
     */
    public void setApostilleStamp(GetConfirmationResponse.ApostilleStamp value) {
        this.apostilleStamp = value;
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
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="extension" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="base64" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "name",
        "extension",
        "base64"
    })
    public static class ApostilledDocument {

        @XmlElement(required = true)
        protected String name;
        @XmlElement(required = true)
        protected String extension;
        @XmlElement(required = true)
        protected String base64;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the extension property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getExtension() {
            return extension;
        }

        /**
         * Sets the value of the extension property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setExtension(String value) {
            this.extension = value;
        }

        /**
         * Gets the value of the base64 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBase64() {
            return base64;
        }

        /**
         * Sets the value of the base64 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBase64(String value) {
            this.base64 = value;
        }

    }


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
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="extension" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="base64" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "name",
        "extension",
        "base64"
    })
    public static class ApostilleStamp {

        @XmlElement(required = true)
        protected String name;
        @XmlElement(required = true)
        protected String extension;
        @XmlElement(required = true)
        protected String base64;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the extension property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getExtension() {
            return extension;
        }

        /**
         * Sets the value of the extension property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setExtension(String value) {
            this.extension = value;
        }

        /**
         * Gets the value of the base64 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBase64() {
            return base64;
        }

        /**
         * Sets the value of the base64 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBase64(String value) {
            this.base64 = value;
        }

    }


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
     *         &lt;element name="surname" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="patronymic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="iin" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "surname",
        "name",
        "patronymic",
        "iin"
    })
    public static class Applicant {

        @XmlElement(required = true)
        protected String surname;
        @XmlElement(required = true)
        protected String name;
        protected String patronymic;
        @XmlElement(required = true)
        protected String iin;

        /**
         * Gets the value of the surname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSurname() {
            return surname;
        }

        /**
         * Sets the value of the surname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSurname(String value) {
            this.surname = value;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the patronymic property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPatronymic() {
            return patronymic;
        }

        /**
         * Sets the value of the patronymic property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPatronymic(String value) {
            this.patronymic = value;
        }

        /**
         * Gets the value of the iin property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIin() {
            return iin;
        }

        /**
         * Sets the value of the iin property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIin(String value) {
            this.iin = value;
        }

    }

}
