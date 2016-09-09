package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe one of the parts of a procurement project that is being
 * subdivided to allow the contracting party to award different lots to different
 * economic operators under different contracts.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:05 a. m.
 */
public class ProcurementProjectLotAdapter{

	/**
	 * An identifier for this procurement project lot.
	 */
	private IdentifierType ID;
	private List<ProcurementProjectAdapter> ProcurementProjects = new ArrayList<>();
	private List<TenderingTermsAdapter> TenderingTermses = new ArrayList<>();

}
