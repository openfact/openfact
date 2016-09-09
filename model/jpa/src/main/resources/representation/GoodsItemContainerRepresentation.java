package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class defining how goods items are split across transport equipment.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:25 a. m.
 */
public class GoodsItemContainerRepresentation{

	/**
	 * An identifier for this goods item container.
	 */
	private IdentifierType ID; 
	/**
	 * The number of goods items loaded into or onto one piece of transport equipment
	 * as a total consignment or part of a consignment.
	 */
	private QuantityType quantity; 
	private List<TransportEquipmentRepresentation> transportEquipments = new ArrayList<>(); 

}
