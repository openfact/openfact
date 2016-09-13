package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe the distinctive features or characteristics qualifying an
 * economic operator to be a party in a tendering process (e.g., number of
 * employees, number of operating units, type of business, technical and
 * financial capabilities, completed p
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:14 a. m.
 */
public class QualifyingPartyModel {

    /**
     * An identifier for an item of evidence to support the classification of
     * this qualifying party.
     */
    private IdentifierModel businessClassificationEvidenceID;
    /**
     * An identifier for an item of evidence to support the business identity of
     * this qualifying party.
     */
    private IdentifierModel businessIdentityEvidenceID;
    /**
     * The number of people employed by this qualifying party.
     */
    private QuantityModel employeeQuantity;
    /**
     * The number of years that this qualifying party has been in operation.
     */
    private QuantityModel operatingYearsQuantity;
    /**
     * The extent to which this party is expected to participate in the
     * tendering process, expressed as a percentage.
     */
    private BigDecimal participationPercent;
    /**
     * Text describing the personal situation of the qualifying party.
     */
    private TextModel personalSituation;
    /**
     * A code stating the Tenderer Role.
     */
    private CodeModel tendererRoleCode;
    private CapabilityModel technicalCapability;
    private CapabilityModel financialCapability;
    private ClassificationSchemeModel businessClassificationScheme;
    private List<CompletedTaskModel> completedTasks = new ArrayList<>();
    private List<DeclarationModel> declarations = new ArrayList<>();
    private List<EconomicOperatorRoleModel> economicOperatorRoles = new ArrayList<>();
    private List<PartyModel> parties = new ArrayList<>();

}
