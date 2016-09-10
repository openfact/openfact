package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.NameType;
import org.openfact.models.ubl.type.QuantityType;
import org.openfact.models.ubl.type.TextType;

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
    private TextType description;
    /**
     * The estimated overall quantity for this procurement project.
     */
    private QuantityType estimatedOverallContractQuantity;
    /**
     * Text describing the reimbursement fee for concession procurement
     * projects.
     */
    private TextType feeDescription;
    /**
     * An identifier for this procurement project.
     */
    private IdentifierType ID;
    /**
     * A name of this procurement project.
     */
    private NameType name;
    /**
     * Free-form text applying to the ProcurementProject. This element may
     * contain additional information about the lot/contract that is not
     * contained explicitly in another structure.
     */
    private TextType note;
    /**
     * A code signifying the subcategory of the type of work for this project
     * (e.g., land surveying, IT consulting).
     */
    private CodeType procurementSubTypeCode;
    /**
     * A code signifying the type of procurement project (e.g., goods, works,
     * services).
     */
    private CodeType procurementTypeCode;
    /**
     * The indication of whether or not the control quality is included in the
     * works project.
     */
    private CodeType qualityControlCode;
    /**
     * The requested delivery date for this procurement project.
     */
    private LocalDate requestedDeliveryDate;
    /**
     * The amount of the reimbursement fee for concession procurement projects.
     */
    private BigDecimal requiredFeeAmount;
    private CommodityClassificationEntity additionalCommodityClassification;
    private CommodityClassificationEntity mainCommodityClassification;
    private List<ContractExtensionEntity> contractExtensions = new ArrayList<>();
    private LocationEntity realizedLocation;
    private PeriodEntity plannedPeriod;
    private List<RequestedTenderTotalEntity> requestedTenderTotals = new ArrayList<>();
    private List<RequestForTenderLineEntity> requestForTenderLines = new ArrayList<>();

}
