package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a means of communication.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:13:38 a. m.
 */
public class Communication {

	/**
	 * The method of communication, expressed as text.
	 */
	private String Channel;
	/**
	 * The method of communication, expressed as a code.
	 */
	private String ChannelCode;
	/**
	 * An identifying value (phone number, email address, etc.) for this channel
	 * of communication
	 */
	private String Value;

	public Communication() {

	}

	public void finalize() throws Throwable {

	}

	public String getChannel() {
		return Channel;
	}

	public String getChannelCode() {
		return ChannelCode;
	}

	public String getValue() {
		return Value;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setChannel(String newVal) {
		Channel = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setChannelCode(String newVal) {
		ChannelCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValue(String newVal) {
		Value = newVal;
	}
}// end Communication