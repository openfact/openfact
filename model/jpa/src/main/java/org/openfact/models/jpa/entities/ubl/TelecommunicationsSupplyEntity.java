package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class describing the supply of a telecommunication service, e.g., providing
 * telephone calls.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:10 a. m.
 */
public class TelecommunicationsSupplyEntity {

    /**
     * Text describing the telecommunications supply.
     */
    private TextType description;
    /**
     * A code signifying the level of confidentiality of this information for
     * this telecommunication supply.
     */
    private CodeType privacyCode;
    /**
     * The type of telecommunications supply, expressed as text.
     */
    private TextType telecommunicationsSupplyType;
    /**
     * The type of telecommunications supply, expressed as a code.
     */
    private CodeType telecommunicationsSupplyTypeCode;
    /**
     * The total amount associated with this telecommunications supply.
     */
    private AmountType totalAmount;
    private List<TelecommunicationsSupplyLineEntity> telecommunicationsSupplyLines = new ArrayList<>();

}
