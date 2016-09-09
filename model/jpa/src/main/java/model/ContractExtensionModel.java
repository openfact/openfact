package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe possible extensions to a contract.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:03 a. m.
 */
public class ContractExtensionModel{

	/**
	 * The maximum allowed number of contract extensions.
	 */
	private NumericType maximumNumberNumeric;
	/**
	 * The fixed minimum number of contract extensions or renewals.
	 */
	private NumericType minimumNumberNumeric;
	/**
	 * A description for the possible options that can be carried out during the
	 * execution of the contract.
	 */
	private TextType optionsDescription;
	private PeriodModel optionValidityPeriod;
	private List<RenewalModel> renewals = new ArrayList<>();

}
