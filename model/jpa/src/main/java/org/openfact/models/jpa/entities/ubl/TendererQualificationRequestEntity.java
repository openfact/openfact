package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * The evaluation that the Contracting Authority party requests to fulfill to
 * the tenderers.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:24 a. m.
 */
public class TendererQualificationRequestEntity {

	/**
	 * The legal status requested for potential tenderers, expressed as text
	 */
	private TextType companyLegalForm;
	/**
	 * The legal status requested for potential tenderers, expressed as a code.
	 */
	private CodeType companyLegalFormCode;
	/**
	 * Text describing the evaluation requirements for this tenderer.
	 */
	private TextType description;
	/**
	 * Textual description of the legal form required for potential tenderers.
	 */
	private QuantityType employeeQuantity;
	/**
	 * Textual description of the legal form required for potential tenderers.
	 */
	private QuantityType operatingYearsQuantity;
	/**
	 * Text describing the personal situation of the economic operators in this
	 * tendering process.
	 */
	private TextType personalSituation;
	private ClassificationSchemeEntity requiredBusinessClassificationScheme;
	private List<EconomicOperatorRoleEntity> economicOperatorRoles = new ArrayList<>();
	private EvaluationCriterionEntity technicalEvaluationCriterion;
	private TenderingTermsEntity financialEvaluationCriterion;
	private TendererRequirementEntity specificTendererRequirement;

}
