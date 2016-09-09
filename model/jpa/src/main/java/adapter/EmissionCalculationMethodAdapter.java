package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define how an environmental emission is calculated.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:43 a. m.
 */
public class EmissionCalculationMethodAdapter{

	/**
	 * A code signifying the method used to calculate the emission.
	 */
	private CodeType CalculationMethodCode;
	/**
	 * A code signifying whether a piece of transport equipment is full, partially
	 * full, or empty. This indication is used as a parameter when calculating the
	 * environmental emission.
	 */
	private CodeType FullnessIndicationCode;
	private LocationAdapter MeasurementToLocation;
	private LocationAdapter MeasurementFromLocation;

}
