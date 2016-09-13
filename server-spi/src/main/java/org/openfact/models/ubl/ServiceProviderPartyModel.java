package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a party contracting to provide services, such as
 * transportation, finance, etc.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:41 a. m.
 */
public class ServiceProviderPartyModel {

    /**
     * An identifier for this service provider.
     */
    private IdentifierModel ID;
    /**
     * The type of service provided, expressed as text.
     */
    private TextModel serviceType;
    /**
     * The type of service provided, expressed as a code.
     */
    private CodeModel serviceTypeCode;
    private ContactModel sellerContact;
    private List<PartyModel> parties = new ArrayList<>();

}
