package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

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
    private TextRepresentation companyLegalForm;
    /**
     * The legal status requested for potential tenderers, expressed as a code.
     */
    private CodeRepresentation companyLegalFormCode;
    /**
     * Text describing the evaluation requirements for this tenderer.
     */
    private TextRepresentation description;
    /**
     * Textual description of the legal form required for potential tenderers.
     */
    private QuantityRepresentation employeeQuantity;
    /**
     * Textual description of the legal form required for potential tenderers.
     */
    private QuantityRepresentation operatingYearsQuantity;
    /**
     * Text describing the personal situation of the economic operators in this
     * tendering process.
     */
    private TextRepresentation personalSituation;
    private ClassificationSchemeRepresentation requiredBusinessClassificationScheme;
    private List<EconomicOperatorRoleRepresentation> economicOperatorRoles = new ArrayList<>();
    private EvaluationCriterionRepresentation technicalEvaluationCriterion;
    private TenderingTermsRepresentation financialEvaluationCriterion;
    private TendererRequirementRepresentation specificTendererRequirement;

}
