package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a party contracting to provide services, such as
 * transportation, finance, etc.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:41 a. m.
 */
public class ServiceProviderParty {

    /**
     * An identifier for this service provider.
     */
    private String ID;
    /**
     * The type of service provided, expressed as text.
     */
    private String ServiceType;
    /**
     * The type of service provided, expressed as a code.
     */
    private String ServiceTypeCode;
    private Contact SellerContact;
    private List<Party> parties = new ArrayList<>();

    /**
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * @return the serviceType
     */
    public String getServiceType() {
        return ServiceType;
    }

    /**
     * @param serviceType
     *            the serviceType to set
     */
    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }

    /**
     * @return the serviceTypeCode
     */
    public String getServiceTypeCode() {
        return ServiceTypeCode;
    }

    /**
     * @param serviceTypeCode
     *            the serviceTypeCode to set
     */
    public void setServiceTypeCode(String serviceTypeCode) {
        ServiceTypeCode = serviceTypeCode;
    }

    /**
     * @return the sellerContact
     */
    public Contact getSellerContact() {
        return SellerContact;
    }

    /**
     * @param sellerContact
     *            the sellerContact to set
     */
    public void setSellerContact(Contact sellerContact) {
        SellerContact = sellerContact;
    }

    /**
     * @return the parties
     */
    public List<Party> getParties() {
        return parties;
    }

    /**
     * @param parties
     *            the parties to set
     */
    public void setParties(List<Party> parties) {
        this.parties = parties;
    }

}// end Service Provider Party