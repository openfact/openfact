package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class describing the supply of a telecommunication service, e.g., providing
 * telephone calls.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:10 a. m.
 */
public class TelecommunicationsSupplyModel {

    /**
     * Text describing the telecommunications supply.
     */
    private TextModel description;
    /**
     * A code signifying the level of confidentiality of this information for
     * this telecommunication supply.
     */
    private CodeModel privacyCode;
    /**
     * The type of telecommunications supply, expressed as text.
     */
    private TextModel telecommunicationsSupplyType;
    /**
     * The type of telecommunications supply, expressed as a code.
     */
    private CodeModel telecommunicationsSupplyTypeCode;
    /**
     * The total amount associated with this telecommunications supply.
     */
    private BigDecimal totalAmount;
    private List<TelecommunicationsSupplyLineModel> telecommunicationsSupplyLines = new ArrayList<>();

}
