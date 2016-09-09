package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe the awarding of a tender in a tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:19 a. m.
 */
public class TenderResultModel{

	/**
	 * The monetary value of the advertisement for this tendering process. 
	 */
	private AmountType advertisementAmount;
	/**
	 * The date on which this result was formalized.
	 */
	private DateType awardDate;
	/**
	 * The time at which this result was formalized.
	 */
	private TimeType awardTime;
	/**
	 * Text describing the result of the tendering process.
	 */
	private TextType description;
	/**
	 * The most expensive tender received in this tendering process.
	 */
	private AmountType higherTenderAmount;
	/**
	 * The least expensive tender received in the tendering process.
	 */
	private AmountType lowerTenderAmount;
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
	private DateType startDate;
	/**
	 * A code signifying the result of the tendering process.
	 */
	private CodeType tenderResultCode;
	private List<ContractModel> contracts = new ArrayList<>();
	private PeriodModel contractFormalizationPeriod;
	private List<SubcontractTermsModel> subcontractTermses = new ArrayList<>();
	private TenderedProjectModel awardedTenderedProject;
	private List<WinningPartyModel> winningParties = new ArrayList<>();

}
