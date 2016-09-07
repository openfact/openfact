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
	private String channel;
	/**
	 * The method of communication, expressed as a code.
	 */
	private String channelCode;
	/**
	 * An identifying value (phone number, email address, etc.) for this channel
	 * of communication
	 */
	private String value;

	public Communication() {

	}

	public void finalize() throws Throwable {

	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}// end Communication