package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class to describe the terms and conditions, set by the contracting
 * authority, under which an appeal can be lodged for a tender award.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:45 a. m.
 */
public class AppealTermsEntity {

	/**
	 * Text describing the terms of an appeal.
	 */
	private TextType description;
	private PartyEntity appealInformationParty;
	private PartyEntity mediationParty;
	private PartyEntity appealReceiverParty;
	private PeriodEntity presentationPeriod;

}
