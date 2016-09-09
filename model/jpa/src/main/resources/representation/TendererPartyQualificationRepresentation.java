package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe the qualifications of a tenderer party.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:22 a. m.
 */
public class TendererPartyQualificationRepresentation{

	private ProcurementProjectLotRepresentation interestedProcurementProjectLot; 
	private QualifyingPartyRepresentation mainQualifyingParty; 
	private QualifyingPartyRepresentation additionalQualifyingParty; 

}
