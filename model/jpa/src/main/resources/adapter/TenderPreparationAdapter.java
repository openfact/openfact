package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe directions for preparing a tender.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:16 a. m.
 */
public class TenderPreparationAdapter{

	/**
	 * Text describing the tender envelope.
	 */
	private TextType description; 
	/**
	 * An identifier for the open tender associated with this tender preparation.
	 */
	private IdentifierType openTenderID; 
	/**
	 * An identifier for the tender envelope to be used with the tender.
	 */
	private IdentifierType tenderEnvelopeID; 
	/**
	 * A code signifying the type of tender envelope (economical or objective criteria
	 * versus technical or subjective criteria).
	 */
	private CodeType tenderEnvelopeTypeCode; 
	private List<ProcurementProjectLotAdapter> procurementProjectLots = new ArrayList<>(); 
	private TenderRequirementAdapter documentTenderRequirement; 

}
