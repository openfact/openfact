package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class to describe the awarding of a tender in a tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:19 a. m.
 */
public class TenderResultEntity {

	/**
	 * The monetary value of the advertisement for this tendering process.
	 */
	private BigDecimal advertisementAmount;
	/**
	 * The date on which this result was formalized.
	 */
	private LocalDate awardDate;
	/**
	 * The time at which this result was formalized.
	 */
	private LocalTime awardTime;
	/**
	 * Text describing the result of the tendering process.
	 */
	private TextType description;
	/**
	 * The most expensive tender received in this tendering process.
	 */
	private BigDecimal higherTenderAmount;
	/**
	 * The least expensive tender received in the tendering process.
	 */
	private BigDecimal lowerTenderAmount;
	/**
	 * The number of electronic tenders received.
	 */
	private QuantityType receivedElectronicTenderQuantity;
	/**
	 * The number of foreing tenders received.
	 */
	private QuantityType receivedForeignTenderQuantity;
	/**
	 * The total number of tenders received in this tendering process.
	 */
	private QuantityType receivedTenderQuantity;
	/**
	 * The date on which the awarded contract begins.
	 */
	private LocalDate startDate;
	/**
	 * A code signifying the result of the tendering process.
	 */
	private CodeType tenderResultCode;
	private List<ContractEntity> contracts = new ArrayList<>();
	private PeriodEntity contractFormalizationPeriod;
	private List<SubcontractTermsEntity> subcontractTermses = new ArrayList<>();
	private TenderedProjectEntity awardedTenderedProject;
	private List<WinningPartyEntity> winningParties = new ArrayList<>();

}
