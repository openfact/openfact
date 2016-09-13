package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.ChannelCodeRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a means of communication.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:13:38 a. m.
 */
public class CommunicationRepresentation {

    /**
     * The method of communication, expressed as text.
     */
    private TextRepresentation channel;
    /**
     * The method of communication, expressed as a code.
     */
    private ChannelCodeRepresentation codeTypeChannelCode;
    /**
     * An identifying value (phone number, email address, etc.) for this channel
     * of communication
     */
    private TextRepresentation value;

}
