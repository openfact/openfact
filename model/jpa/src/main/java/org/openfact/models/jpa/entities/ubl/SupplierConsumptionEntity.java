package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * The consumption in case the consumption is for one and only one supplier.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:58 a. m.
 */
public class SupplierConsumptionEntity {

	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private TextType description;
	private List<ConsumptionEntity> consumptions = new ArrayList<>();
	private List<ConsumptionLineEntity> consumptionsLine = new ArrayList<>();
	private List<ContractEntity> contracts = new ArrayList<>();
	private PartyEntity utilityCustomerParty;
	private PartyEntity utilitySupplierParty;

}
