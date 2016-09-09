package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a means of communication.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:13:38 a. m.
 */
public class CommunicationAdapter{

	/**
	 * The method of communication, expressed as text.
	 */
	private TextType channel;
	/**
	 * The method of communication, expressed as a code.
	 */
	private channelCodeType CodeTypechannelCode;
	/**
	 * An identifying value (phone number, email address, etc.) for this channel of
	 * communication
	 */
	private TextType value;

}
