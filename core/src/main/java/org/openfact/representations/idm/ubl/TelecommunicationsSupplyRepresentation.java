package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class describing the supply of a telecommunication service, e.g., providing
 * telephone calls.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:10 a. m.
 */
public class TelecommunicationsSupplyRepresentation {

    /**
     * Text describing the telecommunications supply.
     */
    private TextRepresentation description;
    /**
     * A code signifying the level of confidentiality of this information for
     * this telecommunication supply.
     */
    private CodeRepresentation privacyCode;
    /**
     * The type of telecommunications supply, expressed as text.
     */
    private TextRepresentation telecommunicationsSupplyType;
    /**
     * The type of telecommunications supply, expressed as a code.
     */
    private CodeRepresentation telecommunicationsSupplyTypeCode;
    /**
     * The total amount associated with this telecommunications supply.
     */
    private BigDecimal totalAmount;
    private List<TelecommunicationsSupplyLineRepresentation> telecommunicationsSupplyLines = new ArrayList<>();

}
