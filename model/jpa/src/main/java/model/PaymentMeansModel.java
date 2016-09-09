package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.PaymentMeansCodeType;


/**
 * A class to describe a means of payment.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:39 a. m.
 */
public class PaymentMeansModel{

	/**
	 * An identifier for this means of payment.
	 */
	private IdentifierType ID;
	/**
	 * An identifier for the payment instruction.
	 */
	private IdentifierType InstructionID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType InstructionNote;
	/**
	 * A code signifying the payment channel for this means of payment.
	 */
	private CodeType PaymentChannelCode;
	/**
	 * The date on which payment is due for this means of payment.
	 */
	private DateType PaymentDueDate;
	/**
	 * An identifier for a payment made using this means of payment.
	 */
	private IdentifierType PaymentID;
	/**
	 * A code signifying the type of this means of payment.
	 */
	private PaymentMeansCodeType PaymentMeansCode;
	private List<CardAccountModel> CardAccounts = new ArrayList<>();
	private List<CreditAccountModel> CreditAccounts = new ArrayList<>();
	private FinancialAccountModel PayeeFinancialAccount;
	private FinancialAccountModel PayerFinancialAccount;
	private List<PaymentMandateModel> PaymentMandates = new ArrayList<>();
	private List<TradeFinancingModel> TradeFinancings = new ArrayList<>();

}
