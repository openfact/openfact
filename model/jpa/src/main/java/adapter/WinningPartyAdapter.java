package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A party that is identified as the awarded by a tender result.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:59 a. m.
 */
public class WinningPartyAdapter{

	/**
	 * Indicates the rank obtained in the award.
	 */
	private TextType rank;
	private List<PartyAdapter> parties = new ArrayList<>();

}
