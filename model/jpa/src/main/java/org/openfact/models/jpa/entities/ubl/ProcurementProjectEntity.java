package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.NameType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe a project to procure goods, works, or services.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:04 a. m.
 */
public class ProcurementProjectEntity {

    /**
     * Text describing this procurement project.
     */
    private TextType Description;
    /**
     * The estimated overall quantity for this procurement project.
     */
    private QuantityType EstimatedOverallContractQuantity;
    /**
     * Text describing the reimbursement fee for concession procurement
     * projects.
     */
    private TextType FeeDescription;
    /**
     * An identifier for this procurement project.
     */
    private IdentifierType ID;
    /**
     * A name of this procurement project.
     */
    private NameType Name;
    /**
     * Free-form text applying to the ProcurementProject. This element may
     * contain additional information about the lot/contract that is not
     * contained explicitly in another structure.
     */
    private TextType Note;
    /**
     * A code signifying the subcategory of the type of work for this project
     * (e.g., land surveying, IT consulting).
     */
    private CodeType ProcurementSubTypeCode;
    /**
     * A code signifying the type of procurement project (e.g., goods, works,
     * services).
     */
    private CodeType ProcurementTypeCode;
    /**
     * The indication of whether or not the control quality is included in the
     * works project.
     */
    private CodeType QualityControlCode;
    /**
     * The requested delivery date for this procurement project.
     */
    private DateType RequestedDeliveryDate;
    /**
     * The amount of the reimbursement fee for concession procurement projects.
     */
    private AmountType RequiredFeeAmount;
    private CommodityClassificationEntity AdditionalCommodityClassification;
    private CommodityClassificationEntity MainCommodityClassification;
    private List<ContractExtensionEntity> ContractExtensions = new ArrayList<>();
    private LocationEntity RealizedLocation;
    private PeriodEntity PlannedPeriod;
    private List<RequestedTenderTotalEntity> RequestedTenderTotals = new ArrayList<>();
    private List<Request> ForTenderLineRequestForTenderLines = new ArrayList<>();

}
