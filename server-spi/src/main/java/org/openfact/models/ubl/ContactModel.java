package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a contactable person or department in an organization.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:58 a. m.
 */
public class ContactModel {

    /**
     * The primary email address of this contact.
     */
    private TextModel electronicMail;
    /**
     * An identifier for this contact.
     */
    private IdentifierModel ID;
    /**
     * The name of this contact. It is recommended that this be used for a
     * functional name and not a personal name.
     */
    private NameModel name;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures; in particular, a textual description of the
     * circumstances under which this contact can be used (e.g., "emergency" or
     * "after hours").
     */
    private TextModel note;
    /**
     * The primary fax number of this contact.
     */
    private TextModel telefax;
    /**
     * The primary telephone number of this contact.
     */
    private TextModel telephone;
    private CommunicationModel otherCommunication;

}
