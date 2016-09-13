package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a project to procure goods, works, or services.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:04 a. m.
 */
public class ProcurementProjectModel {

    /**
     * Text describing this procurement project.
     */
    private TextModel description;
    /**
     * The estimated overall quantity for this procurement project.
     */
    private QuantityModel estimatedOverallContractQuantity;
    /**
     * Text describing the reimbursement fee for concession procurement
     * projects.
     */
    private TextModel feeDescription;
    /**
     * An identifier for this procurement project.
     */
    private IdentifierModel ID;
    /**
     * A name of this procurement project.
     */
    private NameModel name;
    /**
     * Free-form text applying to the ProcurementProject. This element may
     * contain additional information about the lot/contract that is not
     * contained explicitly in another structure.
     */
    private TextModel note;
    /**
     * A code signifying the subcategory of the type of work for this project
     * (e.g., land surveying, IT consulting).
     */
    private CodeModel procurementSubTypeCode;
    /**
     * A code signifying the type of procurement project (e.g., goods, works,
     * services).
     */
    private CodeModel procurementTypeCode;
    /**
     * The indication of whether or not the control quality is included in the
     * works project.
     */
    private CodeModel qualityControlCode;
    /**
     * The requested delivery date for this procurement project.
     */
    private LocalDate requestedDeliveryDate;
    /**
     * The amount of the reimbursement fee for concession procurement projects.
     */
    private BigDecimal requiredFeeAmount;
    private CommodityClassificationModel additionalCommodityClassification;
    private CommodityClassificationModel mainCommodityClassification;
    private List<ContractExtensionModel> contractExtensions = new ArrayList<>();
    private LocationModel realizedLocation;
    private PeriodModel plannedPeriod;
    private List<RequestedTenderTotalModel> requestedTenderTotals = new ArrayList<>();
    //private List<Request> forTenderLineRequestForTenderLines = new ArrayList<>();

}
