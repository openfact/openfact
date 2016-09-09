

/**
 * A class to describe a means of communication.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:13:38 a. m.
 */
public class Communication {

	/**
	 * The method of communication, expressed as text.
	 */
	private Text. Type Channel;
	/**
	 * The method of communication, expressed as a code.
	 */
	private Channel_ Code. Type ChannelCode;
	/**
	 * An identifying value (phone number, email address, etc.) for this channel of
	 * communication
	 */
	private Text. Type Value;

	public Communication(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getChannel(){
		return Channel;
	}

	public Channel_ Code. Type getChannelCode(){
		return ChannelCode;
	}

	public Text. Type getValue(){
		return Value;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setChannel(Text. Type newVal){
		Channel = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setChannelCode(Channel_ Code. Type newVal){
		ChannelCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValue(Text. Type newVal){
		Value = newVal;
	}
}//end Communication