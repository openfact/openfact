package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a means of communication.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:13:38 a. m.
 */
public class CommunicationModel {

    /**
     * The method of communication, expressed as text.
     */
    private TextModel channel;
    /**
     * The method of communication, expressed as a code.
     */
    private ChannelCodeModel codeTypeChannelCode;
    /**
     * An identifying value (phone number, email address, etc.) for this channel
     * of communication
     */
    private TextModel value;

}
