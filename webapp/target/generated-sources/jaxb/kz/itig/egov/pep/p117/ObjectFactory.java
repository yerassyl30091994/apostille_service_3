//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.09.30 at 11:49:10 AM ALMT 
//


package kz.itig.egov.pep.p117;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the kz.itig.egov.pep.p117 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: kz.itig.egov.pep.p117
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetConfirmationResponse }
     * 
     */
    public GetConfirmationResponse createGetConfirmationResponse() {
        return new GetConfirmationResponse();
    }

    /**
     * Create an instance of {@link GetConfirmation }
     * 
     */
    public GetConfirmation createGetConfirmation() {
        return new GetConfirmation();
    }

    /**
     * Create an instance of {@link GetConfirmationResponse.Applicant }
     * 
     */
    public GetConfirmationResponse.Applicant createGetConfirmationResponseApplicant() {
        return new GetConfirmationResponse.Applicant();
    }

    /**
     * Create an instance of {@link GetConfirmationResponse.ApostilledDocument }
     * 
     */
    public GetConfirmationResponse.ApostilledDocument createGetConfirmationResponseApostilledDocument() {
        return new GetConfirmationResponse.ApostilledDocument();
    }

    /**
     * Create an instance of {@link GetConfirmationResponse.ApostilleStamp }
     * 
     */
    public GetConfirmationResponse.ApostilleStamp createGetConfirmationResponseApostilleStamp() {
        return new GetConfirmationResponse.ApostilleStamp();
    }

}
