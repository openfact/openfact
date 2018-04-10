
package pe.gob.sunat.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pe.gob.sunat.service package. 
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

    private final static QName _GetStatus_QNAME = new QName("http://service.sunat.gob.pe", "getStatus");
    private final static QName _GetStatusResponse_QNAME = new QName("http://service.sunat.gob.pe", "getStatusResponse");
    private final static QName _GetStatusCdrResponse_QNAME = new QName("http://service.sunat.gob.pe", "getStatusCdrResponse");
    private final static QName _GetStatusCdr_QNAME = new QName("http://service.sunat.gob.pe", "getStatusCdr");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pe.gob.sunat.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetStatus }
     * 
     */
    public GetStatus createGetStatus() {
        return new GetStatus();
    }

    /**
     * Create an instance of {@link GetStatusResponse }
     * 
     */
    public GetStatusResponse createGetStatusResponse() {
        return new GetStatusResponse();
    }

    /**
     * Create an instance of {@link GetStatusCdrResponse }
     * 
     */
    public GetStatusCdrResponse createGetStatusCdrResponse() {
        return new GetStatusCdrResponse();
    }

    /**
     * Create an instance of {@link GetStatusCdr }
     * 
     */
    public GetStatusCdr createGetStatusCdr() {
        return new GetStatusCdr();
    }

    /**
     * Create an instance of {@link StatusResponse }
     * 
     */
    public StatusResponse createStatusResponse() {
        return new StatusResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sunat.gob.pe", name = "getStatus")
    public JAXBElement<GetStatus> createGetStatus(GetStatus value) {
        return new JAXBElement<GetStatus>(_GetStatus_QNAME, GetStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sunat.gob.pe", name = "getStatusResponse")
    public JAXBElement<GetStatusResponse> createGetStatusResponse(GetStatusResponse value) {
        return new JAXBElement<GetStatusResponse>(_GetStatusResponse_QNAME, GetStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatusCdrResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sunat.gob.pe", name = "getStatusCdrResponse")
    public JAXBElement<GetStatusCdrResponse> createGetStatusCdrResponse(GetStatusCdrResponse value) {
        return new JAXBElement<GetStatusCdrResponse>(_GetStatusCdrResponse_QNAME, GetStatusCdrResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatusCdr }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sunat.gob.pe", name = "getStatusCdr")
    public JAXBElement<GetStatusCdr> createGetStatusCdr(GetStatusCdr value) {
        return new JAXBElement<GetStatusCdr>(_GetStatusCdr_QNAME, GetStatusCdr.class, null, value);
    }

}
