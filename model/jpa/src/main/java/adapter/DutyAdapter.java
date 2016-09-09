package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * The charging rate used for both call charging and time dependent charging
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:38 a. m.
 */
public class dutyAdapter{

	/**
	 * The amount of this duty.
	 */
	private amountType amount;
	/**
	 * Text describing this duty.
	 */
	private TextType duty;
	/**
	 * The type of this charge rate, expressed as a code.
	 */
	private CodeType dutyCode;
	private List<TaxCategoryAdapter> taxCategories = new ArrayList<>();

}
