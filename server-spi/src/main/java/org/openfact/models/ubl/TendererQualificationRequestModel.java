package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * The evaluation that the Contracting Authority party requests to fulfill to
 * the tenderers.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:24 a. m.
 */
public class TendererQualificationRequestModel {

    /**
     * The legal status requested for potential tenderers, expressed as text
     */
    private TextModel companyLegalForm;
    /**
     * The legal status requested for potential tenderers, expressed as a code.
     */
    private CodeModel companyLegalFormCode;
    /**
     * Text describing the evaluation requirements for this tenderer.
     */
    private TextModel description;
    /**
     * Textual description of the legal form required for potential tenderers.
     */
    private QuantityModel employeeQuantity;
    /**
     * Textual description of the legal form required for potential tenderers.
     */
    private QuantityModel operatingYearsQuantity;
    /**
     * Text describing the personal situation of the economic operators in this
     * tendering process.
     */
    private TextModel personalSituation;
    private ClassificationSchemeModel requiredBusinessClassificationScheme;
    private List<EconomicOperatorRoleModel> economicOperatorRoles = new ArrayList<>();
    private EvaluationCriterionModel technicalEvaluationCriterion;
    private TenderingTermsModel financialEvaluationCriterion;
    private TendererRequirementModel specificTendererRequirement;

}
