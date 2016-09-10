package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.QuantityType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * The evaluation that the Contracting Authority party requests to fulfill to
 * the tenderers.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:24 a. m.
 */
public class TendererQualificationRequestRepresentation {

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
    private ClassificationSchemeRepresentation requiredBusinessClassificationScheme;
    private List<EconomicOperatorRoleRepresentation> economicOperatorRoles = new ArrayList<>();
    private EvaluationCriterionRepresentation technicalEvaluationCriterion;
    private TenderingTermsRepresentation financialEvaluationCriterion;
    private TendererRequirementRepresentation specificTendererRequirement;

}
