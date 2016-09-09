package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * The evaluation that the Contracting Authority party requests to fulfill to the
 * tenderers.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:24 a. m.
 */
public class TendererQualificationRequestAdapter{

	/**
	 * The legal status requested for potential tenderers, expressed as text
	 */
	private TextType CompanyLegalForm;
	/**
	 * The legal status requested for potential tenderers, expressed as a code.
	 */
	private CodeType CompanyLegalFormCode;
	/**
	 * Text describing the evaluation requirements for this tenderer.
	 */
	private TextType Description;
	/**
	 * Textual description of the legal form required for potential tenderers.
	 */
	private QuantityType EmployeeQuantity;
	/**
	 * Textual description of the legal form required for potential tenderers.
	 */
	private QuantityType OperatingYearsQuantity;
	/**
	 * Text describing the personal situation of the economic operators in this
	 * tendering process.
	 */
	private TextType PersonalSituation;
	private ClassificationSchemeAdapter RequiredBusinessClassificationScheme;
	private List<EconomicOperatorRoleAdapter> EconomicOperatorRoles = new ArrayList<>();
	private EvaluationCriterionAdapter TechnicalEvaluationCriterion;
	private TenderingTermsAdapter FinancialEvaluationCriterion;
	private TendererRequirementAdapter SpecificTendererRequirement;

}
