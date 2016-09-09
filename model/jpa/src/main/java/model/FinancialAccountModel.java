package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a financial account.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:11 a. m.
 */
public class FinancialAccountModel{

	/**
	 * A code signifying the format of this financial account.
	 */
	private CodeType accountFormatCode;
	/**
	 * A code signifying the type of this financial account.
	 */
	private CodeType accountTypeCode;
	/**
	 * An alias for the name of this financial account, to be used in place of the
	 * actual account name for security reasons.
	 */
	private nameType aliasname;
	/**
	 * A code signifying the currency in which this financial account is held.
	 */
	private CurrencyCodeType codeTypeCurrencyCode;
	/**
	 * The identifier for this financial account; the bank account number.
	 */
	private IdentifierType ID;
	/**
	 * The name of this financial account.
	 */
	private nameType name;
	/**
	 * Free-form text applying to the PaymentModel for the owner of this account.
	 */
	private TextType paymentNote;
	private BranchModel financialInstitutionBranch;
	private List<CountryModel> countries = new ArrayList<>();

}
