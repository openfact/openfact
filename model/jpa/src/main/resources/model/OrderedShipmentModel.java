package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe an ordered shipment.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:20 a. m.
 */
public class OrderedShipmentModel{

	private List<PackageModel> packages = new ArrayList<>();
	private List<ShipmentModel> shipments = new ArrayList<>();

}
